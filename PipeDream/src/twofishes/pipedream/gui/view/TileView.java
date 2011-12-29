package twofishes.pipedream.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import twofishes.pipedream.gui.controller.TileController;
import twofishes.pipedream.tile.Tile;

public class TileView extends AbsView implements ITileView, MouseListener {
	private Tile tile;
	
	public TileView() {
		addMouseListener(this);
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public void paintComponent(Graphics g)
    {
       super.paintComponent(g);

       
       
       Graphics2D g2 = (Graphics2D)g;
       
       g2.setColor(Color.BLACK);
       g2.drawRect(0, 0, 49, 49);
       //g2.drawLine(50, 0, 50, 50);
       
       
       //draw red rectangle
       g2.setColor(Color.RED);
       //g2.fillRect(0, 0, 10, 10);
    }

	public void mouseClicked(MouseEvent arg0) {
		//TODO Don't create new TileController here - Inject singleton instead
		TileController tileController = new TileController();
		tileController.handleClick(this.tile);
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
