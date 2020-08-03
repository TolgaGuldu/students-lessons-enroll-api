package com.students.enroll.controller;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.students.enroll.model.Lesson;
import com.students.enroll.model.Student;
import com.students.enroll.service.LessonService;
import com.students.enroll.service.StudentService;

public class StudentsLessonEnrollController {
	private final static Logger LOG = LoggerFactory.getLogger(StudentsLessonEnrollController.class);

	@Mock
	private StudentService studentServiceMock;
	@Mock
	private LessonService lessonServiceMock;

	@InjectMocks
	private StudentLessonEnrollController studentLessonEnrollController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setStudentId(1l);
		studentLessonEnrollController.addStudent(student);
	}

	@Test
	public void testRemoveStudent() {
		Long studentId = 1l;
		studentLessonEnrollController.removeStudent(studentId);
	}

	@Test
	public void testEnrollStudentToCLesson() {
		Long lessonId = 1l;
		Set<Student> students = Collections.emptySet();
		studentLessonEnrollController.enrollStudentsToLesson(lessonId, students);
	}

	@Test
	public void testGetStudentsByLessonName() {
		String lessonName = "DevOps";
		studentLessonEnrollController.getStudentsByLessonName(lessonName);
	}

}
