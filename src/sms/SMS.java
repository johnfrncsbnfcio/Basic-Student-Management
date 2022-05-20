/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sms;

import java.sql.*;
import sms.student.database.Database;
import sms.student.resources.DataStorage;
import sms.student.view.Login;

/**
 *
 * @author Bilog
 */
public class SMS {

    static PreparedStatement ps;
    static ResultSet rs;
    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        /* Check database connection first */
        Database.getConnection();
        
        if(Database.isConnected){
            
            try{
                Connection con = Database.getConnection();
                String sql = "SELECT EXISTS(SELECT 1 FROM mysql.user WHERE user = ?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, DataStorage.username);
                rs = ps.executeQuery();
                if(rs.next()){
                    Login login = new Login();
                    login.setVisible(true);
                }else{
                    System.out.println("No account detected");
                }
            }catch(SQLException e){
                System.out.println("Error connecting to database");
            }
            
        }else{
            System.out.println("Database Error");
        }
    }
    
}
