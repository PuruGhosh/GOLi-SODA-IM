package com.Golisoda.userService.Service;

import com.Golisoda.userService.Dto.warehouseDto;
import com.Golisoda.userService.Exception.userException;
import com.Golisoda.userService.Util.AddressMapper;
import com.Golisoda.userService.Util.WarehouseMapper;
import com.Golisoda.userService.dao.WarehouseDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@Slf4j

public class wareHouseService {
    @Autowired
    WarehouseDao warehousedao;
    @Autowired
    WarehouseMapper warehousemapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    addressService addressService;
    public warehouseDto createUSer(warehouseDto warehouse) {

        log.info("Adding new warehouse {}",warehouse);
        var warehouseForDB = warehousemapper.toWarehouse(warehouse);
        var warehouseId= UUID.randomUUID().toString();
        warehouseForDB.setWarehouseID(warehouseId);
        var address = warehouse.getAddress();
        var addressForDB = addressMapper.toAddress(address);
        addressForDB.setUserId(warehouseId);
        var addressID = UUID.randomUUID().toString();
        addressForDB.setAddress_id(addressID);
        addressForDB.setUser_type("warehouse");
        addressService.addAddress(addressForDB);
        warehouseForDB.setAddress(addressForDB);
        return warehousemapper.toWarehouseDto(warehousedao.save(warehouseForDB));

    }

    public warehouseDto readUser(String email_id) {
        log.info("Fetching data from DB with warehouse email id {}",email_id);
        var warehouseFromDB= warehousedao.findByEmailid(email_id);
        if(warehouseFromDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        return warehousemapper.toWarehouseDto(warehouseFromDB);
    }

    public String deleteUser(String email_id) {
        log.info("Deleting warehouse with email id {} from DB",email_id);
        var deletedWarehouseFromDB= warehousedao.findByEmailid(email_id);
        if(deletedWarehouseFromDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        warehousedao.deleteById(deletedWarehouseFromDB.getWarehouseID());
        return "Deleted warehouse user with email id" + email_id;
    }

    public warehouseDto updateUser(String  email_id, warehouseDto warehouse) {
        log.info("Updating warehouse user data in DB with email id {}",email_id);
        var existingwarehouseFromDB= warehousedao.findByEmailid(email_id);
        if(existingwarehouseFromDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        var existingwarehouse = warehousemapper.toWarehouseDto(existingwarehouseFromDB);
        existingwarehouse.setName(warehouse.getName());
        existingwarehouse.setAddress(warehouse.getAddress());
        existingwarehouse.setCapacity(warehouse.getCapacity());
        existingwarehouse.setManager_name(warehouse.getManager_name());
        existingwarehouse.setManager_phn_no(warehouse.getManager_phn_no());
        existingwarehouse.setAlt_phn_no(warehouse.getAlt_phn_no());
        existingwarehouse.setAadhar_no(warehouse.getAadhar_no());
        existingwarehouse.setPan_no(warehouse.getPan_no());
        existingwarehouse.setEmailid(warehouse.getEmailid());
        existingwarehouse.setRegion(warehouse.getRegion());
        var resultWarehouse = warehousemapper.toWarehouse(existingwarehouse);
        return warehousemapper.toWarehouseDto(warehousedao.save(resultWarehouse));
    }
}
