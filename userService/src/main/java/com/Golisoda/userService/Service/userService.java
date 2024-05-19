package com.Golisoda.userService.Service;

import com.Golisoda.userService.Models.UserdB;
import com.Golisoda.userService.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service

public class userService {

    @Autowired
    userDao userdao;
    public ResponseEntity<String> createUSer(UserdB userdB) {

    userdao.save(userdB);
    return new ResponseEntity<>("Created a user", HttpStatus.CREATED);

    }

    public ResponseEntity<UserdB> readUser(Integer id) {
        UserdB ud= userdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        return new ResponseEntity<>(ud,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(Integer id) {
        userdao.deleteById(id);
        return new ResponseEntity<>("Deleted user",HttpStatus.OK);
    }

    public ResponseEntity<UserdB> updateUser(Integer id, UserdB ud) {
        UserdB existingud = userdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        existingud.setF_name(ud.getF_name());
        existingud.setL_name(ud.getL_name());
        existingud.setDob(ud.getDob());
        existingud.setAadhar_no(ud.getAadhar_no());
        existingud.setPan_no(ud.getPan_no());
        existingud.setDoj(ud.getDoj());
        existingud.setDesignation(ud.getDesignation());
        existingud.setReporting_user_id(ud.getReporting_user_id());
        existingud.setAddress_id(ud.getAddress_id());
        existingud.setPhone_no(ud.getPhone_no());
        existingud.setAlt_phone_no(ud.getAlt_phone_no());
        existingud.setEmail_id(ud.getEmail_id());

        return new ResponseEntity<>(userdao.save(existingud),HttpStatus.ACCEPTED);




    }
}
