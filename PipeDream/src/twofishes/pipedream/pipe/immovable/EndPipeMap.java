package twofishes.pipedream.pipe.immovable;

import twofishes.pipedream.pipe.PipeMap;

public class EndPipeMap extends PipeMap {
 
	EndPipeMap(){
		addPipe(EndPipeEast.class);
		addPipe(EndPipeWest.class);
		addPipe(EndPipeNorth.class);
		addPipe(EndPipeSouth.class);
	}
}
