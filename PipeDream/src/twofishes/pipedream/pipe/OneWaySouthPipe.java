package twofishes.pipedream.pipe;

/**
 * The pipe goes south; goo can only come in
 * from the north and go towards the south.
 * @author bluenautius2
 *
 */
public class OneWaySouthPipe extends AbsPipe {

	public OneWaySouthPipe(){
		
	}
	

	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.NORTH)){
			return Entrance.SOUTH;
		}else{
			return Entrance.BLOCKED;
		}
		
	}

}
