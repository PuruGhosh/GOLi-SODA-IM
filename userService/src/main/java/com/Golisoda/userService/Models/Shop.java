package com.Golisoda.userService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor

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
    private String emailid;
    private Long gstin_no;
    private Long trade_lisence_no;
    private String shop_type;
    private Long poc_aadhar_no;
    private String poc_pan_no;
    public Shop() {
        this.Shopid = UUID.randomUUID().toString(); // Assign UUID as the ID
    }


}
