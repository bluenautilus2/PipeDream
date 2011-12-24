package twofishes.pipedream.engine;

import java.util.HashMap;

import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.CrossPipe;
import twofishes.pipedream.pipe.HorizontalPipe;
import twofishes.pipedream.pipe.NorthEastElbowPipe;
import twofishes.pipedream.pipe.NorthWestElbowPipe;
import twofishes.pipedream.pipe.OneWayEastPipe;
import twofishes.pipedream.pipe.OneWayNorthPipe;
import twofishes.pipedream.pipe.OneWaySouthPipe;
import twofishes.pipedream.pipe.OneWayWestPipe;
import twofishes.pipedream.pipe.SouthEastElbowPipe;
import twofishes.pipedream.pipe.SouthWestElbowPipe;
import twofishes.pipedream.pipe.VerticalPipe;

class PipeMap {

	protected HashMap<Integer, Class<? extends AbsPipe>> pipeMap = new HashMap<Integer, Class<? extends AbsPipe>>();

	protected int count = 0;

	public PipeMap() {
		
		addPipe(VerticalPipe.class);
		addPipe(HorizontalPipe.class);
		addPipe(NorthEastElbowPipe.class);
		addPipe(NorthWestElbowPipe.class);
		addPipe(OneWayEastPipe.class);
		addPipe(OneWayWestPipe.class);
		addPipe(OneWayNorthPipe.class);
		addPipe(OneWaySouthPipe.class);
		addPipe(SouthEastElbowPipe.class);
		addPipe(SouthWestElbowPipe.class);
		addPipe(CrossPipe.class);
	}

	protected void addPipe(Class<? extends AbsPipe> pipeClass) {
		pipeMap.put(count++, pipeClass);
	}

	protected Class<? extends AbsPipe> get(int index) {
		return pipeMap.get(index);
	}

	public int size() {
		return pipeMap.keySet().size();
	}

}