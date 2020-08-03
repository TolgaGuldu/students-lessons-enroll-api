package com.students.enroll.service;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.enroll.dao.repository.*;
import com.students.enroll.exception.StudentLessonIllegalStateException;
import com.students.enroll.model.*;

@Service
public class LessonService {
	private final static Logger LOG = LoggerFactory.getLogger(LessonService.class);

	private LessonRepository lessonRepository;
	private StudentRepository studentRepository;


	@Autowired
	public LessonService(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}


	public void enrollStudentToLesson(Long lessonId, Set<Student> students) {
		LOG.info("LessonId :: {} , Student :: {}", lessonId, students);
		Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
		if (!lessonOptional.isPresent()) {
			throw new StudentLessonIllegalStateException("Failed to register Student. Invalid LessonId :: " + lessonId);
		}
		Lesson lesson = lessonOptional.get();
		students.addAll(lesson.getStudents());
		lesson.setStudents(students);
		lessonRepository.save(lesson);
	}


	public void unenrollStudentToLesson(Long lessonId,  Set<Student> students) {
		LOG.info("LessonId :: {} , Student :: {}", lessonId,  students);
		Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
		if (!lessonOptional.isPresent()) {
			throw new StudentLessonIllegalStateException("Failed to unregister Student. Invalid LessonId :: " + lessonId);
		}
		Lesson lesson = lessonOptional.get();
		lesson.setStudents(students);
		students.remove(lesson.getStudents());
		lessonRepository.save(lesson);
	}

	public Optional<Lesson> getLessonByLessonName(String lessonName) {
		return lessonRepository.findLessonByLessonName(lessonName);
	}

}
