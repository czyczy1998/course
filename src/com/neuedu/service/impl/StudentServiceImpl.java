package com.neuedu.service.impl;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.StudentDao;
import com.neuedu.dao.impl.StudentDaoImpl;
import com.neuedu.model.Student;
import com.neuedu.service.StudentService;

public class StudentServiceImpl implements StudentService{
	StudentDao sd  = new StudentDaoImpl();

	@Override
	public List<Map<String, String>> getAll() {
		
		return sd.getAll();
	}

	@Override
	public boolean add(Student student) {
		
		return sd.save(student);
	}

	@Override
	public boolean update(Student student) {
		
		return sd.update(student);
	}

	@Override
	public boolean delete(String sid) {
		return sd.delete(sid);
	}

	@Override
	public Map<String, String> getStudentByid(String stuid) {
		List<Map<String, String>> list = sd.getStudentById(stuid);
		return list.get(0);
		
	}

	@Override
	public Student login(String stunum, String password) {
		List<Student> list = sd.getStudentByNumAndPwd(stunum, password);
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	

}
