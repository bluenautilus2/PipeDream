package twofishes.pipedream.pipe;

import twofishes.pipedream.tile.Tile;


public abstract class AbsPipe {

	private PipeState currentState = PipeState.EMPTY;
	
	/**
	 * How many times the goo advances before the
	 * pipe is full. Children can override
	 */
	protected int gooCount = 8;
	
	//Set if the tile has been laid down.
	protected Tile tile = null;
	
	public abstract Entrance getExit(Entrance entered);
	
	/**
	 * Called each time the goo advances on the pipe
	 */
	public void gooAdvance(){
		if(getCurrentState().equals(PipeState.EMPTY)){
			setCurrentState(PipeState.FILLING);
		}
		
		gooCount--;
		
		if(gooCount==0){
			this.setCurrentState(PipeState.FULL);
		}
		
		//update pipe animation and fire gui event
		//@todo
	}
	
	public void setToTile(Tile tile){
		this.tile = tile;
	}
	
	protected void gooEntered(){
		this.setCurrentState(PipeState.FILLING);
	    //Children can override this to trigger specific
		//Pipe Behavior
		
	}
	
	protected void pipeFull(){
		this.setCurrentState(PipeState.FULL);
		//Children can override this to trigger specific
		//Pipe Behavior
		
	}

	public PipeState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(PipeState currentState) {
		this.currentState = currentState;
	}
	
	
	
	
	
}
