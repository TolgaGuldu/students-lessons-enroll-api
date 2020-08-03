package com.students.enroll.service;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.enroll.dao.repository.StudentRepository;
import com.students.enroll.exception.StudentLessonIllegalStateException;
import com.students.enroll.model.Lesson;
import com.students.enroll.model.Student;

@Service
public class StudentService {
	private final static Logger LOG = LoggerFactory.getLogger(StudentService.class);

	private StudentRepository studentRepository;
	private LessonService lessonService;

	@Autowired
	public StudentService(LessonService lessonService, StudentRepository studentRepository) {
		this.lessonService = lessonService;
		this.studentRepository = studentRepository;
	}

	public Long addStudent(Student student) {
		student = studentRepository.save(student);
		LOG.info("Student {} Successfully added", student.getStudentId());
		return student.getStudentId();
	}

	public void removeStudent(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new StudentLessonIllegalStateException("Failed to remove Student. Invalid StudentId :: " + studentId);
		}
		studentRepository.delete(student.get());
	}

	public void registerLesson(Long studentId, Set<Lesson> lessons) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		if (!studentOptional.isPresent()) {
			throw new StudentLessonIllegalStateException("Failed to register lesson. Invalid LessonId :: " + studentId);
		}
		Student student = studentOptional.get();
		lessons.addAll(student.getLessons());
		student.setLessons(lessons);
		studentRepository.save(student);
	}

	public void unregisterLesson(Long studentId, Set<Lesson> lessons) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		if (!studentOptional.isPresent()) {
			throw new StudentLessonIllegalStateException("Failed to unregister lesson. Invalid LessonId :: " + studentId);
		}
		Student student = studentOptional.get();
		student.setLessons(lessons);
		//lessons.removeAll(student.getLessons());
		studentRepository.delete(studentOptional.get());
		studentRepository.save(student);
	}

	public Set<Student> getStudentsByLessonName(String lessonName) {
		Optional<Lesson> lesson = lessonService.getLessonByLessonName(lessonName);
		if (!lesson.isPresent()) {
			throw new StudentLessonIllegalStateException("Failed to get Students. Invalid lessonName :: " + lessonName);
		}
		Comparator<Student> studentByName = (Student student1, Student student2) -> student1.getStudentName()
				.compareTo(student2.getStudentName());
		TreeSet<Student> sortedStudents = new TreeSet<>(studentByName);

		Set<Student> students = lesson.get().getStudents();
		students.forEach(student -> student.setLessons(null));
		sortedStudents.addAll(students);
		LOG.debug("Actual Students :: {} and Sorted Students by Name:: {}", students, sortedStudents);
		return sortedStudents;
	}
}
