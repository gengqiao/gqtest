package com.gq;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/** 
* @className:ss.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-5-22
*/
public class ss {
	/**
	 * @param args
	 */

private static final String PASSWORD_CRYPT_KEY = "whaty_thty"; 

private final static String DES = "DES"; 
	public static void main(String[] args) {
		/*String s=decrypt("BE52692B35DD999065775115B4AA872FF91B71D076E53FB731699E4B45A229921D18429D5460D7C1A3F69245735030F220D203E8849D6CDA84B9564C18214BC638D8464A65654ED4");
		System.out.println(s);*/
       String ss="'null'ssss";
      System.out.println( ss.replaceAll("'null'", "null"));

	}
	
    public static byte[] decrypt(byte[] src, byte[] key)throws Exception { 

        // DES算法要求有一个可信任的随机数源

        SecureRandom sr = new SecureRandom(); 

        // 从原始密匙数据创建一个DESKeySpec对象

        DESKeySpec dks = new DESKeySpec(key); 

        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成

        // 一个SecretKey对象

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES); 

        SecretKey securekey = keyFactory.generateSecret(dks); 

        // Cipher对象实际完成解密操作

        Cipher cipher = Cipher.getInstance(DES); 

        // 用密匙初始化Cipher对象

        cipher.init(Cipher.DECRYPT_MODE, securekey, sr); 

        // 现在，获取数据并解密

        // 正式执行解密操作

        return cipher.doFinal(src); 

     } 
	  public final static String decrypt(String data){ 

		     try { 

		      return new String(decrypt(hex2byte(data.getBytes()),

		         PASSWORD_CRYPT_KEY.getBytes())); 

		    }catch(Exception e) { 

		    } 

		    return null; 

		  } 
	  
	  public static byte[] hex2byte(byte[] b) { 

		    if((b.length%2)!=0) 

		       throw new IllegalArgumentException("长度不是偶数"); 

		        byte[] b2 = new byte[b.length/2]; 

		        for (int n = 0; n < b.length; n+=2) { 

		          String item = new String(b,n,2); 

		          b2[n/2] = (byte)Integer.parseInt(item,16); 

		        } 

		    return b2;
		  }
	
	public static boolean updateStudentScore(String login_id, String opencourse_id, String score){
		// TODO Auto-generated method stub
		//模拟考试场次不做回传
		String[] moniBatchid={"ff80808153e4fbb40153e53f4773000e","ff80808153e4fbb40153e54055e40010","ff80808153e5d07d0153e9b6c118000e","ff80808153f52f0a01540dcd64d70105","ff80808153f52f0a01540e4712e70120"};
	
		 
		try { 
			 StringBuffer sql2 = new StringBuffer();
			if( !Arrays.asList(moniBatchid).contains(opencourse_id)){
				 sql2.append(" INSERT INTO examscore_back (`LOGINID`, `SCORE`, `EXAMBATCHID`, `SUBTIME`)  " );
				 sql2.append(" VALUES ('"+login_id + "','"+Double.parseDouble(score)+"','"+opencourse_id+"',sysdate())");	
				System.out.println(sql2.toString());
			}
					
					 // generalService.executeBySQL(sql2.toString());
				
				
		    return true;	
		} catch (Exception e) {
			System.out.println(" exam score come back fail: login_id="+login_id+",opencourse_id="+opencourse_id+",score="+score);
			e.printStackTrace();
		}
		return false;
	}	
}
