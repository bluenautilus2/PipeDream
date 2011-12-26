package twofishes.pipedream.tile;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

public class TestTileModel extends TestCase {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	public void  testConstruct(){
		TileModel contructed = new TileModel(5,5);
	    Tile t = contructed.getTile(2, 3);
	    assertTrue(t!=null);
	    assertTrue(t.getX()==2 && t.getY() == 3);
	    
	    assertTrue(null == contructed.getTile(5,6));   
	    
	}
	
	public void testNextTile(){
		TileModel tileModel = new TileModel(100,100);
		
		Tile middle = tileModel.getTile(50, 50);
		
		Tile t2 = tileModel.getTileToTheEast(middle, true);
		assertTrue(t2.getX()==51 && t2.getY()==50);
		
		Tile t3 = tileModel.getTileToTheWest(middle, true);
		assertTrue(t3.getX()==49 && t3.getY()==50);
		
		Tile t4 = tileModel.getTileToTheSouth(middle, true);
		assertTrue(t4.getX()==50 && t4.getY()==49);
		
		Tile t5 = tileModel.getTileToTheNorth(middle, true);
		assertTrue(t5.getX()==50 && t5.getY()==51);
		
		Tile edge = tileModel.getTile(99, 50);
		Tile t6 = tileModel.getTileToTheEast(edge, true);
		assertTrue(t6.getX()==0 && t6.getY()==50);
		Tile t7 = tileModel.getTileToTheEast(edge, false);
		assertTrue(t7==null);
		
		edge = tileModel.getTile(0, 50);
		Tile t8 = tileModel.getTileToTheWest(edge, true);
		assertTrue(t8.getX()==99 && t8.getY()==50);
		Tile t9 = tileModel.getTileToTheWest(edge, false);
		assertTrue(t9==null);
		
		edge = tileModel.getTile(50, 99);
		Tile t10 = tileModel.getTileToTheNorth(edge, true);
		assertTrue(t10.getX()==50 && t10.getY()==0);
		Tile t11 = tileModel.getTileToTheNorth(edge, false);
		assertTrue(t11==null);
		
		edge = tileModel.getTile(50, 0);
		Tile t12 = tileModel.getTileToTheSouth(edge, true);
		assertTrue(t12.getX()==50 && t12.getY()==99);
		Tile t13 = tileModel.getTileToTheSouth(edge, false);
		assertTrue(t13==null);
	}
}
