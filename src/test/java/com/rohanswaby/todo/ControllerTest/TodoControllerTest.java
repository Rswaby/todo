package com.rohanswaby.todo.ControllerTest;

import com.rohanswaby.todo.controller.TodoController;
import com.rohanswaby.todo.service.TodoService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TodoControllerTest {
    @InjectMocks
    TodoController todoController;

    @Mock
    TodoService todoService;
}
