import java.math.BigDecimal;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
* @className:ss.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-12-29
*/
public class ss {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 JSONArray arr=new JSONArray();
		   for(int i=0;i<5;i++){
		  	 JSONObject obj=new JSONObject();
		      obj.put("name", "geng");
		      obj.put("age",23);
		      arr.add(obj);
		   }
		   System.out.println(arr.toString());
	}
}
