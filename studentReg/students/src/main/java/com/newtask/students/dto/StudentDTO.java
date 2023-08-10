package com.newtask.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentDTO {
    private int stdID;
    private String name;
    private String address;
    private String number;

}
