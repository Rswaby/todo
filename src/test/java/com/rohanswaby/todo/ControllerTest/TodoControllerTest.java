package com.rohanswaby.todo.ControllerTest;

import com.rohanswaby.todo.controller.TodoController;
import com.rohanswaby.todo.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {
//    @InjectMocks
//    TodoController todoController;

    @Mock
    TodoService todoService;


    @Autowired
    private MockMvc mvc;

    @Test
    public void creatTodoTest() throws Exception{
        //MockHttpServletRequest request = new MockHttpServletRequest();
        //RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

    }
}
