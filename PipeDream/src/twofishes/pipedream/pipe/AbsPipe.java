package twofishes.pipedream.pipe;

import java.util.ArrayList;

public abstract class AbsPipe {

	protected PipeState currentState = PipeState.EMPTY;
	
	
	public abstract Entrance getExit(Entrance entered);
	  
	
	
	
	
	
	
	
}
