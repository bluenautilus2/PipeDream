package twofishes.pipedream.pipe;

import java.util.ArrayList;


public class EndPipes extends ArrayList<Class<? extends AbsPipe>> {
 
	private static final long serialVersionUID = 1;
	
	EndPipes(){
		super.add(EndPipeEast.class);
		super.add(EndPipeWest.class);
		super.add(EndPipeNorth.class);
		super.add(EndPipeSouth.class);
	}
}
