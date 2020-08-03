package com.students.enroll.controller;

import java.util.Set;

import javax.validation.Valid;

import com.students.enroll.dao.repository.LessonRepository;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.students.enroll.model.*;
import com.students.enroll.service.*;


@RestController
public class StudentLessonEnrollController {
	private final static Logger LOG = LoggerFactory.getLogger(StudentLessonEnrollController.class);

	private StudentService studentService;
	private LessonService lessonService;

	@Autowired
	public StudentLessonEnrollController(StudentService studentService, LessonService lessonService) {
		this.studentService = studentService;
		this.lessonService = lessonService;
	}

	@PostMapping("/student")
	public String addStudent(@Valid @RequestBody Student student) {
		LOG.info("Student :: Student Name {}", student.getStudentName());
		studentService.addStudent(student);
		return "Student with Name:" + student.getStudentName() + " has been Added.";
	}

	@DeleteMapping("/student/{studentId}")
	public String removeStudent(Long studentId) {
		studentService.removeStudent(studentId);
		return "Student with Id:" + studentId + " has been removed.";
	}

	@PutMapping("/enrollStudentToLesson/{lessonId}")
	public String enrollStudentsToLesson(@PathVariable Long lessonId, @RequestBody Set<Student> students) {
		lessonService.enrollStudentToLesson(lessonId, students);
		return "Students has been successfully Enrolled to Lesson :: " + lessonId;
	}

	@DeleteMapping("/unenrollStudentToLesson/{lessonId}")
	public String unenrollStudentsToLesson(@PathVariable Long lessonId, @RequestBody Set<Student> students) {
		lessonService.unenrollStudentToLesson(lessonId, students);
		return "Students has been successfully Unenrolled to Lesson :: " + lessonId;
	}

	@GetMapping("/studentsByLessonName/{lessonName}")
	public Set<Student> getStudentsByLessonName(@PathVariable String lessonName) {
		return studentService.getStudentsByLessonName(lessonName);
	}

}
