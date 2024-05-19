package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Models.UserdB;
import com.Golisoda.userService.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class userController {

    @Autowired
    userService userservice;

    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody UserdB userdB){
        return userservice.createUSer(userdB);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<UserdB> readUser(@PathVariable Integer id){
        return userservice.readUser(id);
    }
    @PostMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody Integer id){
        return userservice.deleteUser(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<UserdB> updateUser(@PathVariable Integer id, @RequestBody UserdB ud){
        return userservice.updateUser(id,ud);
    }


}
