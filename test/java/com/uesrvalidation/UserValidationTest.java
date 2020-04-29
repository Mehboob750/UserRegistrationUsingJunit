package com.uesrvalidation;

import org.junit.Assert;
import org.junit.Test;

public class UserValidationTest {
    //Test cases for first name
    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        UserValidator validator=new UserValidator();
        boolean result = validator.validateFirstName("Mehboob");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenFirstName_WhenStartWithSmallLetters_ShouldReturnFalse() {
        UserValidator validator=new UserValidator();
        boolean result = validator.validateFirstName("mehboob");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenFirstName_WhenSizeIsLessThanThree_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("Me");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenFirstName_WhenNameContainSpecialCharacter_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("@Mehboob");
        Assert.assertEquals(false, result);
    }

    //Test cases for last name
    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        UserValidator validator=new UserValidator();
        boolean result = validator.validateLastName("Shaikh");
        Assert.assertEquals(true,result);
    }

    //Test cases to check EmailId
    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmailAddress("mehboob@bridgelabz.com");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenEmail_WhenItNotContainsSpecialSymbol_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmailAddress("mehboobbridglabz.com");
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenEmail_WhenInvalid_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmailAddress("mehboob@.com");
        Assert.assertEquals(false,result);
    }

    //Test cases to check moblie number

    @Test
    public void givenMobileNumber_WhenValid_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("1234567890");
        Assert.assertEquals(true,result);
    }
    @Test
    public void givenMobileNumber_WhenStartWithCountryCodeAndSpace_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("91 1234567890");
        Assert.assertEquals(true,result);
    }
    @Test
    public void givenMobileNumber_WhenStartWithCountryCodeAndWithoutSpace_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("911234567890");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenMobileNumber_WhenItContainsCharacterOrSpecialSymbol_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("12345678A@");
        Assert.assertEquals(false,result);
    }

    //Test cases for Password Rule-1 minimum 8 Characters
    @Test
    public void givenPassword_WhenContainsMinimumEightCharacter_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("Abcd1234");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPassword_WhenContainsLessThanEightCharacter_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("Abcd12");
        Assert.assertEquals(false,result);
    }
    //Test cases for Password Rule-2 should have atleast 1 uppercase Character
    @Test
    public void givenPassword_WhenContainsAtleastOneUpperCaseCharacter_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("abcABCabc");
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenPassword_WhenNotContainsUpperCaseCharacter_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("abcabcabc");
        Assert.assertEquals(false,result);
    }

 //Test cases for Password Rule-3 should have atleast 1 Numeric number
    @Test
    public void givenPassword_WhenContainsAtleastOneNumericNumber_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("abcABCab1");
        Assert.assertEquals(true,result);
    }
    @Test
    public void givenPassword_WhenNotContainsNumericNumber_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("Aabcabcabc");
        Assert.assertEquals(false,result);
    }


}
