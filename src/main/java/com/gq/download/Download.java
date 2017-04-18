package com.gq.download;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
	public static void main(String[] args) {
		Connection conn=	ChangeDB.go("jyzdy", "", "125.208.27.156", 3307, "192.168.148.18", 13304, "zgcl", "zgcl", "");
		String sql="SELECT\n" +
				"	ec.name,es.articlepath\n" +
				"FROM\n" +
				"	pe_bzz_examscore es,\n" +
				"	pe_bzz_student s,\n" +
				"	pe_enterprise e,\n" +
				"	enum_const ec\n" +
				"WHERE\n" +
				"	es.STUDENT_ID = s.id\n" +
				"AND s.FK_ENTERPRISE_ID = e.id\n" +
				"AND s.shengFen = ec.id\n" +
				"and es.fk_exam_batch_id='ff8080813885271601388b3bfe731752'\n" +
				"and es.TOTAL_SCORE>=90";
		List list=	ChangeDB.getData(conn,sql);
		System.out.println("总共有"+list.size()+"条数据");
		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			String name=(String)map.get("NAME");
			String articlepath=(String)map.get("articlepath");
			//articlepath=articlepath.replaceAll("2014-4", "2014-4_1");
			//下面添加服务器的IP地址和端口，以及要下载的文件路径
			String urlPath = "http://www.jyzdy.org"+articlepath;
			//下面代码是下载到本地的位置
			String filePath = "E:\\一些项目记录\\残联\\统计数据\\五个学期的优秀论文\\一期班优秀学员论文\\"+name+"";
			System.out.println("正在准备下载第"+i+"条数据；省份的名字是"+name);
			try{
				URL url = new URL(urlPath);
				//downloadFile(url, filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("=======又一个学期完成了=======");

	}

	public static void downloadFile(String urlPath, String filePath) throws IOException {
		URL theURL = new URL(urlPath);
		File dirFile = new File(filePath);
		if (!dirFile.exists()) {
			//文件路径不存在时，自动创建目录
			dirFile.mkdir();
		}
		//从服务器上获取图片并保存
		URLConnection connection = theURL.openConnection();
		String name = theURL.getFile().split("/")[theURL.getFile().split("/").length - 1];
		InputStream in = connection.getInputStream();
		System.out.println("准备写入");
		FileOutputStream os = new FileOutputStream(filePath + "\\" + name);
		byte[] buffer = new byte[4 * 1024];
		int read;
		while ((read = in.read(buffer)) > 0) {
			os.write(buffer, 0, read);
		}
		System.out.println("写入成功");
		os.close();
		in.close();
	}
	
	

}