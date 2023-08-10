package com.newtask.students.service;

import com.newtask.students.dto.StudentDTO;
import com.newtask.students.entity.Student;
import com.newtask.students.repo.StudentRep;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional

public class StudentService {

    @Autowired
    private StudentRep StudentRep;

    @Autowired
    private ModelMapper modelMapper;

    public  String saveStudent(StudentDTO studentDTO) {
        if (StudentRep.existsById(studentDTO.getStdID())) {
            return "Student already exists";
        } else {
            StudentRep.save(modelMapper.map(studentDTO, Student.class));
            return "Student saved successfully";
        }
    }
    public List<StudentDTO> getStudent() {
        List<Student> studentList = StudentRep.findAll();
        return modelMapper.map(studentList,new TypeToken<ArrayList<StudentDTO>>(){
        }.getType());
    }

    public  String updateStudent(StudentDTO studentDTO) {
        if (StudentRep.existsById(studentDTO.getStdID())) {
            StudentRep.save(modelMapper.map(studentDTO, Student.class));
            return "Student updated successfully";
        } else {
            return "Student does not exist";
        }
    }

    public  StudentDTO searchStudent(int stdID) {
        if (StudentRep.existsById(stdID)) {
            return modelMapper.map(StudentRep.findById(stdID).get(), StudentDTO.class);
        } else {
            return null;
        }
    }

    public String deleteStudent(int stdID) {
        if (StudentRep.existsById(stdID)) {
            StudentRep.deleteById(stdID);
            return "Student deleted successfully";
        } else {
            return "Student does not exist";
        }
    }

}
