package com.hw6;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

import java.sql.*;

/**
 * @author chunchung
 */
public class photoGallery extends HttpServlet {
    private Connection conn;
    private Statement st;
    private ResultSet rs=null;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ArrayList Rows = new ArrayList();
        
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/assignment6";
            conn = DriverManager.getConnection(connectionURL, "TEST", "TEST");
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM APP.pics");
            rs =  st.executeQuery(q1);
            
        }
        catch( ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch (SQLException se)
        {
            se.printStackTrace();  
        }

       try{
            while(rs.next()) {
                ArrayList row = new ArrayList();
                for(int i=1;i<=5;i++) {
                    row.add(rs.getString(i));
                }
                Rows.add(row);
            }
       }
       catch(SQLException sqle)
                 {
            sqle.printStackTrace();  
        }

        request.setAttribute("rows", Rows);
        RequestDispatcher requestDispatcher; 
        requestDispatcher = request.getRequestDispatcher("/gallery.jsp");
        requestDispatcher.forward(request, response);

    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}