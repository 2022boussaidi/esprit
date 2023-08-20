package com.full.full.repository;

import com.full.full.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {
    Task findById(long id);
}
