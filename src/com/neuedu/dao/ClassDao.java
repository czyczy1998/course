package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.model.TbClass;
import com.neuedu.utils.DBUtil;

public class ClassDao {

	public List<Map<String, String>> getAll() {
		String sql = "select * from tb_class";
		return DBUtil.query(sql, null);
	}
	
	public boolean save(String classname) {
		String sql = "insert into tb_class(classname) values(?)";

		return DBUtil.update(sql, classname);
	}
	
	
	public boolean update(String classid, String classname) {
		String sql = "update tb_class set classname = ? where classid = ?";		
		return DBUtil.update(sql, classname,classid);
	}

	public boolean delete(String classid) {
		String sql = "delete from tb_class where classid = ?";
		return DBUtil.update(sql, classid);
	}
}
