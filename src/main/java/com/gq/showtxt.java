package com.gq;
import java.io.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		String filePath="I:\\运营项目\\节能项目\\垃圾回收\\垃圾分类100题.txt";
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
	                    int line=0;
	                    String[] str={"A","B","C","D"};
	                    JSONArray arr=new JSONArray();
	                    JSONObject obj=new JSONObject();
	                    while((lineTxt = bufferedReader.readLine()) != null){
	                    	line=line+1;
                           if((line-2)%6==0){//处理题目行
                        	  String  delte= lineTxt.split("、")[0];
                        	   lineTxt=   lineTxt.substring(delte.length()+1,lineTxt.length())  ;//先去掉题目编号
                        	   arr.add(obj);
                        	   obj=new JSONObject();
                        	   
                            for(int i=0;i<str.length;i++){
                            	if(lineTxt.indexOf(str[i])>-1){
                            		lineTxt=	lineTxt.replace(str[i], "");
                            		obj.put("q", lineTxt);
                            		System.out.println("答案："+str[i]);
                            		obj.put("a", str[i]);
                            	}
                            }
                           }else{
                        	   if((line-1)%6!=0){
                        		 String key=  lineTxt.split("\\.")[0];
                        		 String value=lineTxt.split("\\.")[1];
                        		 obj.put(key, value);
                        		 System.out.println(key+value);
                        	   }
                           }	
	                    	System.out.println(line+lineTxt);
	                    }
	                    read.close();
	                    System.out.println(arr.toString());
	        }else{
	            System.out.println("找不到指定的文件");
	        }
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	     
	    }
}
