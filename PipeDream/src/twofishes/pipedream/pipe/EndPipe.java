package twofishes.pipedream.pipe;

import twofishes.pipedream.engine.goo.GooChangeListener;


public class EndPipe extends AbsPipe {

	@Override
	public Entrance getExit(Entrance entered) {
			return Entrance.BLOCKED;
		
	}
	
	@Override
	public Entrance getExit(GooChangeListener listener){
		return Entrance.BLOCKED;
	}
}
