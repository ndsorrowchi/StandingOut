/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.*;
/**
 *
 * @author chiming
 */
public class userbean extends Object implements Serializable {
    private String uid;//user id
    private String uname;//nick name
    public userbean(){
        uid="";
        uname="";
    }
    public String getUid(){return uid;}
    public String getUname(){return uname;}
    
    public void setUid(String id){uid=id;}
    public void setUname(String name){uname=name;}
}
