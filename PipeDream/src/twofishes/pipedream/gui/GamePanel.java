package twofishes.pipedream.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import twofishes.pipedream.gui.view.GridView;
import twofishes.pipedream.gui.view.StatsView;

public class GamePanel extends JPanel {
	public GamePanel() {
		//TODO Don't use concrete implementation
		GridView grid = new GridView();
		StatsView stats = new StatsView();
		
		super.add(stats, BorderLayout.NORTH);
		super.add(grid, BorderLayout.SOUTH);
		super.setBorder(new EmptyBorder(8, 8, 8, 8));
	}
}
