package com.whaty.util;
import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;
/** 
* @className:test.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-11-25
*/
public class SendEmailByQq {
	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		sendEmail("gengqiaode@163.com","新会员通知","cehsi");
	}
	
	
	public static void sendEmail(String email,String title ,String text){
		try {
			Properties props = new Properties();
			// 开启debug调试
			props.setProperty("mail.debug", "true");
			// 发送服务器需要身份验证
			props.setProperty("mail.smtp.auth", "true");
			// 设置邮件服务器主机名
			props.setProperty("mail.host", "smtp.qq.com");
			// 发送邮件协议名称
			props.setProperty("mail.transport.protocol", "smtp");
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
			Session session = Session.getInstance(props);
			Message msg = new MimeMessage(session);
			msg.setSubject(title);
			msg.setText(text);
			//**发送人的邮箱地址**
			msg.setFrom(new InternetAddress("714234516@qq.com"));
			Transport transport = session.getTransport();
			transport.connect("smtp.qq.com", "714234516@qq.com", "frecumtcqdkwbfhf");
			transport.sendMessage(msg, new Address[] { new InternetAddress(email) });
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
