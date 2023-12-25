package com.zolobook.eLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class BorrowedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer borrowId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Books book;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    Users borrower;

    LocalDateTime borrowStartTime;
    LocalDateTime borrowEndTime;

    boolean returned = false;

}
