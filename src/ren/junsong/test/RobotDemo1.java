package ren.junsong.test;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotDemo1 {
	public static void main(String[] args) {
		Robot robot;
		int delay=1500;  //�����������ӳ���
		try {
			robot = new Robot();
			int i = 0;
			while (true) {
				robot.delay((int)(delay+1000*(Math.random()-0.5))); // �ӳ�1.5s
				robot.keyPress(KeyEvent.VK_SPACE); // ����������ֵΪint
				int j = (int) ((Math.random()-0.5) * 50 + 110);    
				robot.delay(j);
				robot.keyRelease(KeyEvent.VK_SPACE);
				//Color color = robot.getPixelColor(100, 100);
				//System.out.println(color);
				i++;
			}
		} catch (AWTException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
