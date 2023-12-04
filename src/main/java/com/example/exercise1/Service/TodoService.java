package com.example.exercise1.Service;

import com.example.exercise1.Exception.AppException;
import com.example.exercise1.Model.Actor;
import com.example.exercise1.Model.Film;
import com.example.exercise1.Model.Todo;
import com.example.exercise1.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo createNewTodo(Todo task) {
        task.setStatus(false);
        task.setLastUpdate(new Timestamp((new Date()).getTime()));
        return todoRepository.save(task);
    }
    public Todo saveTodo(Todo task){
        return todoRepository.save(task);
    }
    public Todo findById(Integer theId){
        Optional<Todo> res=todoRepository.findById(theId);
        Todo task=null;
        if(res.isPresent()){
            task=res.get();
        }else{
            throw new AppException(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "task is Not Found");
        }
        return task;
    }
    public void deleteById(Integer theId){
        todoRepository.deleteById(theId);
    }

}
