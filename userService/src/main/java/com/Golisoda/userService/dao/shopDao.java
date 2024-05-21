package com.Golisoda.userService.dao;

import com.Golisoda.userService.Models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface shopDao extends JpaRepository<Shop,String > {
}
