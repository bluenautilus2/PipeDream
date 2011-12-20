package twofishes.pipedream.engine;

import java.util.HashMap;
import java.util.Random;

import twofishes.pipedream.pipe.*;

public class PipeGenerator {

	
	
	
	
	public PipeGenerator(){
		
	}
	
	public AbsPipe getNewPipe(){
		return null;
	}
	
	
	
	
	
	public class PipeMap{
		
		private HashMap<Integer,Class<? extends AbsPipe>> pipeMap;
		
		private int count = 0;
		
		public PipeMap(){
			pipeMap = new HashMap<Integer,Class<? extends AbsPipe>>();
			addPipe(VerticalPipe.class);
			addPipe(HorizontalPipe.class);
			addPipe(NorthEastElbowPipe.class);
			
		}
		
		private void addPipe(Class<? extends AbsPipe> pipeClass){
			pipeMap.put(count++,pipeClass);
		}
		
	}
	
}
