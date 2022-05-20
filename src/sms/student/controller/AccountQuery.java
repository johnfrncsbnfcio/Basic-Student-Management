/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.controller;

/**
 *
 * @author Bilog
 */

import java.sql.*;
import java.util.ArrayList;
import sms.student.database.Database;
import sms.student.model.AccountData;
import sms.student.resources.Prompt;

public class AccountQuery implements AccountInterface {

    PreparedStatement ps, ps1;
    ResultSet rs;

    @Override
    public void save(AccountData account) {

        try {
            Connection con = Database.getConnection();
            String sql = "INSERT INTO account_table(account_user,account_pass) VALUES (?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, AccountData.getAccountUser());
            ps.setString(2, AccountData.getAccountPass());
            ps.executeUpdate();
            Prompt.showMessage("OK", "Account created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            Prompt.showMessage("ERROR", "Failed to create account.");
        }

    }

    @Override
    public void update(AccountData account) {

        try {
            Connection con = Database.getConnection();
            String sql = "SELECT * FROM account_table WHERE account_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, AccountData.getAccountId());
            rs = ps.executeQuery();

            if (rs.next()) {

                String userName = rs.getString("account_user");
                String password = rs.getString("account_pass");

                if (!AccountData.getAccountPassOld().equals(rs.getString("account_pass"))) {

                    Prompt.showMessage("ERROR", "Wrong account password.");

                } else {

                    try {

                        String sql1 = "UPDATE account_table SET account_pass = ? WHERE account_id = ? AND account_pass = ?";
                        ps1 = con.prepareStatement(sql1);
                        ps1.setString(1, AccountData.getAccountPassNew());
                        ps1.setInt(2, AccountData.getAccountId());
                        ps1.setString(3, AccountData.getAccountPassOld());

                        int count = ps1.executeUpdate();
                        if (count > 0) {
                            AccountData.setAccountPassOld(AccountData.getAccountPassNew());
                            Prompt.showMessage("OK", "Account password updated successfully.");
                        } else {
                            Prompt.showMessage("ERROR", "Failed to update account password.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Prompt.showMessage("ERROR", "Failed to change account password.");
                    }

                }
            } else {
                Prompt.showMessage("ERROR", "Someting went wrong. Please restart the application.");
            }
        } catch (Exception e) {
            Prompt.showMessage("ERROR", "Contact your System Developer.");
        }

    }

    @Override
    public void delete(AccountData account) {

        try {
            Connection con = Database.getConnection();
            String sql = "DELETE FROM account_table WHERE account_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, AccountData.getAccountId());
            ps.executeUpdate();
            Prompt.showMessage("OK", "Account deleted successfully.");
        } catch (Exception e) {
            Prompt.showMessage("ERROR", "Failed to delete account.");
        }

    }

    @Override
    public AccountData get(int id) {

        AccountData account = new AccountData();

        try {
            Connection con = Database.getConnection();
            String sql = "SELECT * FROM account_table WHERE account_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            rs = ps.executeQuery();
            if (rs.next()) {
                account.setAccountId(rs.getInt("account_id"));
                account.setAccountUser(rs.getString("account_user"));
                account.setAccountPass(rs.getString("account_pass"));
            }
        } catch (Exception e) {
            Prompt.showMessage("ERROR", "Failed to get account details.");
        }
        return account;
    }

    @Override
    public ArrayList<AccountData> accountList() {

        ArrayList<AccountData> list = new ArrayList<AccountData>();

        try {
            Connection con = Database.getConnection();
            String sql = "SELECT * FROM account_table";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            AccountData account;
            while (rs.next()) {
                account = new AccountData(rs.getInt("account_id"), rs.getString("account_user"), rs.getString("account_pass"));
                list.add(account);
            }
        } catch (Exception e) {
            Prompt.showMessage("ERROR", "Failed to load account details.");
        }

        return list;
    }

    @Override
    public void checkUpdateAccount(int id, String user, String newPass, String oldPass) {

        if (user.equals("") && newPass.equals("") && oldPass.equals("")) {
            Prompt.showMessage("ERROR", "Complete all details.");
        } else {
            try {
                Connection con = Database.getConnection();
                String sql = "SELECT * FROM account_table WHERE account_id = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String userName = rs.getString("account_user");
                    String password = rs.getString("account_pass");

                } else {

                    Prompt.showMessage("ERROR", "Sign-In failed. Provide correct details.");
                }
            } catch (Exception e) {
                Prompt.showMessage("ERROR", "Something went wrong while signing-in.");
            }
        }

    }

}
