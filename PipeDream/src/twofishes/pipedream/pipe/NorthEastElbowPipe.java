package twofishes.pipedream.pipe;

public class NorthEastElbowPipe extends AbsPipe {

	public NorthEastElbowPipe(){
		
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.NORTH)){
			return Entrance.EAST;
		}else if(entered.equals(Entrance.EAST)){
			return Entrance.NORTH;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
