package com.virtualpairprogrammers.isbntools;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateISBNTest5 {
    @Test
    public void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        //the original number was with a heading Zero: "0140449116" but did'nt work with integer parameter
        boolean result = validator.checkISBN(140449116);
        assertTrue(result, "first value");

        result = validator.checkISBN(140177396);
        assertTrue(result, "second value");
    }

    @Test
    public void checkAnInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        //changed the last digit
        boolean result = validator.checkISBN(140449117);

        assertFalse(result);
    }
}
