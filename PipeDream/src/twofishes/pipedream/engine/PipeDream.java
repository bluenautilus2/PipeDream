package twofishes.pipedream.engine;

import java.awt.Dimension;

import javax.swing.JFrame;

import twofishes.pipedream.gui.*;

public class PipeDream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MainFrame theFrame = new MainFrame();
		
		//TODO move this stuff into MainFrame constructor
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		theFrame.setTitle("PipeDream") ;
		theFrame.setPreferredSize(new Dimension(100,100)) ; //remove later
	
		theFrame.pack();
		theFrame.setVisible(true);

	}

}
