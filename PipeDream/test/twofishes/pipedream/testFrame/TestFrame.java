package twofishes.pipedream.testFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import twofishes.pipedream.engine.PipeGenerator;
import twofishes.pipedream.engine.PipeModel;
import twofishes.pipedream.engine.goo.GooGenerator;
import twofishes.pipedream.gui.GamePanel;
import twofishes.pipedream.gui.MainFrame;
import twofishes.pipedream.gui.view.GridView;
import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.CrossPipe;
import twofishes.pipedream.pipe.Entrance;
import twofishes.pipedream.pipe.HorizontalPipe;
import twofishes.pipedream.pipe.MovablePipes;
import twofishes.pipedream.pipe.NorthEastElbowPipe;
import twofishes.pipedream.pipe.NorthWestElbowPipe;
import twofishes.pipedream.pipe.SouthEastElbowPipe;
import twofishes.pipedream.pipe.SouthWestElbowPipe;
import twofishes.pipedream.pipe.StarterPipeEast;
import twofishes.pipedream.pipe.StarterPipeNorth;
import twofishes.pipedream.pipe.StarterPipeSouth;
import twofishes.pipedream.pipe.StarterPipeWest;
import twofishes.pipedream.pipe.VerticalPipe;
import twofishes.pipedream.tile.Tile;
import twofishes.pipedream.tile.TileModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;

public class TestFrame extends JFrame {
	
	static public void main(String [] args) {
		
		//Init the Pipe Generator
		PipeGenerator pipeGenerator = new PipeGenerator(new MovablePipes());
		
		//Init the GUI
		TestFrame theFrame = new TestFrame();

		//generate random pipeline for testing purposes
		theFrame.generate(10,10) ;
		
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		theFrame.pack();
		theFrame.setVisible(true);		
		
	}
	
	private void generate(int x, int y) {
		TestTileModel testTileModel = setupTileModel(x, y) ;
		TestPipeModel testPipeModel = setupPipeModel(testTileModel) ; 
		pack() ;
	}

	class TestTileModel extends TileModel {

		AbsPipe startPipe ;
		
		public TestTileModel(int numTilesWide, int numTilesHigh) {
			super(numTilesWide, numTilesHigh);
			this.startPipe = generateTileModel(this) ;
		}

		public AbsPipe getStartPipe() {
			return startPipe ;
		}
		
	}
	
	class TestPipeModel extends PipeModel {

		public TestPipeModel(TileModel tileModel, GooGenerator gooGenerator, AbsPipe startingPipe, boolean ignoreWalls) {
			super(tileModel, gooGenerator, startingPipe, ignoreWalls);
		}
		
	}
	
	private TestTileModel setupTileModel(int x, int y) {
		TestTileModel tileModel = new TestTileModel(x, y);
		setTileModel(tileModel) ;
		return tileModel;
	}
	
	
	private TestPipeModel setupPipeModel(TestTileModel testTileModel) {
		AbsPipe startPipe = testTileModel.getStartPipe() ;
		TestPipeModel pipeModel = new TestPipeModel(testTileModel, null, startPipe, true) ;
		setPipeModel(pipeModel) ;
		return pipeModel ;
	}

	private void setPipeModel(PipeModel pipeModel) {
		this.pipeModel = pipeModel ;
	}

	private void setTileModel(TileModel tileModel) {
		gridView.setTileModel(tileModel) ;
	}

	private GridView gridView = new GridView();
	private PipeModel pipeModel ;
	
