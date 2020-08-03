package com.students.enroll.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student implements Serializable {
	private static final long serialVersionUID = 1013479834262222490L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private Long studentId;

	@Column(name = "STUDENT_NAME")
	@NotEmpty(message = "Please provide a studentName")
	private String studentName;

	@Column(name = "STUDENT_SURNAME")
	@NotEmpty(message = "Please provide a studentSurName")
	private String studentSurName;

	@Column(name = "STUDENT_AGE")
	@NotEmpty(message = "Please provide a studentAge")
	private String studentsAge;

	@Column(name = "STUDENT_ENTER_SYSTEM_DATE")
	@NotEmpty(message = "Please provide a studentEnterSystemDate")
	private String studentzEnterSystemDate;



	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "students", cascade=CascadeType.ALL)
	private Set<Lesson> lessons;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + ((studentSurName == null) ? 0 : studentSurName.hashCode());
		result = prime * result + ((studentsAge == null) ? 0 : studentsAge.hashCode());
		result = prime * result + ((studentzEnterSystemDate == null) ? 0 : studentzEnterSystemDate.hashCode());
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
		Student other = (Student) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentSurName == null) {
			if (other.studentSurName != null)
				return false;
		} else if (!studentSurName.equals(other.studentSurName))
			return false;
		if (studentsAge == null) {
			if (other.studentsAge != null)
				return false;
		} else if (!studentsAge.equals(other.studentsAge))
			return false;
		if (studentzEnterSystemDate == null) {
			if (other.studentzEnterSystemDate != null)
				return false;
		} else if (!studentzEnterSystemDate.equals(other.studentzEnterSystemDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId+  ", studentName=" + studentName  + ", studentSurName=" + studentSurName + ", studentsAge=" + studentsAge+ ", studentzEnterSystemDate=" + studentzEnterSystemDate + "]";
	}

}
