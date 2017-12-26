import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/** 
* @className:excletest.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-9-13
*/
public class excletest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//readExcle();
		int a=1;
		a=a+=1;
		 System.out.println(a);
		 System.out.println(a=+1);
		
	}
	public static void readExcle(){
		Workbook work = null;
		File infile=new File("E:\\一些项目记录\\国管局\\三期节能远程学员信息 - 20160914.xls");
		File outfile=new File("E:\\一些项目记录\\国管局\\省统计.txt");
		try {
			work = Workbook.getWorkbook(infile);
			Sheet sheet = work.getSheet(0);
			String content="";
			HashSet<String> set=new HashSet<String>();
            for(int i=1;i<27032;i++){
                String sheng=sheet.getCell(0, i).getContents().trim();
               if(sheng==" "||sheng==""||sheng==null){
            	   continue;
               }
               sheng.replaceAll("\\*", "");
                 set.add(sheng);
            }
            content+="共"+set.size()+"个县"+System.getProperty("line.separator")  ;
            for(String s:set){
            	content+=s+System.getProperty("line.separator")  ;
            }
            System.out.println(content);
            writeTxtFile(content,outfile);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void writeTxtFile(String content,File file) throws IOException{
		if(!file.exists()){
			file.createNewFile();
		}
		 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		 writer.write(content);
		 writer.close();
		 System.out.println("-------------over-----------------");
		/*FileOutputStream out=new FileOutputStream(file);
		out.write(content.getBytes("GBK"));
		out.close();*/
		
		
		
	}
	
	
	
}
