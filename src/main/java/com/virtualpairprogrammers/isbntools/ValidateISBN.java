package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {
    public boolean checkISBN(String isbn) {
        if (isbn.length() < 10) throw new NumberFormatException("ISBN numbers must be 10 digits long");

        int total = 0;
        for (int i = 0; i < 10; i++) {
            char charAt = isbn.charAt(i);
            if (!Character.isDigit(charAt)) {
                if (i == 9 && charAt == 'X') {
                    total += 10;
                }
                else {
                    throw new NumberFormatException("ISBN numbers can only contain numeric digits");
                }
            }
            else total += Character.getNumericValue(charAt) * (10 - i);
        }

        return total % 11 == 0;
    }
}
