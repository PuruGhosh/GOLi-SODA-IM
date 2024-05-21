package com.Golisoda.userService.Service;

import com.Golisoda.userService.Dto.shopDto;
import com.Golisoda.userService.Models.Shop;
import com.Golisoda.userService.Util.ShopMapper;
import com.Golisoda.userService.dao.shopDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class shopService {
    private static final Logger log = LoggerFactory.getLogger(shopService.class);
    @Autowired
    shopDao shopdao;
    @Autowired
    ShopMapper shopmapper;

    public shopDto createUSer(shopDto shop) {

        log.info("Adding shop user {}",shop);
        var shopForDB = shopmapper.toShop(shop);
        shopForDB.setShopid(UUID.randomUUID().toString());
        return shopmapper.toShopDto(shopdao.save(shopForDB));

    }

    public shopDto readUser(String  id) {
        log.info("Fetching data from DB with user id {}",id);
        var shop= shopdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Shop not found"));
        return shopmapper.toShopDto(shop);
    }

    public String deleteUser(String id) {
        log.info("Deleting user with id {} from DB",id);
        shopdao.deleteById(id);
        return "Deleted user with id" + id;
    }
    public shopDto updateUser(String id, shopDto shop) {
        log.info("Updating user data in DB with user id {}",id);
        Shop existingShop = shopdao.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Shop not found"));
        existingShop.setShop_name(shop.getShop_name());
        existingShop.setShop_owner(shop.getShop_owner());
        existingShop.setAddress(shop.getAddress());
        existingShop.setPhone_no(shop.getPhone_no());
        existingShop.setAlt_phone_no(shop.getAlt_phone_no());
        existingShop.setEmail_id(shop.getEmail_id());
        existingShop.setGstin_no(shop.getGstin_no());
        existingShop.setTrade_lisence_no(shop.getTrade_lisence_no());
        existingShop.setShop_type(shop.getShop_type());
        existingShop.setPoc_aadhar_no(shop.getPoc_aadhar_no());
        existingShop.setPoc_pan_no(shop.getPoc_pan_no());
        return shopmapper.toShopDto(shopdao.save(existingShop));

    }
}
