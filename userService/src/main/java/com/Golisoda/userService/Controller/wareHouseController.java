package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Dto.userDto;
import com.Golisoda.userService.Dto.warehouseDto;
import com.Golisoda.userService.Models.RestResponse;
import com.Golisoda.userService.Models.WareHouse;
import com.Golisoda.userService.Service.wareHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j

@RestController
@RequestMapping("warehouse")

public class wareHouseController {
    @Autowired
    wareHouseService warehouseservice;
    @PostMapping("create")
    public ResponseEntity<RestResponse<warehouseDto>> createUser(@RequestBody warehouseDto warehouse){
        log.info("Creating warehouse {}",warehouse);
        RestResponse<warehouseDto> response= new RestResponse<>();
        response.setData(warehouseservice.createUSer(warehouse));
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<RestResponse<warehouseDto>> readUser(@PathVariable String id){

        log.info("fetching data from service with warehouse id{}",id);
        RestResponse<warehouseDto> response= new RestResponse<>();
        response.setData(warehouseservice.readUser(id));
        return ResponseEntity.ok(response);
    }
    @PostMapping("delete")
    public ResponseEntity<RestResponse<String>> deleteUser(@RequestBody String id){

        log.info("deleting warehouse from service with warehouse id {}",id);
        RestResponse<String> response= new RestResponse<>();
        response.setData(warehouseservice.deleteUser(id));
        return ResponseEntity.ok(response);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<warehouseDto>> updateUser(@PathVariable String id, @RequestBody warehouseDto warehouse){
        log.info("updating warehouse from service with warehouse id{}",id);
        RestResponse<warehouseDto> response= new RestResponse<>();
        response.setData(warehouseservice.updateUser(id,warehouse));
        return ResponseEntity.ok(response);
    }
}
