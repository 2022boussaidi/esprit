package com.full.full.controller;

import com.full.full.models.Task;
import com.full.full.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3002/")
@AllArgsConstructor
@RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    Task newTask(@RequestBody Task newTask) {
        return taskService.createTask(newTask);
    }

    @GetMapping
    List<Task> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @PostMapping("/{projectId}/addTask/{taskId}")
    Task addTaskToProject(@PathVariable Long projectId, @PathVariable Long taskId) {
        taskService.addTaskToProject(projectId, taskId);
        return taskService.getTaskById(taskId);
    }
    @DeleteMapping("/{projectId}/removeTask/{taskId}")
    void removeTaskFromProject(@PathVariable Long projectId, @PathVariable Long taskId) {
        taskService.removeTaskFromProject(projectId, taskId);
    }
    @PutMapping("/{id}/mark-completed")
    ResponseEntity<String> markTaskAsCompleted(@PathVariable Long id) {
        taskService.markTaskAsCompleted(id);
        return ResponseEntity.ok("Task marked as completed.");
    }

}