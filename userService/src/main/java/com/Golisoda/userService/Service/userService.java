package com.Golisoda.userService.Service;

import com.Golisoda.userService.Dto.userDto;
import com.Golisoda.userService.Exception.userException;
import com.Golisoda.userService.Util.AddressMapper;
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
    @Autowired
    addressService addressService;
    @Autowired
    AddressMapper addressmapper;
    public userDto createUSer(userDto user) {

        log.info("Adding new user {}",user);
        var userForDB = usermapper.toUser(user);
        var userID = UUID.randomUUID().toString();
    userForDB.setUser_id(userID);
    var address = user.getAddress();
    var addressForDB = addressmapper.toAddress(address);
    addressForDB.setUserId(userID);
    var addressID = UUID.randomUUID().toString();
    addressForDB.setAddress_id(addressID);
    addressForDB.setUser_type("user");
    addressService.addAddress(addressForDB);
    userForDB.setAddress(addressForDB);
    return usermapper.toUserDto(userdao.save(userForDB));

    }

    public userDto readUser(String  email_id) {
        log.info("Fetching data from DB with user id {}",email_id);
        var userFromDB= userdao.findByEmailid(email_id);
        if(userFromDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        return usermapper.toUserDto(userFromDB);
    }

    public String deleteUser(String email_id) {
        var userDeletedDB= userdao.findByEmailid(email_id);
        if(userDeletedDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        var id = userDeletedDB.getUser_id();
        log.info("Deleting user with email id {} from DB",email_id);
        userdao.deleteById(id);
        return "Deleted user with email id" + email_id;
    }

    public userDto updateUser(String email_id, userDto ud) {
        log.info("Updating user data in DB with email id {}",email_id);
        var existinguserDB = userdao.findByEmailid(email_id);
        if(existinguserDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }

        var existingud = usermapper.toUserDto(existinguserDB);
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
        existingud.setEmailid(ud.getEmailid());

        var resultUser = usermapper.toUser(existingud);

        return usermapper.toUserDto(userdao.save(resultUser));




    }
}
