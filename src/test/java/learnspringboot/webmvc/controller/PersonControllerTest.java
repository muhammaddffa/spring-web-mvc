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
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Dade")
                        .param("middleName", "Jack")
                        .param("lastName", "Puki")
                        .param("email", "dade@example.com")
                        .param("phone", "081238200")
                        .param("address.street", "Pahlawan")
                        .param("address.city", "Bandung")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "1111")
                        .param("hobbies[0]", "Coding") // List dengan tipe data primitive seperti String, Integer, dan sejenisnya
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Cooking")
                        .param("socialMedias[0].name", "Facebook") // Untuk List dengan tipe data object
                        .param("socialMedias[0].location", "facebook.com/muhammaddaffa")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person Dade Jack Puki " +
                        "with email dade@example.com with phone 081238200 with address " + "Pahlawan, Bandung, Indonesia, 1111"))
        );
    }

    @Test
    void createPersonInvalid() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName", "Jack")
                        .param("lastName", "Puki")
                        .param("address.street", "Pahlawan")
                        .param("address.city", "Bandung")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "1111")
                        .param("hobbies[0]", "Coding") // List dengan tipe data primitive seperti String, Integer, dan sejenisnya
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Cooking")
                        .param("socialMedias[0].name", "Facebook") // Untuk List dengan tipe data object
                        .param("socialMedias[0].location", "facebook.com/muhammaddaffa")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("You send invalid data"))
        );
    }

}
