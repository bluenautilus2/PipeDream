package twofishes.pipedream.engine;

import twofishes.pipedream.pipe.immovable.StarterPipeEast;
import twofishes.pipedream.pipe.immovable.StarterPipeNorth;
import twofishes.pipedream.pipe.immovable.StarterPipeSouth;
import twofishes.pipedream.pipe.immovable.StarterPipeWest;


public class StarterPipeMap extends PipeMap {
 
	StarterPipeMap(){
		addPipe(StarterPipeEast.class);
		addPipe(StarterPipeWest.class);
		addPipe(StarterPipeNorth.class);
		addPipe(StarterPipeSouth.class);
	}
}
