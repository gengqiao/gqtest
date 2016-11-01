package com.gq;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import jxl.Sheet;
import jxl.Workbook;
/** 
* @className:sqlcon.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-4-29
*/
public class uploadExcle {
	/**
	 * @param args
	 */
	//存储信息的map
	private static Map diquMap = new HashMap();

	public static void main(String[] args) {
		String path = "E:/管理员数据2.xls";
		File file = new File(path);
		Map map = batchUpload(file);
		selct(map.get("provinceSql").toString(), "1");
		System.out.println("查询省成功");
		selct(map.get("citySql").toString(), "2");
		System.out.println("查询市成功");
		selct(map.get("loginIdSql").toString(), "3");
		System.out.println("查询用户名");
		insert((List<HashMap<String, String>>) map.get("list"));
		System.out.println("插入成功");
	}

	/**
	 * 遍历数据，拼接insert
	 * @param list
	 */
	public static void insert(List<HashMap<String, String>> list) {
		List<String> sqllist = new ArrayList<String>();
		for (HashMap<String, String> map : list) {
			Set<String> s = map.keySet();
			String sql = " INSERT into pr_mana_organ (Id , fk_manager,fk_organ,fk_site_id) VALUES ( ";
			for (String str : s) {
				String uuid = UUID.randomUUID().toString().replace("-", "");
				sql += "'" + uuid + "','" + diquMap.get(str) + "','" + diquMap.get(map.get(str)) + "','ff8080815698ddd001569c64edae03c7')";
			}
			sqllist.add(sql);
		}
		exacuteListSql(sqllist);
	}

	/**
	 * 读取excle
	 * @param file
	 * @return
	 */
	public static Map batchUpload(File file) {
		Map zongMap = new HashMap();
		Workbook work = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			work = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet = work.getSheet(0);
		int rows = sheet.getRows(); // 获取Excel表格的行数
		if (rows < 2) {
			System.out.println("表格读取异常");
		}
		int count = 0;
		String loginIds = "";
		String provinces = "";
		String citys = "";
		for (int i = 0; i < rows; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			String loginId = sheet.getCell(0, i).getContents().trim().replace(" ", "");
			String province = sheet.getCell(1, i).getContents().trim().replace(" ", "");
			String city = sheet.getCell(2, i).getContents().trim().replace(" ", "");
			map.put(loginId, province + city);
			loginIds += "'" + loginId + "',";
			provinces += "'" + province + "',";
			citys += "'" + city + "',";
			list.add(map);
		}
		String loginIdSql = " SELECT id,LOGIN_ID as loginId from pe_manager where LOGIN_ID in ( ";
		loginIdSql += loginIds.substring(0, loginIds.length() - 1);
		loginIdSql += ")";
		zongMap.put("loginIdSql", loginIdSql);
		String provinceSql = " SELECT id,name as province from pe_organ WHERE name IN ( ";
		provinceSql += provinces.substring(0, provinces.length() - 1);
		provinceSql += ") and level='1' ";
		zongMap.put("provinceSql", provinceSql);
		String citySql = " SELECT o2.id AS id, o1. NAME AS province,	o2. NAME AS city FROM 	pe_organ o1 inner JOIN pe_organ o2 ON o1.id = o2.FK_PARENT_ID WHERE o1. NAME IN ( ";
		citySql += provinces.substring(0, provinces.length() - 1);
		citySql += " ) AND o2. NAME IN ( ";
		citySql += citys.substring(0, citys.length() - 1);
		citySql += ") and o1.level='1' and o2.level='2' ";
		zongMap.put("citySql", citySql);
		zongMap.put("list", list);
		return zongMap;
	}

	/**
	 * 查询数据放在map中
	 * @param sql
	 * @param flag
	 */
	public static void selct(String sql, String flag) {
		String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "olcp";
		List list = new ArrayList();
		try {
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String key = "";
				if ("2".equals(flag)) {
					key = rs.getString("province") + rs.getString("city");
				} else if ("1".equals(flag)) {
					key = rs.getString("province");
				} else {
					key = rs.getString("loginId");
				}
				diquMap.put(key, rs.getString("id"));
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
	}

	/**
	 * 批处理进行数据插入
	 * @param sqlList
	 */
	public static void exacuteListSql(List<String> sqlList) {
		String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "olcp";
		try {
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			for (String sql : sqlList) {
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
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

	private static List convertList(ResultSet rs) throws SQLException {
		List list = new ArrayList();
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		while (rs.next()) {
			Map rowData = new HashMap();
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(rowData);
		}
		return list;
	}
}
