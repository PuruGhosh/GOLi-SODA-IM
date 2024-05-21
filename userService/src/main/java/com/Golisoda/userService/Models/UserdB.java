package com.Golisoda.userService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor

@Table(name = "userdb")
public class UserdB {
    @Id
    private String user_id;
    private String f_name;
    private String l_name;
    private LocalDate dob;
    private Long aadhar_no;
    private String pan_no;
    private LocalDate doj;
    private String designation;
    private String reporting_user_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
    private Long phone_no;
    private Long alt_phone_no;
    private String emailid;

    public UserdB() {
        this.user_id = UUID.randomUUID().toString(); // Assign UUID as the ID
    }
}
