package twofishes.pipedream.pipe;

public class SouthEastElbowPipe extends AbsPipe {

	public SouthEastElbowPipe(){
		
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.SOUTH)){
			return Entrance.EAST;
		}else if(entered.equals(Entrance.EAST)){
			return Entrance.SOUTH;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
