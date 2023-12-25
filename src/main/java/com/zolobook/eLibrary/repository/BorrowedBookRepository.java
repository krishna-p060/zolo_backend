package com.zolobook.eLibrary.repository;

import com.zolobook.eLibrary.model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BorrowedBookRepository extends JpaRepository<BorrowedBooks, Integer> {
    // Add custom queries if needed
}