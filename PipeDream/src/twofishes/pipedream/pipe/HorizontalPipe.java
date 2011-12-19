package twofishes.pipedream.pipe;

public class HorizontalPipe extends AbsPipe {

	public HorizontalPipe(){
	
	}
	
	@Override
	public Entrance getExit(Entrance entered){
		if(entered.equals(Entrance.WEST)){
			return Entrance.EAST;
		}else if(entered.equals(Entrance.EAST)){
			return Entrance.WEST;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
