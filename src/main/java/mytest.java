import java.lang.reflect.Constructor;

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
		
		Class<?> clazz=Singleton.class;
		try {
			
			Constructor[]  sss=	clazz.getDeclaredConstructors();
			
			for(Constructor s:sss){
				System.out.println("所有方法："+s);
			}
			
			Constructor c0=clazz.getDeclaredConstructor();   
            c0.setAccessible(true);   
              
            Singleton po=(Singleton)c0.newInstance();   
            System.out.println("不带参的构造函数\t"+po); 
            /*	
			Constructor   c=	clazz.getDeclaredConstructor(new Class[]{int.class,String.class});   
			
			c.setAccessible(true);
			Test t=(Test) c.newInstance(new Object[]{1,"诺基亚"});   
			System.out.println("带参的构造函数\t"+t); 
			//t.say("ss");
*/			
			
		/*	
			
			Method method=clazz.getMethod("say", String.class);
			
			method.invoke(clazz.newInstance(), "gengqiao");
			
			*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  
	
}

class Test{
	
	int price;  
    String brand;  
    private Test(){  
          
    }  
    private Test(int price,String brand){  
        this.price = price;  
        this.brand = brand;  
    }  
    @Override  
    public String toString() {  
        return price + "\t"+brand;  
    }  
	
}