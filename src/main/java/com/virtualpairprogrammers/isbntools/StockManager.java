package com.virtualpairprogrammers.isbntools;

public class StockManager {

    private ExternalISBNDataService externalISBNDataService;

    public void setExternalISBNDataService(ExternalISBNDataService externalISBNDataService) {
        this.externalISBNDataService = externalISBNDataService;
    }

    public String getLocatorCode(String isbn) {
        Book book = externalISBNDataService.lookup(isbn);
        StringBuilder locatorBuilder = new StringBuilder();
        locatorBuilder.append(isbn.substring(isbn.length() - 4));
        locatorBuilder.append(book.getAuthor().substring(0, 1));
        locatorBuilder.append(book.getTitle().split(" ").length);
        return locatorBuilder.toString();
    }
}
