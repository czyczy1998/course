package com.neuedu.vo;

import com.neuedu.model.Course;

public class SelectionVO {
	private int courseid;
	private String coursename;
	private int hour;
	private double score;
	private int selid;
	private int stuid;
	private int year;  //ѧ��
	private String term; //ѧ�ڣ�1����ѧ�ڣ�2����ѧ��
	private double grade;//�ɼ�
	private String strterm; //ѧ�ڵ��ַ�����ʽ����ѧ�ڣ���ѧ��
	
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
	public String getStrterm() {
		return strterm;
	}
	public void setStrterm(String strterm) {
		this.strterm = strterm;
	}
	
	
	
}
