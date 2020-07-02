package com.myhome.www.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class FileUtil {
	
	//크로핑&리사이징 메서드
	public static void imageResize(String orgFilePath, String targetFilePath, 
			String imageType) throws Exception{
		
		BufferedImage originalImage = ImageIO.read(new File(orgFilePath));
		int imgwidth = Math.min(originalImage.getHeight(), originalImage.getWidth());
		int imgheight = imgwidth;
		//크로핑
		BufferedImage scaledImage = Scalr.crop(originalImage, (originalImage.getWidth() - imgwidth)/2, 
				(originalImage.getHeight() - imgheight)/2, imgwidth, imgheight);
		//리사이징
		BufferedImage resizedImage = Scalr.resize(scaledImage, 200, 200);
		ImageIO.write(resizedImage, imageType, new File(targetFilePath));}}
