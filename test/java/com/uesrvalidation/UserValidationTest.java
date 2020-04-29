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


}
