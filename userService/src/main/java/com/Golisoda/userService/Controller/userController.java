package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Dto.userDto;
import com.Golisoda.userService.Models.RestResponse;
import com.Golisoda.userService.Service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class userController {

    @Autowired
    userService userservice;

    @PostMapping("/create")
    public ResponseEntity<RestResponse<userDto>> createUser(@RequestBody userDto user){

        log.info("Creating user{}",user);
        RestResponse<userDto> response= new RestResponse<>();
        response.setData(userservice.createUSer(user));
        return ResponseEntity.ok(response);


    }

    @GetMapping("/read/{id}")
    public ResponseEntity<RestResponse<userDto>> readUser(@PathVariable String  id){

        log.info("fetching data from service with user id{}",id);
        RestResponse<userDto> response= new RestResponse<>();
        response.setData(userservice.readUser(id));
        return ResponseEntity.ok(response);
    }
    @PostMapping("/delete")
    public ResponseEntity<RestResponse<String>> deleteUser(@RequestBody String id){

        log.info("deleting user from service with user id{}",id);
        RestResponse<String> response= new RestResponse<>();
        response.setData(userservice.deleteUser(id));
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<RestResponse<userDto>> updateUser(@PathVariable String id, @RequestBody userDto user){
        log.info("updating user from service with user id{}",id);
        RestResponse<userDto> response= new RestResponse<>();
        response.setData(userservice.updateUser(id,user));
        return ResponseEntity.ok(response);
    }


}
