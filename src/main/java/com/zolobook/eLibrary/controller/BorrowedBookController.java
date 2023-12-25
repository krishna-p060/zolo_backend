package com.zolobook.eLibrary.controller;

import com.zolobook.eLibrary.helper.BorrowData;
import com.zolobook.eLibrary.model.Books;
import com.zolobook.eLibrary.model.BorrowedBooks;
import com.zolobook.eLibrary.model.Users;
import com.zolobook.eLibrary.service.BookService;
import com.zolobook.eLibrary.service.BorrowedBookService;
import com.zolobook.eLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/booky")
public class BorrowedBookController {

    @Autowired
    BorrowedBookService borrowedBookService;
    @Autowired
    UserService userService;
    @Autowired
    BookService booksService;

    @PostMapping("/{book_id}/borrow")
    public ResponseEntity<String> borrowBook(@PathVariable Integer book_id, @RequestBody BorrowData borrowData) {
        try {
            Books book = booksService.getBookById(book_id);
            Users borrower = userService.getUserById(borrowData.getBorrowerId());

            if (book != null && borrower != null) {
                BorrowedBooks borrowedBooks = new BorrowedBooks();
                borrowedBooks.setBook(book);
                borrowedBooks.setBorrower(borrower);
                borrowedBooks.setBorrowStartTime(borrowData.getBorrowStartTime());
                borrowedBooks.setBorrowEndTime(borrowData.getBorrowEndTime());

                // Update book availability status
                booksService.updateBookAvailabilityStatus(book_id, false);

                return ResponseEntity.ok(borrowedBookService.borrowBook(borrowedBooks));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid book or borrower ID.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error borrowing book.");
        }
    }

    @PutMapping("/{bookId}/borrow/{borrowId}")
    public ResponseEntity<String> returnBook(@PathVariable Integer bookId, @PathVariable Integer borrowId) {
        try {
            // Update book availability status
            booksService.updateBookAvailabilityStatus(bookId, true);

            return ResponseEntity.ok(borrowedBookService.returnBook(bookId, borrowId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error returning book.");
        }
    }
}