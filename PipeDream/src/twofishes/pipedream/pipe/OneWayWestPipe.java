package twofishes.pipedream.pipe;

/**
 * The pipe goes west; goo can only come in
 * from the east and go towards the west.
 * @author bluenautius2
 *
 */
public class OneWayWestPipe extends AbsPipe {

	public OneWayWestPipe(){
		
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.EAST)){
			return Entrance.WEST;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
