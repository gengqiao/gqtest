package com.gq;
import java.lang.reflect.Array;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/** 
* @className:sqlcon.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-4-29
*/
public class sqlcon {
	/**
	 * @param args
	 */
/*	List<String> sqllt =new ArrayList<String>();
	static String[] str ={};
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("教育部","0");
		map.put("卫生部","2");
		map.put("工业和信息化部","0");
		map.put("水利部","1");
		map.put("税务总局","0");
		map.put("人民银行","22");
		map.put("国资委","1");
		map.put("海关总署","0");
		map.put("质检总局","4");
		map.put("安监总局","0");
		map.put("地震局","0");
		map.put("其他中央部委及其他事业单位、团体组织","3");
		map.put("工商总局","0");
		map.put("公安部","2");
		map.put("北京市","8");
		map.put("天津市","12");
		map.put("河北省","12");
		map.put("山西省","10");
		map.put("内蒙古自治区","10");
		map.put("辽宁省","21");
		map.put("吉林省","11");
		map.put("黑龙江省","12");
		map.put("上海市","16");
		map.put("江苏省","20");
		map.put("浙江省","3");
		map.put("安徽省","19");
		map.put("福建省","17");
		map.put("江西省","23");
		map.put("山东省","17");
		map.put("河南省","11");
		map.put("湖北省","12");
		map.put("湖南省","7");
		map.put("广东省","22");
		map.put("广西壮族自治区","20");
		map.put("海南省","12");
		map.put("重庆市","17");
		map.put("四川省","13");
		map.put("贵州省","15");
		map.put("云南省","10");
		map.put("西藏自治区","5");
		map.put("陕西省","7");
		map.put("甘肃省","13");
		map.put("青海省","2");
		map.put("宁夏回族自治区","15");
		map.put("新疆维吾尔自治区","19");
		map.put("新疆生产建设兵团","6");

		   String key="新疆生产建设兵团";
			String val=map.get(key);
			if("0".equals(val)){
				val="1";
			}
			int li=Integer.parseInt(val)-1;

			String sql=" select score,name from test1 where name='"+key+"' ORDER BY score desc limit "+li+",1";
		 //  System.out.println(sql);
			aa(sql);
			//System.out.println(sql);
		
		
		System.out.println("完事了=================="+key);
	}*/
   public static void main(String[] args) {
	String sql="select TRUE_NAME from CER_TEST ";
	//String[] str={"s","w"};
	aa(sql);
	}
	public static void aa(String sql) {
		String url = "jdbc:mysql://192.168.20.200:3306/thjnpx?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "z9z7w7w8";
		try {
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String name=rs.getString("TRUE_NAME");
			      if(name.length()==4){
						System.out.println(name);
  
			      }
				
				
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

	public static void bb(String ssqq) {
		String url = "jdbc:mysql://192.168.20.200:3306/thjnpx?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "z9z7w7w8";
		try {
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
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
