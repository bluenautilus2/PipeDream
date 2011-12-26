package twofishes.pipedream.pipe;

import java.util.ArrayList;


public class UnmovablePipes extends ArrayList<Class<? extends AbsPipe>> {
 
	private static final long serialVersionUID = 1;
	
	UnmovablePipes(){
		super.add(SlowDownHorizontalPipe.class);
		super.add(SlowDownVerticalPipe.class);
		super.add(SpeedUpHorizontalPipe.class);
		super.add(SpeedUpVerticalPipe.class);
	}
}
