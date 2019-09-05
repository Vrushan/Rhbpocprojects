package com.example.RHB.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RHB.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
