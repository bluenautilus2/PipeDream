package twofishes.pipedream.pipe;

import java.util.ArrayList;



public class StarterPipes extends ArrayList<Class<? extends AbsPipe>> {
 
	private static final long serialVersionUID = 1;
	
	StarterPipes(){
		super.add(StarterPipeEast.class);
		super.add(StarterPipeWest.class);
		super.add(StarterPipeNorth.class);
		super.add(StarterPipeSouth.class);
	}
}
