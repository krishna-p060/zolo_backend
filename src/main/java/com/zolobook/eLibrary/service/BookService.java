package com.zolobook.eLibrary.service;

import com.zolobook.eLibrary.model.Books;
import com.zolobook.eLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Books> getAllBooks() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving books.", e);
        }
    }

    public String addBooks(Books books) {
        try {
            if (books.isShare()) {
                books.setAvailableToBorrow(true);
            }
            bookRepository.save(books);
            return "Book Added Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error adding book.", e);
        }
    }

    public List<Books> getSharedBooks() {
        try {
            return bookRepository.findByShareTrue();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving shared books.", e);
        }
    }

    public Books getBookById(Integer id) {
        try {
            return bookRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving book by ID.", e);
        }
    }

    public boolean isAvailableToBorrow(Integer bookId) {
        try {
            Books book = bookRepository.findById(bookId).orElse(null);
            return book != null && book.isAvailableToBorrow();
        } catch (Exception e) {
            throw new RuntimeException("Error checking book availability.", e);
        }
    }

    public String updateBookAvailabilityStatus(Integer bookId, Boolean status) {
        try {
            Books book = bookRepository.findById(bookId).orElse(null);
            if (book != null) {
                book.setAvailableToBorrow(status);
                bookRepository.save(book);
                return "Book availability status updated successfully";
            } else {
                return "Book not found";
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating book availability status.", e);
        }
    }
}
