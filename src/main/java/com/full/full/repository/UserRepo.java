package com.full.full.repository;

import com.full.full.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findById(long id);

    User findByUsername(String username);
}
