package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.entity.User;
import com.example.demo.services.UserServices;

import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServices userService;

//    @Test
//    public void testGetAllUsers() throws Exception {
//      
//        User user1 = new User("John", "Doe", "john.doe@example.com", null);
//        User user2 = new User("Jane", "Smith", "jane.smith@example.com", null);
//        
//        List<User> userList = Arrays.asList(user1, user2);
//        Mockito.when(userService.getAllUsers()).thenReturn(userList);
//
// 
//        ResultActions result = mockMvc.perform(get("/api/users")
//                .contentType(MediaType.APPLICATION_JSON));
//
//
//        result.andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.length()").value(userList.size()))
//                .andExpect(jsonPath("$[0].firstName").value("John"))
//                .andExpect(jsonPath("$[0].lastName").value("Doe"))
//                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
//                .andExpect(jsonPath("$[1].firstName").value("Jane"))
//                .andExpect(jsonPath("$[1].lastName").value("Smith"))
//                .andExpect(jsonPath("$[1].email").value("jane.smith@example.com"));
//    }

    @Test
    public void testCreateUser() throws Exception {
 
        User user = new User("John", "Doe", "john.doe@example.com", null);
        Mockito.when(userService.createUser(ArgumentMatchers.any(User.class))).thenReturn(user);

        ResultActions result = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"Jui\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\"}"));


        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
              
}
}
