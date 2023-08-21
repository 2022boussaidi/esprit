package com.full.full.repository;

import com.full.full.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

    User findById(long id);

    User findByUsername(String username);
    List<User> findByTeamIsNull();
}
