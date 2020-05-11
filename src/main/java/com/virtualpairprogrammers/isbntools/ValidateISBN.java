package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {

    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == LONG_ISBN_LENGTH) {
            return isValid13DigitsISBN(isbn);
        }
        else {
            if (isbn.length() != SHORT_ISBN_LENGTH) throw new NumberFormatException("ISBN numbers must be 10 digits long");

            return isValid10DigitsISBN(isbn);
        }
    }

    private boolean isValid10DigitsISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            char charAt = isbn.charAt(i);
            if (!Character.isDigit(charAt)) {
                if (i == 9 && charAt == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN numbers can only contain numeric digits");
                }
            } else total += Character.getNumericValue(charAt) * (SHORT_ISBN_LENGTH - i);
        }

        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isValid13DigitsISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            char charAt = isbn.charAt(i);
            if (i % 2 == 0) total += Character.getNumericValue(charAt);
            else total += Character.getNumericValue(charAt) * 3;
        }

        return total % LONG_ISBN_MULTIPLIER == 0;
    }
}
