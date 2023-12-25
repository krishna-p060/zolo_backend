package com.zolobook.eLibrary.helper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
public class BorrowData {
    Integer borrowerId; // owner of the book
    LocalDateTime borrowStartTime;
    LocalDateTime borrowEndTime;

}
