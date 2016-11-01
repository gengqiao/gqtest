package com.gq;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class ExportXml {
	private List<String> fileNamels = new ArrayList<String>();
	private String filesp = System.getProperty("file.separator");
	private String currentJavaRoot;
	private List<String> javaSourceDirectory = new ArrayList<String>();
	private boolean isExportAll = false;// 是否提取javaRoot目录下所有的文件，false:只提取java文件相对应的.class文件，true:提取java文件相对应的.class文件与其它文件
	private static String srcpath = "E:\\课件";
	private static String despath = "D:\\课件";
	private static int fileSize = 0;
	static String suffix = ".mp4";

	public static void main(String[] args) {
		//copyFiles();//执行复制操作
		showFiles(srcpath);//显示源目录文件名称和总个数
		//showFiles(despath);//显示目标目录文件名称和总个数
	}

	public static void showFiles(String path) {
		getFiles(path);
		System.out.println("总共：" + fileSize);
	}

	public static void copyFiles() {
		File srcFile = new File(srcpath);
		if (!srcFile.exists() || !srcFile.isDirectory()) {
			System.out.println(srcpath + "不存在");
			return;
		}
		srcFile = new File(despath);
		if (!srcFile.exists() || !srcFile.isDirectory()) {
			srcFile.mkdir();
			//System.out.println(despath + "不存在");
			return;
		}
		ExportXml exportClass = new ExportXml();
		for (int j = 60; j <= 91; j++) {//意思是处理001到048文件夹内的文件
			for (int i = 1; i <= 27; i++) {
				String ad = "";
			/*	if (i < 10) {
					ad = "0" + i;
				} else {
					ad = "" + i;
				}*/
				ad = "" + i;

				String courseCode = "";
				if (j > 99) {
					courseCode = "" + j;
				} else if (j < 10) {
					courseCode = "00" + j;
				} else {
					courseCode = "0" + j;
				}
				String coursepath = "\\" + courseCode + "\\" + ad + "\\contents.files\\1";
				int result = exportClass.exportFileByName(srcpath + coursepath, despath + coursepath, "video.mp4");
				if (result == 0) {
					if (i < 10) {//把前面的0去掉，再重试一次
						ad = "" + i;
						coursepath = "\\" + courseCode + "\\" + ad + "\\contents.files\\1";
						result = exportClass.exportFileByName(srcpath + coursepath, despath + coursepath, "video.mp4");
						if (result == 0) {
							break;
						}
					}else{
						break;
					}
					
				}
			}
		}
	}

	public int exportFileByName(String srcPath, String outPath, String xmlFileName) {
		this.fileNamels.clear();
		int res = this.listFile(new File(srcPath), xmlFileName);
		if (res == 0) {
			return res;
		}
		String src = null;
		String des = null;
		for (String fileName : fileNamels) {
			src = fileName;
			if (src.indexOf(srcPath) != -1) {
				fileName = src.substring(src.indexOf(srcPath) + srcPath.length());
			}
			des = outPath + this.filesp + fileName;
			copyFile(src, des);
		}
		return 1;
	}

	/*
	 * 获取指定文件
	 */
	public int listFile(File f, String xmlFileName) {
		if (!f.exists()) {
			System.err.println("文件或目录：" + f.getAbsolutePath() + "不存在");
			return 0;
		}
		String fileName = f.getAbsolutePath();
		if (f.isDirectory()) {
			// System.out.println("directory:"+f.getPath()+"--parent:"+f.getParent());
			// System.out.println("directory:"+f.getPath()+"--parent:"+f.getParent());
			String directoryName;
			//if (fileName.indexOf(filesp + currentJavaRoot + filesp) != -1) {
			directoryName = fileName;//substring(fileName.indexOf(this.filesp + this.currentJavaRoot + this.filesp) + this.currentJavaRoot.length() + 1);
			javaSourceDirectory.add(directoryName);
			//}
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				listFile(t[i], xmlFileName);
			}
		} else {
			// System.out.println("fileName:"+f.getAbsolutePath()+"--parent:"+f.getParent());
			//if (fileName.indexOf(filesp + currentJavaRoot + filesp) != -1) {
			int index = fileName.indexOf(filesp + currentJavaRoot + filesp);
			if (fileName.lastIndexOf(xmlFileName) != -1) {
				String javaFile = fileName;
				this.fileNamels.add(javaFile);
				System.out.println("fileName:" + javaFile);
			}
			//}
		}
		return 1;
	}

	/*
	 * 列出svn 更新时导出的文件中 src目录下所有文件的文件名（包括相对src的全路径，java文件名变为相对应的class文件名）
	 */
	public void listFile(File f) {
		if (!f.exists()) {
			System.err.println("文件或目录：" + f.getAbsolutePath() + "不存在");
			return;
		}
		String fileName = f.getAbsolutePath();
		if (f.isDirectory()) {
			// System.out.println("directory:"+f.getPath()+"--parent:"+f.getParent());
			// System.out.println("directory:"+f.getPath()+"--parent:"+f.getParent());
			String directoryName;
			if (fileName.indexOf(filesp + currentJavaRoot + filesp) != -1) {
				directoryName = fileName.substring(fileName.indexOf(this.filesp + this.currentJavaRoot + this.filesp) + this.currentJavaRoot.length() + 1);
				javaSourceDirectory.add(directoryName);
			}
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				listFile(t[i]);
			}
		} else {
			// System.out.println("fileName:"+f.getAbsolutePath()+"--parent:"+f.getParent());
			if (fileName.indexOf(filesp + currentJavaRoot + filesp) != -1) {
				int index = fileName.indexOf(filesp + currentJavaRoot + filesp);
				if (fileName.lastIndexOf(".java") != -1) {
					String javaFile = fileName.substring(index + this.currentJavaRoot.length() + 1, fileName.lastIndexOf(".java")) + ".class";
					this.fileNamels.add(javaFile);
					System.out.println("fileName:" + javaFile);
				} else {
					if (this.isExportAll) {
						String otherFile = fileName.substring(index + this.currentJavaRoot.length() + 1);
						this.fileNamels.add(otherFile);
						System.out.println("fileName:" + otherFile);
					}
				}
			}
		}
	}

	/*
	 * 文件复制
	 */
	private void copyFile(String oldPath, String newPath) { // 复制文件
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

	static void getFiles(String filePath) {
		File root = new File(filePath);
		if (!root.exists() || !root.isDirectory()) {
			System.out.println("不存在或不是目录");
			return;
		}
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFiles(file.getAbsolutePath());
				//System.out.println("显示" + filePath + "下所有子目录及其文件" + file.getAbsolutePath());
			} else if (file.getAbsolutePath().toLowerCase().endsWith(suffix.toLowerCase())) {
				System.out.println("显示" + filePath + "下所有子目录" + file.getAbsolutePath());
				fileSize++;
			}
		}
	}
}