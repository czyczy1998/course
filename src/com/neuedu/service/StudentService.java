package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.model.Student;

public interface StudentService {
	public List<Map<String, String>> getAll();
	public boolean add(Student student);
	public boolean update(Student student);
	public boolean delete(String sid);
	
	public Map<String, String> getStudentByid(String stuid);
	
	//Ñ§ÉúµÇÂ¼
	public Student login(String stunum, String password);
	
}
