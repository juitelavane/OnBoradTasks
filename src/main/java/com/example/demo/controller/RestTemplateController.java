//package com.example.demo.controller;
//
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.demo.entity.User;
//
//@RestController
//public class RestTemplateController {
   
//	static String baseurl = "/api/template" ;
//   
//   
//   @GetMapping(value = "/api/users")
//   public List<User> getUserList() {
//   RestTemplate restTemplate = new RestTemplate();
//
//   String url = "https://localhost:8080/api/users";
//   System.out.println(url);
//
//   ResponseEntity<List<User>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
//   System.out.println(response);
//
//   List<User> user = response.getBody();
//   
//   
//   
//   return user;
//   }
   
//   @RequestMapping(value = "/api/template")
//   public String getUserList() {
//      HttpHeaders headers = new HttpHeaders();
//      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//      HttpEntity<String> entity = new HttpEntity<String>(headers);
//      
//      System.out.println(restTemplate.exchange(baseurl, HttpMethod.GET, entity, String.class).getBody());
//      return restTemplate.exchange(
//    		  baseurl, HttpMethod.GET, entity, String.class).getBody();
//   }
//    
////   @RequestMapping(value = "/api/template", method = RequestMethod.POST)
//   public String createUserTemplate(@RequestBody User user) {
//      HttpHeaders headers = new HttpHeaders();
//      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//      HttpEntity<User> entity = new HttpEntity<User>(user,headers);
//      
//      return restTemplate.exchange(
//         "http://localhost:8080/api/template", HttpMethod.POST, entity, String.class).getBody();
//   }
////   @RequestMapping(value = "/api/template/{id}", method = RequestMethod.PUT)
//   public String updateUserTemplate(@PathVariable("id") String id, @RequestBody User user) {
//      HttpHeaders headers = new HttpHeaders();
//      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//      HttpEntity<User> entity = new HttpEntity<User>(user,headers);
//      
//      return restTemplate.exchange(
//         "http://localhost:8080/api/template/"+id, HttpMethod.PUT, entity, String.class).getBody();
//   }
////   @RequestMapping(value = "/api/users/template/{id}", method = RequestMethod.DELETE)
//   public String deleteUserTemplate(@PathVariable("id") String id) {
//      HttpHeaders headers = new HttpHeaders();
//      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//      HttpEntity<User> entity = new HttpEntity<User>(headers);
//      
//      return restTemplate.exchange(
//         "http://localhost:8080/api/template/"+id, HttpMethod.DELETE, entity, String.class).getBody();
////   }
//}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;

@RestController
@RequestMapping("/api/resttemplate")
@Profile("rest-template")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    private final String getUserByIdUrl = "http://localhost:8080/api/users/{id}";

    private final String createUserUrl = "http://localhost:8080/api/users";


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserByIdUsingRestTemplate(@PathVariable long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<User> response = restTemplate.exchange(
                getUserByIdUrl,
                HttpMethod.GET,
                requestEntity,
                User.class,
                id
        );

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

}

