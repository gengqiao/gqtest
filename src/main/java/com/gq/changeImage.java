/*
 * 文件名：changeImage.java 
 * 描述：〈描述〉
 * 创建人：Administrator
 * 创建时间：2017年7月5日上午11:29:35
 */
package com.gq;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class changeImage {
	static List<String>  pathlist=new ArrayList<String>();
	 public static final String JPG = "jpeg";
	 
	  public static void converter(File imgFile,String format,File formatFile)
		      throws IOException{
		    BufferedImage bIMG =ImageIO.read(imgFile);
		    ImageIO.write(bIMG, format, formatFile);
		  }
	
	public static void main(String[] args) {
		traverseFolder("I:\\运营项目\\班组长\\七期班结业数据\\image\\15\\");
		
		try {
			for (String str:pathlist){
				String path=str.split("\\.")[0];
				File file=new File(str);
				converter(file,JPG, new File(path+".jpeg"));
				file.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void FindImage(){
	       traverseFolder("I:\\运营项目\\班组长\\七期班结业数据\\image\\"); 
	       String regNo="201501024614,201501017636,201501022432,201501020997,201501023202,201501019671,201501019328,201501019394,201501023228,201501019591,201501019343,201501018445,201501020049,201501020145,201501020164,";
	       regNo+="201501020038,201501020318,201501020334,201501020048,201501023801,201501017427,201501020154,201501021653,201501018723,201501018665,201501018747,201501018985,201501024577,201501021732,";
	       regNo+="201501018933,201501022548,201501025653,201501025434,201501023984,201501027112,201501022692,201501023989,201501025993,201501022166,201501027111,";
	       regNo+="201501026399,201501027225,201501019713,201501026792,201501026799,201501026798,201501027237,201501026785,201501024053,201501027117,201501027119,201501027244,201501019259,";
	       regNo+="201501021196,201501020440,201501022946,201501023450,201501020410,201501023455,201501019213,201501023531,201501023456,201501020424,201501019154,201501023469,201501020391,201501023500,201501021183,201501019286,";
	       regNo+="201501024722,201501027280,201501018191,201501021412,201501024723,201501020450,201501020761,";
	       regNo+="201501021096,201501017654,201501022085,201501022088,201501021420,201501018176,";
	       regNo+="201501025222,201501021112,201501023032,201501019961,201501023101,201501024932,201501023038,201501025171,";
	       regNo+="201501019313,201501025749,201401050142,201401049949,201401049989,201401050061";
	       String[] regNos=regNo.split(",");
	       System.out.println(regNos.length);
	      for(String str:pathlist){
	    	  for (String s:regNos){
	    		  if(str.indexOf(s)>-1){
	    			   String name=  str.split("\\\\")[ str.split("\\\\").length-1];
	    			  // System.out.println("-------------------"+name);
	    			  copyFile(str,"I:\\运营项目\\班组长\\七期班结业数据\\image\\15\\"+name);	  
	    		  }
		       }
	      }
	
		
	}
	
	
	
	
	public static void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder(file2.getAbsolutePath());
                    } else {
                    	String pathUrl=file2.getAbsolutePath();
                    	pathlist.add(pathUrl);
                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
	

	/*
	 * 文件复制
	 */
	private static void copyFile(String oldPath, String newPath) { // 复制文件
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);

			File newfile = new File(newPath);

			if (!newfile.getParentFile().exists()) {// 目录不存在时，创建目录
				newfile.getParentFile().mkdirs();
			}

			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);

				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					// System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				System.out.println("文件：" + oldfile.getName() + " 复制大小：" + (double) bytesum / 1024 + " KB");
			} else {
				System.err.println("文件：" + oldfile.toString() + "不存在！！！");
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}

}
