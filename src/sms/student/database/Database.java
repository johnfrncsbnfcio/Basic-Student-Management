/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.database;

import java.sql.*;
import sms.student.resources.*;
/**
 *
 * @author Bilog
 */
public class Database {
    static Connection con;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/"+DataStorage.dbname;
    static String uname = "root";
    static String pass = "";
    static public boolean isConnected = false;
    
    public static Connection getConnection(){
        try{
            if(con == null){
                Class.forName(driver);
                con = DriverManager.getConnection(url,DataStorage.username,DataStorage.password);
                isConnected = true;
            }else{
                isConnected = false;
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("error");
        }
        return con;
    }
}
