package twofishes.pipedream.engine;

import twofishes.pipedream.pipe.immovable.SlowDownHorizontalPipe;
import twofishes.pipedream.pipe.immovable.SlowDownVerticalPipe;
import twofishes.pipedream.pipe.immovable.SpeedUpHorizontalPipe;
import twofishes.pipedream.pipe.immovable.SpeedUpVerticalPipe;


public class UnmovablePipeMap extends PipeMap {
 
	UnmovablePipeMap(){
		addPipe(SlowDownHorizontalPipe.class);
		addPipe(SlowDownVerticalPipe.class);
		addPipe(SpeedUpHorizontalPipe.class);
		addPipe(SpeedUpVerticalPipe.class);
	}
}
