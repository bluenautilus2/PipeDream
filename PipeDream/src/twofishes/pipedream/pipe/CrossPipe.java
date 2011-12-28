package twofishes.pipedream.pipe;

/**
 * The most important pipe Gives mad bonuses
 * 
 * Made up of two different pipes underneath, but appears to the world and model
 * as one pipe.
 * 
 * @author bluenautilus2
 * 
 */
public class CrossPipe extends AbsPipe {

	private HorizontalPipe horizontalPipe;
	private VerticalPipe verticalPipe;

	public CrossPipe() {
		horizontalPipe = new HorizontalPipe();
		verticalPipe = new VerticalPipe();
	}

	@Override
	public Entrance getExit(Entrance entered) {
		if (isVertical(entered)) {
			return verticalPipe.getExit(entered);
		} else if (isHorizontal(entered)) {
			return horizontalPipe.getExit(entered);
		}
		return Entrance.BLOCKED;
	}

	public void gooEntering(Entrance entrance) {

		if(isVertical(entrance)){
			this.verticalPipe.gooEntering(entrance);
		}

		if (isHorizontal(entrance)) {
			this.horizontalPipe.gooEntering(entrance);
		}
	}
	
	//hmm.
	public void gooAdvance(){
		

	}
	
	
	/**
	 * Must be called when it has been determined that 
	 * the pipe is full.
	 * Note that due to threading and multiple pipes it is
	 * possible that both could be full on the same call.
	 */
	public void pipeFull(){
		if(this.verticalPipe.getCurrentState().equals(PipeState.FILLING)&&(this.verticalPipe.gooCount==0)){
			this.verticalPipe.pipeFull();
		}
		if(this.horizontalPipe.getCurrentState().equals(PipeState.FILLING)&&(this.horizontalPipe.gooCount==0)){
			this.horizontalPipe.pipeFull();
		}
		
	}
	
	//uhhh. hm.
	public Entrance getExit(){
		return null;
	}
	
	

	private boolean isVertical(Entrance entrance) {
		if (entrance.equals(Entrance.NORTH) || entrance.equals(Entrance.SOUTH)) {
			return true;
		}
		return false;
	}
	
	private boolean isHorizontal(Entrance entrance) {
		if (entrance.equals(Entrance.EAST) || entrance.equals(Entrance.WEST)) {
			return true;
		}
		return false;
	}

}
