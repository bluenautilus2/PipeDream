package twofishes.pipedream.gui.controller;

import javax.inject.Inject;

import twofishes.pipedream.stats.Stats;

public class StatsController extends AbsController {
	
	public Stats stats;
	
	@Inject
	public StatsController(Stats stats) {
		this.stats = stats;
	}
	
	public void handleUpdate() {
		//Update Stats Object
		
		//Tell StatsView to update itself
	}
}
