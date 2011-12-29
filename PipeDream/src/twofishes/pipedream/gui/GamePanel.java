package twofishes.pipedream.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import twofishes.pipedream.gui.view.GridView;
import twofishes.pipedream.gui.view.StatsView;

public class GamePanel extends JPanel {
	
	private GridView grid;
	private StatsView stats;
	
	private JScrollPane gridScrollPane = new JScrollPane() ;
	
	public GamePanel() {
		this.setLayout(new BorderLayout()) ;
		super.add(gridScrollPane, BorderLayout.CENTER);
		super.setBorder(new EmptyBorder(8, 8, 8, 8));
		
		//TODO Set these dynamically
		setStats(new StatsView()) ;

	}

	public void setGrid(GridView grid) {
		this.grid = grid;
		gridScrollPane.setViewportView(this.grid) ;

	}

	public void setStats(StatsView stats) {
		this.stats = stats;
		super.add(this.stats, BorderLayout.NORTH);
	}
}
