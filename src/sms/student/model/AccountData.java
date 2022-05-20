/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package sms.student.model;

/**
 *
 * @author Bilog
 */
public class AccountData {

    private static int accountId;
    private static String accountUser;
    private static String accountPass;
    private static String accountPassNew;
    private static String accountPassOld;

    public AccountData() {

    }

    public AccountData(int accountId, String accountUser, String accountPass) {
        AccountData.accountId = accountId;
        AccountData.accountUser = accountUser;
        AccountData.accountPass = accountPass;
    }

    public static int getAccountId() {
        return accountId;
    }

    public static void setAccountId(int accountId) {
        AccountData.accountId = accountId;
    }

    public static String getAccountUser() {
        return accountUser;
    }

    public static void setAccountUser(String accountUser) {
        AccountData.accountUser = accountUser;
    }

    public static String getAccountPass() {
        return accountPass;
    }

    public static void setAccountPass(String accountPass) {
        AccountData.accountPass = accountPass;
    }

    public static String getAccountPassNew() {
        return accountPassNew;
    }

    public static void setAccountPassNew(String accountPassNew) {
        AccountData.accountPassNew = accountPassNew;
    }

    public static String getAccountPassOld() {
        return accountPassOld;
    }

    public static void setAccountPassOld(String accountPassOld) {
        AccountData.accountPassOld = accountPassOld;
    }
}
