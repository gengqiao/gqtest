package com.gq.download;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.gq.mysql.ChangeDB;
/**
 * 从线上直接下载文件，并通过sql处理文件
 * @author 耿桥
 *
 */
public class Download {
	static String imagepath = "I:\\运营项目\\残联平台\\五期班结业\\五期班补考\\image\\";
	static String logpath = "I:\\运营项目\\残联平台\\五期班结业\\五期班补考\\image\\log.txt";
	public static void main(String[] args) {
		Connection conn=	ChangeDB.getLocalConnection();
		String sql=" SELECT jiaopeinum,photoLink from jyzdy_bukao where photoLink is not null  and isdaochu='20171225' ";
		List list=	ChangeDB.getData(conn,sql);
		System.out.println("总共有"+list.size()+"条数据");
		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			String jiaopeinum=(String)map.get("jiaopeinum");
			String photoLink=(String)map.get("photoLink");
			//下面添加服务器的IP地址和端口，以及要下载的文件路径
			String urlPath = "http://www.jyzdy.org"+photoLink;
			//下面代码是下载到本地的位置
			try {
				downloadFile(urlPath,imagepath,jiaopeinum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		System.out.println("=======又一个学期完成了=======");

	}
	
	
	public static void downloadFile(String urlPath, String filePath, String NewName) throws IOException {
		URL theURL = new URL(urlPath);
		File dirFile = new File(filePath);
		if (!dirFile.exists()) {
			// 文件路径不存在时，自动创建目录
			dirFile.mkdir();
		}
		// 从服务器上获取图片并保存
		URLConnection connection = theURL.openConnection();
		String name = theURL.getFile().split("/")[theURL.getFile().split("/").length - 1];
		String weizhui=name.split("\\.")[1];
		String newName = NewName + "." + weizhui;
		HttpURLConnection httpUrlConnection = (HttpURLConnection) connection;
		InputStream in = httpUrlConnection.getInputStream();
		connection.getExpiration();
		int size=httpUrlConnection.getContentLength()/1024;
		System.out.println(newName+"准备写入大小" +size );
		String newPath=filePath + newName;
		Long startTime = System.currentTimeMillis();
		FileOutputStream os = new FileOutputStream(newPath);
		byte[] buffer = new byte[4 * 1024];
		int read;
		while ((read = in.read(buffer)) > 0) {
			os.write(buffer, 0, read);
		}
		Long endTime = System.currentTimeMillis();
		if (endTime - startTime > 300000) {
			writeTxtFile("下载" + newName + "所花时间：" + (endTime - startTime) + System.getProperty("line.separator"), logpath);
		}
		System.out.println("写入成功");
		os.flush();
		os.close();
		in.close();
		if (size > 300) {
			System.out.println("学号为："+newName+"  的照片太大，大小为："+size);
            System.out.println();
            thjnpxOldDownloadImger. reduceImg(newPath, newPath, 390, 567,null);  
		    File srcfile = new File(newPath);  
		    System.out.println("压缩后大小为 ："+srcfile.length()/1024);
		}
		if(!("jpg".equals(weizhui)||"jpeg".equals(weizhui)||"png".equals(weizhui)||"gif".equals(weizhui))){
			System.out.println("学号为："+newName+"  的照片格式不对，格式为："+weizhui);
			thjnpxOldDownloadImger.converter(newPath,"jpeg",filePath+NewName+".jpeg");
		}
		ChangeDB.executeSql("INSERT into thjnpx_jp (loginId,var0) VALUES ('"+NewName+"','true') ");
		
	}
	public static void writeTxtFile(String content, String file) {

		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(file, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeUTF(content);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}