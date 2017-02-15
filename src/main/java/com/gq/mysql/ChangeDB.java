package com.gq.mysql;  
import com.jcraft.jsch.JSch;  
import com.jcraft.jsch.Session;  
import java.sql.*;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *jdbc使用SSH隧道连接mysql数据库demo
 * @author gengqiao
 *可以运用和这个小程序直连数据库。处理数据
 */
public class ChangeDB {  
    /**
     * 
   * 获得映射
     * @param username 远程ssh的用户名
     * @param password 远程ssh的密码
     * @param ConnecHost 远程地址
     * @param lport 本地需要映射的端口
     * @param host 远程MySql服务器的内网地址 
     * @param rport 远程MySQL服务端口 
     * @param Database 数据库名
     * @param DataUserName 数据库用户名
     * @param DataPassword 数据库密码
     * @return
     */
    public static Connection go(String username,String password,String ConnecHost,int lport, String host, int rport,String Database,String DataUserName,String DataPassword) {  
    	Connection   conn=null;
    	try {  
            JSch jsch = new JSch();  
            Session session = jsch.getSession(username, ConnecHost, 22); // 端口账号 
            session.setPassword(password);  
            session.setConfig("StrictHostKeyChecking", "no");  
            session.connect();  
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息  
            int assinged_port=  session.setPortForwardingL(lport, host, rport);//端口映射 转发
            System.out.println("localhost:" + assinged_port);  //端口映射 转发
                //1、加载驱动  
             Class.forName("com.mysql.jdbc.Driver");  
             conn = DriverManager.getConnection("jdbc:mysql://localhost:"+lport+"/"+Database, DataUserName, DataPassword); 
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return conn;
        
    }  
/**
 * 数据查询的方法
 * @param conn 数据库连接
 * @param sql 需要查询的sql
 * @return 一个以sql的列名为key的map组成的list
 */
    public static List getData(Connection conn,String sql)  {  
    	List list=new ArrayList();
    	try {
	        // 获取所有表名  
	        Statement statement = conn.createStatement();  
	        ResultSet resultSet = statement.executeQuery(sql);  
	        // 获取列名  
	        ResultSetMetaData metaData = resultSet.getMetaData();
	        // 获取数据  
	        while (resultSet.next()) {
	        	Map map=new HashMap();
	            for (int i = 0; i < metaData.getColumnCount(); i++) {  
	                // resultSet数据下标从1开始  
	            	String columnName = metaData.getColumnName(i + 1);  
	            	String value=resultSet.getString(i + 1);
	            	map.put(columnName, value);
	            }  
	            list.add(map);
	        }  
	        statement.close();  
	        conn.close();  
    	} catch (SQLException e) {
			// TODO: handle exception
		} 
        return list;
    }  
  
    private static void getData(Connection conn) throws SQLException {  
        // 获取所有表名  
        Statement statement = conn.createStatement();  
        ResultSet resultSet = statement.executeQuery("select * from enum_const limit 10");  
        // 获取列名  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        for (int i = 0; i < metaData.getColumnCount(); i++) {  
            // resultSet数据下标从1开始  
            String columnName = metaData.getColumnName(i + 1);  
            int type = metaData.getColumnType(i + 1);  
            if (Types.INTEGER == type) {  
                // int  
            } else if (Types.VARCHAR == type) {  
                // String  
            }  
            System.out.print(columnName + "\t");  
        }  
        // 获取数据  
        while (resultSet.next()) {  
            for (int i = 0; i < metaData.getColumnCount(); i++) {  
                // resultSet数据下标从1开始  
                System.out.print(resultSet.getString(i + 1) + "\t");  
            }  
            System.out.println();  
  
        }  
        statement.close();  
        conn.close();  
    }  
  
}  