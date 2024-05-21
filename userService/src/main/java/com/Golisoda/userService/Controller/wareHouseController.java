package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Dto.warehouseDto;
import com.Golisoda.userService.Models.RestResponse;
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

    @GetMapping("email/{email_id}")
    public ResponseEntity<RestResponse<warehouseDto>> readUser(@PathVariable String email_id){

        log.info("fetching data from service with warehouse id{}",email_id);
        RestResponse<warehouseDto> response= new RestResponse<>();
        response.setData(warehouseservice.readUser(email_id));
        return ResponseEntity.ok(response);
    }
    @PostMapping("delete")
    public ResponseEntity<RestResponse<String>> deleteUser(@RequestBody String email_id){

        log.info("deleting warehouse from service with warehouse email id {}",email_id);
        RestResponse<String> response= new RestResponse<>();
        response.setData(warehouseservice.deleteUser(email_id));
        return ResponseEntity.ok(response);
    }
    @PutMapping("update/{email_id}")
    public ResponseEntity<RestResponse<warehouseDto>> updateUser(@PathVariable String email_id, @RequestBody warehouseDto warehouse){
        log.info("updating warehouse from service with warehouse email id {}",email_id);
        RestResponse<warehouseDto> response= new RestResponse<>();
        response.setData(warehouseservice.updateUser(email_id,warehouse));
        return ResponseEntity.ok(response);
    }
}
