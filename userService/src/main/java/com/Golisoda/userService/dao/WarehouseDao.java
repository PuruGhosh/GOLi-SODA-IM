package com.Golisoda.userService.dao;

import com.Golisoda.userService.Models.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseDao extends JpaRepository<WareHouse,Integer> {
}
