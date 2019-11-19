package com.lti.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lti.fms.dao.UserNotFoundException;
import com.lti.fms.entities.User;
import com.lti.fms.service.IDetailsService;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private IDetailsService detailsService;

    /**
     * Get Request
     * 1)server.com/user/find?id=8 example  facebook.com?user=mohan
     * 2)server.com/find/8 example facebook.com/mohan
     *
     *
     */
    @RequestMapping(value = "/user/find/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<User> findUser(@PathVariable int id) {
        User user = detailsService.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("user not found for id=" + id);
        }
        ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        System.out.println("response entity=" + responseEntity);
        return responseEntity;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFound(UserNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user/create",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        user = detailsService.createUser(user);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
        System.out.println("response entity=" + responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/user/all",
    method = RequestMethod.GET,
    produces = "application/json")
    public ResponseEntity<List<User>> allUsers(){
      List<User>users= detailsService.allUsers();
      ResponseEntity<List<User>> response=new ResponseEntity<>(users, HttpStatus.OK);
      return response;

    }




}






