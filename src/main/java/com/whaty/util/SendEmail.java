package com.whaty.util;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/** 
 * 163邮箱发邮件
* @className:SendEmail.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-11-25
*/
public class SendEmail {
   
	static String mailUser = "notice@webtrn.cn"; //用户名
	static String pwd = "AjSaNriOD9jQAj9O"; //你所要通过的帐号的密码是多少，也就是mailUser的密码
	static String host = "mail.webtrn.cn";
	private static Session session = null;
	static String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	final static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(20);
	
	public static void main(String[] args) throws NoSuchProviderException {
		String [] sss={"gengqiao@whaty.com"};
		final String title="【清华就业指导员】学习通知";
	   final String content="亲爱的学员：本期班学习时间为2017年7月-2017年1月中下旬，您还未开始学习，请尽快登录项目网站www.jyzdy.org学习。学习须知参见网站通知公告。";
	    Pattern pattern = Pattern.compile(regex);
	    for (int i=0;i<sss.length;i++){
	    	if(!pattern.matcher(sss[i]).matches()){
 				continue;
 			}else{
 				final String email = sss[i];
 				newFixedThreadPool.submit(new Runnable() {
					@Override
					public void run() {
						 send(email, title,content);
					}
				});
	    	
 			}
	    }
	}
/**
 * 邮件调用接口
 * @param email 
 * @param title
 * @param content
 */
	public static  void  send(String email,String title,String content){
		initSession();
		try {
			Transport ts = session.getTransport();
			ts.connect(host, mailUser, pwd);
			//创建邮件对象
			MimeMessage msg = new MimeMessage(session);
			//设置发件人
			try {
				msg.setFrom(new InternetAddress(mailUser,"jyzdy@mail.tsinghua.edu.cn"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//设置收件人
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			msg.setSubject(title);
			msg.setContent(content, "text/html;charset=UTF-8");//设置发送主题
			ts.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//初始化参数
	private static Session initSession() {
		Properties prop = new Properties();
		prop.put("mail.host", host);
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smpt.port", "25");
		session = Session.getInstance(prop, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailUser, pwd);
			}
		});
		session.setDebug(true);
		return session;
	}

}
