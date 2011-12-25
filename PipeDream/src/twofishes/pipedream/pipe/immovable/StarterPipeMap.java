package twofishes.pipedream.pipe.immovable;

import twofishes.pipedream.pipe.PipeMap;


public class StarterPipeMap extends PipeMap {
 
	StarterPipeMap(){
		addPipe(StarterPipeEast.class);
		addPipe(StarterPipeWest.class);
		addPipe(StarterPipeNorth.class);
		addPipe(StarterPipeSouth.class);
	}
}
