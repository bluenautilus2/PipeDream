package twofishes.pipedream.engine;

import java.util.ArrayList;

import twofishes.pipedream.engine.goo.GooChangeListener;
import twofishes.pipedream.engine.goo.GooGeneratedListener;
import twofishes.pipedream.engine.goo.GooGenerator;
import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.PipeState;
import twofishes.pipedream.tile.TileModel;

public class PipeModel implements GooGeneratedListener{
   
	 AbsPipe starterPipe = null; 
	
	 AbsPipe currentPipe = null;
	
	 ArrayList<GooChangeListener> gooChangeListeners = new ArrayList<GooChangeListener>();
	 
	 GooGenerator gooGenerator = null;
	 
	 TileModel playingField = null;
	 
	 
	 
	 public PipeModel(TileModel tileModel, GooGenerator gooGenerator){
		 this.playingField = tileModel;
		 this.gooGenerator = gooGenerator;
		 gooGenerator.addListener(this);
		 addGooChangeListener(gooGenerator);
	 }
	 
	 public void addGooChangeListener(GooChangeListener listener){
		 this.gooChangeListeners.add(listener);
	 }
	 
	 public void gooAdvanced(){
		 currentPipe.gooAdvance();
		 if(currentPipe.getCurrentState().equals(PipeState.FULL)){
			 AbsPipe newPipe= getNextTile();
			 if(newPipe == null){
				 for(GooChangeListener listener:this.gooChangeListeners){
					 listener.gooBlocked();
				 }
			 }else{
				 beginNewPipe(newPipe);
				 
			 }
				 
			 
			 
			 
		 }
	 }
	
	 private AbsPipe getNextTile(){
		 return null;
		 
	 }
	 
	 private void beginNewPipe(AbsPipe pipe){
		 //se
	 }
}
