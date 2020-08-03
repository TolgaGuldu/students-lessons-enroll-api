package com.students.enroll.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lesson implements Serializable {

	private static final long serialVersionUID = -3770142805983192214L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LESSON_ID", unique = true, nullable = false, length = 20)
	private Long lessonId;

	@Column(name = "LESSON_NAME")
	@NotEmpty(message = "Please provide a lessonName")
	private String lessonName;


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_lesson", joinColumns = {
			@JoinColumn(name = "LESSON_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) })
	private Set<Student> students;

	public Lesson(String lessonName) {
		this.lessonName=lessonName;
	}

	public Lesson() {
		this.lessonName=lessonName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lessonId == null) ? 0 : lessonId.hashCode());
		result = prime * result + ((lessonName == null) ? 0 : lessonName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		if (lessonId == null) {
			if (other.lessonId != null)
				return false;
		} else if (!lessonId.equals(other.lessonId))
			return false;
		if (lessonName == null) {
			if (other.lessonName != null)
				return false;
		} else if (!lessonName.equals(other.lessonName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lesson [lessonId=" + lessonId + ", lessonName=" + lessonName + "]";
	}

}
