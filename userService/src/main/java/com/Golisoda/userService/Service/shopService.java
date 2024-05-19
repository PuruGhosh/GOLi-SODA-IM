package com.Golisoda.userService.Service;

import com.Golisoda.userService.Models.Shop;
import com.Golisoda.userService.dao.shopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class shopService {
    @Autowired
    shopDao shopdao;
    public ResponseEntity<String> createUSer(Shop shop) {

        shopdao.save(shop);
        return new ResponseEntity<>("Created a shop user", HttpStatus.CREATED);

    }

    public ResponseEntity<Shop> readUser(Integer id) {
        Shop shop= shopdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Shop not found"));
        return new ResponseEntity<>(shop,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(Integer id) {
        shopdao.deleteById(id);
        return new ResponseEntity<>("Deleted user",HttpStatus.OK);
    }

    public ResponseEntity<Shop> updateUser(Integer id, Shop shop) {
        Shop existingShop = shopdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Shop not found"));
        existingShop.setShop_name(shop.getShop_name());
        existingShop.setShop_owner(shop.getShop_owner());
        existingShop.setAddress_id(shop.getAddress_id());
        existingShop.setPhone_no(shop.getPhone_no());
        existingShop.setAlt_phone_no(shop.getAlt_phone_no());
        existingShop.setEmail_id(shop.getEmail_id());
        existingShop.setGstin_no(shop.getGstin_no());
        existingShop.setTrade_lisence_no(shop.getTrade_lisence_no());
        existingShop.setShop_type(shop.getShop_type());
        existingShop.setPoc_aadhar_no(shop.getPoc_aadhar_no());
        existingShop.setPoc_pan_no(shop.getPoc_pan_no());
        return new ResponseEntity<>(shopdao.save(existingShop),HttpStatus.ACCEPTED);

    }
}
