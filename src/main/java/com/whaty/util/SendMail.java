package com.whaty.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendMail { 
     protected javax.mail.Session session = null;
     
//邮件用户名
     String mailUser = "cyrus"; //用户名
     String emailUser = "cyrus@thjnpx.org"; //你通过哪个帐号发送邮件
     String host = "mail.thjnpx.org";     //你通过哪个主机发送邮件
     String pwd = "whaty123";   //你所要通过的帐号的密码是多少，也就是mailUser的密码
     String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    
     String getter = "" ;       //谁接收邮件
     
     public static void sendToStudent(String[] emails){
		SendMail sendMail=new SendMail();
		sendMail.SendMailInit();
		try {
			sendMail.sendToStudent(emails,"中央企业班组长岗位管理能力资格认证网络课堂入学通知书");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sendMail.send("yangwei10@tsinghua.org.cn", content);
		//sendMail.send("gaoyuan@whaty.com", content);
     }
     
     public void sendToStudent(String emails[],String title)throws Exception {
         Message msg = new MimeMessage(session);
         msg.setFrom(new InternetAddress(mailUser)); //设置发送者
         msg.setSentDate(new Date()); //设置发送时间
         msg.setSubject(title);
         Transport transport = session.getTransport("smtp"); //得到发送协议
         transport.connect(host, mailUser, pwd);//与发送者的邮箱相连
         String content="";
         Pattern pattern = Pattern.compile(regex);
 		 for(int i=1;i<emails.length;i++){//i=1为了过滤掉传来的第一个空值
 			String str[] = emails[i].split(";");//把学号和该学员的email分开
 			String s = "";//给id加密
 			content="亲爱的学员:<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！</div><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您参加由国资委和清华大学联合举办的“中央企业班组长岗位管理能力资格认证网络课堂”，请点击下面的链接下载您的入学通知书，并按通知书上的账号及密码登录项目网站：http://www.thbzzpx.org 上线学习。</div>" +
 					"<div><a href='http://www.thbzzpx.org/offer_letter.jsp?id="+s+"' >http://www.thbzzpx.org/recruit/offer_letter.jsp?id="+s+"</a></div><div>(如果您无法点击这个链接，请将此链接复制到浏览器地址栏后访问)</div>" +
 					//"<div>附：<a href='http://www.thbzzpx.local.org:8001/recruit/student_handbook.doc'>学员手册电子版下载地址</a></div>" +
 					"<div>-----------------------------------</div>" +
 					"<div>中央企业班组长岗位管理能力资格认证培训项目组</div>" +
 					"<div>地&nbsp;&nbsp;址：清华大学创新大厦B座7层央企班组长项目组</div>" +
 					"<div>邮&nbsp;&nbsp;编：100084</div>" +
 					"<div>咨询电话：010-62797946 62796154</div>" +
 					"<div>技术支持：400-890-1166</div>" +
 					"<div>传&nbsp;&nbsp;真：010-62789770 </div>" +
 					"<div>E-mail:  thbzzpx@sina.cn</div>";
 			if(!pattern.matcher(str[0]).matches()){
 				continue;
 			}else{
	 			this.getter = str[0];
	 			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(getter));//设置接受者
	 			msg.setContent(content, "text/html;charset=UTF-8");//设置发送主题
	 			transport.send(msg); //发送消息
 			}
 		}
     }
     
  /*   
      * 通过二级单位id批量发送通知
      
     public static String enterSendToStudent(String[] emails){
 		SendMail sendMail=new SendMail();
 		sendMail.SendMailInit();
 		String successEmail = "";
		successEmail = sendMail.enterSendToStudent(emails,"中央企业班组长岗位管理能力资格认证远程培训项目入学通知书");
 		return successEmail;
      }*/
     
    /* public String enterSendToStudent(String emails[],String title){
    	 String successEmail = "";
    	 Hashtable sql_hash = new Hashtable();
    	 int t=1;//标示sql语句
    	 try{
	         Message msg = new MimeMessage(session);
	         msg.setFrom(new InternetAddress(emailUser)); //设置发送者
	         msg.setSentDate(new Date()); //设置发送时间
	         msg.setSubject(title);
	         Transport transport = session.getTransport("smtp"); //得到发送协议
	         transport.connect(host, mailUser, pwd);//与发送者的邮箱相连
	  		 String content="";
	  		 Pattern pattern = Pattern.compile(regex);
	  		 for(int i=1;i<emails.length;i++){//i=1为了过滤掉传来的第一个空值
	  			String str[] = emails[i].split(";");//把学号和该学员的email分开
	  			//System.out.println("---"+emails[i]);
	  			String s = JavaDES.encrypt(str[1]);//给id加密
	  			content="亲爱的学员:<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！</div><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您参加由国资委和清华大学联合举办的“中央企业班组长岗位管理能力资格认证网络课堂”，请点击下面的链接下载您的入学通知书，并按通知书上的账号及密码登录项目网站：http://www.thbzzpx.org 上线学习。</div>" +
	  					"<div><a href='http://www.thbzzpx.org/recruit/offer_letter.jsp?id="+s+"' >http://www.thbzzpx.org/recruit/offer_letter.jsp?id="+s+"</a></div><div>(如果您无法点击这个链接，请将此链接复制到浏览器地址栏后访问)</div>" +
	  					//"<div>附：<a href='http://www.thbzzpx.local.org:8001f/recruit/student_handbook.doc'>学员手册电子版下载地址</a></div>" +
	  					"<div>-----------------------------------</div>" +
	  					"<div>中央企业班组长岗位管理能力资格认证培训项目组</div>" +
	  					"<div>地&nbsp;&nbsp;址：清华大学创新大厦B座7层央企班组长项目组</div>" +
	  					"<div>邮&nbsp;&nbsp;编：100084</div>" +
	 					"<div>咨询电话：010-62797946 62796154</div>" +
	 					"<div>技术支持：400-890-1166</div>" +
	 					"<div>传&nbsp;&nbsp;真：010-62789770 </div>" +
	 					"<div>E-mail:  thbzzpx@sina.cn</div>";
	  			if(!pattern.matcher(str[0]).matches()){
	 				continue;
	 			}else{
		 			this.getter = str[0];
		 			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(getter));//设置接受者
		 			msg.setContent(content, "text/html;charset=UTF-8");//设置发送主题
		 			transport.send(msg); //发送消息
		 			successEmail = successEmail+","+str[1];
		 			String sql = "update pe_bzz_recruit set is_send_email = '1' where id = '" + str[1] + "'";
		 			sql_hash.put(new Integer(t), sql);
		 			t++;
		 			//System.out.println("----sql---:"+sql);
	 			}
	 		 }
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 return successEmail;
    	 }
     }
     */
     public static void sendOne(String email){
 		SendMail sendMail=new SendMail();
 		sendMail.SendMailInit();
 		String str[] = email.split(";");//把id和该管理员的email分开
 		String s = "";//给id加密
 		String content="亲爱的管理员:<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！</div><div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎贵企业参加由国资委和清华大学联合举办的“中央企业班组长岗位管理能力资格认证远程培训项目”，请点击下面的链接下载您所在单位学员的学习账号及密码，并发放给对应学员。</div>" +
 				"<div><a href='http://www.thbzzpx.org/recruit/apply_excel.jsp?id="+s+"' >http://www.thbzzpx.org/recruit/apply_excel.jsp?id="+s+"</a></div><div>(如果您无法点击这个链接，请将此链接复制到浏览器地址栏后访问)</div>" +
 				//"<div>附：<a href='http://www.jyzdy.org/recruit/student_handbook.doc'>学员手册电子版下载地址</a></div>" +
				"<div>-----------------------------------</div>" +
				"<div>中央企业班组长岗位管理能力资格认证培训项目组</div>" +
				"<div>地&nbsp;&nbsp;址：清华大学创新大厦B座7层央企班组长项目组</div>" +
				"<div>邮&nbsp;&nbsp;编：100084</div>" +
				"<div>咨询电话：010-62797946 62796154</div>" +
				"<div>技术支持：400-890-1166</div>" +
				"<div>传&nbsp;&nbsp;真：010-62789770 </div>" +
				"<div>E-mail:  thbzzpx@sina.cn</div>";
 		sendMail.getter = str[0];
 		try {
 			sendMail.send(sendMail.getter, content,"中央企业班组长岗位管理能力资格认证网络课堂学习账号及密码");
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     
   public static void main(String[] args) {
	   SendMail sendMail =new SendMail();
	   sendMail.SendMailInit();
	   try {
		sendMail.send("gengqiao@whaty.com","zouyige","kankan");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
     
     public static void sendMailForPwd(String name,String email,String endDate,String verifyStr,String random){
    	SendMail sendMail=new SendMail();
  		sendMail.SendMailInit();
  		String s = "";//给id加密
  		StringBuffer sb = new StringBuffer("");
		sb.append("<p>亲爱的用户" + name + "：您好！</p>");
		sb.append("<div>");
		sb.append("<p>	   您收到这封这封电子邮件是因为您 (也可能是某人冒充您的名义) 申请了一个新的密码。</p>");
		sb.append("<p>假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。</p>");
		sb.append("<p>要使用新的密码, 请使用以下链接启用密码。</p>");
		sb.append("<a href='http://www.thbzzpx.org/verifypwd/verifypwd_checkMail.action?verifyStr=" + s + "&random="+random+"' target='_blank'>");
		sb.append("http://www.thbzzpx.org/verifypwd/verifypwd_checkMail.action?verifyStr=" + s + "&random="+random+"</a><br/>");
		sb.append("(如果无法点击该URL链接地址，请将它复制并粘帖到浏览器的地址输入框，然后单击回车即可。该链接使用后将立即失效。)");
		sb.append("<div style='font-weight:bold;color:red;'>注意:请您在收到邮件24小时内(" + endDate + "前)使用，否则该链接将会失效。</div>");
		sb.append("</div>");
		String content = sb.toString();
  		sendMail.getter = email;
  		try {
  			sendMail.send(sendMail.getter, content,"残联密码找回(系统邮件，请勿回复）");
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
     }
     
     public void SendMailInit() {
         Properties props = new Properties();          //先声明一个配置文件以便存储信息
         props.put("mail.transport.protocol", "smtp"); //首先说明邮件的传输协议
         props.put("mail.smtp.host", host);            //说明发送邮件的主机地址
         props.put("mail.smtp.auth", "true");          //说明发送邮件是否需要验证，表示自己的主机发送是需要验证的
         props.put("mail.smpt.port", "25");            //说明邮件发送的端口号
   
         //session认证 getInstance()
         session = javax.mail.Session.getInstance(props,new Authenticator(){
        	 public PasswordAuthentication getPasswordAuthentication() {
        		 return new PasswordAuthentication(mailUser,pwd);
        	 }
         });

         //这个是跟踪后台消息。打印在控制台
         session.setDebug(true);
     }
     public void send(String to,String content,String title)throws Exception {
         
         this.getter = to;
         Message msg = new MimeMessage(session);
         //设置发送者
         msg.setFrom(new InternetAddress(mailUser)); 
         //设置接受者
         msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(getter));
         //设置发送时间
         msg.setSentDate(new Date()); 
         //设置内容的基本机制，字体等
         String htmltext=content; 
         msg.setContent(htmltext, "text/html;charset=UTF-8"); 
         //设置发送主题
         msg.setSubject(title);
         
         Transport transport = session.getTransport("smtp"); //得到发送协议
         transport.connect(host, mailUser, pwd);//与发送者的邮箱相连
         transport.send(msg); //发送消息
             
     }
     
 	private static MimeBodyPart createAttachment(String string) throws MessagingException {
 		
 		MimeBodyPart attchBodyPart=new MimeBodyPart();
 		FileDataSource fds=new FileDataSource(string);
 		attchBodyPart.setDataHandler(new DataHandler(fds));
 		//是JAF中的一个类，当MimeBodyPart生成具体的MIME消息时，就会调用DataHandler对象对数据进行处理，获取所需的数据信息。
 		attchBodyPart.setFileName(fds.getName());
 		return attchBodyPart;
 		
 	}
     
 	private static MimeBodyPart createContent(String data, String string) throws MessagingException {
 		
 		MimeBodyPart contentPart=new MimeBodyPart();
 		MimeMultipart contentmultipart=new MimeMultipart("related");
 		MimeBodyPart htmlBodyPart=new MimeBodyPart();
 		htmlBodyPart.setContent(data, "text/html;charset=gb2312");
 		contentmultipart.addBodyPart(htmlBodyPart);
 		
 		MimeBodyPart gifBodyPart=new MimeBodyPart();
 		FileDataSource fds=new FileDataSource(string);
 		gifBodyPart.setDataHandler(new DataHandler(fds));
 		gifBodyPart.setContentID("123.jpg");
 		contentmultipart.addBodyPart(gifBodyPart);
 		contentPart.setContent(contentmultipart);	
 		return contentPart;
 		
 	}
     
}
