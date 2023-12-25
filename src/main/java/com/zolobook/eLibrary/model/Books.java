package com.zolobook.eLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookId;
    String title;
    String author;

    boolean share = false;


    @JoinColumn(name = "user_id")
    Integer userId;

    boolean AvailableToBorrow = false;

}
