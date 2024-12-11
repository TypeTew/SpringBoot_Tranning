package com.todolist.todolist.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Long owner_id;
    private String name;
    private String desc;
    private boolean completed;
}
