package com.example.library_management_system.Repositories;

import com.example.library_management_system.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //public List<User> getAllUsers();
}
