package com.Golisoda.userService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor

//Warehouse(WarehouseID (Primary Key), Name, address_id, Capacity, Manager_name, manager_phn_no, alt_phone_no, aadhaar_no, pan_no, email_id, region)
public class WareHouse {


    @Id
    private String WarehouseID;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
    private Long capacity;
    private String manager_name;
    private Long manager_phn_no;
    private Long alt_phn_no;
    private Long aadhar_no;
    private String  pan_no;
    private String emailid;
    private String region;

    public WareHouse() {
        this.WarehouseID = UUID.randomUUID().toString();
    }
}
