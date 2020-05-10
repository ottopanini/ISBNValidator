package com.virtualpairprogrammers.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ValidateISBNTest4 {
    @Test
    public void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        //the original number was with a heading Zero: "0140449116" but did'nt work with integer parameter
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value", result);

        result = validator.checkISBN("0140177396");
        assertTrue("second value", result);
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

}
