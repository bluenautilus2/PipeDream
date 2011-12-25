package twofishes.pipedream.pipe.immovable;

import twofishes.pipedream.pipe.PipeMap;


public class UnmovablePipeMap extends PipeMap {
 
	UnmovablePipeMap(){
		addPipe(SlowDownHorizontalPipe.class);
		addPipe(SlowDownVerticalPipe.class);
		addPipe(SpeedUpHorizontalPipe.class);
		addPipe(SpeedUpVerticalPipe.class);
	}
}
