import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/** 
* @className:tew.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-9-13
*/
public class tew {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 System.out.println("压缩图片开始...");  
		    File srcfile = new File("C://Users//Administrator//Desktop//aa.jpg");  
		    System.out.println("压缩前srcfile size:" + srcfile.length());  
		    reduceImg("C://Users//Administrator//Desktop//aa.jpg", "C://Users//Administrator//Desktop//bb.jpg", 400, 400,null);  
		    File distfile = new File("C://Users//Administrator//Desktop//bb.jpg");  
		    System.out.println("压缩后distfile size:" + distfile.length());  
	}
	

	public static void downloadFile(String urlPath, String filePath, String NewName) throws IOException {
		URL theURL = new URL(urlPath);
		File dirFile = new File(filePath);
		if (!dirFile.exists()) {
			// 文件路径不存在时，自动创建目录
			dirFile.mkdir();
		}
		// 从服务器上获取图片并保存
		URLConnection connection = theURL.openConnection();
		String name = theURL.getFile().split("/")[theURL.getFile().split("/").length - 1];
		String newName = NewName + "." + name.split("\\.")[1];
		HttpURLConnection httpUrlConnection = (HttpURLConnection) connection;
		InputStream in = httpUrlConnection.getInputStream();
		connection.getExpiration();
		int size=httpUrlConnection.getContentLength()/1024;
		System.out.println(newName+"准备写入大小" +size );
	

		
		Long startTime = System.currentTimeMillis();
		FileOutputStream os = new FileOutputStream(filePath + newName);
		byte[] buffer = new byte[4 * 1024];
		int read;
		while ((read = in.read(buffer)) > 0) {
			os.write(buffer, 0, read);
		}
		Long endTime = System.currentTimeMillis();
		
		System.out.println("写入成功");
		os.flush();
		os.close();
		in.close();
	}

	
	/** 
     * 采用指定宽度、高度或压缩比例 的方式对图片进行压缩 
     * @param imgsrc 源图片地址 
     * @param imgdist 目标图片地址 
     * @param widthdist 压缩后图片宽度（当rate==null时，必传） 
     * @param heightdist 压缩后图片高度（当rate==null时，必传） 
     * @param rate 压缩比例  
     */  
	
	public static void reduceImg(String imgsrc, String imgdist, int widthdist,  
            int heightdist, Float rate) {  
        try {  
            File srcfile = new File(imgsrc);  
            // 检查文件是否存在  
            if (!srcfile.exists()) {  
                return;  
            }  
            // 如果rate不为空说明是按比例压缩  
            if (rate != null && rate > 0) {  
                // 获取文件高度和宽度  
                int[] results = getImgWidth(srcfile);  
                if (results == null || results[0] == 0 || results[1] == 0) {  
                    return;  
                } else {  
                    widthdist = (int) (results[0] * rate);  
                    heightdist = (int) (results[1] * rate);  
                }  
            }  
            // 开始读取文件并进行压缩  
            Image src = javax.imageio.ImageIO.read(srcfile);  
            BufferedImage tag = new BufferedImage((int) widthdist,  
                    (int) heightdist, BufferedImage.TYPE_INT_RGB);  
  
            tag.getGraphics().drawImage(  
                    src.getScaledInstance(widthdist, heightdist,  
                            Image.SCALE_SMOOTH), 0, 0, null);  
  
            FileOutputStream out = new FileOutputStream(imgdist);  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
            encoder.encode(tag);  
            out.close();  
  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }  
	
	/**
	 * 获取图片宽度
	 * 
	 * @param file
	 *            图片文件
	 * @return 宽度
	 */
	public static int[] getImgWidth(File file) {
		InputStream is = null;
		BufferedImage src = null;
		int result[] = { 0, 0 };
		try {
			is = new FileInputStream(file);
			src = javax.imageio.ImageIO.read(is);
			result[0] = src.getWidth(null); // 得到源图宽
			result[1] = src.getHeight(null); // 得到源图高
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
