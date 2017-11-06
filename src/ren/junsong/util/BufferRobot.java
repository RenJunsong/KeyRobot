package ren.junsong.util;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class BufferRobot extends Robot {

	public BufferRobot() throws AWTException {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public synchronized void delay(int ms) {
		delay(ms, 20);
	}
	public synchronized void delay(int ms, int accuracy) {
		super.delay(bufferNumber(ms, accuracy));
	}
	
	public synchronized void type(int keycode){
		super.keyPress(keycode); // ����������ֵΪint
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
	 * ��������о��ȵ���������ԽС������Խ�ߣ�����Ϊ�ٷֱȣ���10��ʾ+-10%
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
	 * ��ͼ����ɫ���д�����һ��ƫ���ڽ��бȽ�
	 * x,y��ʾͼ����������
	 * r,g,b��ʾ��ɫr,g,bֵ
	 * accuracy��ʾ��Χ
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
