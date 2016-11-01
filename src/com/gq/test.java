package com.gq;
import java.sql.DriverManager;
import java.sql.ResultSet;

/** 
* @className:test.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-5-3
*/
public class test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String sql="SELECT * from pe_priority where fk_site_id='ff808081540adfd901540e2ba08a0263'";
	    sql90(sql);
	}
	
	public static void sql90(String sql) {
		String url = "jdbc:mysql://210.14.140.90:3306/webtrn?useUnicode=true&characterEncoding=UTF-8";
		String username = "webtrn";
		String password = "N8RWrda3";
		try {
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url, username, password);
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String ssqq = "";
				while (rs.next()) {
					String name = rs.getString("name");
					System.out.println(name);
					//String count = rs.getString("co");
				  
				}
		
			stmt.executeBatch();
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
	}


	public static void sql57(String ssqq) {
		String url = "jdbc:mysql://192.168.20.57:3306/webtrn?useUnicode=true&characterEncoding=UTF-8";
		String username = "webtrn";
		String password = "whaty@webtrn";
		try {
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url, username, password);
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate(ssqq);
			if (stmt != null) { // 关闭声明   
				stmt.close();
			}
			if (con != null) { // 关闭连接对象   
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
