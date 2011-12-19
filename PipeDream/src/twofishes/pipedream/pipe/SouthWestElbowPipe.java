package twofishes.pipedream.pipe;

public class SouthWestElbowPipe extends AbsPipe {

	public SouthWestElbowPipe(){
		
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.WEST)){
			return Entrance.SOUTH;
		}else if(entered.equals(Entrance.SOUTH)){
			return Entrance.WEST;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
