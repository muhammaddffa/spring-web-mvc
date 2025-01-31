package learnspringboot.webmvc.controller;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void postTodo() throws Exception {
        mockMvc.perform(
                post("/todos")
                        .param("todo", "Dade")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Dade"))
        );
    }

    @Test
    void getTodos() throws Exception {
        mockMvc.perform(
                get("/todos")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Dade"))
        );
    }
}
