package com.virtualpairprogrammers.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest4 {
    @Test
    public void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        //the original number was with a heading Zero: "0140449116" but did'nt work with integer parameter
        boolean result = validator.checkISBN(140449116);

        assertTrue(result);
    }

    @Test
    public void checkAnInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        //changed the last digit
        boolean result = validator.checkISBN(140449117);

        fail();
        assertFalse(result);
    }
}
