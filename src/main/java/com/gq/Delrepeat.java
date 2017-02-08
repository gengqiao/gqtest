package com.gq;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @className:Delrepeat.java
* @classDescription:删除重复数据的一个小demo
* @author:gengqiao
* @createTime:2017-2-7
*/
public class Delrepeat {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map map=new HashMap();
		List list=new ArrayList();
		map.put("11", "11");
		map.put("22", "22");
		list.add(map);
		
	}
	
	
	
	
	
	public static List connection(String sql,List<String> key) {
		List list=new ArrayList();
		String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "olcp";
		try {
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				for(String s:key){
				   
				}
				String name=rs.getString("TRUE_NAME");
			     
			}
			if (rs != null) { // 关闭记录集   
				rs.close();
			}
			if (stmt != null) { // 关闭声明   
				stmt.close();
			}
			if (con != null) { // 关闭连接对象   
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
