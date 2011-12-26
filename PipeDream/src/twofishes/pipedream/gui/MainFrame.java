package twofishes.pipedream.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import twofishes.pipedream.gui.view.GridView;

public class MainFrame extends JFrame {

	public MainFrame() {

		//TODO Don't declare concrete implementation. Use Interface instead. Use for Injection?
		GridView grid = new GridView();
		setContentPane(grid);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		setTitle("PipeDream") ;
		setPreferredSize(new Dimension(1000,1000)) ; //remove later
	}
}
