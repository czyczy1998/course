package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.utils.DBUtil;

public class AdminDao {
	public List<Map<String,String>> getByUnameAndPwd(String username,String password){
		String sql = "select * from tb_admin where username = ? and password = ?";
		Object[] objects = {username,password};
		return DBUtil.query(sql, objects);		
	}
}
