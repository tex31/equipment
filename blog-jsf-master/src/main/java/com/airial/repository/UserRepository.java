package com.airial.repository;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
