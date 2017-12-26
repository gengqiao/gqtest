/*
 * 文件名：checkdata.java 
 * 描述：〈描述〉
 * 创建人：gq
 * 创建时间：2017年6月8日下午6:51:19
 */
package com.gq.checkdata;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;

import com.gq.mysql.ChangeDB;


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author gq
 */
public class checkExamdata {

	/**
	 * 〈一句话功能简述〉
	 * 〈功能详细描述〉
	 *
	 * @param args
	 * @return [返回类型说明]
	 * @exception/throws [违例类型] [违例说明]
	 */
	public static void main(String[] args) {
	    String webtrnSql="SELECT\n" +
	    		"	pt.LOGIN_ID,per.exam_code,pes.SCORE,pes.id \n" +
	    		"FROM\n" +
	    		"	pe_exam_score pes\n" +
	    		"INNER JOIN pe_exam_room per ON pes.FK_EXAMROOM_ID = per.id\n" +
	    		"INNER JOIN pe_trainee pt on pes.FK_TRAINEE_ID=pt.id  where pes.FLAG_ATTENDEXAM='99fff8146acf11e7be3e001e679d0a23' ";
	    
		Connection conn1=	ChangeDB.go("readonly", "hcDJGWqUKA", "210.14.140.85", 3308, "192.168.148.244", 3306, "webtrn", "whatysns", "lg2qf4kx", true); ;
		List<Map<String,String>>  webtrnLsit =ChangeDB.getData(conn1, webtrnSql);
		HashMap<String, String> exclemap=batchUpload(new File("C://Users//Administrator//Desktop//MouseWithoutBorders//thjnpx_score.xls"));
		for (Map<String,String> map:webtrnLsit){
    	    String loginId=map.get("LOGIN_ID");
    	    String examCode=map.get("exam_code");
    	    String scoreString=map.get("score");
    	    String id =map.get("id");
    	    String key=loginId+"_"+examCode;
    	    String score=  exclemap.get(key);
    	try {
     
    		if(StringUtils.isNotEmpty(score)){
    			exclemap.remove(key);
    		}
    		
		} catch (Exception e) {
			System.out.println("score:"+score);
		}
    	 
    	    
       }
		for (String s:exclemap.keySet()){
			
			System.out.println(s+"_"+exclemap.get(s));
			
			
		}
		
	    System.out.println(webtrnLsit.size());
	}
	
	public static HashMap<String, String> batchUpload(File file) {
		Workbook work = null;
		try {
			work = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet = work.getSheet(0);
		int rows = sheet.getRows(); // 获取Excel表格的行数
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i < rows; i++) {
			String key = sheet.getCell(0, i).getContents().trim().replace(" ", "")+"_"+sheet.getCell(1, i).getContents().trim().replace(" ", "");
			String value = sheet.getCell(2, i).getContents().trim().replace(" ", "");
			map.put(key,value);
		}
		return map;
	}
	
	public static void writeTxtFile(String content,File file) throws IOException{
		if(!file.exists()){
			file.createNewFile();
		}
		 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		 writer.write(content);
		 writer.close();
		 System.out.println("-------------over-----------------");
		
		
		
	}
	
}
