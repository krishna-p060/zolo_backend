package com.zolobook.eLibrary.repository;

import com.zolobook.eLibrary.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    // Add custom queries if needed
}







