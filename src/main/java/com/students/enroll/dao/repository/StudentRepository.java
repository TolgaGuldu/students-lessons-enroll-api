package com.students.enroll.dao.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.students.enroll.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
