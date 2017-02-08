import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* @className:mytest.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-11-17
*/
public class mytest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Class<?> clazz=Test.class;
		try {
			Method method=clazz.getMethod("say", String.class);
			
			method.invoke(clazz.newInstance(), "gengqiao");
			
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  
	
}

class Test{
	
	public void say(String name){
		System.out.println("---------"+name);
	}
	
}