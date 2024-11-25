package com.example.traning.repository;

import com.example.traning.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task,Long> {


    public List<Task> findAll();
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findByNameIsContaining(String name);

}
