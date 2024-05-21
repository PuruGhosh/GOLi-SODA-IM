package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Dto.addressDto;
import com.Golisoda.userService.Models.RestResponse;
import com.Golisoda.userService.Service.addressService;
import com.Golisoda.userService.Util.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@Slf4j

public class addressController {
    @Autowired
    addressService addressservice;


    @PostMapping("add")
    public ResponseEntity<RestResponse<addressDto>> addAddress(@RequestBody addressDto address){
        log.info("Adding address {}",address);
        RestResponse<addressDto> response = new RestResponse<>();
        response.setData(addressservice.addAddress(address));
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<RestResponse<addressDto>> readAddress(@PathVariable String id){

        log.info("Fetching address");
        RestResponse<addressDto> response = new RestResponse<>();
        response.setData(addressservice.readAddress(id));
        return ResponseEntity.ok(response);
    }
    @PostMapping("delete")
    public ResponseEntity<RestResponse<String>> deleteAddress(@RequestBody String id){

        log.info("Deleting address");
        RestResponse<String> response = new RestResponse<>();
        response.setData(addressservice.deleteAddress(id));
        return ResponseEntity.ok(response);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<addressDto>> updateAddress(@PathVariable String id, @RequestBody addressDto address){
        log.info("Updating address {}",address);
        RestResponse<addressDto> response = new RestResponse<>();
        response.setData(addressservice.updateAddress(id,address));
        return ResponseEntity.ok(response);
    }
}
