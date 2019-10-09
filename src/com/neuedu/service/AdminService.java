package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.AdminDao;

public class AdminService {
	private AdminDao ad = new AdminDao();
	/*public List<Map<String, String>> login(String username,String password) {
		return ad.getByUnameAndPwd(username, password);
	}*/
	
	public boolean login(String username,String password) {
		List<Map<String, String>> list = ad.getByUnameAndPwd(username, password);
		if(list.size() == 0) {
			return false;
		}
		return true;
	}
}
