package com.example.traning.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "desc is mandatory")
    @Column(name = "description")
    private String des;

    @NotNull(message = "completed is mandatory")
    private Boolean completed;

}
