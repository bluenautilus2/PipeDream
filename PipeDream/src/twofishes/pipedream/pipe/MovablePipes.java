package twofishes.pipedream.pipe;

import java.util.ArrayList;

public class MovablePipes extends ArrayList <Class<? extends AbsPipe>>{

	private static final long serialVersionUID = 1;
	
	public MovablePipes() {
		
		super.add(VerticalPipe.class);
		super.add(HorizontalPipe.class);
		super.add(NorthEastElbowPipe.class);
		super.add(NorthWestElbowPipe.class);
		super.add(OneWayEastPipe.class);
		super.add(OneWayWestPipe.class);
		super.add(OneWayNorthPipe.class);
		super.add(OneWaySouthPipe.class);
		super.add(SouthEastElbowPipe.class);
		super.add(SouthWestElbowPipe.class);
		super.add(CrossPipe.class);
	}
}