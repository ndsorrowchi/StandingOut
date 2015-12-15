package servlets;

import beans.userbean;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import org.apache.pdfbox.io.IOUtils;

/**
 *
 * @author chunchung
 */
public class home extends HttpServlet {

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
        HttpSession session =request.getSession(false);
        RequestDispatcher requestDispatcher;

        if( session!=null && session.getAttribute("usrbn")!=null)
        {   
            userbean ub=(userbean)session.getAttribute("usrbn");
            if(ub.getUname()!=null&&ub.getUid()!=null&&!ub.getUid().equals("")&&!ub.getUname().equals(""))
            {
                requestDispatcher = request.getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);

            }
        }   

        requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
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
