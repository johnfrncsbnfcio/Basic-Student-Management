/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.resources;

/**
 *
 * @author Bilog
 */
public class StringManipulation {
    public static String upperCasefirst(String txt) {
        char[] array = txt.toCharArray();
        array[0] = Character.toUpperCase(array[0]);
        return new String(array);
    }
}
