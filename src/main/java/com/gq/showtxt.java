package com.gq;
import java.io.*;

/** 
* @className:showtxt.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-6-17
*/
public class showtxt {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="C:\\Users\\whaty\\Desktop\\13519895839.txt";
		readTxtFile(filePath);
	}
	
	
	 public static void readTxtFile(String filePath){
	        try {
	                String encoding="UTF-8";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt = null;
	                   // lineTxt="\"title\":\"课程总结\",\"courseName\":\"西部地区新能源推广与应用案例\"";
	                    while((lineTxt = bufferedReader.readLine()) != null){
	                    	//lineTxt=lineTxt.replaceAll("\"title\":\".*[0-30]\",\"courseName", "\"title\":\"\",\"courseName");
	                    	lineTxt=lineTxt.replaceAll("\"title\":\".{0,30}\",\"courseName", "\"title\":\"\",\"courseName");
	                    	System.out.println(lineTxt);
	                    }
	                    read.close();
	        }else{
	            System.out.println("找不到指定的文件");
	        }
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	     
	    }
}
