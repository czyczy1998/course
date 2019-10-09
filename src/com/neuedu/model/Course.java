package com.neuedu.model;

public class Course {
	/*courseid int not null auto_increment,
	coursename varchar(20) not null,
	hour int not null,
	score double(5,2) not null,*/
	private int courseid;
	private String coursename;
	private int hour;
	private double score;
	
	public Course() {}
	
	

	public Course(String coursename, int hour, double score) {
		super();
		this.coursename = coursename;
		this.hour = hour;
		this.score = score;
	}
	
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", hour=" + hour + ", score=" + score
				+ "]";
	}
	
	
	
}
