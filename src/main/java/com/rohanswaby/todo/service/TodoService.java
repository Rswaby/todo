package com.rohanswaby.todo.service;

import com.rohanswaby.todo.model.Todo;
import com.rohanswaby.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements TodoIntService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getTodoByUser(String user){
        return todoRepository.findByUsername(user);
    }

    @Override
    public Optional<Todo> getTodoById(long id){
        return todoRepository.findById(id);
    }

    @Override
    public Todo updateTodo(Todo todo){
        todoRepository.save(todo);

        return todo;
    }

    @Override
    public void createTodo(String name,
                           String title,
                           String details,
                           Date startDate,
                           Date endDate,
                           Boolean done){
        Todo todo = new Todo(name,details, startDate,done);
        todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> deleteTodo(long id){
        Optional<Todo> todo = todoRepository.findById(id);
        todo.ifPresent(value -> todoRepository.delete(value));

        return todo;
    }


    @Override
    public void saveTodo(Todo todo){
        todoRepository.save(todo);
    }



}
