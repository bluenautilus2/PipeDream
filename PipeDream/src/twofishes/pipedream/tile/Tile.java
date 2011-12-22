
package twofishes.pipedream.tile;

import twofishes.pipedream.pipe.*;

public class Tile {

	
	private AbsPipe currentPipe;
	
	private TileState currentState;
	
	private boolean tileLocked = false;
	
	

	public boolean isTileLocked() {
		return tileLocked;
	}

	public void setTileLocked(boolean tileLocked) {
		this.tileLocked = tileLocked;
	}
	
}
