package ren.junsong.util;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class BufferRobot extends Robot {

	public BufferRobot() throws AWTException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public synchronized void delay(int ms) {
		delay(ms, 20);
	}
	public synchronized void delay(int ms, int accuracy) {
		super.delay(bufferNumber(ms, accuracy));
	}
	
	public synchronized void type(int keycode){
		super.keyPress(keycode); // 按键，接受值为int
		delay(100);
		super.keyRelease(keycode);
	}

	private static boolean checkNumber(int accuracy) {
		if (accuracy < 0) {
			return false;
		}
		return true;
	}

	/**
	 * 对随机进行精度调整，数字越小，精度越高，数字为百分比，如10表示+-10%
	 * 
	 * @param ms
	 * @param accuracy
	 * @return
	 */
	private static int bufferNumber(int ms, int accuracy) {
		int bufferTime = 0;
		if (checkNumber(accuracy)) {
			bufferTime = (int) (ms * accuracy / 50 * (Math.random() - 0.5));
		}
		return ms + bufferTime;
	}
	
	/**
	 * 对图像颜色进行处理，在一定偏差内进行比较
	 * x,y表示图像像素坐标
	 * r,g,b表示颜色r,g,b值
	 * accuracy表示误差范围
	 */
	public synchronized boolean getAndEqualsColor(int x,int y,int r,int g,int b,int accuracy){
		Color color=getPixelColor(x, y);
		if((color.getRed()<=r+accuracy)&&(color.getRed()>=r-accuracy)&&(color.getGreen()>=g-accuracy)&&(color.getGreen()<=g+accuracy)&&(color.getBlue()>=b-accuracy)&&(color.getBlue()<=b+accuracy)){
			return true;
		}
		return false;
	}
	
	public synchronized int[] getPixelColorValue(int x,int y){
		int[] rgb=new int[3];
		rgb[0]=getPixelColor(x,y).getRed();
		rgb[1]=getPixelColor(x,y).getGreen();
		rgb[2]=getPixelColor(x,y).getBlue();
		return rgb;
	}
}
