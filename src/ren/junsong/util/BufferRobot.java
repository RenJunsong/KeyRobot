package ren.junsong.util;

import java.awt.AWTException;
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
}
