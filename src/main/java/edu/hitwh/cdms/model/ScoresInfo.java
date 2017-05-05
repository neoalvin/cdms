package edu.hitwh.cdms.model;

public class ScoresInfo {
	private String studentId;
	private String studentName;
	private String studentClass;
	private String courseName;
	private int scoreUsual;
	private int scoreMiddle;
	private int scoreLast;
	private int scoreSummary;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getScoreUsual() {
		return scoreUsual;
	}

	public void setScoreUsual(int scoreUsual) {
		this.scoreUsual = scoreUsual;
	}

	public int getScoreMiddle() {
		return scoreMiddle;
	}

	public void setScoreMiddle(int scoreMiddle) {
		this.scoreMiddle = scoreMiddle;
	}

	public int getScoreLast() {
		return scoreLast;
	}

	public void setScoreLast(int scoreLast) {
		this.scoreLast = scoreLast;
	}

	public int getScoreSummary() {
		return scoreSummary;
	}

	public void setScoreSummary(int scoreSummary) {
		this.scoreSummary = scoreSummary;
	}

	@Override
	public String toString() {
		return "ScoresInfo [studentId=" + studentId + ", studentName="
				+ studentName + ", studentClass=" + studentClass
				+ ", courseName=" + courseName + ", scoreUsual=" + scoreUsual
				+ ", scoreMiddle=" + scoreMiddle + ", scoreLast=" + scoreLast
				+ ", scoreSummary=" + scoreSummary + "]";
	}

}
