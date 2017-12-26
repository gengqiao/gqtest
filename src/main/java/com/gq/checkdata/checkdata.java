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
import java.math.BigDecimal;
import java.sql.*; 
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gq.mysql.ChangeDB;


/**
 * 妇联查询学员的学习时间
 * @author gq
 */
public class checkdata {

	/**
	 * @param args
	 * @return [返回类型说明]
	 * @exception/throws [违例类型] [违例说明]
	 */
	public static void main(String[] args) {
		Connection learnConnection=	ChangeDB.go("readonly", "hcDJGWqUKA", "210.14.140.85", 3307, "192.168.148.119", 3306, "learning_space_1_zhw", "tylearning_user", "S4XwPbzWQDfq", true); ;
		Connection webrnConnection=	ChangeDB.go("readonly", "hcDJGWqUKA", "210.14.140.85", 3308, "192.168.148.244", 3306, "webtrn", "whatysns", "lg2qf4kx", true); ;

		String sql="SELECT\n" +
	    		"	e.id,\n" +
	    		"	(\n" +
	    		"		SELECT\n" +
	    		"			count(*)\n" +
	    		"		FROM\n" +
	    		"			scorm_course_info info,\n" +
	    		"			scorm_course_item item\n" +
	    		"		WHERE\n" +
	    		"			c.ID = info.FK_COURSE_ID\n" +
	    		"		AND item.FK_SCORM_COURSE_ID = info.ID\n" +
	    		"		AND item.wareType IN ('video', 'jz')\n" +
	    		"	) total,\n" +
	    		"	(\n" +
	    		"		SELECT\n" +
	    		"			count(*)\n" +
	    		"		FROM\n" +
	    		"			scorm_stu_sco sco\n" +
	    		"		WHERE\n" +
	    		"			sco.FK_COURSE_ID = c.ID\n" +
	    		"		AND sco.STUDENT_ID = s.fk_sso_user_id\n" +
	    		"		AND sco. STATUS = 'completed'\n" +
	    		"		AND SYSTEM_ID IN (\n" +
	    		"			SELECT\n" +
	    		"				item1.id\n" +
	    		"			FROM\n" +
	    		"				scorm_course_info info1,\n" +
	    		"				scorm_course_item item1\n" +
	    		"			WHERE\n" +
	    		"				c.ID = info1.FK_COURSE_ID\n" +
	    		"			AND item1.FK_SCORM_COURSE_ID = info1.ID\n" +
	    		"			AND item1.type IN ('video', 'sco')\n" +
	    		"		)\n" +
	    		"	) finish,\n" +
	    		"	(\n" +
	    		"		SELECT\n" +
	    		"			TOTAL_TIME\n" +
	    		"		FROM\n" +
	    		"			scorm_stu_course ssc\n" +
	    		"		WHERE\n" +
	    		"			ssc.STUDENT_ID = s.FK_SSO_USER_ID\n" +
	    		"		AND ssc.FK_COURSE_ID = c.id and ssc.FK_SITE_ID='thjfpx'\n" +
	    		"    GROUP BY ssc.STUDENT_ID,ssc.FK_COURSE_ID\n" +
	    		"	) totaltime\n" +
	    		"FROM\n" +
	    		"	pr_tch_stu_elective e,\n" +
	    		"	pe_tch_course c,\n" +
	    		"	pe_student s\n" +
	    		"WHERE\n" +
	    		"	e.FK_COURSE_ID = c.ID\n" +
	    		"AND e.fk_stu_id = s.id\n" +
	    		"AND s.SITE_CODE = 'thjfpx'\n" +
	    		"AND s.LOGIN_ID IN (\n" +
	    		"	'13080750742',\n" +
	    		"	'13361831619',\n" +
	    		"	'13520106953',\n" +
	    		"	'13520173831',\n" +
	    		"	'13521871403',\n" +
	    		"	'13683156808',\n" +
	    		"	'13683653230',\n" +
	    		"	'13771559890',\n" +
	    		"	'13791365896',\n" +
	    		"	'13793577771',\n" +
	    		"	'13858222562',\n" +
	    		"	'13871332218',\n" +
	    		"	'13880772565',\n" +
	    		"	'13903163868',\n" +
	    		"	'13915240378',\n" +
	    		"	'13915919688',\n" +
	    		"	'13934740089',\n" +
	    		"	'13937277777',\n" +
	    		"	'13951412583',\n" +
	    		"	'13955327577',\n" +
	    		"	'13965155363',\n" +
	    		"	'13984023455',\n" +
	    		"	'13992935585',\n" +
	    		"	'13993496682',\n" +
	    		"	'13993902285',\n" +
	    		"	'13998235457',\n" +
	    		"	'15010145649',\n" +
	    		"	'15103720065',\n" +
	    		"	'15201033954',\n" +
	    		"	'15210779810',\n" +
	    		"	'15248119795',\n" +
	    		"	'15313380324',\n" +
	    		"	'15379222636',\n" +
	    		"	'15527379695',\n" +
	    		"	'15603728799',\n" +
	    		"	'15611562508',\n" +
	    		"	'15690739966',\n" +
	    		"	'15701291310',\n" +
	    		"	'15885100133',\n" +
	    		"	'15888389220',\n" +
	    		"	'15904944229',\n" +
	    		"	'17712351349',\n" +
	    		"	'18109227720',\n" +
	    		"	'18152499922',\n" +
	    		"	'18201499584',\n" +
	    		"	'18201617343',\n" +
	    		"	'18211159445',\n" +
	    		"	'18211161043',\n" +
	    		"	'18377296913',\n" +
	    		"	'18600922227',\n" +
	    		"	'18609635810',\n" +
	    		"	'18610309957',\n" +
	    		"	'18642300127',\n" +
	    		"	'18805473376',\n" +
	    		"	'18839366288',\n" +
	    		"	'18946103550',\n" +
	    		"	'18950089098'\n" +
	    		")\n" +
	    		"GROUP BY\n" +
	    		"	e.id order by s.LOGIN_ID ,e.id";
	    List<Map<String,String>>  list =ChangeDB.getData(learnConnection, sql);
	     Map<String,String> learnDate=new HashMap<String,String>();
	    for(int i=0;i<list.size();i++){
	    	Map<String,String> map =list.get(i);
	    	String id=map.get("id");
	    	String total=map.get("total");
	    	String finish=map.get("finish");
	    	String totaltime=map.get("totaltime");
	    	if(totaltime!=null&&totaltime!="null"){
		    	String[] ste=totaltime.split(":");
		    	  Double d1=((Double.parseDouble(ste[0])*60d+Double.parseDouble(ste[1]))/45d);
		    	  BigDecimal   b   =   new   BigDecimal(d1);  
		    	  Double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		    	  totaltime=f1.toString();
	    	}else{
	    		totaltime="0";
	    	}  
	    	Double item=0d;
	    	if(!"0".equals(total)){
		        item=(Double.parseDouble(finish)/Double.parseDouble(total));
		        BigDecimal   b   =   new   BigDecimal(item);  
		        item   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 

	    	}
	    	learnDate.put(id,item+"_"+totaltime);
	    	
	   }
	    String webtrnSql="SELECT\n" +
	    		"	pt.LOGIN_ID,pt.TRUE_NAME,pt.WORK_PLACE,pt.ZHIWU,pt.MOBILE,pte.id,ptc.course_time,ec.name\n" +
	    		"FROM\n" +
	    		"	pe_tch_elective pte\n" +
	    		"INNER JOIN pe_open_course poc on pte.FK_OPENCOURSE_ID=poc.id \n" +
	    		"INNER JOIN pe_trainee pt on pte.FK_TRAINEE_ID=pt.id \n" +
	    		"INNER JOIN pe_tch_course ptc on poc.FK_TCH_COURSE=ptc.id INNER JOIN enum_const ec on poc.Flag_CourseAttribute =ec.id  \n" +
	    		"where pte.FK_SITE_ID='ff808081540adfd901540e2ba08a0263'\n" +
	    		"and pt.LOGIN_ID in (\n" +
	    		"'13080750742',\n" +
	    		"'13361831619',\n" +
	    		"'13520106953',\n" +
	    		"'13520173831',\n" +
	    		"'13521871403',\n" +
	    		"'13683156808',\n" +
	    		"'13683653230',\n" +
	    		"'13771559890',\n" +
	    		"'13791365896',\n" +
	    		"'13793577771',\n" +
	    		"'13858222562',\n" +
	    		"'13871332218',\n" +
	    		"'13880772565',\n" +
	    		"'13903163868',\n" +
	    		"'13915240378',\n" +
	    		"'13915919688',\n" +
	    		"'13934740089',\n" +
	    		"'13937277777',\n" +
	    		"'13951412583',\n" +
	    		"'13955327577',\n" +
	    		"'13965155363',\n" +
	    		"'13984023455',\n" +
	    		"'13992935585',\n" +
	    		"'13993496682',\n" +
	    		"'13993902285',\n" +
	    		"'13998235457',\n" +
	    		"'15010145649',\n" +
	    		"'15103720065',\n" +
	    		"'15201033954',\n" +
	    		"'15210779810',\n" +
	    		"'15248119795',\n" +
	    		"'15313380324',\n" +
	    		"'15379222636',\n" +
	    		"'15527379695',\n" +
	    		"'15603728799',\n" +
	    		"'15611562508',\n" +
	    		"'15690739966',\n" +
	    		"'15701291310',\n" +
	    		"'15885100133',\n" +
	    		"'15888389220',\n" +
	    		"'15904944229',\n" +
	    		"'17712351349',\n" +
	    		"'18109227720',\n" +
	    		"'18152499922',\n" +
	    		"'18201499584',\n" +
	    		"'18201617343',\n" +
	    		"'18211159445',\n" +
	    		"'18211161043',\n" +
	    		"'18377296913',\n" +
	    		"'18600922227',\n" +
	    		"'18609635810',\n" +
	    		"'18610309957',\n" +
	    		"'18642300127',\n" +
	    		"'18805473376',\n" +
	    		"'18839366288',\n" +
	    		"'18946103550',\n" +
	    		"'18950089098'\n" +
	    		") ORDER BY pt.LOGIN_ID,pte.id ";
		List<Map<String,String>>  webtrnLsit =ChangeDB.getData(webrnConnection, webtrnSql);
       Double bixiuTime=0d;//必修已完成学时
       Double xuanxiuTime=0d;//选修已完成学时
       int totalTime=0;//总学时
       int bixiuTotalTime=0;//必修课总学时
       int xuanxiuTotlTime=0;//选修课总学时
       Double studyTime=0d; //学习时常
       Double overStudyTime=0d;//已完成学时
       List dataList=new ArrayList();
       
       	String sloginId="";
	   	String strueName="";
	   	String sworkPlace="";
	   	String szhiwu="";
	   	String smobile="";
	   	String sid="";
	   	String scourse_time="";
	   	String sname ="";
       
		for(int i=0;i<webtrnLsit.size();i++){
	    	Map<String,String> map=webtrnLsit.get(i);
	    	String loginId=map.get("login_id");
	    	String trueName=map.get("true_name");
	    	String workPlace=map.get("work_place");
	    	String zhiwu=map.get("zhiwu");
	    	String mobile=map.get("mobile");
	    	String id=map.get("id");
	    	String course_time=map.get("course_time");
	    	String name =map.get("name");
   		    totalTime+=Integer.parseInt(course_time);
	    	String value=learnDate.get(id);
	    	if(StringUtils.isNotEmpty(value)){
	    		String[] v=value.split("_");
    			Double time=Double.parseDouble(v[1]);
    			BigDecimal   b1   =   new   BigDecimal(time);  
    			time   =   b1.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
    			
	    		String item=v[0];
	    		Double overTime=	Integer.parseInt(course_time)*Double.parseDouble(item);
	    		 BigDecimal   b   =   new   BigDecimal(overTime);  
		    	  overTime   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
	    		overStudyTime+=overTime;
	    		studyTime+=time;
	    		if(i==0){
	    			sloginId=loginId;
	    			sloginId=loginId;
	    			 strueName=trueName;
	    		   	 sworkPlace=workPlace;
	    		   	 szhiwu=zhiwu;
	    		   	 smobile=mobile;
	    		   	 sid=id;
	    		   	 sname =name;
	               Object[] data1={"用户名","姓名","工作单位","职务","手机号","总学时","已完成总学时","必修课总学时","必修课已完成学时","选修课总学时","选修课已完成学时","学习时常"};
	               dataList.add(data1);
	               System.out.println(Arrays.toString(data1));
	               if("必修".equals(name)){
		    			bixiuTime+=overTime;
		    			bixiuTotalTime+=Integer.parseInt(course_time);
	    			}else if("选修".equals(name)){
	    				xuanxiuTime+=overTime;
	    				xuanxiuTotlTime+=Integer.parseInt(course_time);
	    			}
	    		} else if(sloginId.equals(loginId)){
	    			if("必修".equals(name)){
		    			bixiuTime+=overTime;
		    			bixiuTotalTime+=Integer.parseInt(course_time);
	    			}else if("选修".equals(name)){
	    				xuanxiuTime+=overTime;
	    				xuanxiuTotlTime+=Integer.parseInt(course_time);
	    			}
	    		}else{

                   Object[] data={sloginId,strueName,sworkPlace,szhiwu,smobile,totalTime-Integer.parseInt(course_time),overStudyTime-overTime,bixiuTotalTime,bixiuTime,xuanxiuTotlTime,xuanxiuTime,studyTime};
                   System.out.println(Arrays.toString(data));
                   dataList.add(data);
                   overStudyTime=overTime;
                   totalTime=Integer.parseInt(course_time);
                   sloginId=loginId;
	    			studyTime=time;
	    			
	    			 strueName=trueName;
	    		   	 sworkPlace=workPlace;
	    		   	 szhiwu=zhiwu;
	    		   	 smobile=mobile;
	    		   	 sid=id;
	    		   	 scourse_time=course_time;
	    		   	 sname =name;
	    			
	    			if("必修".equals(name)){
	    				bixiuTime=overTime;
		    			bixiuTotalTime=Integer.parseInt(course_time);
		    			xuanxiuTime=0d;
		    			xuanxiuTotlTime=0;
		    			
	    			}else if("选修".equals(name)){
	    				xuanxiuTime=(double) overTime;
		    			xuanxiuTotlTime=Integer.parseInt(course_time);
		    			bixiuTime=0d;
		    			bixiuTotalTime=0;
	    			}
	    		}
	    		
	    	}else{
	    		 Object[] data={sloginId,strueName,sworkPlace,szhiwu,smobile,totalTime-Integer.parseInt(course_time),0,bixiuTotalTime,bixiuTime,xuanxiuTotlTime,xuanxiuTime,studyTime};
                 System.out.println(Arrays.toString(data));
                 dataList.add(data);
	    	}
	    	
		}
	
		
		
		System.out.println("-----------------over---------------------");
		System.exit(0);
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
