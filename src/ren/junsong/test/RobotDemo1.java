package ren.junsong.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import ren.junsong.util.BufferRobot;

/**
 * Space
 * 
 * @author famugoing
 *
 */
public class RobotDemo1 {
	public static void main(String[] args) throws AWTException {

		SpaceFish spaceFish = new SpaceFish();
		Thread fish = new Thread(spaceFish, "自动空格");
		SpaceCheck spaceCheck = new SpaceCheck();
		Thread fishGame = new Thread(spaceCheck, "自动游戏");
		AutoBait autoBait = new AutoBait();
		Thread bait = new Thread(autoBait, "自动鱼饵");

		fish.start();
		fishGame.start();
		//bait.start();
	}
}

/**
 * 此线程用于确保一直钓鱼
 * 
 * @author famugoing
 *
 */
class SpaceFish implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				BufferRobot bspaceFish = new BufferRobot();
				if (bspaceFish.getAndEqualsColor(1081, 517, 233, 233, 233, 8)
						&& bspaceFish.getAndEqualsColor(1053, 506, 183, 183, 183, 8)
						&& bspaceFish.getAndEqualsColor(1038, 530, 128, 128, 128, 8)) {
					bspaceFish.type(KeyEvent.VK_SPACE);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 此线程用于确保钓鱼过程中的小游戏成功
 * 
 * @author famugoing
 *
 */
class SpaceCheck implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				BufferRobot bspaceCheck = new BufferRobot();
				if (bspaceCheck.getAndEqualsColor(832, 624, 255, 217, 46, 10)
						&& bspaceCheck.getAndEqualsColor(796, 623, 255, 217, 46, 10)
						&& bspaceCheck.getAndEqualsColor(792, 648, 237, 170, 1, 10)) {
					if ( bspaceCheck.getAndEqualsColor(875, 682, 82, 222, 237, 30)) {
						Thread.sleep(150);
						bspaceCheck.type(KeyEvent.VK_SPACE);
					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}

	}

}

/**
 * 此线程用于自动给鱼饵
 * 
 * @author famugoing
 *
 */
class AutoBait implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(540000);
				BufferRobot bAutoBait = new BufferRobot();
				boolean isBait=bAutoBait.getAndEqualsColor(669,886, 240,240, 240, 15)
						&& bAutoBait.getAndEqualsColor(674, 886,238,238,238, 15)
						&& bAutoBait.getAndEqualsColor(674,893, 0, 0, 0, 15);
				if (!isBait) {
					bAutoBait.delay(5000);
					bAutoBait.type(KeyEvent.VK_2);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}

	}

}