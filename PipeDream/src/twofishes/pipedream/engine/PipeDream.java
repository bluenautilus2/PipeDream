package twofishes.pipedream.engine;

import twofishes.pipedream.gui.GamePanel;
import twofishes.pipedream.gui.MainFrame;
import twofishes.pipedream.gui.view.GridView;
import twofishes.pipedream.pipe.MovablePipes;
import twofishes.pipedream.tile.TileModel;

public class PipeDream {

	final public static int GRID_SIZE = 15;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Init the Pipe Generator
		PipeGenerator pipeGenerator = new PipeGenerator(new MovablePipes());
		
		//Init the TileModel
		TileModel tileModel = new TileModel(GRID_SIZE, GRID_SIZE);
		GridView gridView = new GridView();
		gridView.setTileModel(tileModel);
		
		//Init the GUI
		MainFrame theFrame = new MainFrame();
		GamePanel gamePanel = new GamePanel();
		gamePanel.setGrid(gridView);
	
		theFrame.setContentPane(gamePanel);
		theFrame.pack();
		theFrame.setVisible(true);

	}

}
