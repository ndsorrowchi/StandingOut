/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.userbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
        response.setContentType("image/jpg");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String i=(String) request.getAttribute("imgid");//NumberFormatException
            int id=Integer.parseInt(i);
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/StandingOut";
            con = DriverManager.getConnection(connectionURL, "test", "test");
            Statement st = con.createStatement();
            String sql="select * from PICS where PICID='"+usr+"'";
            ResultSet sqlres=st.executeQuery(sql);
            int count =0;
            while(sqlres.next())
            {
                count++;
            }
           if(count==0)
            {
                StringBuffer tmp=new StringBuffer("insert into users values('");
                tmp.append(usr);
                tmp.append("','");
                tmp.append(pwd);
                tmp.append("','");
                tmp.append(alias);
                tmp.append("')");
                st.executeUpdate(tmp.toString());

                userbean msb=new userbean();

                msb.setUid(usr);
                msb.setUname(alias);
                HttpSession session=request.getSession(true);
                session.setAttribute("usrbn", msb);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gallery.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("errmsg", "This Email is already registered.");
                rderr.forward(request, response);
            }            
            
            PdfHandler.convert(arr);
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
