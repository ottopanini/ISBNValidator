package com.virtualpairprogrammers.isbntools;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StockManagementTest {
    @Test
    public void testCanGetACorrectLocatorCode() {
        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
            }
        };
        StockManager stockManager = new StockManager();
        stockManager.setExternalISBNDataService(testService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        Assertions.assertEquals("7396J4", locatorCode);
    }
}
