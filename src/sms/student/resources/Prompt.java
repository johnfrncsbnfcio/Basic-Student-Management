/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.resources;

import javax.swing.JOptionPane;

/**
 *
 * @author Bilog
 */
public class Prompt {
    public static void showMessage(String type, String msg) {
        switch(type) {
        case "OK":
            JOptionPane.showMessageDialog(null, msg);
            break;
        case "ERROR":
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
            break;
        }
    }
}
