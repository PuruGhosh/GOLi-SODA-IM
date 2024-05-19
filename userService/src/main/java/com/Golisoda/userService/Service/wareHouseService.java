package com.Golisoda.userService.Service;

import com.Golisoda.userService.Models.WareHouse;
import com.Golisoda.userService.dao.WarehouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class wareHouseService {
    @Autowired
    WarehouseDao warehousedao;
    public ResponseEntity<String> createUSer(WareHouse warehouse) {

        warehousedao.save(warehouse);
        return new ResponseEntity<>("Created a warehouse user", HttpStatus.CREATED);

    }

    public ResponseEntity<WareHouse> readUser(Integer id) {
        WareHouse warehouse= warehousedao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Warehouse not found"));
        return new ResponseEntity<>(warehouse,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(Integer id) {
        warehousedao.deleteById(id);
        return new ResponseEntity<>("Deleted user",HttpStatus.OK);
    }

    public ResponseEntity<WareHouse> updateUser(Integer id, WareHouse warehouse) {
        WareHouse existingwarehouse= warehousedao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Warehouse not found"));
        existingwarehouse.setName(warehouse.getName());
        existingwarehouse.setAddress_id(warehouse.getAddress_id());
        existingwarehouse.setCapacity(warehouse.getCapacity());
        existingwarehouse.setManager_name(warehouse.getManager_name());
        existingwarehouse.setManager_phn_no(warehouse.getManager_phn_no());
        existingwarehouse.setAlt_phn_no(warehouse.getAlt_phn_no());
        existingwarehouse.setAadhar_no(warehouse.getAadhar_no());
        existingwarehouse.setPan_no(warehouse.getPan_no());
        existingwarehouse.setEmail_id(warehouse.getEmail_id());
        existingwarehouse.setRegion(warehouse.getRegion());
        return new ResponseEntity<>(warehousedao.save(existingwarehouse),HttpStatus.ACCEPTED);
    }
}
