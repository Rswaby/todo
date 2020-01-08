package com.rohanswaby.todo.ControllerTest;

import com.rohanswaby.todo.controller.TodoController;
import com.rohanswaby.todo.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {
//    @InjectMocks
//    TodoController todoController;

    @Mock
    TodoService todoService;

    @Test
    public void creatTodoTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }
}
