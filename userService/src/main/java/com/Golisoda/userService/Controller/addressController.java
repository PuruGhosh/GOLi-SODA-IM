package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Models.Address;
import com.Golisoda.userService.Service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")

public class addressController {
    @Autowired
    addressService addressservice;
    @PostMapping("add")
    public ResponseEntity<String> addAddress(@RequestBody Address address){
        return addressservice.addAddress(address);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Address> readAddress(@PathVariable Integer id){
        return addressservice.readAddress(id);
    }
    @PostMapping("delete")
    public ResponseEntity<String> deleteAddress(@RequestBody Integer id){
        return addressservice.deleteAddress(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Integer id, @RequestBody Address address){
        return addressservice.updateAddress(id,address);
    }
}
