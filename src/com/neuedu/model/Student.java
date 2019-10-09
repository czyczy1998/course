package com.neuedu.model;

public class Student {
	
	private int stuid;
	private String stunum;
	private String stuname;
	private String password;
	private int classid;
	
	public Student() {}

	public Student(int stuid, String stunum, String stuname, String password, int classid) {

		this.stuid = stuid;
		this.stunum = stunum;
		this.stuname = stuname;
		this.password = password;
		this.classid = classid;
	}
	public Student(String stunum, String stuname, String password, int classid) {
		this(0, stunum, stuname, password, classid);
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	
	

}
