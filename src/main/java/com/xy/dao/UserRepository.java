package com.xy.dao;

import com.xy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username,String password);
}
