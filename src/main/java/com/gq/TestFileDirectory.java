package com.gq;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TestFileDirectory {
	private static int m = 0;
	private static int n = 0;
	private static String address[] = {"151200100121.doc",
		"151205500001.doc",
		"151205500002.doc",
		"151205510001.doc",
		"151205510004.doc",
		"151205510005.doc",
		"151205510006.doc",
		"151205510007.doc",
		"151205510008.doc",
		"151205510009.doc",
		"151205510010.doc",
		"151205510011.doc",
		"151205510012.doc",
		"151205520001.doc",
		"151205520002.doc",
		"151205530001.doc",
		"151205530002.doc",
		"151205540001.doc",
		"151205560001.doc",
		"151205560003.doc",
		"151205560004.doc",
		"151205560005.doc",
		"151205560006.doc",
		"151205560007.doc",
		"151205570001.doc",
		"151205580002.doc",
		"151205590001.doc",
		"151205590002.doc",
		"151205590003.doc",
		"151205590004.doc",
		"151205590005.doc",
		"151205610001.doc",
		"151205630001.doc",
		"151205660003.doc",
		"161205590001.doc"
};
	private static int mn = 0;
	private static Map<String, String> map = new HashMap<String, String>();
	static {
		map.put("1001000", "教育部");
		map.put("1002000", "卫生部");
		map.put("1003000", "工业和信息化部");
		map.put("1004000", "水利部");
		map.put("1005000", "税务总局");
		map.put("1006000", "人民银行");
		map.put("1007000", "国资委");
		map.put("1008000", "海关总署");
		map.put("1009000", "质检总局");
		map.put("101000", "新疆生产建设兵团");
		map.put("1010000", "安监总局");
		map.put("1011000", "地震局");
		map.put("1012000", "银监会");
		map.put("1013000", "气象局");
		map.put("1014000", "新华社");
		map.put("1015000", "其他中央部委及其他事业单位、团体组织");
		map.put("1016000", "中科院");
		map.put("1017000", "工商总局");
		map.put("1018000", "公安部");
		map.put("102000", "中央国家机关及垂管系统");
		map.put("103000", "中央部委所属学校");
		map.put("104000", "中央部委所属医院");
		map.put("105000", "中央部委所属其它事业单位或团体组织");
		map.put("110000", "北京市");
		map.put("120000", "天津市");
		map.put("130000", "河北省");
		map.put("140000", "山西省");
		map.put("150000", "内蒙古自治区");
		map.put("210000", "辽宁省");
		map.put("220000", "吉林省");
		map.put("230000", "黑龙江省");
		map.put("310000", "上海市");
		map.put("320000", "江苏省");
		map.put("330000", "浙江省");
		map.put("340000", "安徽省");
		map.put("350000", "福建省");
		map.put("360000", "江西省");
		map.put("370000", "山东省");
		map.put("410000", "河南省");
		map.put("420000", "湖北省");
		map.put("430000", "湖南省");
		map.put("440000", "广东省");
		map.put("450000", "广西壮族自治区");
		map.put("460000", "海南省");
		map.put("500000", "重庆市");
		map.put("510000", "四川省");
		map.put("520000", "贵州省");
		map.put("530000", "云南省");
		map.put("540000", "西藏自治区");
		map.put("610000", "陕西省");
		map.put("620000", "甘肃省");
		map.put("630000", "青海省");
		map.put("640000", "宁夏回族自治区");
		map.put("650000", "新疆维吾尔自治区");
		map.put("710000", "台湾省");
		map.put("810000", "香港特别行政区");
		map.put("820000", "澳门特别行政区");
		map.put("900000", "清华大学");
	}

	public static void main(String[] args) throws Exception {
		/*File root = new File("C:\\Users\\Administrator\\Desktop\\主观题2\\主观题");
		showAllFiles(root);
		System.out.println("共有WORD文件：" + m);
		System.out.println("共有文件夹：" + n);
		System.out.println("补考学员有：" + mn);*/
		checkaddress();
	}

	final static void showAllFiles(File dir) throws Exception {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isDirectory()) {
				try {
					n++;
					//System.out.println(fs[i].getName() + "----" + listFiles(fs[i],".DOC"));
					if ("examagain".equals(fs[i].getName())) {
						mn = mn + listFiles(fs[i], ".DOC");
					}
					String oldpath = fs[i].getPath();
					String newpath = fs[i].getParent() + "\\" + map.get(fs[i].getName()) + "(" + listFiles(fs[i], ".DOC") + ")";
					if (!"examagain".equals(fs[i].getName()) && map.get(fs[i].getName()) != null) {
						//System.out.println("oldpath-------"+oldpath);
						//System.out.println("newpath-------"+newpath);
						//renameDirectory(oldpath,newpath);
					}
					if ("examagain".equals(fs[i].getName())) {
						System.out.println("oldpath-------" + oldpath);
						File f = new File(oldpath);
						f.delete();
					}
					showAllFiles(fs[i]);
				} catch (Exception e) {
				}
			} else {
				if (fs[i].getName().toUpperCase().endsWith(".DOC")) {
					if (fs[i].getPath().indexOf("examagain") > 0) {
						String oldPath = fs[i].getPath();
						String newPath = "E:\\工作\\补考论述题\\" + fs[i].getName();
						//copyFile(oldPath, newPath);'
						File f = new File(oldPath);
						f.delete();
					}
					m++;
				}
			}
		}
	}

	static int listFiles(File f, String prefix) {
		int m = 0;
		if (f.isDirectory()) {
			File[] fs = f.listFiles();
			for (int i = 0; i < fs.length; i++) {
				if (fs[i].getName().toUpperCase().endsWith(prefix)) {
					int q = fs[i].getName().toUpperCase().indexOf("151400100001");
					int w = fs[i].getName().toUpperCase().indexOf("151203960001");
					int e = fs[i].getName().toUpperCase().indexOf("151699990001");
					int r = fs[i].getName().toUpperCase().indexOf("151599990001");
					int t = fs[i].getName().toUpperCase().indexOf("151399990001");
					if (q != -1 || w != -1 || e != -1 || r != -1 || t != -1) {
						System.out.println(fs[i].getPath());
					}
					m++;
				}
			}
		}
		return m;
	}

	//文件复制
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
				byte[] buffer = new byte[8192];
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

	//重命名文件夹名称
	static void renameDirectory(String fromDir, String toDir) {
		File from = new File(fromDir);
		if (!from.exists() || !from.isDirectory()) {
			System.out.println("Directory does not exist: " + fromDir);
			return;
			
		}
		File to = new File(toDir);
		//Rename
		if (from.renameTo(to))
			System.out.println("Success!");
		else
			System.out.println("Error");
	}
//判断文件是否存在
	static void checkaddress() {
		int m = 0;
		for (int i = 0, j = address.length; i < j; i++) {
			File file = new File("E:\\一些项目记录\\国管局\\考试情况统计\\主观题\\主观题\\区域节能工作管理人员\\安徽省(34)\\"+address[i]);
			if (!file.exists()) {
				System.out.println("Directory does not exist: " + address[i]);
			} else {
				System.out.println(m = m + 1);
			}
		}
	}
}
