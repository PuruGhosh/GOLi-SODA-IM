package com.Golisoda.userService.Dto;

import com.Golisoda.userService.Models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class userDto {
    private String user_id;
    private String f_name;
    private String l_name;
    private LocalDate dob;
    private Long aadhar_no;
    private Long pan_no;
    private LocalDate doj;
    private String designation;
    private Integer reporting_user_id;
    private Address address;
    private Long phone_no;
    private Long alt_phone_no;
    private String email_id;
}
