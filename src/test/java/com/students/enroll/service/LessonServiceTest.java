package com.students.enroll.service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.students.enroll.dao.repository.LessonRepository;
import com.students.enroll.exception.StudentLessonIllegalStateException;
import com.students.enroll.model.Lesson;
import com.students.enroll.model.Student;

public class LessonServiceTest {

	@Mock
	private LessonRepository lessonRepositoryMock;

	@InjectMocks
	private LessonService lessonService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEnrollStudentToLesson() {
		Long lessonId = 1l;
		Lesson lesson = new Lesson();
		lesson.setLessonId(lessonId);
		lesson.setLessonName("Spring");
		lesson.setStudents(Collections.emptySet());
		Mockito.when(lessonRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(lesson));
		Set<Student> students = Collections.emptySet();
		lessonService.enrollStudentToLesson(lessonId, students);

	}
	
	@Test(expected=StudentLessonIllegalStateException.class)
	public void testEnrollStudentToLessonEmptyLesson() {
		Long lessonId = 1l;
		Mockito.when(lessonRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		Set<Student> students = Collections.emptySet();
		lessonService.enrollStudentToLesson(lessonId, students);

	}

	@Test
	public void testGetLessonByLessonName() {
		String lessonName = "DevOps";
		lessonService.getLessonByLessonName(lessonName);
	}

}
