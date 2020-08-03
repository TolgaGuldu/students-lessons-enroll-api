package com.students.enroll.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.enroll.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

	public Optional<Lesson> findLessonByLessonName(String lessonName);
}