	public TestFrame() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(gridView) ;
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel sewerControlPanel = new JPanel();
		getContentPane().add(sewerControlPanel, BorderLayout.EAST);
		sewerControlPanel.setLayout(new BoxLayout(sewerControlPanel, BoxLayout.Y_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		sewerControlPanel.add(verticalGlue);
		
		JPanel sewerGeneratorPanel = new JPanel();
		sewerControlPanel.add(sewerGeneratorPanel);
		sewerGeneratorPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "SewerGenerator", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sewerGeneratorPanel.setLayout(new BoxLayout(sewerGeneratorPanel, BoxLayout.Y_AXIS));
		
		JPanel xyComboPanel = new JPanel();
		xyComboPanel.setBorder(new TitledBorder(null, "x,y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sewerGeneratorPanel.add(xyComboPanel);
		xyComboPanel.setLayout(new BoxLayout(xyComboPanel, BoxLayout.X_AXIS));
		
		final JSpinner xSpinner = new JSpinner();
		xyComboPanel.add(xSpinner);
		xSpinner.setModel(new SpinnerNumberModel(10, 1, 50, 1));
		
		final JSpinner ySpinner = new JSpinner();
		xyComboPanel.add(ySpinner);
		ySpinner.setModel(new SpinnerNumberModel(10, 1, 50, 1));
		
		JButton generateSewer = new JButton("Generate");
		sewerGeneratorPanel.add(generateSewer);
		generateSewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//generate random pipeline for testing purposes
				int x = (Integer) xSpinner.getValue() ;
				int y = (Integer) ySpinner.getValue() ;
				generate(x,y) ;
			}
		});

		JPanel flowPanel = new JPanel();
		sewerControlPanel.add(flowPanel);
		flowPanel.setBorder(new TitledBorder(null, "FlowControl", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		flowPanel.setLayout(new BoxLayout(flowPanel, BoxLayout.Y_AXIS));
		
		JButton resetSewer = new JButton("Reset");
		resetSewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset() ;
			}
		});
		flowPanel.add(resetSewer);
		
		JButton advanceGooButton = new JButton("AdvanceGoo");
		flowPanel.add(advanceGooButton);
		
