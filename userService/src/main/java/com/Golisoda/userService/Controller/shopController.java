package com.Golisoda.userService.Controller;

import com.Golisoda.userService.Dto.shopDto;
import com.Golisoda.userService.Dto.userDto;
import com.Golisoda.userService.Models.RestResponse;
import com.Golisoda.userService.Models.Shop;
import com.Golisoda.userService.Service.shopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
public class shopController {
    private static final Logger log = LoggerFactory.getLogger(shopController.class);
    @Autowired
    shopService shopservice;

    @PostMapping("create")
    public ResponseEntity<RestResponse<shopDto>> createUser(@RequestBody shopDto shop){

        log.info("creating shop user from service{}",shop);
        RestResponse<shopDto> response = new RestResponse<>();
        response.setData(shopservice.createUSer(shop));
        return ResponseEntity.ok(response);
    }

    @GetMapping("email/{email_id}")
    public ResponseEntity<RestResponse<shopDto>> readUser(@PathVariable String email_id){

        log.info("fetching data from service with shop id {}",email_id);
        RestResponse<shopDto> response = new RestResponse<>();
        response.setData(shopservice.readUser(email_id));
        return ResponseEntity.ok(response);
    }
    @PostMapping("delete")
    public ResponseEntity<RestResponse<String>> deleteUser(@RequestBody String email_id){

        log.info("deleting user from service with user id{}",email_id);
        RestResponse<String> response= new RestResponse<>();
        response.setData(shopservice.deleteUser(email_id));
        return ResponseEntity.ok(response);
    }
    @PutMapping("update/{email_id}")
    public ResponseEntity<RestResponse<shopDto>> updateUser(@PathVariable String email_id, @RequestBody shopDto shop){
        log.info("updating user from service with email id {}",email_id);
        RestResponse<shopDto> response= new RestResponse<>();
        response.setData(shopservice.updateUser(email_id,shop));
        return ResponseEntity.ok(response);
    }

}
