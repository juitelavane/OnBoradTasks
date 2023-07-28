package com.example.demo;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.ServicesController;
import com.example.demo.controller.UserController;
import com.example.demo.entity.Services;
import com.example.demo.entity.User;
import com.example.demo.repository.ServicesRepository;
import com.example.demo.services.UserServices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.controller.ServicesController;
import com.example.demo.entity.Services;
import com.example.demo.repository.ServicesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootFirstAppApplicationTests {

	@Test
	void contextLoads() {
	}
	Services service;
	
	@Autowired
	private ServicesController services;

	@MockBean
	private ServicesRepository repository;
	
	
	@Test
	public void getAllServicesTest() {
	when(repository.findAll()).thenReturn(Stream.of(new Services ("1","12","1000"), new Services ("2","24","2000")).collect(Collectors.toList()));
	assertEquals(2,services.getAllServices().size());
	}
		
	@Test
	public void saveUserTest() {
		Services service = new Services("3","12","1000");
		when(repository.save(service)).thenReturn(service);
		assertEquals(service,services.createServices(service));
	}



    @Mock
    private ServicesRepository servicesRepository;

    @InjectMocks
    private ServicesController servicesController;

    @Before
    public void setup() {
    }

    @Test
    public void testCreateServices_ValidValue() {
    	
        Services inputServices = new Services("someType", "6", "someFee");

        when(servicesRepository.save(any(Services.class))).thenReturn(inputServices);

        Services createdServices = servicesController.createServices(inputServices);

        assertEquals(inputServices, createdServices);
        int validity = Integer.parseInt(inputServices.getValidity());
        System.out.println(validity);
        assertEquals("Valid validity is not a multiple of 3", 0, validity % 3);
        verify(servicesRepository, times(1)).save(any(Services.class));
    }
    
    @Mock
    private UserServices userServices;

    @InjectMocks
    private UserController userController;

    @Test
    public void testFindAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("John", "Doe", "john@example.com", new Services()));
        userList.add(new User("Jane", "Smith", "jane@example.com", new Services()));
        when(userServices.getAllUsers()).thenReturn(userList);
        List<User> result = userController.findAllUsers();
               assertEquals(userList.size(), result.size());
       }

    @Test
    public void testCreateServices_InvalidValue() {
        Services inputServices = new Services("someType", "&", "someFee");
        assertThrows(NumberFormatException.class, () -> servicesController.createServices(inputServices));
    }
    
    

	}

//}
