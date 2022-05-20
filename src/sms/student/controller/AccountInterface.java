/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.controller;

/**
 *
 * @author Bilog
 */

import java.util.ArrayList;
import sms.student.model.AccountData;


public interface AccountInterface {
    
    public void save(AccountData account);
    public void update(AccountData account);
    public void delete(AccountData account);
    public AccountData get(int id);
    public ArrayList<AccountData> accountList();
	
	public void checkUpdateAccount(int id, String user, String newPass, String oldPass);
}
