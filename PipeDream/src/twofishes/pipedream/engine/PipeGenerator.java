package twofishes.pipedream.engine;

import java.util.HashMap;
import java.util.Random;

import twofishes.pipedream.pipe.*;

public class PipeGenerator {

	private PipeMap pipeMap;

	private Random random = null;

	public PipeGenerator() {
		pipeMap = new PipeMap();
		random = new Random(System.currentTimeMillis());

	}

	public AbsPipe getNewPipe() {
		int index = random.nextInt() % (pipeMap.size());
		Class<? extends AbsPipe> pipeClass = pipeMap.get(index);
		try {
			return pipeClass.newInstance();
		} catch (Exception e) {
			// what the hell do i do here?
		}

		return null;

	}

	class PipeMap {

		private HashMap<Integer, Class<? extends AbsPipe>> pipeMap;

		private int count = 0;

		public PipeMap() {
			pipeMap = new HashMap<Integer, Class<? extends AbsPipe>>();
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

		private void addPipe(Class<? extends AbsPipe> pipeClass) {
			pipeMap.put(count++, pipeClass);
		}

		public Class<? extends AbsPipe> get(int index) {
			return pipeMap.get(index);
		}

		public int size() {
			return pipeMap.keySet().size();
		}

	}

}
