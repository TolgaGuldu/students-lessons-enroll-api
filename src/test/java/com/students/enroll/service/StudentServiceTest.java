package com.students.enroll.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.students.enroll.dao.repository.StudentRepository;
import com.students.enroll.exception.StudentLessonIllegalStateException;
import com.students.enroll.model.Lesson;
import com.students.enroll.model.Student;

public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepositoryMock;
	
	@Mock
	private LessonService lessonServiceMock;

	@InjectMocks
	private StudentService studentService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddLesson() {
		Student student = new Student();
		student.setStudentId(1l);
		Mockito.when(studentRepositoryMock.save(Mockito.any(Student.class))).thenReturn(student);
		Long lessonId = studentService.addStudent(student);
		Assert.assertEquals(1, lessonId.longValue());
	}

	@Test
	public void testRemoveLesson() {
		Long lessonId = 1l;
		Student student = new Student();
		student.setStudentId(1l);
		Mockito.when(studentRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(student));
		studentService.removeStudent(lessonId);
	}

	@Test(expected = StudentLessonIllegalStateException.class)
	public void testRemoveLessonWithEmptyLesson() {
		Long lessonId = 1l;
		Mockito.when(studentRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		studentService.removeStudent(lessonId);
	}

	@Test
	public void testRegisterStudentToLesson() {
		Long studentId = 1l;
		Student source = new Student();
		source.setStudentId(studentId);
		source.setLessons(Collections.emptySet());
		Mockito.when(studentRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(source));
		Set<Lesson> lessons = Collections.emptySet();
		studentService.registerLesson(studentId, lessons);

	}

	@Test(expected = StudentLessonIllegalStateException.class)
	public void testRegisterStudentToLessonEmptyLesson() {
		Long lessonId = 1l;
		Mockito.when(studentRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		Set<Lesson> lessons = Collections.emptySet();
		studentService.registerLesson(lessonId, lessons);

	}
	
	@Test
	public void testGetStudentsByLessonName() {
		String lessonName = "DevOps";
		Lesson lesson = new Lesson();
		lesson.setLessonId(1l);
		lesson.setLessonName(lessonName);
		
		Set<Student> studentsSet = new HashSet<>();
		
		Student student = new Student();
		student.setStudentName("NA");
		studentsSet.add(student);
		lesson.setStudents(studentsSet);
		lesson.setLessonName("NA");
		Mockito.when(lessonServiceMock.getLessonByLessonName(Mockito.anyString())).thenReturn(Optional.of(lesson));
		Set<Student> students = studentService.getStudentsByLessonName(lessonName);
		Assert.assertNotNull(students);
	}
	
	@Test(expected=StudentLessonIllegalStateException.class)
	public void testGetStudentsByLessonNameWithEmptylesson() {
		String lessonName = "DevOps";
		Mockito.when(lessonServiceMock.getLessonByLessonName(Mockito.anyString())).thenReturn(Optional.empty());
		Set<Student> students = studentService.getStudentsByLessonName(lessonName);
		Assert.assertNotNull(students);
	}

}
