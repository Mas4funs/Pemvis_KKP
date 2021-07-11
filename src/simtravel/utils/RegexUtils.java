/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simtravel.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nursalim
 */
public class RegexUtils {
    
    String regexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
    String regexDigit = "\\d+";
    
    public boolean validateEmail(String emailAddress){
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(emailAddress);
        
        return matcher.matches();
    }
    
    public boolean validateDigit(String numeric){
        Pattern pattern = Pattern.compile(regexDigit);
        Matcher matcher = pattern.matcher(numeric);
        
        return matcher.matches();
    }
    
    public static void main(String[] args){
        System.out.println(new RegexUtils().validateDigit("12345"));
    }
    
}
