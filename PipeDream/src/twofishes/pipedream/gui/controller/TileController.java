package twofishes.pipedream.gui.controller;

import twofishes.pipedream.tile.Tile;

public class TileController extends AbsController {
	public void handleClick(Tile tile) {
		System.out.println("Tile (" + tile.getX() + ", " + tile.getY() + ") clicked.");
	}

}
