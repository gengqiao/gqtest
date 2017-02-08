package com.gq.mysql;  
import com.jcraft.jsch.JSch;  
import com.jcraft.jsch.Session;  
import java.sql.*;  
/**
 *jdbc使用SSH隧道连接mysql数据库demo
 * @author gengqiao
 *可以运用和这个小程序直连数据库。处理数据
 */
public class ChangeDB {  
	static int lport = 3307;//本地端口  
    static String host = "192.168.148.244";//远程MySQL服务器  
    static int rport = 3306;//远程MySQL服务端口 
    public static void go() {  
        try {  
            JSch jsch = new JSch();  
            Session session = jsch.getSession("readonly", "210.14.140.85", 22); // 端口账号 
            session.setPassword("v1Riz8hTex");  
            session.setConfig("StrictHostKeyChecking", "no");  
            session.connect();  
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息  
            int assinged_port=  session.setPortForwardingL(lport, host, rport);//端口映射 转发
            System.out.println("localhost:" + assinged_port);  //端口映射 转发
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
       // Connection conn2 = null;  
        try{  
            System.out.println("=============");  
            go();  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:"+lport+"/webtrn", "webtrn", "N8RWrda3"); 
            System.out.println("--------------");
            getData(conn);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
    private static void getData(Connection conn) throws SQLException {  
        // 获取所有表名  
        Statement statement = conn.createStatement();  
        ResultSet resultSet = statement.executeQuery("select * from enum_const");  
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