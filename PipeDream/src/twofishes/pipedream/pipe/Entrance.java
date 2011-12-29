package twofishes.pipedream.pipe;

public enum Entrance{
	NORTH(),
	SOUTH(),
	EAST(),
	WEST(),
	BLOCKED(),
	END();  //Used only in end pieces

	public Entrance getOppositeSide() {
		Entrance oside ;
		switch(this) {
			case NORTH: oside = Entrance.SOUTH ; break ;
			case SOUTH: oside = Entrance.NORTH ; break ;
			case EAST: oside = Entrance.WEST ; break ;
			case WEST: oside = Entrance.EAST ; break ;
			default: oside=Entrance.BLOCKED ;
		}
		return oside ;
	}
}
