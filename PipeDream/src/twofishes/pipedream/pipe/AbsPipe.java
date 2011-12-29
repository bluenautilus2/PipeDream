package twofishes.pipedream.pipe;

import twofishes.pipedream.engine.goo.GooChangeListener;
import twofishes.pipedream.tile.Tile;

public abstract class AbsPipe {

	private PipeState state = PipeState.EMPTY;

	/**
	 * How many times the goo advances before the pipe is full. Children can
	 * override
	 */
	protected int gooCount = 8;

	// Set if the pipe is set into a tile
	private Tile tile = null;

	private Entrance entranceEntered = null;

	public abstract Entrance getExit(Entrance entered);

	/**
	 * for pipes that affect goo
	 */
	public GooChangeListener gooChangeListener;

	/**
	 * GooChangeListener provided for child pipes that call it to speed up or
	 * slow down flow. Also used by cross pipe to identify source of flow.
	 * 
	 * @param gooChangeListener
	 * @return
	 */
	public Entrance getExit(GooChangeListener gooChangeListener)
			throws Exception {

		if (entranceEntered != null) {
			return getExit(entranceEntered);
		}
		return null;
	}

	/**
	 * Must be called when the pipe has been approved to receive the goo
	 * 
	 * @param entrance
	 */
	public void gooEntering(Entrance entrance, GooChangeListener listener)
			throws Exception {

		// Children can override this to trigger specific
		// Pipe Behavior
		// Like slowing down the goo, etc.

		this.setState(PipeState.FILLING, listener);
		this.setEntranceEntered(entrance);
		this.gooChangeListener = listener;

	}

	/**
	 * Called each time the goo advances on the pipe
	 * 
	 * GooEvent used by special pipes
	 */
	public void gooAdvance(GooChangeListener gooChangeListener)
			throws Exception {

		if (this.entranceEntered == null) {
			throw new Exception("Internal AbsPipe exception:"
					+ " called goodAdvance before gooEntering");
		}

		gooCount--;

		// @todo update pipe animation and fire gui event

		if (gooCount == 0) {
			this.setState(PipeState.FULL, gooChangeListener);
		}

	}

	/**
	 * Must be called when it has been determined that the pipe is full.
	 * 
	 * GooChangeListener used by special pipes
	 */
	public void pipeFull(GooChangeListener listener) throws Exception {

		// Children can override this to trigger specific
		// Pipe Behavior
		this.setState(PipeState.FULL, listener);
	}

	public PipeState getState(GooChangeListener listener) throws Exception {
		return state;
	}

	protected void setState(PipeState state, GooChangeListener listener) throws Exception {
		this.state = state;
	}

	public Entrance getEntranceEntered() {
		return entranceEntered;
	}

	public void setEntranceEntered(Entrance entranceEntered) {
		this.entranceEntered = entranceEntered;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

}
