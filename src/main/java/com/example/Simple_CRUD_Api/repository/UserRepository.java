package com.example.Simple_CRUD_Api.repository;

import com.example.Simple_CRUD_Api.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
