/*
 * 文件名：HttpClientUtil.java 
 * 描述：〈描述〉
 * 创建人：Administrator
 * 创建时间：2017年10月23日下午5:29:15
 */
package com.gq.httpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author Administrator
 */
public class HttpClientUtil {

	/**
	 * 〈一句话功能简述〉
	 * 〈功能详细描述〉
	 *
	 * @param args
	 * @return [返回类型说明]
	 * @exception/throws [违例类型] [违例说明]
	 */
	public static void main(String[] args) {
		   String url = "http://www.mqxypx.com/entity/thty/registerInfo/thtyPeTraineeManager_setInitPwd.action?ids=";  
		    Map<String,String> header = new HashMap<String,String>();  
		    header.put("Cookie", "JSESSIONID=2CED21BCE5D73B6D1C55ABF13D9EA3BB.web215_webtrn");  
		    System.out.println(httpGet(url,null,getCookie()));

	}

	
	public static Map<String,String> getCookie(){
	    Map<String,String> header = new HashMap<String,String>();
	    String url="http://www.mqxypx.com/sso/ssoLogin_login.action?loginId=mqxy@whaty.com&passwd=mqxy2017&authCode=11";
	    HttpGet httpGet = new HttpGet(url); 
	    DefaultHttpClient httpclient = new DefaultHttpClient();  
	    HttpResponse http_response;
		try {
			http_response = httpclient.execute(httpGet);
			 Header[] ss=  http_response.getAllHeaders() ;
		        for(int m=0;m<ss.length;m++){
		        	Header header1 = ss[m];
		        	if("Set-Cookie".equals(header1.getName())){
		        		header.put("Cookie", header1.getValue().split(";")[0]);
		        	}
		        	
		        }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return header;
	}
	
	
	
	/** 
	 * 发送 get 请求 
	 * @param url 
	 * @param encode 
	 * @param headers 
	 * @return 
	 */  
	public static String httpGet(String url,String encode,Map<String,String> headers){  
	    if(encode == null){  
	        encode = "utf-8";  
	    }  
	    String content = null;  
	    DefaultHttpClient httpclient = new DefaultHttpClient();  
	       HttpGet httpGet = new HttpGet(url);  
	        
	       //设置 header  
	       Header headerss[] = buildHeader(headers);  
	       if(headerss != null && headerss.length > 0){  
	        httpGet.setHeaders(headerss);  
	       }  
	       HttpResponse http_response;  
	    try {  
	        http_response = httpclient.execute(httpGet);  
	        HttpEntity entity = http_response.getEntity();  
	        content = EntityUtils.toString(entity, encode);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }finally {  
	           httpGet.releaseConnection();  
	       }  
	       return content;  
	}  
	  
	/** 
	 * 组装请求头 
	 * @param params 
	 * @return 
	 */  
	   public static Header[] buildHeader(Map<String,String> params){  
	    Header[] headers = null;  
	    if(params != null && params.size() > 0){  
	        headers = new BasicHeader[params.size()];  
	        int i  = 0;  
	        for (Map.Entry<String, String> entry:params.entrySet()) {  
	            headers[i] = new BasicHeader(entry.getKey(),entry.getValue());  
	            i++;  
	        }  
	    }  
	    return headers;  
	   }  
}
