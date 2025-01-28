package learnspringboot.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PartnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPartner() throws Exception {
        mockMvc.perform(
                get("/partner/current")
                        .header("X-API-KEY", "SAMPLE")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("SAMPLE : Sample Partner"))
        );
    }

    @Test
    public void getPartnerError() throws Exception {
        mockMvc.perform(
                get("/partner/current")
        ).andExpectAll(
                status().isInternalServerError()
        );
    }
}
