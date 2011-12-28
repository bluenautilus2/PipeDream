package twofishes.pipedream.pipe;

import twofishes.pipedream.tile.Tile;


public abstract class AbsPipe {

	private PipeState currentState = PipeState.EMPTY;
	
	/**
	 * How many times the goo advances before the
	 * pipe is full. Children can override
	 */
	protected int GOO_COUNT = 8;
	
	//Set if the tile has been laid down.
	private Tile tile = null;
	
	private Entrance entranceEntered = null;
	
	public abstract Entrance getExit(Entrance entered);
	
	public Entrance getExit(){
		if(entranceEntered!=null){
			return getExit(entranceEntered);
		}
		return null;
	}
	
	/**
	 * Called each time the goo advances on the pipe
	 */
	public void gooAdvance(){
		
		GOO_COUNT--;
		
		if(GOO_COUNT==0){
			this.setCurrentState(PipeState.FULL);
		}
		
		//@todo update pipe animation and fire gui event
	}
	

	/**
	 * Must be called when the pipe has been approved
	 * to receive the goo
	 * @param entrance
	 */
	public void gooEntering(Entrance entrance){
	
	    //Children can override this to trigger specific
		//Pipe Behavior
		//Like slowing down the goo, etc.
		this.setCurrentState(PipeState.FILLING);
		this.setEntranceEntered(entrance);
		
	}
	
	/**
	 * Must be called when it has been determined that 
	 * the pipe is full.
	 */
	public void pipeFull(){
		
		//Children can override this to trigger specific
		//Pipe Behavior
		this.setCurrentState(PipeState.FULL);
	}
	
	
	

	public PipeState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(PipeState currentState) {
		this.currentState = currentState;
	}

	public Entrance getEntranceEntered() {
		return entranceEntered;
	}

	public void setEntranceEntered(Entrance entranceEntered) {
		this.entranceEntered = entranceEntered;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	
	
}
