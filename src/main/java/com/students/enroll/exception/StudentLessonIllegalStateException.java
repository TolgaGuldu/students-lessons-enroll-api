package com.students.enroll.exception;

public class StudentLessonIllegalStateException extends IllegalStateException {
	private static final long serialVersionUID = 1L;
	
	public StudentLessonIllegalStateException(String message) {
		super(message);
	}
	
	public StudentLessonIllegalStateException(Throwable e) {
		super(e);
	}

}
