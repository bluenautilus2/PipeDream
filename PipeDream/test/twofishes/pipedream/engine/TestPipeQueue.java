package twofishes.pipedream.engine;


import junit.framework.TestCase;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.MovablePipes;

public class TestPipeQueue extends TestCase{
    private static int testSize = 10;
    MovablePipes pipeMap = new MovablePipes();
	PipeQueue queue = new PipeQueue(testSize, pipeMap);
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	public void testConstruct(){
		assertEquals(queue.size(),testSize);
	}
	

	@Test
	public void testPeek() {
		AbsPipe firstPipe = queue.peek();
		assertTrue(firstPipe.equals(queue.pop()));
	}
	
	public void testPop(){
		
		AbsPipe ninthPipe = queue.peek(9);
		for(int i=0; i<9; i++){
			queue.pop();
		}
		assertTrue(ninthPipe.equals(queue.peek()));
		assertEquals(queue.size(),testSize);
	}

}
