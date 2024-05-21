package com.Golisoda.userService.Service;

import com.Golisoda.userService.Dto.shopDto;
import com.Golisoda.userService.Exception.userException;
import com.Golisoda.userService.Models.Shop;
import com.Golisoda.userService.Util.AddressMapper;
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
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    addressService addressService;

    public shopDto createUSer(shopDto shop) {

        log.info("Adding shop user {}",shop);
        var shopForDB = shopmapper.toShop(shop);
        var shopId= UUID.randomUUID().toString();
        shopForDB.setShopid(shopId);
        var address = shop.getAddress();
        var addressForDB = addressMapper.toAddress(address);
        addressForDB.setUserId(shopId);
        var addressID = UUID.randomUUID().toString();
        addressForDB.setAddress_id(addressID);
        addressForDB.setUser_type("shop");
        addressService.addAddress(addressForDB);
        shopForDB.setAddress(addressForDB);
        return shopmapper.toShopDto(shopdao.save(shopForDB));

    }

    public shopDto readUser(String  email_id) {
        log.info("Fetching data from DB with email id {}",email_id);
        var shopFromDB= shopdao.findByEmailid(email_id);
        if(shopFromDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        return shopmapper.toShopDto(shopFromDB);
    }

    public String deleteUser(String email_id) {
        var shopDeletedDB= shopdao.findByEmailid(email_id);
        if(shopDeletedDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        var id = shopDeletedDB.getShopid();
        log.info("Deleting user with id {} from DB",id);
        shopdao.deleteById(id);
        return "Deleted user with id" + email_id;
    }
    public shopDto updateUser(String email_id, shopDto shop) {
        log.info("Updating user data in DB with email id {}",email_id);
        Shop ShopFromDB = shopdao.findByEmailid(email_id);
        if(ShopFromDB==null){
            throw new userException("User with email id %s is not available".formatted(email_id));
        }
        var existingShop = shopmapper.toShopDto(ShopFromDB);
        existingShop.setShop_name(shop.getShop_name());
        existingShop.setShop_owner(shop.getShop_owner());
        existingShop.setAddress(shop.getAddress());
        existingShop.setPhone_no(shop.getPhone_no());
        existingShop.setAlt_phone_no(shop.getAlt_phone_no());
        existingShop.setEmailid(shop.getEmailid());
        existingShop.setGstin_no(shop.getGstin_no());
        existingShop.setTrade_lisence_no(shop.getTrade_lisence_no());
        existingShop.setShop_type(shop.getShop_type());
        existingShop.setPoc_aadhar_no(shop.getPoc_aadhar_no());
        existingShop.setPoc_pan_no(shop.getPoc_pan_no());
        var resultShop = shopmapper.toShop(existingShop);
        return shopmapper.toShopDto(shopdao.save(resultShop));

    }
}
