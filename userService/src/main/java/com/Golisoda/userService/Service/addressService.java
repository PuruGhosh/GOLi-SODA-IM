package com.Golisoda.userService.Service;

import com.Golisoda.userService.Models.Address;
import com.Golisoda.userService.Models.WareHouse;
import com.Golisoda.userService.dao.WarehouseDao;
import com.Golisoda.userService.dao.addressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class addressService {
    @Autowired
    addressDao addressdao;
    public ResponseEntity<String> addAddress(Address address) {

        addressdao.save(address);
        return new ResponseEntity<>("Added a Address", HttpStatus.CREATED);

    }

    public ResponseEntity<Address> readAddress(Integer id) {
        Address address= addressdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Address not found"));
        return new ResponseEntity<>(address,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAddress(Integer id) {
        addressdao.deleteById(id);
        return new ResponseEntity<>("Deleted user",HttpStatus.OK);
    }

    public ResponseEntity<Address> updateAddress(Integer id, Address address) {
        Address existingaddress= addressdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Address not found"));
        existingaddress.setAddress_line1(address.getAddress_line1());
        existingaddress.setAddress_line2(address.getAddress_line2());
        existingaddress.setPin(address.getPin());
        existingaddress.setCity(address.getCity());
        existingaddress.setDistrict(address.getDistrict());
        existingaddress.setState(address.getState());
        existingaddress.setCountry(address.getCountry());
        existingaddress.setUser_type(address.getUser_type());
        existingaddress.setUser_id(address.getUser_id());
        return new ResponseEntity<>(addressdao.save(existingaddress),HttpStatus.ACCEPTED);
    }
}
