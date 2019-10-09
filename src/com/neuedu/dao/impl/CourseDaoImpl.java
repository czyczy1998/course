package com.neuedu.dao.impl;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.CourseDao;
import com.neuedu.model.Course;
import com.neuedu.utils.DBUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public List<Course> getAll(int start, int pageCount) {
		String sql = "select * from tb_course limit ?,?";
		return DBUtil.query(sql,Course.class, start,pageCount);
	}

	@Override
	public List<Course> getAll() {
		return DBUtil.query("select * from tb_course",Course.class,null);
	}

	@Override
	public boolean save(Course c) {
		String sql="insert into tb_course(coursename,hour,score) values(?,?,?)";
		Object[] array = {c.getCoursename(),c.getHour(),c.getScore()};
		return DBUtil.update(sql, array);
	
	}

}
