/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author chunchung
 */
@Stateless
public class uploadCheckerBean implements uploadCheckerBeanLocal {

    private Connection conn;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private boolean checkUrl(String url) {
        boolean retvalue;
        if (url.matches("http://.*") || url.matches("https://.*")) {
            retvalue = true;
        } else {
            retvalue = false;
        }
        return retvalue;
    }

    private boolean checkScore(String score) {
        if (score.matches("^[0-9]*")) {
            return true;
        } else {
            return false;   
        }

    }

    public String checkUpload(String url, String score, String description) {
        if (checkUrl(url) && checkScore(score)) {
            Date now = new Date();
            java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String clean_url, clean_score, clean_description;
            Statement st;


            clean_url = url;
            clean_score = score;
            clean_description = description;
            //open the DBMS and insert the record
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String connectionURL = "jdbc:derby://localhost:1527/Assignment6";
                conn = DriverManager.getConnection(connectionURL, "TEST", "TEST");
                st = conn.createStatement();
                String q1 = new String("INSERT INTO APP.pics (url, score, description, timestamp)"
                        + " VALUES ('"
                        + clean_url + "',"
                        + clean_score + ", '"
                        + clean_description + "', '"
                        + df.format(now) + "')");

                st.execute(q1);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            
            return "Insert Sucess";
        }
        return "Insert failed";
    }
}
