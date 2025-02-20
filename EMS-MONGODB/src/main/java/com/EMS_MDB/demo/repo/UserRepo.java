package com.EMS_MDB.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.EMS_MDB.demo.Entity.MongoUser;


@Repository
public interface UserRepo extends MongoRepository<MongoUser, String> {

}
