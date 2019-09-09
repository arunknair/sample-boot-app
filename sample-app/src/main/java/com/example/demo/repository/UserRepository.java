package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserRepository extends CrudRepository<User, Integer> {

}
