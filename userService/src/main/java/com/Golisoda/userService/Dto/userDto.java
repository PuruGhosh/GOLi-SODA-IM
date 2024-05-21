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
    private String f_name;
    private String l_name;
    private LocalDate dob;
    private Long aadhar_no;
    private String pan_no;
    private LocalDate doj;
    private String designation;
    private String reporting_user_id;
    private addressDto address;
    private Long phone_no;
    private Long alt_phone_no;
    private String emailid;
}
