package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.model.Course;

public interface CourseDao {
	public List<Course> getAll(int start, int pageCount);
	
	public List<Course> getAll();

	public boolean save(Course c);
}
