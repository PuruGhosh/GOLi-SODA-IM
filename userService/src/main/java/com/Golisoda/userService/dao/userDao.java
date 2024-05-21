package com.Golisoda.userService.dao;

import com.Golisoda.userService.Models.UserdB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface userDao extends JpaRepository<UserdB,String > {


    UserdB findByEmailid(String email_id);
}
