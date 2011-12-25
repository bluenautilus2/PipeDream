package twofishes.pipedream.pipe;

import java.util.HashMap;


public class PipeMap {

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

	public Class<? extends AbsPipe> get(int index) {
		return pipeMap.get(index);
	}

	public int size() {
		return pipeMap.keySet().size();
	}

}