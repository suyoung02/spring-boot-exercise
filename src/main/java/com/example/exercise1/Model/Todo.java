package com.example.exercise1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.sql.Timestamp;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Integer todoId;

    @Column(name = "todo_name")
    @NotEmpty(message = "name not be empty")
    private String todoName;

    @Column(name = "description")
    private String description;
    @Column(name = "todo_status")
    private Boolean status;


    @Column(name = "last_update")
    private Timestamp lastUpdate;
    public Todo(){

    }

    public Todo(String todoName, String description, Boolean status, Timestamp lastUpdate) {
        this.todoName = todoName;
        this.description = description;
        this.status = status;
        this.lastUpdate = lastUpdate;
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", todoName='" + todoName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
