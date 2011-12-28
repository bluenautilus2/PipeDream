package twofishes.pipedream.engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twofishes.pipedream.engine.goo.GooChangeListener;
import twofishes.pipedream.engine.goo.GooGenerator;
import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.HorizontalPipe;
import twofishes.pipedream.pipe.SouthWestElbowPipe;
import twofishes.pipedream.pipe.*;

import twofishes.pipedream.tile.TileModel;

import junit.framework.TestCase;

public class TestPipeModel extends TestCase implements GooChangeListener {

	protected int GOO_COUNT = 8;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Simple setup - pipe goes east and then ends.
	 */
	@Test
	public void testStraightPipe() {
        resetCalled();
        
		TileModel playingField = new TileModel(20, 20);
		GooGenerator gooGen = new GooGenerator();

		AbsPipe pipe = new StarterPipeEast();
		playingField.getTile(5, 10).setCurrentPipe(pipe);

		//doesn't include first starter pipe
		int pipeNum = 5;
		
		for (int i = 6; i < (6+pipeNum); i++) {
			AbsPipe newPipe = new HorizontalPipe();
			playingField.getTile(i, 10).setCurrentPipe(newPipe);
		}

		PipeModel pipeModel = new PipeModel(playingField, gooGen, pipe);
		pipeModel.addGooChangeListener(this);

		assertTrue(playingField.getTile(7, 10).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		
		for (int i = 0; i < ((pipeNum)*GOO_COUNT)-1; i++) {
			pipeModel.gooAdvanced();
		}
		assertTrue(playingField.getTile(7, 10).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(playingField.getTile(10, 10).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		assertTrue(gooBlockedCalled == false);
	
		for (int i = 0; i < (GOO_COUNT/2); i++) {
			pipeModel.gooAdvanced();
		}
		
		assertTrue(playingField.getTile(10, 10).getCurrentPipe().getCurrentState().equals(PipeState.FILLING));
		
		//should try to advance beyond end of last pipe
		for (int i = 0; i < GOO_COUNT; i++) {
			pipeModel.gooAdvanced();
		}
		assertTrue(playingField.getTile(10, 10).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(gooBlockedCalled == true);

	}

	/**
	 * Pipe snakes around a bit and then ends
	 */
	@Test
	public void testCurvyPipe() {
        resetCalled();
        
		TileModel playingField = new TileModel(20, 20);
		GooGenerator gooGen = new GooGenerator();

		AbsPipe pipe = new StarterPipeEast();
		playingField.getTile(10, 10).setCurrentPipe(pipe);

	    playingField.getTile(11, 10).setCurrentPipe(new SouthWestElbowPipe());
	    playingField.getTile(11, 9).setCurrentPipe(new VerticalPipe());
	    playingField.getTile(11, 8).setCurrentPipe(new NorthWestElbowPipe());
	    playingField.getTile(10, 8).setCurrentPipe(new OneWayWestPipe());
	    playingField.getTile(9, 8).setCurrentPipe(new SouthEastElbowPipe());
	    playingField.getTile(9, 7).setCurrentPipe(new NorthEastElbowPipe());
	    playingField.getTile(10, 7).setCurrentPipe(new HorizontalPipe());
	   
		PipeModel pipeModel = new PipeModel(playingField, gooGen, pipe);
		pipeModel.addGooChangeListener(this);

		assertTrue(playingField.getTile(10, 10).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		
		for (int i = 0; i < 50; i++) {
			pipeModel.gooAdvanced();
		}
		
		assertTrue(playingField.getTile(10, 10).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(playingField.getTile(9, 7).getCurrentPipe().getCurrentState().equals(PipeState.FILLING));
		assertTrue(playingField.getTile(10, 7).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		assertTrue(gooBlockedCalled == false);
		
		for (int i = 0; i < 16; i++) {
			pipeModel.gooAdvanced();
		}
		assertTrue(playingField.getTile(10, 7).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(gooBlockedCalled == true);

	}
	
	/**
	 * Pipe runs smack into the wall... the test here is not that a wall
	 * is found, but rather lack of tile to put a pipe on.
	 */
	@Test
	public void testPipeIntoWall() {
        resetCalled();
        
		TileModel playingField = new TileModel(5, 5);
		GooGenerator gooGen = new GooGenerator();

		AbsPipe pipe = new StarterPipeWest();
		playingField.getTile(3, 3).setCurrentPipe(pipe);

	    playingField.getTile(2,3).setCurrentPipe(new SouthEastElbowPipe());
	    playingField.getTile(2,2).setCurrentPipe(new VerticalPipe());
	    playingField.getTile(2,1).setCurrentPipe(new VerticalPipe());
	    playingField.getTile(2,0).setCurrentPipe(new NorthWestElbowPipe());
	    playingField.getTile(1,0).setCurrentPipe(new HorizontalPipe());
	    playingField.getTile(0,0).setCurrentPipe(new HorizontalPipe());
	    
		PipeModel pipeModel = new PipeModel(playingField, gooGen, pipe);
		pipeModel.addGooChangeListener(this);

		assertTrue(playingField.getTile(3, 3).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		
		for (int i = 0; i < (5*GOO_COUNT); i++) {
			pipeModel.gooAdvanced();
		}
		
		assertTrue(playingField.getTile(2, 2).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(playingField.getTile(1,0).getCurrentPipe().getCurrentState().equals(PipeState.FILLING));
		assertTrue(playingField.getTile(0, 0).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		assertTrue(gooBlockedCalled == false);
		
		for (int i = 0; i < (GOO_COUNT*2); i++) {
			pipeModel.gooAdvanced();
		}
		assertTrue(playingField.getTile(0, 0).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(gooBlockedCalled == true);

	}
	
    
	/**
	 *  pipe hits another pipe not connected correctly
	 */
	@Test
	public void testPipeWrongDirection() {
        resetCalled();
        
		TileModel playingField = new TileModel(5, 5);
		GooGenerator gooGen = new GooGenerator();

		AbsPipe pipe = new StarterPipeWest();
		playingField.getTile(3, 3).setCurrentPipe(pipe);

	    playingField.getTile(2,3).setCurrentPipe(new SouthEastElbowPipe());
	    playingField.getTile(2,2).setCurrentPipe(new VerticalPipe());
	    playingField.getTile(2,1).setCurrentPipe(new VerticalPipe());
	    playingField.getTile(2,0).setCurrentPipe(new NorthWestElbowPipe());
	    playingField.getTile(1,0).setCurrentPipe(new VerticalPipe()); //this pipe screws it up
	    playingField.getTile(0,0).setCurrentPipe(new HorizontalPipe());
	    
		PipeModel pipeModel = new PipeModel(playingField, gooGen, pipe);
		pipeModel.addGooChangeListener(this);

		assertTrue(playingField.getTile(3, 3).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		
		for (int i = 0; i < (5*GOO_COUNT); i++) {
			pipeModel.gooAdvanced();
		}
		
		assertTrue(playingField.getTile(2, 1).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(playingField.getTile(2,0).getCurrentPipe().getCurrentState().equals(PipeState.FILLING));
		assertTrue(playingField.getTile(1,0).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		assertTrue(gooBlockedCalled == false);
		
		for (int i = 0; i < (GOO_COUNT*2); i++) {
			pipeModel.gooAdvanced();
		}
		assertTrue(playingField.getTile(1, 0).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		assertTrue(gooBlockedCalled == true);

	}
	
	/**
	 * Pipe blocks itself
	 *//*
	@Test
	public void testPipeBlocksItself() {
        resetCalled();
        
		TileModel playingField = new TileModel(5, 5);
		GooGenerator gooGen = new GooGenerator();

		AbsPipe pipe = new StarterPipeWest();
		playingField.getTile(3, 3).setCurrentPipe(pipe);

	    playingField.getTile(2,3).setCurrentPipe(new SouthEastElbowPipe());
	    playingField.getTile(2,2).setCurrentPipe(new VerticalPipe());
	    playingField.getTile(2,1).setCurrentPipe(new VerticalPipe());
	    playingField.getTile(2,0).setCurrentPipe(new NorthWestElbowPipe());
	    playingField.getTile(1,0).setCurrentPipe(new VerticalPipe()); //this pipe screws it up
	    playingField.getTile(0,0).setCurrentPipe(new HorizontalPipe());
	    
		PipeModel pipeModel = new PipeModel(playingField, gooGen, pipe);
		pipeModel.addGooChangeListener(this);

		assertTrue(playingField.getTile(3, 3).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		
		for (int i = 0; i < (5*GOO_COUNT); i++) {
			pipeModel.gooAdvanced();
		}
		
		assertTrue(playingField.getTile(2, 1).getCurrentPipe().getCurrentState().equals(PipeState.FULL));
		assertTrue(playingField.getTile(2,0).getCurrentPipe().getCurrentState().equals(PipeState.FILLING));
		assertTrue(playingField.getTile(1,0).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		assertTrue(gooBlockedCalled == false);
		
		for (int i = 0; i < (GOO_COUNT*2); i++) {
			pipeModel.gooAdvanced();
		}
		assertTrue(playingField.getTile(1, 0).getCurrentPipe().getCurrentState().equals(PipeState.EMPTY));
		assertTrue(gooBlockedCalled == true);

	}
	
	*/
    //@todo: cross-pipe
	//@todo: pipe stops in the end piece
	
	
	boolean speedUpCalled = false;
	
	public void gooSpeedUp() {
       speedUpCalled = true;
	}

	boolean slowDownCalled = false;
	
	public void gooSlowDown() {
        slowDownCalled = true;
	}

	public boolean gooBlockedCalled = false;
	
	public void gooBlocked() {
        gooBlockedCalled = true;
	}
	
	public void resetCalled(){
		speedUpCalled = false;
		slowDownCalled = false;
		gooBlockedCalled = false;
	}

}
