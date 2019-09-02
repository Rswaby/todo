package com.rohanswaby.todo.controller;

import com.rohanswaby.todo.model.Todo;
import com.rohanswaby.todo.service.TodoIntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class TodoController {

    @GetMapping(path = "/test")
    public Date Test(){

        return new Date();
    }

    @Autowired
    private TodoIntService todoService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
    }

    @RequestMapping(value = "/todos/{userName}", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> getTodosByUserName(@PathVariable String userName){

        //get user and query by username
        List<Todo> todos = todoService.getTodoByUser(userName);//will prob need some error checking

        return new ResponseEntity<>(todos,HttpStatus.FOUND);
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Optional<Todo>> deleteTodo(@PathVariable long id){
        Optional< Todo > todo = todoService.deleteTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.ACCEPTED);
    }



    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodoById(@PathVariable long id, @RequestBody Todo todo){
        //find todo by id.

        Optional<Todo> newTodo;
        newTodo = todoService.getTodoById(id);
        Todo todo1;
        if(newTodo.isPresent()){
            todo1 = newTodo.get();
            todo1.setDetails(todo.getDetails());
            todo1.setDone(todo.getDone());
            todo1.setStartDate(todo.getStartDate());
            todo1.setEndDate(todo.getEndDate());
            todo1.setTitle(todo.getTitle());

            todoService.updateTodo(todo1);
            return new ResponseEntity<>(todo1, HttpStatus.ACCEPTED);
        }
        //newTodo.setDetails();
        //= todoService.updateTodo(todo);

        return new ResponseEntity<>(new Todo(), HttpStatus.NOT_FOUND);

    }


    @RequestMapping(value = "/todos" ,method = RequestMethod.POST)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        todoService.createTodo(
                todo.getUsername(),
                todo.getTitle(),
                todo.getDetails(),
                todo.getStartDate(),
                todo.getEndDate(),
                todo.getDone()
        );
        return new ResponseEntity<>(todo, HttpStatus.ACCEPTED);
    }











}
