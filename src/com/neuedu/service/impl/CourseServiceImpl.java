package com.neuedu.service.impl;

import java.util.List;
import java.util.Map;

import com.neuedu.constant.Constant;
import com.neuedu.dao.CourseDao;
import com.neuedu.dao.impl.CourseDaoImpl;
import com.neuedu.model.Course;
import com.neuedu.model.Student;
import com.neuedu.service.CourseService;

public class CourseServiceImpl implements CourseService {
	CourseDao cd = new CourseDaoImpl();

	@Override
	public List<Course> getAll(int pageNO) {
		//1：将页数转换成从第几条开始
		int start = Constant.PAGE_COUNT * (pageNO - 1);

		return cd.getAll(start, Constant.PAGE_COUNT);
	}

	//查询总的记录数
	@Override
	public int getTotalRecord() {
		List<Course> list = cd.getAll();
		return list.size();
	}
	
	//获取总页数
	public int getPageSum(int totalCount) {
		//return (int)Math.ceil((totalCount * 1.0) / Constant.PAGE_COUNT);
		
		return (totalCount - 1) / Constant.PAGE_COUNT + 1;
	}
public boolean add(Course c) {
		
		return cd.save(c);
	}

@Override
public List<Course> getAll() {
	// TODO Auto-generated method stub
	return cd.getAll();
}
	
}
