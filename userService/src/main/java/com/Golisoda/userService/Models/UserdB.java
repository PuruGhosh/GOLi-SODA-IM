package com.Golisoda.userService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class UserdB {
    @Id
    private Integer user_id;
    private String f_name;
    private String l_name;
    private LocalDate dob;
    private Long aadhar_no;
    private Long pan_no;
    private LocalDate doj;
    private String designation;
    private Integer reporting_user_id;
    private Integer address_id;
    private Long phone_no;
    private Long alt_phone_no;
    private String email_id;

}
