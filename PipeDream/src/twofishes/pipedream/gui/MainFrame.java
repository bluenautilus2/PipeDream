package twofishes.pipedream.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		setTitle("PipeDream") ;
		setPreferredSize(new Dimension(1000,1000)) ; //remove later
	}
}
