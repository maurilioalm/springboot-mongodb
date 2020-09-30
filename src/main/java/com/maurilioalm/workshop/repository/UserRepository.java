package com.maurilioalm.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maurilioalm.workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
