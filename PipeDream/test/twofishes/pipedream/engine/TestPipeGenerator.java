package twofishes.pipedream.engine ;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twofishes.pipedream.engine.PipeGenerator;
import twofishes.pipedream.pipe.AbsPipe;

public class TestPipeGenerator {

	PipeGenerator gen = new PipeGenerator();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		for(int i=0; i<20; i++){
			AbsPipe p = gen.getNewPipe();
			System.out.println(i + " " + p.getClass().getName());
		}
	}

}
