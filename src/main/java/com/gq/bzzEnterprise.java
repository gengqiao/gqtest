/*
 * 文件名：bzzEnterprise.java 
 * 描述：〈描述〉
 * 创建人：gq
 * 创建时间：2017年4月19日下午6:29:56
 */
package com.gq;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gq.mysql.ChangeDB;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author gq
 */
public class bzzEnterprise {

	
	private static Map<String,String> getMap(){
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("002","ff8080815b8173af015b85a954eb01d5");
		map.put("003","ff8080815b8173af015b85a954f701d6");
		map.put("005","ff8080815b8173af015b85a9550601d7");
		map.put("007","ff8080815b8173af015b85a9551201d8");
		map.put("009","ff8080815b8173af015b85a9552501d9");
		map.put("010","ff8080815b8173af015b85a9553101da");
		map.put("013","ff8080815b8173af015b85a9553901db");
		map.put("014","ff8080815b8173af015b85a9553e01dc");
		map.put("016","ff8080815b8173af015b85a9554401dd");
		map.put("017","ff8080815b8173af015b85a9554b01de");
		map.put("018","ff8080815b8173af015b85a9555401df");
		map.put("019","ff8080815b8173af015b85a9555f01e0");
		map.put("020","ff8080815b8173af015b85a9556901e1");
		map.put("021","ff8080815b8173af015b85a9556f01e2");
		map.put("023","ff8080815b8173af015b85a9557901e3");
		map.put("024","ff8080815b8173af015b85a9558201e4");
		map.put("026","ff8080815b8173af015b85a9558901e5");
		map.put("029","ff8080815b8173af015b85a9558e01e6");
		map.put("030","ff8080815b8173af015b85a9559401e7");
		map.put("034","ff8080815b8173af015b85a9559b01e8");
		map.put("036","ff8080815b8173af015b85a955a001e9");
		map.put("037","ff8080815b8173af015b85a955a501ea");
		map.put("040","ff8080815b8173af015b85a955ad01eb");
		map.put("041","ff8080815b8173af015b85a955b701ec");
		map.put("042","ff8080815b8173af015b85a955ce01ed");
		map.put("043","ff8080815b8173af015b85a955dd01ee");
		map.put("045","ff8080815b8173af015b85a955e901ef");
		map.put("047","ff8080815b8173af015b85a955f201f0");
		map.put("048","ff8080815b8173af015b85a9560601f1");
		map.put("049","ff8080815b8173af015b85a9561201f2");
		map.put("050","ff8080815b8173af015b85a9561801f3");
		map.put("053","ff8080815b8173af015b85a9562001f4");
		map.put("054","ff8080815b8173af015b85a9562501f5");
		map.put("057","ff8080815b8173af015b85a9562b01f6");
		map.put("058","ff8080815b8173af015b85a9563101f7");
		map.put("059","ff8080815b8173af015b85a9563801f8");
		map.put("061","ff8080815b8173af015b85a9563e01f9");
		map.put("062","ff8080815b8173af015b85a9564801fa");
		map.put("063","ff8080815b8173af015b85a9565301fb");
		map.put("064","ff8080815b8173af015b85a9565f01fc");
		map.put("065","ff8080815b8173af015b85a9567d01fd");
		map.put("068","ff8080815b8173af015b85a9568801fe");
		map.put("069","ff8080815b8173af015b85a9569001ff");
		map.put("070","ff8080815b8173af015b85a9569b0200");
		map.put("071","ff8080815b8173af015b85a956a50201");
		map.put("079","ff8080815b8173af015b85a956ae0202");
		map.put("080","ff8080815b8173af015b85a956b70203");
		map.put("082","ff8080815b8173af015b85a956c40204");
		map.put("086","ff8080815b8173af015b85a956cf0205");
		map.put("088","ff8080815b8173af015b85a956da0206");
		map.put("090","ff8080815b8173af015b85a956e50207");
		map.put("091","ff8080815b8173af015b85a956ed0208");
		map.put("092","ff8080815b8173af015b85a956fa0209");
		map.put("095","ff8080815b8173af015b85a95705020a");
		map.put("096","ff8080815b8173af015b85a9570e020b");
		map.put("097","ff8080815b8173af015b85a95714020c");
		map.put("098","ff8080815b8173af015b85a9571c020d");
		map.put("099","ff8080815b8173af015b85a95722020e");
		map.put("101","ff8080815b8173af015b85a95729020f");
		map.put("102","ff8080815b8173af015b85a957320210");
		map.put("104","ff8080815b8173af015b85a957380211");
		map.put("108","ff8080815b8173af015b85a957400212");
		map.put("110","ff8080815b8173af015b85a9574b0213");
		map.put("111","ff8080815b8173af015b85a957560214");
		map.put("115","ff8080815b8173af015b85a9575d0215");
		map.put("200","ff8080815b8173af015b85a957640216");
		map.put("403","ff8080815b8173af015b85a9576a0217");
		map.put("588","ff8080815b8173af015b85a957710218");
		return map;
	}
	
	
	public static List  init(){
		Connection conn=ChangeDB.go("thbzzpx", "Whaty@!@#456", "114.112.69.156", 1521, "192.168.148.220", 1521, "orcl", "scetraining", "scez9z7w7w8",false);
        String sql="SELECT DISTINCT\n" +
        		"	E . ID, es.code as PRECODE ,\n" +
        		"	E . NAME,\n" +
        		"	E .code ,\n" +
        		"	E .INDUSTRY,\n" +
        		"	E .ADDRESS,\n" +
        		"	E .ZIPCODE,\n" +
        		"	E .FZR_NAME,\n" +
        		"	E .FZR_XB,\n" +
        		"	E .FZR_POSITION,\n" +
        		"	E .FZR_PHONE,\n" +
        		"  e.FZR_MOBILE,\n" +
        		"  e.FZR_EMAIL,\n" +
        		"  e.LXR_NAME,\n" +
        		"  e.LXR_XB,\n" +
        		"  e.LXR_POSITION, \n" +
        		"  e.LXR_PHONE,\n" +
        		"  e.LXR_MOBILE,\n" +
        		"  e.LXR_EMAIL,\n" +
        		"  e.LXR_ADDRESS,\n" +
        		"  e.INFO_SHENG,\n" +
        		"  e.INFO_SHI,\n" +
        		"  e.INFO_JIEDAO,\n" +
        		"  e.receiver_sheng,\n" +
        		" e.RECEIVER_SHI,\n" +
        		" e.receiver_address,\n" +
        		"e.RECEIVER_USERNAME,\n" +
        		" e.RECEIVER_ZIPCODE,\n" +
        		" e.RECEIVER_PHONE,\n" +
        		" e.RECEIVER_MOBILE\n" +
        		"FROM\n" +
        		"	PE_BZZ_STUDENT s,\n" +
        		"	PE_ENTERPRISE E,\n" +
        		"	PE_ENTERPRISE es\n" +
        		"WHERE\n" +
        		"	s.FK_ENTERPRISE_ID = E . ID\n" +
        		"AND E .FK_PARENT_ID = ES. ID\n" +
        		"AND s.FK_BATCH_ID = 'ff80808154bd8f920154bd98eb4f0023' ORDER BY e.CODE";
		List list=  ChangeDB.getData(conn, sql);
		return list;
	}
	public static void main(String[] args) {
		Map<String,String> initmap=getMap();
		List list=init();
		System.out.println("总共有"+list.size()+"条数据");
		StringBuffer sql=new StringBuffer();
		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			String ID=(String)map.get("ID");
			String PRECODE=(String)map.get("PRECODE");
			String NAME=(String)map.get("NAME");
			String CODE=(String)map.get("CODE");
			String INDUSTRY=(String)map.get("INDUSTRY");
			String ADDRESS=(String)map.get("ADDRESS");
			String ZIPCODE=(String)map.get("ZIPCODE");
			String FZR_NAME=(String)map.get("FZR_NAME");
			String FZR_XB=(String)map.get("FZR_XB");
			String FZR_POSITION=(String)map.get("FZR_POSITION");
			String FZR_PHONE=	(String)map.get("FZR_PHONE");
			String FZR_MOBILE=(String)map.get("FZR_MOBILE");
			String FZR_EMAIL=(String)map.get("FZR_EMAIL");
			String LXR_NAME=(String)map.get("LXR_NAME");
			String LXR_XB=(String)map.get("LXR_XB");
			String LXR_POSITION=(String)map.get("LXR_POSITION");
			String LXR_PHONE=(String)map.get("LXR_PHONE");
			String LXR_MOBILE=(String)map.get("LXR_MOBILE");
			String LXR_EMAIL=(String)map.get("LXR_EMAIL");
			String LXR_ADDRESS=(String)map.get("LXR_ADDRESS");
			String INFO_SHENG=(String)map.get("INFO_SHENG");
			String INFO_SHI=(String)map.get("INFO_SHI");
			String INFO_JIEDAO=(String)map.get("INFO_JIEDAO");
			String RECEIVER_SHENG=(String)map.get("RECEIVER_SHENG");
			String RECEIVER_SHI=(String)map.get("RECEIVER_SHI");
			String RECEIVER_ADDRESS=(String)map.get("RECEIVER_ADDRESS");
			String RECEIVER_USERNAME=(String)map.get("RECEIVER_USERNAME");
			String RECEIVER_ZIPCODE=(String)map.get("RECEIVER_ZIPCODE");
			String RECEIVER_PHONE=(String)map.get("RECEIVER_PHONE");
			String RECEIVER_MOBILE=(String)map.get("RECEIVER_MOBILE");
			RECEIVER_SHENG=RECEIVER_SHENG+"省";
			RECEIVER_SHI=RECEIVER_SHI+"市";
			String receiverAddress=fixShengShi(RECEIVER_SHENG,RECEIVER_SHI)+RECEIVER_ADDRESS;
 			sql.append(" INSERT INTO `webtrn`.`pe_organ` ( `Id`,`name`,`code`,`address`,`zip`,`principalName`,`principalEmail`,`fk_site_id`,`FK_PARENT_ID`, ");
            sql.append(" `level`,`INFO_SHENG`,`INFO_SHI`,`industry`,`info_jiedao`,`receiverUsername`,`RECEIVER_MOBILE`,`receiverPhone`, ");
            sql.append(" 	`receiverAddress`,`principalGender`,`principalPosition`,`principalPhone`,`principalMobile`,`lxrName`,`lxrXb`,`lxrPosition`,`lxrPhone`,`lxrMobile`,`lxrEmail`,`lxrAddress`,`lft`,`rgt`)VALUES( ");
            sql.append("'"+ID+"','"+NAME+"','"+CODE+"','"+ADDRESS+"','"+ZIPCODE+"','"+FZR_NAME+"','"+FZR_EMAIL+"', ");
            sql.append("'ff808081596ef8bf01597307895f0ab3','"+initmap.get(PRECODE)+"','2','"+INFO_SHENG+"','"+INFO_SHI+"','"+INDUSTRY+"','"+INFO_JIEDAO+"',");
            sql.append(" '"+RECEIVER_USERNAME+"','"+RECEIVER_MOBILE+"','"+RECEIVER_PHONE+"','"+receiverAddress+"','"+FZR_XB+"','"+FZR_POSITION+"', ");
            sql.append("'"+FZR_PHONE+"' ,'"+FZR_MOBILE+"','"+LXR_NAME+"','"+LXR_XB+"','"+LXR_POSITION+"','"+LXR_PHONE+"' ,'"+LXR_MOBILE+"','"+LXR_EMAIL+"','"+LXR_ADDRESS+"','0','2');");
            sql.append(System.getProperty("line.separator"));
		}
		File outfile=new File("F:\\插入.sql");
		String sql1=sql.toString();
		sql1=sql1.replaceAll("'null'", "null");
		try {
			writeTxtFile(sql1,outfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
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
	
	
	public static   String fixShengShi(String sheng, String shi) {
		
		if(sheng == null || sheng.equals("null") || sheng.equals(""))
			sheng = "";
		if(sheng.equals("null省")) {
			sheng = "";
		}
		
		if(shi == null || shi.equals("null") || shi.equals(""))
			shi = "";
		if(shi.equals("null市")) {
			shi = "";
		} else if(shi.endsWith("市市")) {
			shi = shi.substring(0,shi.length()-1);
		}
		//北京，天津，上海，重庆
		if(sheng.equals("北京省")) {
			sheng = "";
			shi = "北京市";
		} else if(sheng.equals("天津省")) {
			sheng = "";
			shi = "天津市";
		} else if(sheng.equals("上海省")) {
			sheng = "";
			shi = "上海市";
		} else if(sheng.equals("重庆省")) {
			sheng = "";
			shi = "重庆市";
		}else if (sheng.equals("新疆省")||sheng.equals("新疆维吾尔族自治区省")){
			sheng="新疆维吾尔族自治区";
		}else if (sheng.equals("宁夏省")||sheng.equals("宁夏回族自治区省")){
			sheng="宁夏回族自治区";
		}else if (sheng.equals("西藏省")||sheng.equals("西藏自自治区省")){
			sheng="西藏自自治区";
		}else if (sheng.equals("内蒙省")||sheng.equals("内蒙古自治区省")){
			sheng="内蒙古自治区";
		}else if (sheng.equals("广西省")||sheng.equals("广西壮族自治区省")){
			sheng="广西壮族自治区";
		}
		return sheng + " " + shi;
		
	}

}
