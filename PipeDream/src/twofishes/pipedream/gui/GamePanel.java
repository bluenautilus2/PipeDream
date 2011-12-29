package twofishes.pipedream.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import twofishes.pipedream.gui.view.GridView;
import twofishes.pipedream.gui.view.StatsView;
import twofishes.pipedream.stats.Stats;

public class GamePanel extends JPanel {
	
	GridView grid;
	StatsView stats;
	
	public GamePanel() {
		//TODO Set these dynamically
		//TODO fix this constructor
		this.stats = new StatsView(new Stats());
		this.stats.setPreferredSize(new Dimension(500,100));
		
		super.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		super.add(stats, c);
	}

	public void setGrid(GridView grid) {
		this.grid = grid;
		//TOOD Hard coded for now
		grid.setPreferredSize(new Dimension(500,400));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=1;
		
		super.add(grid, c);
	}

	public void setStats(StatsView stats) {
		this.stats = stats;
	}
}
