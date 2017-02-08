package com.gq.mysql;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
public class SshChangeDB {
	static int lport = 3307;//本地端口  
	static String host = "192.168.148.119";//远程MySQL服务器  
	static int rport = 3306;//远程MySQL服务端口 
	static String sshhost = "210.14.140.85";//远程服务器地址
	static String sshusername = "readonly";//服务器用户名
	static String sshPassword = "v1Riz8hTex";//服务器密码
	static int sshport = 22;
	static String filePath = "E:\\delsql.txt";
	static List delList;

	/**
	 * 写入需要删除的数据
	 */
	private static void writeTxt() {
		try {
			File f = new File(filePath);
			if (f.exists()) {
				System.out.print("文件存在");
			} else {
				System.out.print("文件不存在");
				f.createNewFile();
				// 不存在则创建  
			}
			StringBuilder buf = new StringBuilder();
			for (int i = 0; i < delList.size(); i++) {
				buf.append(delList.get(i) + "\n");
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(buf.toString());
			output.close();
			System.out.println("--写完了--");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据信息
	 * @param conn
	 * @throws SQLException
	 */
	private static void getData(Connection conn) throws SQLException {
		// 获取所有表名  
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select id,STUDENT_ID,FK_COURSE_ID,FK_COURSEWARE_ID from scorm_stu_course ");
		Map map = new HashMap();
		delList = new ArrayList();
		int keyconut = 0;
		int valconut = 0;
		int count = 0;
		// 获取数据  
		while (resultSet.next()) {
			count = count + 1;
			Object key = resultSet.getString(2) + resultSet.getString(3) + resultSet.getString(4);
			if (!map.containsKey(key)) {
				map.put(key, resultSet.getString(1));
				keyconut = keyconut + 1;
			} else {
				String delsql = "DELETE from scorm_stu_course where id ='" + resultSet.getString(1) + "';";
				valconut = valconut + 1;
				delList.add(delsql);
			}
		}
		statement.close();
		conn.close();
		System.out.println(delList.size());
		System.out.println("count:" + count + "---keyconut:" + keyconut + "-----valconut:" + valconut);
	}

	/**
	 * 获得ssh链接
	 */
	public static void go() {
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(sshusername, sshhost, sshport); // 端口账号 
			session.setPassword("v1Riz8hTex");
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息  
			int assinged_port = session.setPortForwardingL(lport, host, rport);//端口映射 转发
			System.out.println("localhost:" + assinged_port); //端口映射 转发
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			//1、加载驱动  
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2、创建连接  
		Connection conn = null;
		try {
			System.out.println("=============");
			go();
			//映射到本地的服务
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + lport + "/learning_space_1_zhw", "tylearning_user", "S4XwPbzWQDfq");
			System.out.println("--------------");
			getData(conn);
			writeTxt();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}