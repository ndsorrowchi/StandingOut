/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.userbean;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.PdfHandler;

/**
 *
 * @author chiming
 */
public class ImgHandler extends HttpServlet {
    private Connection con;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("getFILE");
        response.setContentType("image/jpg");
        try (OutputStream out = response.getOutputStream()) {
            /* TODO output your page here. You may use following sample code. */
            String i=(String) request.getParameter("imgid");//NumberFormatException
            
            System.out.println(request.getParameter("imgid"));
            int id=Integer.parseInt(i);
            
            RequestDispatcher rderr = getServletContext().getRequestDispatcher("/error.jsp");
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/StandingOut";
            con = DriverManager.getConnection(connectionURL, "test", "test");
            Statement st = con.createStatement();
            String sql="select IMAGE from TEST.PICS where PICID="+id+"";
            ResultSet sqlres=st.executeQuery(sql);
            int count =0;
            byte[] arrdata = null;
            while(sqlres.next())
            {
                Blob b = sqlres.getBlob(1);
                arrdata=b.getBytes(1L, (int)b.length());
                count++;
            }
            if(count!=0)
            {
                out.write(arrdata);
                out.flush(); 
                out.close();
            }
            else
            {
                out.close();
            }            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImgHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImgHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
