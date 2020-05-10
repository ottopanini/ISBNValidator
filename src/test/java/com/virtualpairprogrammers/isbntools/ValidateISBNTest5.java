package com.virtualpairprogrammers.isbntools;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateISBNTest5 {
    @Test
    public void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        //the original number was with a heading Zero: "0140449116" but did'nt work with integer parameter
        boolean result = validator.checkISBN("0140449116");
        assertTrue(result, "first value");

        result = validator.checkISBN("0140177396");
        assertTrue(result, "second value");
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

    @Test
    public void nineDigitsISBNsNotallowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("123456789"));
    }

    @Test
    public void noneNumericISBNsNotallowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("helloworld"));
    }
}
