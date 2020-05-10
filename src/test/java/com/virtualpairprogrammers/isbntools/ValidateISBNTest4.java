package com.virtualpairprogrammers.isbntools;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateISBNTest4 {
    @Test
    public void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value", result);

        result = validator.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void isbnNumbersEndingbyXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkAnInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        //changed the last digit
        boolean result = validator.checkISBN("0140449117");

        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitsISBNsNotallowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void noneNumericISBNsNotallowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld");
    }
}
