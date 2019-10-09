package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.ScoreInDao;
import com.neuedu.model.ScoreIn;

public class ScoreInService {
	ScoreInDao sd=new ScoreInDao();
public List<Map<String, String>> getAll() {
		
		return sd.getAll();
	}
public boolean edit(String i, String d) {
	// TODO Auto-generated method stub
	return sd.edit(i,d);
}

}
