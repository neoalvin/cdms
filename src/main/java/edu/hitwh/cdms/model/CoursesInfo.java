package edu.hitwh.cdms.model;

public class CoursesInfo {
	private String courseId;
	private String courseName;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "CoursesInfo [courseId=" + courseId + ", courseName="
				+ courseName + "]";
	}

}
