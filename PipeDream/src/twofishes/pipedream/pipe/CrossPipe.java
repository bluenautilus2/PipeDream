package twofishes.pipedream.pipe;

import twofishes.pipedream.engine.goo.GooChangeListener;

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
		// only way to get here is to pass in Blocked
		return Entrance.BLOCKED;
	}

	@Override
	public void gooEntering(Entrance entrance, GooChangeListener listener)
			throws Exception {
		this.gooChangeListener = listener;
		
		if (isVertical(entrance)) {
			this.verticalPipe.gooEntering(entrance, listener);
		}

		if (isHorizontal(entrance)) {
			this.horizontalPipe.gooEntering(entrance, listener);
		}
	}
	
	@Override
	public Entrance gooAdvance(GooChangeListener listener) throws Exception {
		
		//gooAdvance shouldn't get called on empty pipes 
		if(this.verticalPipe.gooCount==0&&this.horizontalPipe.gooCount==0){
			throw new Exception("Shouldn't call gooAdvance() on empty pipes");
		}
		
		AbsPipe pipe = this.getTargetPipe(listener);
		if (pipe != null) {
			return pipe.gooAdvance(listener);
		}
		return Entrance.BLOCKED;
	}

	/**
	 * Must be called when it has been determined that the pipe is full. Note
	 * that due to threading and multiple pipes it is possible that both could
	 * be full on the same call.
	 */
	@Override
	public void pipeFull(GooChangeListener listener) throws Exception {
		AbsPipe pipe = this.getTargetPipe(listener);
		if (pipe != null) {
			pipe.pipeFull(listener);
		}
	}

	@Override
	protected void setState(PipeState state, GooChangeListener listener)
			throws Exception {
		AbsPipe pipe = this.getTargetPipe(listener);
		if (pipe != null) {
			pipe.setState(state, listener);
		}
	}

	@Override
	public PipeState getState(GooChangeListener listener) throws Exception {
		//If they both have the same state, return it.
		//this is the case when neither pipe has flow.
		PipeState temp = this.verticalPipe.getState(listener);
		if(temp.equals(this.horizontalPipe.getState(listener))){
			return temp;
		}
		
		//Otherwise, one has changed state. Determine correct
		//pipe to return.
		AbsPipe pipe = this.getTargetPipe(listener);
		if (pipe != null) {
			return pipe.getState(listener);
		}
		
		return null;
	}
	/**
	 * 
	 * @param listener
	 * @return
	 * @throws Exception
	 */
	private AbsPipe getTargetPipe(GooChangeListener listener) throws Exception {
		boolean horiz = false;
		boolean vert = false;
		if (listener.equals(this.horizontalPipe.gooChangeListener)) {
			horiz = true;
		}
		if (listener.equals(this.verticalPipe.gooChangeListener)) {
			vert = true;
		}
		if (vert && !horiz) {
			return this.verticalPipe;
		}
		if (!vert && horiz) {
			return this.horizontalPipe;
		}

		/**
		 * When only one flow is active and the pipe crossed around, both pipes
		 * will be filled by the same source
		 */
		if (vert && horiz) {
			if (this.verticalPipe.getState(gooChangeListener).equals(PipeState.FULL)
					&& (!this.horizontalPipe.getState(gooChangeListener).equals(PipeState.FULL))) {
				return this.horizontalPipe;
			}
			if ((!this.verticalPipe.getState(gooChangeListener).equals(PipeState.FULL))
					&& (this.horizontalPipe.getState(gooChangeListener).equals(PipeState.FULL))) {
				return this.verticalPipe;
			}
			throw new Exception("Internal crosspipe exception:"
					+ " two cross pipes can't be filling from "
					+ "the same source at the same time.");
		}

		if (!vert && !horiz) {
			throw new Exception("Internal crosspipe exception: "
					+ "Tried to retrieve vert or horiz"
					+ " pipe but neither initialized");
		}
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

	/**
	 * Used for testing and troubleshooting
	 * 
	 * @return
	 */
	public boolean isHorizontalPipeFull() throws Exception {

		if (this.horizontalPipe.getState(gooChangeListener).equals(PipeState.FULL)) {
			return true;
		}
		return false;
	}

	/**
	 * Used for testing, troubleshooting
	 * 
	 * @return
	 */
	public boolean isVerticalPipeFull() throws Exception {
		if (this.verticalPipe.getState(gooChangeListener).equals(PipeState.FULL)) {
			return true;
		}
		return false;
	}

}
