package com.SpringJpa.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SpringJpa.Entity.User;

@Repository
public interface UserLoginRepo extends MongoRepository<User, String> {

}
