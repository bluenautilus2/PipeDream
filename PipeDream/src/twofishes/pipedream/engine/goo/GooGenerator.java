package twofishes.pipedream.engine.goo;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Generates Goo events for one flow If multiple pipes, one goo generator for
 * each starting point.
 * 
 * @author bluenautils2
 * 
 *         should this be a timer task? will look it up when i have internet
 *         access again.
 */
public class GooGenerator implements GooChangeListener {

	private int gooInterval = 1000; // default to one second

	private boolean makeMoreGoo = true;

	ArrayList<GooGeneratedListener> listeners = new ArrayList<GooGeneratedListener>();

	public void addListener(GooGeneratedListener listener) {
		listeners.add(listener);
	}

	public void gooSpeedUp() {
		gooInterval = gooInterval / 2;
	}

	public void gooSlowDown() {
		gooInterval = gooInterval * 2;
	}

	public void gooBlocked() {
		this.makeMoreGoo = false;
	}

	public void run() {
		while (this.makeMoreGoo) {
			try {
				//want to replace this with something more
				//refined at a later time
				Thread.currentThread().sleep(gooInterval);
			} catch (InterruptedException ie) {
				this.makeMoreGoo = false;
			}

			for(GooGeneratedListener ggl:listeners){
				ggl.gooAdvanced();
			}
		}
	}
	
	
}
