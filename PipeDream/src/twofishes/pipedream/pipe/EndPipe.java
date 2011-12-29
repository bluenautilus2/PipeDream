package twofishes.pipedream.pipe;

public class EndPipe extends AbsPipe {

	@Override
	public Entrance getExit(Entrance entered) {
			return Entrance.END;
	}

}
