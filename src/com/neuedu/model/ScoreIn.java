package com.neuedu.model;

public class ScoreIn {
	private int selid;
private String classname;
private int stunum;
private String stuname;
private int year;
private String term;
private String coursename;
private double score;
private double grade;


public ScoreIn(int selid, String classname, int stunum, String stuname, int year, String term, String coursename,
		double score, double grade) {
	super();
	this.selid = selid;
	this.classname = classname;
	this.stunum = stunum;
	this.stuname = stuname;
	this.year = year;
	this.term = term;
	this.coursename = coursename;
	this.score = score;
	this.grade = grade;
}
public int getSelid() {
	return selid;
}
public void setSelid(int selid) {
	this.selid = selid;
}
public String getClassname() {
	return classname;
}
public void setClassname(String classname) {
	this.classname = classname;
}
public int getStunum() {
	return stunum;
}
public void setStunum(int stunum) {
	this.stunum = stunum;
}
public String getStuname() {
	return stuname;
}
public void setStuname(String stuname) {
	this.stuname = stuname;
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
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
public double getGrade() {
	return grade;
}
public void setGrade(double grade) {
	this.grade = grade;
}

}
