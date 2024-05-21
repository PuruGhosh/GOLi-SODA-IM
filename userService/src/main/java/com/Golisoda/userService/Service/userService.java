package com.Golisoda.userService.Service;

import com.Golisoda.userService.Dto.userDto;
import com.Golisoda.userService.Util.UserMapper;
import com.Golisoda.userService.dao.userDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service

public class userService {

    private static final Logger log = LoggerFactory.getLogger(userService.class);
    @Autowired
    userDao userdao;
    @Autowired
    UserMapper usermapper;
    public userDto createUSer(userDto user) {

        log.info("Adding new user {}",user);
        var userForDB = usermapper.toUser(user);
    userForDB.setUser_id(UUID.randomUUID().toString());
    return usermapper.toUserDto(userdao.save(userForDB));

    }

    public userDto readUser(String  id) {
        log.info("Fetching data from DB with user id {}",id);
        var userFromDB= userdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        return usermapper.toUserDto(userFromDB);
    }

    public String deleteUser(String id) {
        log.info("Deleting user with id {} from DB",id);
        userdao.deleteById(id);
        return "Deleted user with id" + id;
    }

    public userDto updateUser(String id, userDto ud) {
        log.info("Updating user data in DB with user id {}",id);
        var existingud = userdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        existingud.setF_name(ud.getF_name());
        existingud.setL_name(ud.getL_name());
        existingud.setDob(ud.getDob());
        existingud.setAadhar_no(ud.getAadhar_no());
        existingud.setPan_no(ud.getPan_no());
        existingud.setDoj(ud.getDoj());
        existingud.setDesignation(ud.getDesignation());
        existingud.setReporting_user_id(ud.getReporting_user_id());
        existingud.setAddress(ud.getAddress());
        existingud.setPhone_no(ud.getPhone_no());
        existingud.setAlt_phone_no(ud.getAlt_phone_no());
        existingud.setEmail_id(ud.getEmail_id());

        return usermapper.toUserDto(userdao.save(existingud));




    }
}
