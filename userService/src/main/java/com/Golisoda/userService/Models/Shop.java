package com.Golisoda.userService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    @Id
    private String Shopid;
    private String shop_name;
    private String shop_owner;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
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
