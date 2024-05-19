package com.Golisoda.userService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
//Warehouse(WarehouseID (Primary Key), Name, address_id, Capacity, Manager_name, manager_phn_no, alt_phone_no, aadhaar_no, pan_no, email_id, region)
public class WareHouse {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer WarehouseID;
    private String name;
    private Integer address_id;
    private Long capacity;
    private String manager_name;
    private Long manager_phn_no;
    private Long alt_phn_no;
    private Long aadhar_no;
    private Long pan_no;
    private String email_id;
    private String region;

}
