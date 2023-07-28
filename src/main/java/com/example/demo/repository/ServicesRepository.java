package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Services;
import com.example.demo.entity.User; 

public interface ServicesRepository extends JpaRepository<Services, Long>{
	
//	@Query("select u from User u WHERE u.service_Number= :serviceid")
//	public List<User> findUsersWithSameService(@Param("serviceid") String serviceid) ; 
	
//	@Query("select User.id, Services.serviceid, User.first_name, User.last_name, User.email, Services.fees FROM User INNER JOIN Services "
//			+ "ON User.service_number = Services.serviceid WHERE Services.serviceid = :serviceid")
//	@Query("From User where service.serviceid = :serviceid")
//	public List<Services> findJoinofBothTables(@Param("serviceid") String serviceid);

}
