package twofishes.pipedream.tile;

import twofishes.pipedream.pipe.*;

public class Tile {

	private AbsPipe currentPipe;

	private TileState currentState = TileState.EMPTY;

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
		if (currentState != TileState.EMPTY) {
			this.tileLocked = tileLocked;
		}
	}
	
	
	public TileState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(TileState currentState) {
		this.currentState = currentState;
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

}
