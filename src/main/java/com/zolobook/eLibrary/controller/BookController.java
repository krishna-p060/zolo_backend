package com.zolobook.eLibrary.controller;

import com.zolobook.eLibrary.model.Books;
import com.zolobook.eLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booky")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks() {
        try {
            List<Books> books = bookService.getAllBooks();
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> addBooks(@RequestBody Books books) {
        try {
            String response = bookService.addBooks(books);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding book.");
        }
    }

    @GetMapping("/shared")
    public ResponseEntity<List<Books>> getSharedBooks() {
        try {
            List<Books> sharedBooks = bookService.getSharedBooks();
            return ResponseEntity.ok(sharedBooks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}