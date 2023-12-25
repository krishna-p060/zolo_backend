package com.zolobook.eLibrary.repository;

import com.zolobook.eLibrary.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {
    // Add custom queries if needed
    List<Books> findByShareTrue();
}
