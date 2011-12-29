package twofishes.pipedream.pipe;

import twofishes.pipedream.engine.goo.GooChangeListener;


public class SpeedUpHorizontalPipe extends HorizontalPipe {
    
	public void gooEntering(Entrance entrance, GooChangeListener listener)
			throws Exception {

		super.gooEntering(entrance, listener);
		listener.gooSpeedUp();
	}
	
}
