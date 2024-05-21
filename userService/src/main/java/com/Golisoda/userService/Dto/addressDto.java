package com.Golisoda.userService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class addressDto {
    private String  address_id;
    private String address_line1;
    private String address_line2;
    private Long pin;
    private String city;
    private String district;
    private String state;
    private String country;
    private String user_type;
    private String user_id;
}
