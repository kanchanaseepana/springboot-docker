package com.nagarro.dockersample.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.dockersample.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
