package twofishes.pipedream.engine;

import java.util.Random;

import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.PipeMap;

public class PipeGenerator {

	protected PipeMap pipeMap;

	protected Random random = null;

	public PipeGenerator(PipeMap pipeMap) {
		this.pipeMap = pipeMap;
		random = new Random(System.currentTimeMillis());
	}

	public AbsPipe getNewPipe() {
		
		int positiveNextInt = Math.abs(random.nextInt()); 
		int index = positiveNextInt % (pipeMap.size());
		Class<? extends AbsPipe> pipeClass = pipeMap.get(index);
		try {
			return pipeClass.newInstance();
		} catch (Exception e) {
			System.out.println("Exception Thrown from PipeGenerator: " + e);
			e.printStackTrace();
		}
		return null;

	}

}
