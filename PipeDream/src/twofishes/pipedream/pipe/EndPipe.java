package twofishes.pipedream.pipe;


public class EndPipe extends AbsPipe {

	@Override
	public Entrance getExit(Entrance entered) {
			return Entrance.BLOCKED;
		
	}
	
	@Override
	public Entrance getExit(){
		return Entrance.BLOCKED;
	}
}
