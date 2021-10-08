package com.alfa.model;

import com.alfa.model.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ServiceBooks {
    private List<Book> books;
    private static Logger logger = Logger.getLogger(ServiceBooks.class.getName());

    public ServiceBooks() {
        this.books = SourceBooks.getBooks();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<String> getAllBooks() {
        return ConverterBooks.convert(books);
    }

    public void addBook(String param1, String param2, String param3, int param4, int param5, double param6) {
        books.add(new Book(param1, param2, param3, param4, param5, param6));
    }

    public List<Book> search(String criteria, String param) {
        logger.info("Criteria = " + criteria + ", Parameter = " + param);
        switch (criteria) {
            case "author":
                return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(param)).collect(Collectors.toList());
            case "publisher":
                return books.stream().filter(book -> book.getPulisher().equalsIgnoreCase(param)).collect(Collectors.toList());
            default:
                return new ArrayList<>();
        }
    }

    public List<Book> searchYear(int param) {
        return books.stream().filter(book -> book.getYear() >= param).collect(Collectors.toList());
    }
}
