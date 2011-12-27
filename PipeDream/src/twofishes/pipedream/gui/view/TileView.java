package twofishes.pipedream.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import twofishes.pipedream.tile.Tile;

public class TileView extends AbsView implements ITileView {
	private Tile tile;
	
	public TileView() {
		
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public void paintComponent(Graphics g)
    {
       super.paintComponent(g);

       Graphics2D g2 = (Graphics2D)g;
       
       //draw black background
       g2.setColor(Color.BLACK);
       g2.fillRect(0, 0, this.getWidth(),  this.getHeight());
       
       //draw red rectangle
       g2.setColor(Color.RED);
       g2.fillRect(0, 0, 2, 2);
    }
}
