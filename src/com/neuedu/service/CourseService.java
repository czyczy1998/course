package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.model.Course;

public interface CourseService {
	public List<Course> getAll(int pageNO);
	public int getTotalRecord();
	public int getPageSum(int totalCount);
	public boolean add(Course c);
	public List<Course> getAll();
	
	
}
