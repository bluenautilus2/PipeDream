package twofishes.pipedream.tile;

import java.util.Random;

public class RandomTilePlacement {

	TileModel tileModel = null;
	protected Random random = null;

	public RandomTilePlacement(TileModel tileModel) {

		this.tileModel = tileModel;
		random = new Random(System.currentTimeMillis());

	}

	public Tile getLocation() {

		int positiveNextInt = Math.abs(random.nextInt());

		while (true) {

			// 2 tiles away from the sides
			int x = (positiveNextInt % (tileModel.getNumTilesWide() - 5)) + 2;
			// 2 tiles away from the top and bottom
			int y = (positiveNextInt % (tileModel.getNumTilesWide() - 5)) + 2;

			Tile newSpot = tileModel.getTile(x, y);
			if (newSpot.getCurrentPipe() == null) {
				return newSpot;
			}
		}
	}

}
