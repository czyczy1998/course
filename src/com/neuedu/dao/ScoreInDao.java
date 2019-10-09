package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.model.ScoreIn;
import com.neuedu.model.Student;
import com.neuedu.utils.DBUtil;

public class ScoreInDao {
	public List<Map<String, String>> getAll() {
		String sql = "SELECT a.selid,b.classname,d.stunum,d.stuname,a.`year`,a.term,c.coursename,c.score,a.grade FROM selection a,tb_class b,tb_course c,tb_student d WHERE a.stuid=d.stuid AND a.courseid=c.courseid AND b.classid=d.classid";
		return DBUtil.query(sql, null);
	}

	public boolean edit(String selid, String grade) {
		String sql = "update selection set grade = ? where selid = ?";	
		Object []obj= {grade,selid};
		return DBUtil.update(sql, obj);
	}


	
}
