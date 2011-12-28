package twofishes.pipedream.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class StatsView extends AbsView {
	public void paintComponent(Graphics g)
    {
       super.paintComponent(g);

       Graphics2D g2 = (Graphics2D)g;
       
       //draw black background
       g2.setColor(Color.BLACK);
       g2.fillRect(0, 0, this.getWidth(),  this.getHeight());
       
       //draw red rectangle
       g2.setColor(Color.GREEN);
       g2.fillRect(0, 0, 50, 500);
    }
}
