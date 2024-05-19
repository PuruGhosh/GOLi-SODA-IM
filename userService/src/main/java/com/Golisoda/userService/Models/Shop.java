package com.Golisoda.userService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Shop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer Shopid;
    private String shop_name;
    private String shop_owner;
    private Integer address_id;
    private Long phone_no;
    private Long alt_phone_no;
    private String email_id;
    private Long gstin_no;
    private Long trade_lisence_no;
    private String shop_type;
    private Long poc_aadhar_no;
    private Long poc_pan_no;


}
