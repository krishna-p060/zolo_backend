package com.zolobook.eLibrary.service;

import com.zolobook.eLibrary.model.BorrowedBooks;
import com.zolobook.eLibrary.repository.BorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BorrowedBookService {
    @Autowired
    BorrowedBookRepository borrowedBookRepository;

    public String borrowBook(BorrowedBooks borrowedBooks) {
        borrowedBookRepository.save(borrowedBooks);
        return "Book Borrowed Successfully";
    }

    public String returnBook(Integer bookId, Integer borrowId) {
        BorrowedBooks borrowedBooks = borrowedBookRepository.findById(borrowId).orElse(null);
        if (borrowedBooks != null) {
            borrowedBooks.setBorrowEndTime(LocalDateTime.now());
            borrowedBooks.setReturned(true);
            borrowedBookRepository.save(borrowedBooks);
            return "Book Returned Successfully";
        } else {
            return "Borrowed book not found.";
        }
    }
}
