package com.sx.libarary.until;

import java.io.File;

import org.apache.tomcat.jni.OS;

public class PathUntil {
	private static String separator=System.getProperty(File.separator);
	public static String getBaseImagePath(){
		String  os=System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win")){
			basePath="H:/photo";
		}else{
			basePath="/home/libarary/images";
		}
		return basePath;
	}
	
	public static String getBookImage(Integer bookid){
		String bookImgPath="/upload/item/book/"+bookid+"/";
		return bookImgPath;
	}
}
