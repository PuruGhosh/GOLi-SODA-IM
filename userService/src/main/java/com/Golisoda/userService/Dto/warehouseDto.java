package com.Golisoda.userService.Dto;

import com.Golisoda.userService.Models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class warehouseDto {
    private String WarehouseID;
    private String name;
    private Address address;
    private Long capacity;
    private String manager_name;
    private Long manager_phn_no;
    private Long alt_phn_no;
    private Long aadhar_no;
    private Long pan_no;
    private String email_id;
    private String region;

}
