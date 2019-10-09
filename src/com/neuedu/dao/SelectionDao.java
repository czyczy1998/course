package com.neuedu.dao;

import java.util.List;

import com.neuedu.model.Course;
import com.neuedu.model.Selection;
import com.neuedu.vo.SelectionVO;

public interface SelectionDao {
	//Ϊѡ��γ��б�
	public List<Course> getUnSelectedList(String stuid);
	//��ѯ��ѡ��Ŀγ��б�
	public List<SelectionVO> getSelectedList(String stuid);
	public void delete(String selid);
	public boolean save(Selection selection);
}
