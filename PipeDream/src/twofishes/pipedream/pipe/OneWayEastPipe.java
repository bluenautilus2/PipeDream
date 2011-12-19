package twofishes.pipedream.pipe;

/**
 * The pipe goes east; goo can only come in
 * from the west and go towards the east.
 * @author bluenautius2
 *
 */
public class OneWayEastPipe extends AbsPipe {

	public OneWayEastPipe(){
		
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.WEST)){
			return Entrance.EAST;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
