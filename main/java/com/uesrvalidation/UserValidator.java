package com.uesrvalidation;

import java.net.PasswordAuthentication;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    private static final String EMAIL_PATTERN = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@[0-9a-zA-Z]+.[a-zA-Z]{2,4}([.][a-zA-Z]{2,3})?$";
    private static final String MOBILE_PATTERN = "^([0-9]{2}[ ])?([1-9]{1}[0-9]{9})$";
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,})";
    public boolean validateFirstName(String firstName) {
        Pattern pattern = Pattern.compile(PATTERN);
        return pattern.matcher(firstName).matches();
    }

    public boolean validateLastName(String lastName) {
        Pattern pattern = Pattern.compile(PATTERN);
        return pattern.matcher(lastName).matches();
    }

    public boolean validateEmailAddress(String emailId) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(emailId).matches();
    }

    public boolean validateMobileNumber(String mobileNumber) {
         Pattern pattern = Pattern.compile(MOBILE_PATTERN);
         return pattern.matcher(mobileNumber).matches();
    }

    public boolean validatePassword(String password) {
        int SPECIAL_CHARACTER = 0;
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        Pattern pattern1 = Pattern.compile("[!@#$%^&*()]");
        Matcher matcher1 = pattern1.matcher(password);
    //    return pattern.matcher(password).matches();
        while(matcher1.find()){
            SPECIAL_CHARACTER++;
        }
        return SPECIAL_CHARACTER==1;
    }
}
