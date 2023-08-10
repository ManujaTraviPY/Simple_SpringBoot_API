package com.newtask.students.controller;


import com.newtask.students.dto.StudentDTO;
import com.newtask.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/student")


public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity saveStudent(@RequestBody StudentDTO studentDTO){
        try {
            return ResponseEntity.ok().body("Student saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Student already exists");
        }
    }

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody StudentDTO studentDTO){
        try {
            return ResponseEntity.ok().body("Student updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Student does not exist");
        }
    }

    @GetMapping("/getStudent")
    public ResponseEntity getStudent(){
        try {
            return ResponseEntity.ok().body(studentService.getStudent());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Student does not exist");
        }
    }

    @GetMapping("/searchStudent/{stdID}")
    public ResponseEntity searchStudent(@PathVariable int stdID){
        try {
            return ResponseEntity.ok().body(studentService.searchStudent(stdID));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Student does not exist");
        }
    }

    @DeleteMapping("/deleteStudent/{stdID}")
    public ResponseEntity deleteStudent(@PathVariable int stdID){
        try {
            return ResponseEntity.ok().body("Student deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Student does not exist");
        }
    }
}
