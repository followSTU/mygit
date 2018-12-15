package com.sx.libarary.until;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class BookImageUtil {
	private static String Path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormate=new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r=new Random();
	public static String generateThumbnail(CommonsMultipartFile thumbnail,String targetAddr) throws Exception{
		String waterPath=URLDecoder.decode(Path,"utf-8");
		String realFileName=getRandomFileName();
		String extension=getFileExtension(thumbnail);
		madeDirPath(targetAddr);
		String relativeAddr=targetAddr+realFileName+extension;
		File dest=new File(PathUntil.getBaseImagePath()+relativeAddr);
		Thumbnails.of(thumbnail.getInputStream()).size(400, 400)
		.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("H:/photo/water.png")),0.5f)
		.outputQuality(0.8f).toFile(dest);
		return relativeAddr;
	}
	public static String testgenerateThumbnail(String targetAddr) throws Exception{
		String waterPath=URLDecoder.decode(Path,"utf-8");
		String realFileName=getRandomFileName();
		madeDirPath(targetAddr);
		String relativeAddr=targetAddr+realFileName;
		File dest=new File(PathUntil.getBaseImagePath()+relativeAddr);
		Thumbnails.of(new File("H:/photo/02.jpg")).size(400, 400)
		.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("H:/photo/water.png")),0.5f)
		.outputQuality(0.8f).toFile(dest);
		return relativeAddr;
	}
	private static String getRandomFileName() {
		int randNum=r.nextInt(89999)+10000;
		String date=sDateFormate.format(new Date());
		return date+randNum;
	}
	private static String getFileExtension(CommonsMultipartFile cfile) {
		String originalFileName=cfile.getOriginalFilename();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}
	private static void madeDirPath(String targetAddr) {
		String realFileParentPath = PathUntil.getBaseImagePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
	}
}
