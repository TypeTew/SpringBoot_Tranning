package com.example.traning.controllers;


import com.example.traning.models.Task;
import com.example.traning.servies.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    // [GET All] API สำหรับ เรียกดูข้อมูล / ค้นหาชื่อของ Task todo-list
    @GetMapping("/")
    public ResponseEntity<?> getAllTask(@RequestParam(value = "name", defaultValue = "") String name){
        if(name.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTask());
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(taskService.findTaskName(name));
        }
    }

    // [GET Detail] API สำหรับ เรียกดูข้อมูลของเเต่ละ Task todo-list
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTask(@PathVariable Long id){
        Optional<Task> task = taskService.findTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body(task);

    }

    //INSERT TASK
    @PostMapping("/")
    public ResponseEntity<?> createTask(@RequestBody Task task){
        Task newTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    // [GET] AllCompletedTask
    // API สำหรับ เรียกดู Task ที่ทำเสร็จแล้วทั้งหมด (completed = true)
    @GetMapping("/completed")
    public ResponseEntity<?> getAllTaskCompleted(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllCompletedTask());
    }

    // [GET] findAllUnCompletedTask
    // API สำหรับ เรียกดู Task ที่ทำไม่เสร็จแล้วทั้งหมด (completed = false)
    @GetMapping("/uncompleted")
    public ResponseEntity<List<Task>> getAllTaskUnCompleted(){
        List<Task> tasks = taskService.findAllUnCompletedTask();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }




}