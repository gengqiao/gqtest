import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.crypto.Data;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
/** 
* @className:te.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-7-27
*/
public class te {
	
	
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		Session session = cluster.connect();
		String cql = "create keyspace thbzzpxScore with placement_strategy = 'org.apache.cassandra.locator.SimpleStrategy' and strategy_options = {replication_factor:3};";
		ResultSet re=session.execute(cql);
		List<Row> list=re.all();
		for (Row row : list) {
			System.out.println(row.getString("*"));
		}
		System.out.println(session.hashCode());
		session.close();
		  UUID uuid = UUID.randomUUID();
		  String ui=uuid.toString();
		  ui=ui.replaceAll("-", "");
		  System.out.println(ui);
	}
	*/
	public static void main(String[] args) {
		String[] ste={"2f1425fd887f4148a6e5d19af91e077d",
				"97089cedb0184efcba2a430810c4cc08",
				"87f9165509854ebc96f731e192b9804f",
				"a413af17f13e4a82b5ddd8b8f95bd429",
				"3b419479af154b2aabbc2b7bf74fb92d",
				"19d46ee983ff40ca87868be0e73d65e6",
				"e52839401d694d379579ce5561e29009",
				"bcdec9bf3eb1475985f9625545e0c4f0",
				"6bcc1f5e2653430d9931ee01d4f48cf9",
				"823052baaf5441298f2e3ba8127c9b26",
				"6968cddf3b8342aa8245b84cc9750315",
				"2a7f8debc7e446d3b58d6ec4dce892b1",
				"c69b2be2d94949a0bc8323786e229675",
				"cf5abfe01e924824a48068714fc5051d",
				"916f8e09207d452c94c412839b9a0d78",
				"deb6697e5bf14c39afdac550521d5470",
				"82bbd4dbed0346c39ff909b6d61186c3",
				"615ce505b8854b2fa1a72808bb9b45f5",
				"4155937520da4a15a80f4e1dc25aa881",
				"6996c4d6a9034256aa1e4139cbee5c66",
				"8d60433a963a4d55bfc5649d47d4966a",
				"7b7f7a54bfab4be88faf84d0d11e5ac1",
				"439374b6420c4e6cbfa77f3615eee410"};
		//Arrays.asList(ste);
	/*	List list= new ArrayList();
		//System.out.println(list.get(0));
		String invoiceId = UUID.randomUUID().toString().replace("-", "");
      //   System.out.println(invoiceId);
		list.add(invoiceId);
        list.add("1111111111");
        
        System.out.println(list.toString());
        */
	/*	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		System.out.print(dateFormater.format(date));
		*/
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -1); //得到前一天
			Date date = calendar.getTime();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(df.format(date));

		/*String not="20160904163030";
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");       
          try {
			System.out.println(sdf.parse(not));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println(list.contains("43937d4b6420c4e6cbfa77f3615eee410"));
		
	/*	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");       

		  try {
			System.out.println(sdf.parse("20160112"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		///System.out.println("张棯博");
	/*
		 timer1("1");
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 timer1("2");*/
		 
	}
	  public static void timer1(final String s) {
		    Timer timer = new Timer();
		    timer.schedule(new TimerTask() {
		      public void run() {
		        System.out.println("-------设定要指定任务--------"+s);
		      }
		    }, 2000);// 设定指定的时间time,此处为2000毫秒
		  }
}
