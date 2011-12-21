package twofishes.pipedream.engine;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import twofishes.pipedream.gui.*;

public class PipeDream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MainFrame theFrame = new MainFrame();
		theFrame.pack();
		theFrame.setVisible(true);
		theFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
			System.exit(0);
			}
		});

	}

}
