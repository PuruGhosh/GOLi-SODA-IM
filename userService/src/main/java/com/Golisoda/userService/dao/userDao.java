package com.Golisoda.userService.dao;

import com.Golisoda.userService.Models.UserdB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao extends JpaRepository<UserdB,String > {
}
