package ren.junsong.util;
  
import java.awt.AWTException;
import java.awt.event.KeyEvent;

public class DebugBufferRobet {
	public static void main(String[] args) {
		try {
			BufferRobot br=new BufferRobot();
			while(true){
				br.delay(1500);
				br.type(KeyEvent.VK_SPACE);
			}

		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	} 
}
   