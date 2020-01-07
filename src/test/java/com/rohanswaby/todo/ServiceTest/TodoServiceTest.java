package com.rohanswaby.todo.ServiceTest;

import com.rohanswaby.todo.model.Todo;
import com.rohanswaby.todo.repository.TodoRepository;
//import com.rohanswaby.todo.service.TodoIntService;
import com.rohanswaby.todo.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {


    @InjectMocks
    TodoService todoService;

    @Mock
    TodoRepository todoRepository;

    @Test
    public void getTodoByUserName(){
        List<Todo> todoList = new ArrayList<>();

        todoList.add(new Todo("rohan","details",new Date(),false));
        todoList.add(new Todo("rue","details",new Date(),false));
        todoList.add(new Todo("ronny","details",new Date(),false));
        todoList.add(new Todo("rohan","details",new Date(),false));
        todoList.add(new Todo("rohan","details",new Date(),false));

        when(todoRepository.findByUsername("rohan")).thenReturn(todoList);
        verify(todoRepository,times(0)).findByUsername("rohan");

        List<Todo> list = todoRepository.findByUsername("Rohan");

        System.out.println(list.size());

        verify(todoRepository,times(1)).findByUsername("Rohan");


    }

}
