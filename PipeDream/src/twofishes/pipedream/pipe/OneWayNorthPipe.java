package twofishes.pipedream.pipe;


/**
 * The pipe goes north; goo can only come in
 * from the south and go towards the north.
 * @author bluenautius2
 *
 */
public class OneWayNorthPipe extends AbsPipe {

	public OneWayNorthPipe(){
		
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.SOUTH)){
			return Entrance.NORTH;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
