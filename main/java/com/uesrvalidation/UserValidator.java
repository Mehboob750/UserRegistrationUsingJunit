package com.uesrvalidation;

import java.util.regex.Pattern;

public class UserValidator {
    private static final String PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    public boolean validateFirstName(String fname) {
        Pattern pattern = Pattern.compile(PATTERN);
        return pattern.matcher(fname).matches();
    }
}
