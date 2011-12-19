package twofishes.pipedream.pipe;

public class VerticalPipe extends AbsPipe {

	public VerticalPipe(){
	
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.NORTH)){
			return Entrance.SOUTH;
		}else if(entered.equals(Entrance.SOUTH)){
			return Entrance.NORTH;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
