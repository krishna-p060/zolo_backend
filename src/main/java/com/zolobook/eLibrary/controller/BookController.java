package com.zolobook.eLibrary.controller;

import com.zolobook.eLibrary.model.Books;
import com.zolobook.eLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booky")
public class BookController {


    @Autowired
    BookService bookService;

    @GetMapping
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public String addBooks(@RequestBody Books books) {
        //System.out.println(books);

        return bookService.addBooks(books);
    }

    @GetMapping("/shared")
    public List<Books> getSharedBooks() {
        return bookService.getSharedBooks();
    }


}
