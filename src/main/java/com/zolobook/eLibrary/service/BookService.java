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
        return bookRepository.findAll();
    }

    public String addBooks(Books books) {
//        System.out.println(books.getUser().getUserId());
        if (books.isShare()) {
            books.setAvailableToBorrow(true);
        }
        bookRepository.save(books);
        return "Book Added Successfully";
    }

    public List<Books> getSharedBooks() {
        return bookRepository.findByShareTrue();
    }

    public Books getBookById(Integer id) {

        return bookRepository.findById(id).orElse(null);
    }

    public String updateBookAvailabilityStatus(Integer bookId, Boolean status) {
        Books book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            book.setAvailableToBorrow(status);
            bookRepository.save(book);
            return "Book availability status updated successfully";
        } else {
            return "Book not found";
        }
    }



}
