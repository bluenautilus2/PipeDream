package twofishes.pipedream.engine;

import java.util.ArrayList;

import twofishes.pipedream.pipe.AbsPipe;

public class PipeQueue {
   
	private ArrayList<AbsPipe> pipeList;
	
	private int FRONT_OF_QUEUE = 0;
	
	
	
	public PipeQueue(int size){
		pipeList = new ArrayList<AbsPipe>(size);
	}
	
	public void add(AbsPipe newPipe){
		pipeList.add(newPipe);
	}
	
	public AbsPipe pop(){
		return pipeList.remove(FRONT_OF_QUEUE);
	}
	
	public AbsPipe peek(){
		return pipeList.get(FRONT_OF_QUEUE);
	}
	
	
	
	
	
}
