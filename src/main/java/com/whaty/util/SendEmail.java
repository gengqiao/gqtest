package com.whaty.util;
import java.util.Properties;
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
   
	static String mailUser = "cyrus@thjnpx.org"; //用户名
	static String pwd = "whaty123"; //你所要通过的帐号的密码是多少，也就是mailUser的密码
	static String host = "mail.thjnpx.org";
	//此邮箱的密码是anyi001
	private static Session session = null;
	public static void main(String[] args) throws NoSuchProviderException {
		String[] email={
	    		
	    		"HD8653@QQ.COM",
	    		"51254085@qq.com",
	    		"99798653@qq.com",
	    		"644694384@qq.com",
	    		"460775605@qq.com",
	    		"zchcz5268242@163.com",
	    		"930298982@qq.com",
	    		"13963417521@163.com",
	    		"361952716@qq.com",
	    		"251520907@qq.com",
	    		"yieryi75120@sina.com",
	    		"76890161@qq.com",
	    		"275280722@qq.com",
	    		"zchcz5268242@163.com",
	    		"350522685@qq.com",
	    		"27581576@qq.com",
	    		"1538795184@qq.com",
	    		"2579065746@qq.com",
	    		"luckzk@139.com",
	    		"zxlaist@163.com",
	    		"jy0303791031@163.com",
	    		"315047847@qq.com",
	    		"198116762@qq.com",
	    		"1401208930@qq.com",
	    		"76240779@qq.com",
	    		"3893790@qq.com",
	    		"maming82625@126.com",
	    		"l346949715@sina.com",
	    		"287677824@qq.com",
	    		"310150233@qq.com",
	    		"517580351@qq.com",
	    		"mulin5138@163.com",
	    		"119478969@qq.com",
	    		"790573039@qq.com",
	    		"miaony2006@163.com",
	    		"mzxmax@163.com",
	    		"zhaoshuai_08@126.com",
	    		"13589060923@163.com",
	    		"qidong82746589@163.com",
	    		"82724907@qq.com",
	    		"445648650@qq.com",
	    		"34742576@qq.com",
	    		"690597950@qq.com",
	    		"110409159@qq.com",
	    		"1602101910@qq.com",
	    		"1363916587@qq.com",
	    		"280514786@qq.com",
	    		"41506948@qq.com",
	    		"504755990@qq.com",
	    		"861662990@qq.com",
	    		"261454382@qq.com",
	    		"330551775@qq.com",
	    		"826707370@qq.com",
	    		"1449890369@qq.com",
	    		"331463213@qq.com",
	    		"1085206360@qq.com",
	    		"time0s0pace@163.com",
	    		"1071129977@qq.com",
	    		"86296984@qq.com",
	    		"2627036152@qq.com",
	    		"80566178@qq.com",
	    		"1753715221@qq.com",
	    		"465628492@qq.com",
	    		"654606651@qq.com",
	    		"294371983@qq.com",
	    		"123861951@qq.com",
	    		"325606321@qq.com",
	    		"278541335@qq.com",
	    		"457785024@qq.com",
	    		"609342387@qq.com",
	    		"570771095@qq.com",
	    		"309773579@qq.com",
	    		"3224734585@qq.com",
	    		"75345985@qq.com",
	    		"2296330425@qq.com",
	    		"530769728@qq.com",
	    		"18705319596@qq.com",
	    		"53288660@qq.com",
	    		"27204816@qq.com",
	    		"641896019@qq.com",
	    		"1101132713@qq.com",
	    		"1049353916@qq.com",
	    		"597010983@qq.com",
	    		"523996741@qq.com",
	    		"13730931051@163.com",
	    		"835068952@qq.com",
	    		"41481725@qq.com",
	    		"77246827@qq.com",
	    		"1473456276@qq.com",
	    		"757856876@qq.com",
	    		"262782416@qq.com",
	    		"hgsryx@126.com",
	    		"49808699@qq.com",
	    		"ziliner16@163.com",
	    		"79481685@qq.com",
	    		"113867269@qq.com",
	    		"625436447@qq.com",
	    		"2753221115@qq.com",
	    		"721502360@qq.com",
	    		"1104506190@qq.com",
	    		"1634735343@qq.com",
	    		"329968920@qq.com",
	    		"86893984@qq.com",
	    		"81514955@qq.com",
	    		"275514487@qq.com",
	    		"346874913@qq.com",
	    		"kangtaoxin@163.com",
	    		"15866391107@163.com",
	    		"mmx8136@163.com",
	    		"cc-aiwosuoai@163.com",
	    		"zhaohaitao4342@vip.qq.com",
	    		"270458981@qq.com",
	    		"498779084@qq.com",
	    		"fzjiangyuan@126.com",
	    		"779354371@qq.com",
	    		"648159924@qq.com",
	    		"yyiill123@163.com",
	    		"372215772@qq.com",
	    		"huang84517@163.com",
	    		"1124379302@qq.com",
	    		"472279104@qq.com",
	    		"29237294@qq.com",
	    		"591215300@qq.com",
	    		"14908918@qq.com",
	    		"15348925@qq.com",
	    		"765186799@qq.com",
	    		"765186799@qq.com",
	    		"www.dcswa@163.com",
	    		"65750738@qq.com",
	    		"413602493@qq.com",
	    		"43382273@qq.com",
	    		"7128546@sina.com",
	    		"375839674@qq.com",
	    		"395981600@qq.com",
	    		"442668898@qq.com",
	    		"438015340@qq.com",
	    		"460099957@qq.com",
	    		"240215682@qq.com",
	    		"502087336@126.com",
	    		"450489095@qq.com",
	    		"15738215@qq.com",
	    		"313503385@qq.com",
	    		"810200811@qq.com",
	    		"603415557@qq.com",
	    		"618657117@qq.com",
	    		"415749810@qq.com",
	    		"125656369@qq.com",
	    		"852035556@qq.com",
	    		"670334529@qq.com",
	    		"734299163@qq.com",
	    		"249777640@qq.com",
	    		"451895044@qq.com",
	    		"1962948082@qq.com",
	    		"410033982@qq.com",
	    		"yangyuxing312@163.com",
	    		"95702489@qq.com",
	    		"1078248274@qq.com",
	    		"herodyg@163.com",
	    		"1020595232@qq.com",
	    		"2460628929@qq.com",
	    		"76216398@qq.com",
	    		"171501415@qq.com",
	    		"jixiang_357407171@q",
	    		"1191431418@qq.com",
	    		"76127980@qq.com",
	    		"375097111@qq.com",
	    		"253261615@qq.com",
	    		"670719073@qq.com",
	    		"407907452@qq.com",
	    		"453962527@qq.com",
	    		"329235927@qq.com",
	    		"932850903@qq.com",
	    		"1062839157@qq.com",
	    		"316434997@qq.com",
	    		"472403193@qq.com",
	    		"276533056@qq.com",
	    		"1164553185@qq.com",
	    		"958746071@qq.com",
	    		"546403545@qq.com",
	    		"28269889@qq.com",
	    		"578804775@qq.com",
	    		"460579213@qq.com",
	    		"15165883438@139.com",
	    		"568092826@qq.com",
	    		"81058262@qq.com",
	    		"741521359@qq.com",
	    		"147108967@qq.com",
	    		"59224934@qq.com",
	    		"346327076@qq.com",
	    		"15154159998@163.com",
	    		"346721131@qq.com",
	    		"524769229@qq.com",
	    		"liuweiping5858@126.com",
	    		"zkangelflying@163.com",
	    		"1342082380@qq.com",
	    		"763960411@qq.com",
	    		"306614801@qq.com",
	    		"251176326@qq.com",
	    		"289556527@qq.com",
	    		"yangxinyan1126@163.com",
	    		"5696498@qq.com",
	    		"363416308@qq.com",
	    		"864834099@qq.com",
	    		"xianweiren@126.com",
	    		"490964276@qq.com",
	    		"490478581@qq.com",
	    		"40000344@qq.com",
	    		"165238560@qq.com",
	    		"452339813@qq.com",
	    		"250133887@qq.com",
	    		"82814536@qq.com",
	    		"502135502@qq.com",
	    		"416189015@qq.com",
	    		"402239260@qq.com",
	    		"460378177@qq.com",
	    		"304382929@qq.com",
	    		"32123255@qq.com",
	    		"765186799@qq.com",
	    		"zzhangpeng@126.com",
	    		"177029196@qq.com",
	    		"335968775@qq.com",
	    		"13806481218@163.com",
	    		"xuqian85315@163.com",
	    		"Buku_55@163.com",
	    		"251158062@qq.com",
	    		"52198634@qq.com",
	    		"29442009@qq.com",
	    		"yinmaoan@126.com",
	    		"116652866@qq.com",
	    		"251389406@qq.com",
	    		"239920318@qq.com",
	    		"75730561@qq.com",
	    		"459935094@qq.com",
	    		"943576891@qq.com",
	    		"251389406@qq.com",
	    		"106347096@qq.COM",
	    		"ylldyx@163.com",
	    		"844010958@qq.com",
	    		"495140118@qq.com",
	    		"1178780410@qq.com",
	    		"584432166@qq.com",
	    		"hlt200200@126.com",
	    		"332335839@qq.com",
	    		"1543638896@qq.com",
	    		"15550008113@163.com",
	    		"168627478@qq.com",
	    		"420231101@qq.com",
	    		"272680190@163.com",
	    		"38275162@qq.com",
	    		"623430428@qq.com",
	    		"116636991@qq.com",
	    		"58135136@qq.com",
	    		"qunandliang@163.com",
	    		"234630803@qq.com",
	    		"349453323@qq.com",
	    		"3340865843@qq.com",
	    		"513842216@qq.com",
	    		"738918718@qq.com",
	    		"2290481556@qq.com",
	    		"847491905@qq.com",
	    		"35799067@qq.com",
	    		"520180451@qq.com",
	    		"844369741@qq.com",
	    		"50689047@qq.com",
	    		"haibingbest@163.com",
	    		"151768279@qq.com",
	    		"245876304@qq.com",
	    		"414931630@qq.com",
	    		"kp364095@126.com",
	    		"354179951@qq.com",
	    		"353452616@qq.com",
	    		"653940483@qq.com",
	    		"1805627441@qq.com",
	    		"183489412@qq.com",
	    		"249175151@qq.com",
	    		"83514472@qq.com",
	    		"57992721@qq.com",
	    		"1053071180@qq.com",
	    		"279719145@qq.com",
	    		"30794948@qq.com",
	    		"499791214@qq.com",
	    		"50032897@163.com",
	    		"82553060@qq.com",
	    		"317494731@qq.com",
	    		"723194353@qq.com",
	    		"1121748379@qq.cn",
	    		"js831218@163.com",
	    		"736738882@qq.com",
	    		"562577149@qq.com",
	    		"1171969687@qq.com",
	    		"sycscz@163.com",
	    		"123609472@qq.com",
	    		"y999yking@163.com",
	    		"36523778@163.com",
	    		"602435155@qq.com",
	    		"109331728@qq.com",
	    		"373348183@qq.com",
	    		"xenh@163.com",
	    		"1404655322@qq.com",
	    		"13563885955@189.com",
	    		"451888951@qq.com",
	    		"mengyaming@live.com",
	    		"281976115@qq.com",
	    		"717481480@qq.com",
	    		"359883104@qq.com",
	    		"467299950@qq.com",
	    		"758545690@qq.com",
	    		"729932802@qq.com",
	    		"371752734@qq.com",
	    		"632382109@qq.com",
	    		"282044120@qq.com",
	    		"121348366@qq.com",
	    		"877886360@qq.com",
	    		"673906816@qq.com",
	    		"1312046981@qq.com",
	    		"290117478@qq.com",
	    		"ZCYYWD1989@163.COM",
	    		"15997036@qq.com",
	    		"543129727@qq.com",
	    		"wanglei1117728@163.com",
	    		"155069917@qq.com",
	    		"407944463@qq.com",
	    		"liangdong20@163.com",
	    		"281953032@qq.com",
	    		"851259996@qq.com",
	    		"jxxxlgq@163.com",
	    		"779426866@qq.com",
	    		"631160486@qq.com",
	    		"470822321@qq.com",
	    		"315599059@qq.com",
	    		"41399711@qq.com",
	    		"251179404@qq.com",
	    		"851587897@qq.com","genqgiao@whaty.com"};
		String[] email1={"qingdaojy@126.com",
				"m13708928804@163.com",
				"xrfqd@126.com",
				"892181579@qq.com",
				"592508059@qq.com",
				"jinnuoma@163.com",
				"forttever@sina.com.cn",
				"442646011@qq.com",
				"575814542@qq.com",
				"13793113679@163.com",
				"sbgrz@126.com",
				"1791737393@qq.com",
				"1912877895@qq.com",
				"38693951@qq.com",
				"153113546@qq.com",
				"980703781@qq.com",
				"1002885978@qq.com",
				"13864085307@163.com",
				"yunshu981012@163.com",
				"tlyzcwd@126.com",
				"jnly0001@163.com",
				"1210984007@qq.com",
				"1094992199@QQ.COM",
				"2784157924@qq.com",
				"1359193802@qq.com",
				"1471040886@qq.com",
				"zhu163789@163.com",
				"674786609@qq.com",
				"sdjnbyq@163.com",
				"578921364@qq.com",
				"89316516@qq.com",
				"rzwkq@126.com",
				"junjie05@163.com",
				"zbzxsh@163.com",
				"baoshudongdong@163.com","gengqiao@whaty.com"
};
		//xueyuan
		String title="【济南铁路局通知】务必添加班组长远程学习交流群";
	    String content="【济南铁路局】为方便学员沟通交流，接收通知等，请务必添加济铁青年班组长QQ学习群，群号578116830。另外目前可以登陆，正式开学时间为本月底。为避免忘记和本单位核对信息，账号密码前期请不要修改。首次登陆提示时点击取消更改。";
	    //guanliyuan 
	    String title1="【济南铁路局通知】务必添加班组长远程学习管理与沟通群";
	    String content1="【济南铁路局】为方便各位管理员对班组长远程学习的管理与沟通，请您添加QQ群，群号：567133973。登陆后在学期中选择 2017济铁一期 ，即可查看本单位学员信息。目前可以登陆查看信息，正式开学时间为本月底。";
	   /* for(int i=1;i<email1.length;i++){
	 		try {
	 			System.out.println("-------发送到第"+i+"个;邮箱为"+email[i]);
	 			if(i%49==0&&i!=0){
	 				break;
	 		    }
	 			
			//	send(email1[i], title1, content1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }*/
	   send("gengqiao@whaty.com", title,content);
		//send("gengqiao@whaty.com","新会员通知","欢迎您注册成为安逸会员 访问www.anyi.date;账号为23233223'；密码为：233333333");
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
			msg.setFrom(new InternetAddress("cyrus"));
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
