package com.rohanswaby.todo.ControllerTest;

import com.rohanswaby.todo.controller.TodoController;
import com.rohanswaby.todo.service.TodoIntService;
import com.rohanswaby.todo.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
@ContextConfiguration(classes = {TodoController.class,TodoIntService.class})
public class TodoControllerTest {
    @InjectMocks
    TodoController todoController;

//    @InjectMocks
//    TodoService todoService;

    @Mock
    TodoService todoService;


    @Autowired
    private MockMvc mvc;

    @Test
    public void creatTodoTest() throws Exception{
        //MockHttpServletRequest request = new MockHttpServletRequest();
        //RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        mvc.perform(MockMvcRequestBuilders
                .get("/todos/{userName}","rohan")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("rohan"));
    }
}
