package ren.junsong.test;

import java.awt.AWTException;
import java.util.Arrays;

import ren.junsong.util.BufferRobot;

public class Delete {
	public static void main(String[] args) {
		try {
			BufferRobot br=new BufferRobot();
			br.delay(5000);
			String str1=Arrays.toString(br.getPixelColorValue(895, 591));
			String str2=Arrays.toString(br.getPixelColorValue(875, 682));
			String str3=Arrays.toString(br.getPixelColorValue(674, 893));
			System.out.println(str1+str2+str3);
		} catch (AWTException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
