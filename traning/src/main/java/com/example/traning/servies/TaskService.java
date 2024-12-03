package com.example.traning.servies;

import com.example.traning.models.Task;
import com.example.traning.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // === function/method Service สำหรับ เรียก task todo-list ทั้งหมด
    public List<Task> getAllTask() {
        return  taskRepository.findAll();
    }

    // ==== function/method Service สำหรับ สร้าง task todo-list
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    // ==== function/method Service สำหรับ ค้นหา task todo-list ด้วย ID
    public Optional<Task> findTaskById(Long id){
        return taskRepository.findById(id);
    }

    // ==== function/method Service สำหรับ เรียก task todo-list ที่ทำเสร็จแล้วทั้งหมด (Completed = True)
    public List<Task> findAllCompletedTask()
    {
        return taskRepository.findByCompletedTrue();
    }

    // ==== function/method Service สำหรับ เรียก task todo-list ที่ทำไม่เสร็จแล้วทั้งหมด (Completed = False)
    public List<Task> findAllUnCompletedTask()
    {
        return taskRepository.findByCompletedFalse();
    }

    public List<Task> findTaskName(String name)
    {
        return taskRepository.findByNameIsContaining(name);
    }

    // === function/method Service สำหรับ แก้ไขข้อมูล task todo-list
    public Optional<Task> updateTask(Long id, Task task){
        Optional<Task> getTask = taskRepository.findById(id);

        if(getTask.isEmpty()){
            return getTask;
        }

        task.setId(id);
        return Optional.of(taskRepository.save(task));
    }

    // === function/method Service สำหรับ ลบข้อมูล task todo-list
    public boolean deleteTask(Long id) {
        Optional<Task> getTask = taskRepository.findById(id);
        if (getTask.isEmpty()) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }

}
