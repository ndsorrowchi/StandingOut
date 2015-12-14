package servlets;

import beans.userbean;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.sql.*;

/**
 * @author chunchung
 */
public class photoGallery extends HttpServlet {

    private Connection conn;
    private Statement st;
    private ResultSet rs = null;
    private Connection messageConn;
    private Statement messages;
    private ResultSet messagesRS;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ArrayList Rows = new ArrayList();
        HashMap<String, ArrayList> msg = new HashMap<String, ArrayList>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/StandingOut";
            conn = DriverManager.getConnection(connectionURL, "test", "test");
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM TEST.PICS order by SCORE Desc");
            rs = st.executeQuery(q1);

            messageConn = DriverManager.getConnection(connectionURL, "test", "test");
            messages = messageConn.createStatement();
            
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        try {

            while (rs.next()) {
                ArrayList row = new ArrayList();

                String id = rs.getString(1);
                ArrayList message = getMessages(id);

                for (int i = 1; i <= 5; i++) {
                    row.add(rs.getString(i));
                }
                Rows.add(row);
                msg.put(id, message);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        request.setAttribute("rows", Rows);
        request.setAttribute("msg", msg);

        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/gallery.jsp");
        requestDispatcher.forward(request, response);

    }

    private ArrayList getMessages(String photoid) {
        String q1 = new String("SELECT * FROM TEST.MESSAGES where PHOTOID = " + photoid);
        
        System.out.println(q1);
        ArrayList Rows = new ArrayList();

        try {
            messagesRS = messages.executeQuery(q1);
            while (messagesRS.next()) {
                ArrayList messagesArr = new ArrayList();

                for (int i = 1; i <= 5; i++) {
                    System.out.println(messagesRS.getString(i));
                    messagesArr.add(messagesRS.getString(i));
                }
                Rows.add(messagesArr);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return Rows;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
