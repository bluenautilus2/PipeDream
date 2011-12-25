package twofishes.pipedream.pipe.immovable;

import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.Entrance;

public class EndPipe extends AbsPipe {

	@Override
	public Entrance getExit(Entrance entered) {
			return Entrance.BLOCKED;
		
	}
}
