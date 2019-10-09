package com.neuedu.model;

public class Selection {
	
	private int selid;
	private int stuid;
	private int courseid;
	private int year;  //学年
	private String term; //学期
	private double grade;//成绩
	
	public Selection() {}

	public Selection(int stuid, int courseid, int year, String term) {
		this(stuid, courseid, year, term, 0);
	}

	public Selection(int stuid, int courseid, int year, String term, double grade) {
		super();
		this.stuid = stuid;
		this.courseid = courseid;
		this.year = year;
		this.term = term;
		this.grade = grade;
	}
	
	public int getSelid() {
		return selid;
	}
	public void setSelid(int selid) {
		this.selid = selid;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
}
