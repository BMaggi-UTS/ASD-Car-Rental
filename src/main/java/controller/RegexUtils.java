package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    private static String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
    private static String namePattern = "[A-Z][a-z]*";
    private static String passwordPattern = "[A-Z][a-z][0-9]{2,}";
    private static String phonePattern = "04[0-9]{8}$";


    private static boolean validate(String pattern, String input){       
       Pattern regEx = Pattern.compile(pattern);       
       Matcher match = regEx.matcher(input);       
       return match.matches(); 
    }       

    public static boolean validateEmail(String email){                       
       return validate(emailPattern,email);   
    }

    public static boolean validateName(String name){
       return validate(namePattern,name); 
    }       

    public static boolean validatePassword(String password){
       return validate(passwordPattern,password); 
    }

    public static boolean validatePhoneNo(String phoneNo) {
      return validate(phonePattern, phoneNo);
    }

}
