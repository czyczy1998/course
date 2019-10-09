package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import com.neuedu.model.Student;

public interface StudentDao {
	public List<Map<String, String>> getAll();
	public boolean save(Student student);
	public boolean update(Student student);
	public boolean delete(String sid);
	public List<Map<String, String>> getStudentById(String stuid);
	
	public List<Student> getStudentByNumAndPwd(String stunum,String password);
}
