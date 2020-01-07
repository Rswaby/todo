package com.rohanswaby.todo.ServiceTest;

import com.rohanswaby.todo.model.Todo;
import com.rohanswaby.todo.repository.TodoRepository;
//import com.rohanswaby.todo.service.TodoIntService;
import com.rohanswaby.todo.service.TodoService;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {


    @Mock
    TodoService todoService;



    @Mock
    TodoRepository todoRepository;

    @Test
    public void getTodoByUserNameTest(){
        List<Todo> todoList = new ArrayList<>();

        todoList.add(new Todo("rohan","details",new Date(),false));
        todoList.add(new Todo("rue","details",new Date(),false));
        todoList.add(new Todo("ronny","details",new Date(),false));
        todoList.add(new Todo("rohan","details",new Date(),false));
        todoList.add(new Todo("rohan","details",new Date(),false));

        when(todoRepository.findByUsername("rohan")).thenReturn(todoList);
        verify(todoRepository,times(0)).findByUsername("rohan");

        List<Todo> list = todoRepository.findByUsername("rohan");

        System.out.println(list.size());

        verify(todoRepository,times(1)).findByUsername("rohan");


    }

    @Test
    public  void getTodoByIdTest(){
        Todo todo = new Todo("rohan","details",new Date(),false);

        when(todoService.getTodoById(0)).thenReturn(Optional.of(todo));
        verify(todoService,times(0)).getTodoById(90);
        Optional<Todo> result = todoService.getTodoById(0);
        verify(todoService,times(1)).getTodoById(0);
        //assertEquals(todo,)

    }

}
