package servlets;

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
import javax.servlet.annotation.MultipartConfig;
import javax.sql.rowset.serial.SerialBlob;
import org.apache.pdfbox.io.IOUtils;
import utils.PdfHandler;

/**
 *
 * @author chunchung
 */
@MultipartConfig
public class submitphoto extends HttpServlet {

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
        String clean_url, clean_score, clean_description;
        Statement st;

        //open the DBMS and insert the record
        try {
            InputStream fileContent = request.getPart("image").getInputStream();
            byte[] bytes = IOUtils.toByteArray(fileContent);
            byte[] imgbytes = PdfHandler.convert(bytes);

            Blob blob = new SerialBlob(imgbytes);

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/StandingOut";
            conn = DriverManager.getConnection(connectionURL, "test", "test");
            st = conn.createStatement();
            String q1 = new String("INSERT INTO TEST.PICS (score, description, timestamp, image)"
                    + " VALUES ("
                    + request.getParameter("score") + ", '"
                    + request.getParameter("description") + "', '"
                    + df.format(now) + "',"
                    + "?)");

            PreparedStatement statement = conn.prepareStatement(q1);
            statement.setBinaryStream(1, new ByteArrayInputStream(imgbytes), imgbytes.length);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("status", "done");
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/submit.jsp");
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
