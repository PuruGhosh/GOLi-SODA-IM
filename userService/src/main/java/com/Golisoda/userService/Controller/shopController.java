package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Models.Shop;
import com.Golisoda.userService.Service.shopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
public class shopController {
    @Autowired
    shopService shopservice;
    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody Shop shop){
        return shopservice.createUSer(shop);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Shop> readUser(@PathVariable Integer id){
        return shopservice.readUser(id);
    }
    @PostMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody Integer id){
        return shopservice.deleteUser(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Shop> updateUser(@PathVariable Integer id, @RequestBody Shop shop){
        return shopservice.updateUser(id,shop);
    }

}
