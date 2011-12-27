package twofishes.pipedream.gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import twofishes.pipedream.tile.TileModel;

public class GridView extends AbsView implements IGridView {
	
	private TileModel tileModel;
	
	public GridView() {
		
	}
	
	public void setTileModel(TileModel tileModel) {
		this.tileModel = tileModel;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for(int i = 0; i < tileModel.getNumTilesHigh(); i++) {
			for (int j = 0; j < tileModel.getNumTilesHigh(); j++) {
				c.gridx = i;
				c.gridy = j;
				
				//Add the panel to the GridBagConstraints
				//TODO Get the correct tileView
				TileView tileView = new TileView();
				this.add(tileView, c);
			}
		}
		
	}
	
	public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       
       // Any special drawing that needs to be done for the grid itself
    }
}
