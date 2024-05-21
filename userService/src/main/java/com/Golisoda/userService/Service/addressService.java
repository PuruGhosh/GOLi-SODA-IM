package com.Golisoda.userService.Service;

import com.Golisoda.userService.Dto.addressDto;
import com.Golisoda.userService.Models.Address;
import com.Golisoda.userService.Util.AddressMapper;
import com.Golisoda.userService.dao.addressDao;
import com.Golisoda.userService.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class addressService {
    @Autowired
    addressDao addressdao;
    @Autowired
    userDao userdao;
    @Autowired
    private AddressMapper addressmapper;
    public  void addAddress(Address address) {

        var addressId = UUID.randomUUID().toString();
        address.setAddress_id(addressId);

//        Address addressForDB=new Address(address.getAddress_id(), address.getAddress_line1(), address.getAddress_line2(), address.getPin(), address.getCity(), address.getDistrict(), address.getState(), address.getCountry(), address.getUser_type(), address.getUser_id());
        ;
        addressdao.save(address);

    }

//    public addressDto readAddress(String id) {
//        var addressFromDB= addressdao.findById(id)
//                .orElseThrow(()-> new IllegalArgumentException("Address not found"));
//
//        return addressmapper.toAddressDto(addressFromDB);
//    }
//
//    public String deleteAddress(String id) {
//        addressdao.deleteById(id);
//        return "Address with user id "+ id + "is deleted";
//    }

    public addressDto updateAddress(String id, addressDto address) {
        var existingaddress= addressdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Address not found"));
        existingaddress.setAddress_line1(address.getAddress_line1());
        existingaddress.setAddress_line2(address.getAddress_line2());
        existingaddress.setPin(address.getPin());
        existingaddress.setCity(address.getCity());
        existingaddress.setDistrict(address.getDistrict());
        existingaddress.setState(address.getState());
        existingaddress.setCountry(address.getCountry());
        addressdao.save(existingaddress);
        return addressmapper.toAddressDto(existingaddress);
    }
}
