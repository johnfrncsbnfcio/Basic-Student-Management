/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.resources;

import java.util.regex.Pattern;

/**
 *
 * @author Bilog
 */
public class EmailValidation {

    public boolean isValidEmail;
    public boolean isValidEmailEdit;
    
    public void validateEmail(String email) {

        if (email == null || email.isEmpty()) {
            isValidEmail = false;
        }

        String email_regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(email_regex);
        if (pattern.matcher(email).matches()) {
            isValidEmail = true;
        } else {
            isValidEmail = false;
        }

    }
    
    public void validateEmailEdit(String email) {

        if (email == null || email.isEmpty()) {
            isValidEmailEdit = false;
        }

        String email_regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(email_regex);
        if (pattern.matcher(email).matches()) {
            isValidEmailEdit = true;
        } else {
            isValidEmailEdit = false;
        }

    }

}
