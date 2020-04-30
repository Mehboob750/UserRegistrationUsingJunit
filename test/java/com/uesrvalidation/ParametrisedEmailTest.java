package com.uesrvalidation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrisedEmailTest {
    private final String emailId;
    private final Boolean expectedResult;
    UserValidator validator = new UserValidator();

    public ParametrisedEmailTest(String emailId, Boolean expectedResult) {
        this.expectedResult = expectedResult;
        this.emailId = emailId;
    }

    @Parameterized.Parameters
    public static Collection email_With_ExpectedOutput() {
        return Arrays.asList(new Object[][]{{"abc@gmail.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.123@yahoo.co.in", true},
                {"abc111@abc.com",true},
                {"abc.100@abc.com.au",true},
                {"abc@1.com",true},
                {"abc+100@gmail.com",true},
                {"abc",false},
                {"abc@.com.my",false},
                {"abc123@gmail.a",false},
                {"abc123@.com",false},
                {"abc()*@gmail.com",false},
                {"abc..2002@gmail.com",false},
                {"abc@%*.com",false},
                {"abc.@gmail.com",false},
                {"abc@avcgmail..com",false},
                {"abc@gmail.com.1a",false},
                {"abc@gmail.com.aa.au",false}});
    }

    @Test
    public void givenEmilId_WhenProper_ShouldReturnTrue() {
        Assert.assertEquals(expectedResult,validator.validateEmailAddress(emailId));
    }
}