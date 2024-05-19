package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Models.WareHouse;
import com.Golisoda.userService.Service.wareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("warehouse")

public class wareHouseController {
    @Autowired
    wareHouseService warehouseservice;
    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody WareHouse warehouse){
        return warehouseservice.createUSer(warehouse);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<WareHouse> readUser(@PathVariable Integer id){
        return warehouseservice.readUser(id);
    }
    @PostMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody Integer id){
        return warehouseservice.deleteUser(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<WareHouse> updateUser(@PathVariable Integer id, @RequestBody WareHouse warehouse){
        return warehouseservice.updateUser(id,warehouse);
    }
}
