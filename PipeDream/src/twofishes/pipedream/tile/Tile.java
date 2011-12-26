package twofishes.pipedream.tile;

import twofishes.pipedream.pipe.*;

public class Tile {

	private AbsPipe currentPipe;

	private boolean destroying = false;

	private boolean tileLocked = false;

	private int x = 0;

	private int y = 0;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isTileLocked() {
		return tileLocked;
	}

	public void setTileLocked(boolean tileLocked) {
		//can't lock empty tiles
		if(this.currentPipe==null){
			this.tileLocked = tileLocked;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public AbsPipe getCurrentPipe() {
		return currentPipe;
	}

	public void setCurrentPipe(AbsPipe currentPipe) {
		this.currentPipe = currentPipe;
		currentPipe.setTile(this);
	}

	public boolean isDestroying() {
		return destroying;
	}

	public void setDestroying(boolean destroying) {
		this.destroying = destroying;
	}

}
