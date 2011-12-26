package twofishes.pipedream.engine;

import java.util.ArrayList;

import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.MovablePipes;

/**
 * Maintains a full queue of pipes at all times
 * when you pop one off the queue, it adds a new one to
 * the tail
 * 
 * @author bluenautilus2
 *
 */

public class PipeQueue {
   
	private ArrayList<AbsPipe> pipeList;
	
	private int FRONT_OF_QUEUE = 0;
	
	private PipeGenerator pipeGenerator;
	
	public PipeQueue(int size, MovablePipes pipeMap){
		pipeGenerator = new PipeGenerator(pipeMap);
		pipeList = new ArrayList<AbsPipe>(size);
		for(int i=0; i<size; i++){
			this.add(pipeGenerator.getNewPipe());
		}
	}
	
	public void add(AbsPipe newPipe){
		pipeList.add(newPipe);
	}
	
	public AbsPipe pop(){
		this.add(pipeGenerator.getNewPipe());
		return pipeList.remove(FRONT_OF_QUEUE);
	}
	
	public AbsPipe peek(){
		return pipeList.get(FRONT_OF_QUEUE);
	}
	
	public AbsPipe peek(int i){
		return pipeList.get(i);
	}
	
	public int size(){
		return pipeList.size();
	}
	
	
	
	
	
}
