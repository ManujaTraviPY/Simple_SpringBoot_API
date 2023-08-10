package com.newtask.students.repo;

import com.newtask.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRep extends JpaRepository<Student, Integer> {

}
