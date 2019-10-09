package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.ClassDao;
import com.neuedu.model.TbClass;

public class ClassService {
	private ClassDao cd = new ClassDao();

	public List<Map<String, String>> getAll() {
		
		return cd.getAll();
	}
	
	public boolean add(String classname) {
		return cd.save(classname);
	}
	
	public boolean edit(String classid,String classname) {
		return cd.update(classid, classname);
	}

	public boolean delete(String classid) {
		
		return cd.delete(classid);
	}

}
