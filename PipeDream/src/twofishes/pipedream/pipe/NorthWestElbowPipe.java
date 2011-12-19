package twofishes.pipedream.pipe;

public class NorthWestElbowPipe extends AbsPipe {

	public NorthWestElbowPipe(){
	
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.WEST)){
			return Entrance.NORTH;
		}else if(entered.equals(Entrance.NORTH)){
			return Entrance.WEST;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
