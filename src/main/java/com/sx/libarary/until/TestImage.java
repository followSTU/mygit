package com.sx.libarary.until;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class TestImage {
	
	public static void main(String[] args) throws IOException {
		String basePath1 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String path=URLDecoder.decode(basePath1,"utf-8");
		Thumbnails.of(new File("H:/photo/02.png")).size(200, 240)
		.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(path+"water1.png")), 0.5f)
		.outputQuality(0.8f).toFile("H:/photo/update/02new.jpg");

	}

}
