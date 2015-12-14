package servlets;

import beans.userbean;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;

/**
 *
 * @author chunchung
 */
public class updateMessage extends HttpServlet {

    @EJB
    private uploadCheckerBeanLocal uploadCheckerBean;

    private Connection conn;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date now = new Date();
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Statement st;

        System.out.println(request.getParameter("photoid"));

        userbean msb = null;
        HttpSession session = request.getSession(false);
        String name = "Anynomous";

        if (session != null) {
            msb = (userbean) session.getAttribute("usrbn");
            if (msb != null) {

                name = msb.getUname();
            }
        }
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/StandingOut";
            conn = DriverManager.getConnection(connectionURL, "test", "test");
            String myquery = "INSERT INTO TEST.MESSAGES (USERNAME, PHOTOID, COMMENT, TIMESTAMP)"
                    + " VALUES ('" + name + "', " + request.getParameter("photoid") + ", ?, '" + df.format(now) + "')";
            
            System.out.println(myquery);
            PreparedStatement mystatement = conn.prepareStatement(myquery);
            mystatement.setString(1, request.getParameter("comment"));
            mystatement.executeUpdate();

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("Success Data");

        //request.setAttribute("status", uploadStatus);
        //RequestDispatcher requestDispatcher; 
        //requestDispatcher = request.getRequestDispatcher("/submit.jsp");
        //requestDispatcher.forward(request, response);
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
        return "This API is using for submit image";
    }
}
