package servlets;

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
public class updatePhoto extends HttpServlet {

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

        Statement st;

        System.out.println(request.getParameter("photoid"));

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/StandingOut";
            conn = DriverManager.getConnection(connectionURL, "test", "test");
            st = conn.createStatement();
            String q1 = new String("UPDATE TEST.PICS SET SCORE = SCORE + 1 Where PICID = "
                    + request.getParameter("photoid") );

            st.execute(q1);
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
