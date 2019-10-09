package com.neuedu.dao.impl;

import java.util.List;

import com.neuedu.dao.SelectionDao;
import com.neuedu.model.Course;
import com.neuedu.model.Selection;
import com.neuedu.utils.DBUtil;
import com.neuedu.vo.SelectionVO;

public class SelectionDaoImpl implements SelectionDao{

	@Override
	public List<Course> getUnSelectedList(String stuid) {
		String sql = "select * from tb_course where courseid not in (select courseid from selection where stuid = ?)";
		return DBUtil.query(sql, Course.class, stuid);
	}

	@Override
	public List<SelectionVO> getSelectedList(String stuid) {
		String sql = "select s.*,coursename,`hour`,score,if(s.term = 1,'上学期','下学期') strterm from selection s,tb_course c where s.courseid = c.courseid and stuid = ?";
		
		return DBUtil.query(sql, SelectionVO.class, stuid);
	}

	@Override
	public void delete(String selid) {
		String sql = "delete from selection where selid = ?";
		DBUtil.update(sql, selid);
		
	}

	@Override
	public boolean save(Selection selection) {
		String sql = "insert into selection(stuid,courseid,year,term) values(?,?,?,?)";
		return DBUtil.update(sql, selection.getStuid(),selection.getCourseid(),selection.getYear(),selection.getTerm());
	}

}
