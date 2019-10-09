package com.neuedu.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neuedu.model.Course;
import com.sun.media.sound.SoftInstrument;



//数据库的增删改查
public class DBUtil {
	//增删改方法
	public static boolean update(String sql,Object... array) {
		//获取连接
		ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
		Connection conn = connUtil.getConnection();
		PreparedStatement ps = null;
		
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			if(array != null && array.length != 0) {
				for(int i = 0; i < array.length; i++) {
					ps.setObject(i+1, array[i]);
				}
			}
			int num = ps.executeUpdate();
			if(num > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connUtil.close(conn, ps);
		}
		
		
		return flag;
	}
	
	
	//查询
	public static List<Map<String,String>> query(String sql,Object... array){
		ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
		Connection conn = connUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try {
			ps = conn.prepareStatement(sql);
			if(array != null && array.length != 0) {
				for(int i = 0; i < array.length; i++) {
					ps.setObject(i+1, array[i]);
				}
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			

			while(rs.next()) {
				Map<String,String> map = new HashMap<String, String>();
				 
				for(int i = 0; i < columnCount; i++) {
					String columnName = metaData.getColumnLabel(i+1);
					String colunmValue = rs.getString(columnName);
					map.put(columnName, colunmValue);
				}
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connUtil.close(conn, ps, rs);
		}	
		
		return list;
	}
	
	
	public static <T> List<T> query(String sql,Class<T> clazz,Object... array) {
		ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
		
		Connection conn = connUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			ps = conn.prepareStatement(sql);
			if(array != null && array.length != 0) {
				for(int i = 0; i < array.length; i++) {
					ps.setObject(i+1, array[i]);
				
				}
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount(); //查询结构的字段的长度，也就是有几个字段
			
			
			while(rs.next()) {
				T t = clazz.newInstance();
				 
				for(int i = 0; i < columnCount; i++) {
					String columnName = metaData.getColumnLabel(i+1);
					String colunmValue = rs.getString(columnName);
					
					Field field = clazz.getDeclaredField(columnName);
					if(field != null && (colunmValue != null && !"".equals(colunmValue))) {
						field.setAccessible(true);
						String fieldType = field.getType().getSimpleName(); 
						if("String".equals(fieldType)) {
							field.set(t, colunmValue);
						}else if("int".equals(fieldType)) {
							field.set(t, Integer.parseInt(colunmValue));
						}else if("float".equals(fieldType)) {
							field.set(t, Float.parseFloat(colunmValue));
						}else if("double".equals(fieldType)) {
							field.set(t, Double.parseDouble(colunmValue));
						}else if("long".equals(fieldType)) {
							field.set(t, Long.parseLong(colunmValue));
						}
						
					}
					
				}
				
				list.add(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connUtil.close(conn, ps, rs);
		}	
		
		return list;
	}


}
