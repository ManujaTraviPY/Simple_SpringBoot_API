package com.newtask.students.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //manage the primary key
    private int stdID;
    private String name;
    private String address;
    private String number;


}
