package com.Golisoda.userService.dao;

import com.Golisoda.userService.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface addressDao extends JpaRepository<Address,String > {
}
