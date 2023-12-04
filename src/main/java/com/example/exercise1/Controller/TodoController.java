package com.example.exercise1.Controller;

import com.example.exercise1.Exception.AppException;
import com.example.exercise1.Model.Actor;
import com.example.exercise1.Model.Film;
import com.example.exercise1.Model.Todo;
import com.example.exercise1.Service.ActorServices;
import com.example.exercise1.Service.TodoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/todos")
public class TodoController {
    private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PostMapping()
    public Todo addTodo(@Valid @RequestBody Todo task){

        task.setTodoId(0);
        Todo dbTask = todoService.createNewTodo(task);
        return dbTask;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> detailFilm( @PathVariable (value = "id") String id ) {
        int todoId;
        try {
            todoId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }

        Todo task =todoService.findById(todoId);
        return ResponseEntity.ok(task);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateFilm(@PathVariable (value = "id") String id,@Valid @RequestBody Todo task){
        int todoId;
        try {
            todoId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }
        Todo dbTask =todoService.findById(todoId);
        if(dbTask!=null){
            task.setTodoId(todoId);
            if(task.getDescription()==null){
                task.setDescription(dbTask.getDescription());
            }
            task.setLastUpdate(new Timestamp((new Date()).getTime()));
            Todo res=todoService.saveTodo(task);
        }


        return ResponseEntity.ok(task);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable (value = "id") String id) {
        int todoId;
        try {
            todoId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }

        Todo task =todoService.findById(todoId);
        if(task==null){
            throw new RuntimeException("Not Found");
        }
        todoService.deleteById(todoId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
