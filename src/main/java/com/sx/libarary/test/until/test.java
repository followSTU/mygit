package com.sx.libarary.test.until;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Test;

import com.sx.libarary.until.BookImageUtil;
import com.sx.libarary.until.PathUntil;

public class test {
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String path=PathUntil.getBookImage(12);
		try {
			System.out.println(System.getProperty(File.separator));
			String imgpath=BookImageUtil.testgenerateThumbnail(path);
			System.out.println(imgpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
