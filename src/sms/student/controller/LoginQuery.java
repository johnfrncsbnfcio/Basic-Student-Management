/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.controller;

import java.sql.*;
import sms.student.resources.Prompt;
import sms.student.database.Database;
import sms.student.model.AccountData;
import sms.student.resources.*;

/**
 *
 * @author Bilog
 */
public class LoginQuery extends StringManipulation implements LoginInterface{

    PreparedStatement ps;
    ResultSet rs;
    
    private boolean isLoginOk;
	
    public boolean isLoginOk() {
        return isLoginOk;
    }

    public void setLoginOk(boolean isLoginOk) {
        this.isLoginOk = isLoginOk;
    }
    
    @Override
    public void checkAccount(String user, String pass) {
        if(user.equals("") && pass.equals("")) {
                Prompt.showMessage("ERROR", "Complete all details.");
        }else {
                try {
                    Connection con = Database.getConnection();
                    String sql = "SELECT * FROM account_table WHERE BINARY account_user = ? AND BINARY account_pass = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, user);
                    ps.setString(2, pass);
                    rs = ps.executeQuery();
                    if(rs.next()){
                        AccountData.setAccountId(rs.getInt("account_id"));
                        AccountData.setAccountUser(rs.getString("account_user"));
                        AccountData.setAccountPass(rs.getString("account_pass"));
                        setLoginOk(true);
                        Prompt.showMessage("OK", "Welcome, " + upperCasefirst(rs.getString("account_user")));
                    }else {
                        setLoginOk(false);
                        Prompt.showMessage("ERROR","Sign-In failed. Provide correct details.");
                    }
                } catch (Exception e) {
                        Prompt.showMessage("ERROR","Something went wrong while signing-in.");
                }
        }
    }
    
}
