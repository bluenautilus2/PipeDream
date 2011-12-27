package twofishes.pipedream.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import twofishes.pipedream.gui.view.GridView;
import twofishes.pipedream.gui.view.StatsView;

public class GamePanel extends JPanel {
	
	GridView grid;
	StatsView stats;
	
	public GamePanel() {
		//TODO Set these dynamically
		this.stats = new StatsView();
		
		super.add(stats, BorderLayout.NORTH);
		super.setBorder(new EmptyBorder(8, 8, 8, 8));
	}

	public void setGrid(GridView grid) {
		this.grid = grid;
		super.add(grid, BorderLayout.SOUTH);
	}

	public void setStats(StatsView stats) {
		this.stats = stats;
	}
}
