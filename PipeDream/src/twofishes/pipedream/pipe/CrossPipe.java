package twofishes.pipedream.pipe;

public class CrossPipe extends AbsPipe {

	private HorizontalPipe horizontalPipe;
	private VerticalPipe verticalPipe;
	
	public CrossPipe(){
		horizontalPipe = new HorizontalPipe();
		verticalPipe = new VerticalPipe();
	}
	
	@Override
	public Entrance getExit(Entrance entered) {
		if(entered.equals(Entrance.NORTH)||entered.equals(Entrance.SOUTH)){
			return verticalPipe.getExit(entered);
		}else if (entered.equals(Entrance.WEST)||entered.equals(Entrance.EAST)){
			return horizontalPipe.getExit(entered);
		}
		return Entrance.BLOCKED;
	}

}
