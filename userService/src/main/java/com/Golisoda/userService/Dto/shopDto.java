package com.Golisoda.userService.Dto;

import com.Golisoda.userService.Models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class shopDto {
    private String Shopid;
    private String shop_name;
    private String shop_owner;
    private Address address;
    private Long phone_no;
    private Long alt_phone_no;
    private String email_id;
    private Long gstin_no;
    private Long trade_lisence_no;
    private String shop_type;
    private Long poc_aadhar_no;
    private Long poc_pan_no;
}
