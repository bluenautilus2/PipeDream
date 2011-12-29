package twofishes.pipedream.gui.view;

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
				Tile tile = this.tileModel.getTile(i, j);
				updateTile(tile, i, j) ;
			}
		}
	}
	
	public void setSelectedTile(Tile tile) {
		//Tile may or may not be part of TileModel
		
	}
	
	private void updateTile(Tile tile, int i, int j) {
		//Tile may or may not be part of TileModel
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = i;
		c.gridy = tileModel.getNumTilesHigh()-j;

		//Add the panel to the GridBagConstraints
		TileView tileView = new TileView();
		tileView.setTile(tile);
		
		this.add(tileView, c);
	}

	public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       
       // Any special drawing that needs to be done for the grid itself
    }

	public TileModel getTileModel() {
		return this.tileModel ;
	}
}