		JToggleButton autoAdvanceButton = new JToggleButton("AutoAdvance");
		flowPanel.add(autoAdvanceButton);
		advanceGooButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pipeModel.gooAdvanced() ;
				} catch (Exception e) {
					e.printStackTrace();
				}
				scrollPane.repaint() ;
			}
		});
		
	}

	private void reset() {
		TileModel tileModel = gridView.getTileModel() ;
		for(int x=0 ; x<tileModel.getNumTilesWide() ; x++) {
			for(int y=0 ; y<tileModel.getNumTilesHigh() ; y++) {
				Tile tile = tileModel.getTile(x, y) ;
				AbsPipe pipe = tile.getCurrentPipe() ;
			}
		}
	}

	private static AbsPipe generateTileModel(TileModel tileModel) {
		int nx = tileModel.getNumTilesWide() ;
		int ny = tileModel.getNumTilesHigh() ;

		Entrance exit ;
		AbsPipe currentPipe = null ;
		AbsPipe startPipe = null ;
		
		//get random staring location
		int x = (int)(Math.random()*nx) ;
		int y = (int)(Math.random()*ny) ;
		
		//get random starting pipe
		exit = getRandomSide(Entrance.NORTH, Entrance.SOUTH, Entrance.EAST, Entrance.WEST) ;
		switch(exit) {
			case NORTH: currentPipe = new StarterPipeNorth() ; break ;
			case SOUTH: currentPipe = new StarterPipeSouth() ; break ;
			case EAST: currentPipe = new StarterPipeEast() ; break ;
			case WEST: currentPipe = new StarterPipeWest() ; break ;
			default: exit = Entrance.BLOCKED ;
		}
		
		System.out.println("SET:" + x + "," + y + ":" + currentPipe.getClass().getSimpleName()) ;
		tileModel.setPipe(currentPipe, x, y) ;

		startPipe = currentPipe ;
		
		
		//while can't lay down pipe
		//get random exit of current pipe
		//ensure exit corresponds to empty location
		//if not empty location, hope it is a cross piece
		//get random pipe with corresponding entrance

		while(exit!=Entrance.BLOCKED) {
			
			switch(exit) {
				case NORTH:
					x=x ;
					y+=1 ;
					break ;
				case SOUTH:
					x=x ;
					y-=1 ;
					break ;
				case EAST:
					x+=1 ;
					y=y ;
					break ;
				case WEST:
					x-=1 ;
					y=y ;
					break ;
				default:
			}
			x=x<0?nx+x:x ;
			y=y<0?ny+y:y ;
			x=x>=nx?x%nx:x ;
			y=y>=ny?y%ny:y ;
			
			Entrance entrance = exit.getOppositeSide() ;
			switch(entrance) {
				case NORTH: exit = getRandomSide(Entrance.SOUTH, Entrance.EAST, Entrance.WEST) ; break ;
				case SOUTH: exit = getRandomSide(Entrance.NORTH, Entrance.EAST, Entrance.WEST) ; break ;
				case EAST: exit = getRandomSide(Entrance.NORTH, Entrance.SOUTH, Entrance.WEST) ; break ;
				case WEST: exit = getRandomSide(Entrance.NORTH, Entrance.SOUTH, Entrance.EAST) ; break ;
				default: exit = Entrance.BLOCKED ;
			}
			
			if(entrance == exit) {
				System.out.println("what the???" + entrance + exit) ;
				System.exit(-1) ;
			}
			
			
			AbsPipe npipe = null ;
			Tile ntile = tileModel.getTile(x, y) ;
			System.out.println("" + entrance + exit) ;
			if(ntile.getCurrentPipe()==null) {
				npipe = getRandomPipe(entrance, exit) ;
				if(npipe!=null) {
					currentPipe = npipe ;
					System.out.println("SET:" + x + "," + y + ":" + currentPipe.getClass().getSimpleName()) ;
					tileModel.setPipe(npipe,  x, y) ;
				}
				else {
					//???
					System.out.println("SET:" + x + "," + y + ":" + "FAIL" + entrance + exit) ;
				}
			}
			else {
				exit = Entrance.BLOCKED ;
			}
		}
		
		return startPipe ;
		
	}



	private static AbsPipe getRandomPipe(Entrance entrance, Entrance exit) {
		AbsPipe pipe = null ;
		switch(entrance) {
			case NORTH:
				switch(exit) {
					case SOUTH: //straight or cross
						pipe = ((int)(Math.random()*2)%2)==0?new CrossPipe():new VerticalPipe() ; break ;
					case EAST:
						pipe = new NorthEastElbowPipe() ; break ;
					case WEST:
						pipe = new NorthWestElbowPipe() ; break ;
					default:
						pipe = null ;
				}
				break ;
			case SOUTH:
				switch(exit) {
					case NORTH: //straight or cross
						pipe = ((int)(Math.random()*2)%2)==0?new CrossPipe():new VerticalPipe() ; break ;
					case EAST:
						pipe = new SouthEastElbowPipe() ; break ;
					case WEST:
						pipe = new SouthWestElbowPipe() ; break ;
					default:
						pipe = null ;
				}
				break ;
			case EAST:
				switch(exit) {
					case NORTH:
						pipe = new NorthEastElbowPipe() ; break ;
					case SOUTH:
						pipe = new SouthEastElbowPipe() ; break ;
					case WEST: //straight or cross
						pipe = ((int)(Math.random()*2)%2)==0?new CrossPipe():new HorizontalPipe() ; break ;
					default:
						pipe = null ;
				}
				break ;
			case WEST:
				switch(exit) {
					case NORTH:
						pipe = new NorthWestElbowPipe() ; break ;
					case SOUTH:
						pipe = new SouthWestElbowPipe() ; break ;
					case EAST: //straight or cross
						pipe = ((int)(Math.random()*2)%2)==0?new CrossPipe():new HorizontalPipe() ; break ;
					default:
						pipe = null ;
				}
				break ;
			default:
				pipe = null ;
		}
		return pipe ;
	}

	private static Entrance getRandomSide(Entrance ... sides) {
		int i = (int)(Math.random()*sides.length) ;
		return sides[i] ;
	}
	
	
}
