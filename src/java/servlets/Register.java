/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import beans.userbean;
/**
 *
 * @author chiming
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String usr=request.getParameter("username");
            String pwd=request.getParameter("password");
            String alias=request.getParameter("nickname");
            
            RequestDispatcher rderr = getServletContext().getRequestDispatcher("/error.jsp");
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String connectionURL = "jdbc:derby://localhost:1527/StandingOut";
                con = DriverManager.getConnection(connectionURL, "test", "test");
                Statement st = con.createStatement();
                String sql="select * from users where username='"+usr+"'";
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

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    request.setAttribute("errmsg", "This Email is already registered.");
                    rderr.forward(request, response);
                }
                
            }
            catch(ClassNotFoundException clnf)
            {
                request.setAttribute("errmsg", clnf.getMessage());
                rderr.forward(request, response);                 
            }
            catch (SQLException sqle)
            {
                request.setAttribute("errmsg", sqle.getMessage());
                rderr.forward(request, response);                  
            }
            finally
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
        return "Register on StandingOut";
    }// </editor-fold>

}
