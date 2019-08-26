package com.rohanswaby.todo.service;

import com.rohanswaby.todo.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TodoIntService {

    List<Todo> getTodoByUser(String user);

    Optional<Todo> getTodoById(long id);

    void createTodo(String name,String tile, String description, Date startDate,Date endDate,Boolean done);

    Todo updateTodo(Todo todo);

    Optional<Todo> deleteTodo(long id);

    void saveTodo(Todo todo);


}
