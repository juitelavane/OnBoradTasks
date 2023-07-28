//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
////import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.User;
////import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.repository.UserRepository;
//
//
//@RestController
//@RequestMapping("/api/services")
//public class ServicesController {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
////	@GetMapping("/{serviceid}")
////	public List<User> findUsersWithSameService(@PathVariable (value = "serviceid") String serviceId)
////	{
////		return this.userRepository.findUsersWithSameService(serviceId);
////	}
////	
////	@GetMapping("/{serviceid}")
////	public List<User> findUsersWithSameService()
////	{
////	return this.userRepository.findJoinofBothTables();
////	}
//
//}


package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Services;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ServicesRepository;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

	@Autowired
	private ServicesRepository servicesRepository;

	// get all users
	@GetMapping
	public List<Services> getAllServices() {
		return this.servicesRepository.findAll();
	}

	// get user by id
	@GetMapping("/{id}")
	public Services getServicesById(@PathVariable (value = "id") long servicesId) {
		return this.servicesRepository.findById(servicesId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + servicesId));
	}

	// create user
	@PostMapping
	public Services createServices(@RequestBody Services services) {
		return this.servicesRepository.save(services);
	}
	
	// update user
	@PutMapping("/{id}")
	public Services updateServices(@RequestBody Services services, @PathVariable ("id") long servicesId) {
		Services existingServices = this.servicesRepository.findById(servicesId)
		.orElseThrow(() -> new ResourceNotFoundException("Service not found with id :" + servicesId));
		existingServices.setFee(services.getFee());
		existingServices.setValidity(services.getValidity());
		existingServices.setType(services.getType());
		 return this.servicesRepository.save(existingServices);
	}
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Services> deleteServices(@PathVariable ("id") long servicesId){
		 Services existingUser = this.servicesRepository.findById(servicesId)
					.orElseThrow(() -> new ResourceNotFoundException("Service not found with id :" + servicesId));
		 this.servicesRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}
	
//	@GetMapping("/{serviceid}")
//	public List<Services> findUsersWithSameService(@PathVariable (value = "serviceid") String serviceId)
//	{
//	return this.servicesRepository.findJoinofBothTables(serviceId);
//	}
}
