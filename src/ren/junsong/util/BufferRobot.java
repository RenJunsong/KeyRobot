package ren.junsong.util;

import java.awt.AWTException;
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
}
