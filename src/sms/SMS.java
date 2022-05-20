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
                    System.out.println("no account detected");
                }
            }catch(Exception e){
                System.out.println("nooo");
            }
            
        }else{
            System.out.println("false");
        }
    }
    
}
