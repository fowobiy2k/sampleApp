/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testjsp;

/**
 *
 * @author user
 */
import java.sql.*;
import java.util.*;

public class LinkDatabase {
    
    public static Connection getConnection(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mathlabbase","root","");
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return con;
    }
    
    public static ResultSet getData(){
        ResultSet rs = null;
        
        try{System.out.println("before attempt");
            Connection con = getConnection();System.out.println("after attempt");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int numberOfColumns = md.getColumnCount();
            
            
            
            /**while(rs.next()){
                names.add(rs.getString("userName")); System.out.println("scanning result set");
            }**/
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    public static String sayHello(){
        return "hello world of programmers";
    }
}
