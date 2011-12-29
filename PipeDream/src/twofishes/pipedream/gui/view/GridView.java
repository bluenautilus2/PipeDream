package twofishes.pipedream.gui.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import twofishes.pipedream.tile.Tile;
import twofishes.pipedream.tile.TileModel;

public class GridView extends AbsView implements IGridView {
	
	private TileModel tileModel;
	
	private TileView selectedTile ;
	
	public GridView() {
		
	}
	
	public void setTileModel(TileModel tileModel) {
		this.removeAll() ;
		
		this.tileModel = tileModel;
		
		this.setLayout(new GridBagLayout());

		for(int i = 0; i < tileModel.getNumTilesWide(); i++) {
			for (int j = 0; j < tileModel.getNumTilesHigh(); j++) {
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = i;
				 c.gridy = tileModel.getNumTilesHigh()-j;
				
				//Add the panel to the GridBagConstraints
				TileView tileView = new TileView();

				Tile tile = this.tileModel.getTile(i, j);
				tileView.setTile(tile);
				
				tileView.setPreferredSize(new Dimension(50, 50));
				
				
				this.add(tileView, c);

				
			}
		}
	}
	
	public void setSelectedTile(Tile tile) {
		//Tile may or may not be part of TileModel
		
	}

	public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       
       
       Graphics2D g2 = (Graphics2D)g;
       
       g2.setColor(Color.BLACK);
       g2.drawRect(0, 0, 499, 399);
       // Any special drawing that needs to be done for the grid itself
    }

	public TileModel getTileModel() {
		return this.tileModel ;
	}
}
