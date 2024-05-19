package com.Golisoda.userService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
//Address ( id, address_line1, address_line2, pin, city, district, state, country, user_type, user_id)
public class Address {
    @Id
    private Integer address_id;
    private String address_line1;
    private String address_line2;
    private Long pin;
    private String city;
    private String district;
    private String state;
    private String country;
    private String user_type;
    private Integer user_id;

}
