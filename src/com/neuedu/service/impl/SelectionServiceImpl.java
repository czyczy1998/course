package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.SelectionDao;
import com.neuedu.dao.impl.SelectionDaoImpl;
import com.neuedu.model.Course;
import com.neuedu.model.Selection;
import com.neuedu.service.SelectionService;
import com.neuedu.vo.SelectionVO;

public class SelectionServiceImpl implements SelectionService {
	
	SelectionDao sd = new SelectionDaoImpl();

	@Override
	public List<Course> getUnSelectedList(String stuid) {
		
		return sd.getUnSelectedList(stuid);
	}

	@Override
	public List<SelectionVO> getSelectedList(String stuid) {
		return sd.getSelectedList(stuid);
	}

	@Override
	public void batchDelete(String[] selids) {
		for(String selid : selids) {
			sd.delete(selid);
		}
		
	}

	@Override
	public boolean batSelectCourse(List<Selection> selections) {
		boolean flag = true;
		for(Selection selection : selections) {
			flag = sd.save(selection);
			if(!flag) {
				return flag;
			}
		}
		return flag;
	}

}
