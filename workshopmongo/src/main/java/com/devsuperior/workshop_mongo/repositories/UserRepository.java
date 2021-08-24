package com.devsuperior.workshop_mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.workshop_mongo.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
