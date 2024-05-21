package com.Golisoda.userService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor

@Table(name = "address")
//Address ( id, address_line1, address_line2, pin, city, district, state, country, user_type, user_id)
public class Address {
    @Id
    private String  address_id;
    private String address_line1;
    private String address_line2;
    private Long pin;
    private String city;
    private String district;
    private String state;
    private String country;
    private String user_type;
    private String userId;
    public Address() {
        this.address_id = UUID.randomUUID().toString(); // Assign UUID as the ID
    }

}
