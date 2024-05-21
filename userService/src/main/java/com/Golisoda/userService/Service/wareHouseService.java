package com.Golisoda.userService.Service;

import com.Golisoda.userService.Dto.warehouseDto;
import com.Golisoda.userService.Models.WareHouse;
import com.Golisoda.userService.Util.WarehouseMapper;
import com.Golisoda.userService.dao.WarehouseDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@Slf4j

public class wareHouseService {
    @Autowired
    WarehouseDao warehousedao;
    @Autowired
    WarehouseMapper warehousemapper;
    public warehouseDto createUSer(warehouseDto warehouse) {

        log.info("Adding new warehouse {}",warehouse);
        var userForDB = warehousemapper.toWarehouse(warehouse);
        userForDB.setWarehouseID(UUID.randomUUID().toString());
        return warehousemapper.toWarehouseDto(warehousedao.save(userForDB));

    }

    public warehouseDto readUser(String id) {
        log.info("Fetching data from DB with warehouse id {}",id);
        var userFromDB= warehousedao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        return warehousemapper.toWarehouseDto(userFromDB);
    }

    public String deleteUser(String id) {
        log.info("Deleting warehouse with id {} from DB",id);
        warehousedao.deleteById(id);
        return "Deleted user with id" + id;
    }

    public warehouseDto updateUser(String  id, warehouseDto warehouse) {
        log.info("Updating user data in DB with user id {}",id);
        var existingwarehouse= warehousedao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Warehouse not found"));
        existingwarehouse.setName(warehouse.getName());
        existingwarehouse.setAddress(warehouse.getAddress());
        existingwarehouse.setCapacity(warehouse.getCapacity());
        existingwarehouse.setManager_name(warehouse.getManager_name());
        existingwarehouse.setManager_phn_no(warehouse.getManager_phn_no());
        existingwarehouse.setAlt_phn_no(warehouse.getAlt_phn_no());
        existingwarehouse.setAadhar_no(warehouse.getAadhar_no());
        existingwarehouse.setPan_no(warehouse.getPan_no());
        existingwarehouse.setEmail_id(warehouse.getEmail_id());
        existingwarehouse.setRegion(warehouse.getRegion());
        return warehousemapper.toWarehouseDto(warehousedao.save(existingwarehouse));
    }
}
