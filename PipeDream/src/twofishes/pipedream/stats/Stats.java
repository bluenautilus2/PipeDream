package twofishes.pipedream.stats;

//TODO Create relevant values for this class
public class Stats {
	private String lastColumClicked;
	private int timeLeft;
	private int timesClicked;
	
	
	public String getLastColumClicked() {
		return lastColumClicked;
	}
	public void setLastColumClicked(String lastColumClicked) {
		this.lastColumClicked = lastColumClicked;
	}
	public int getTimeLeft() {
		return timeLeft;
	}
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}
	public int getTimesClicked() {
		return timesClicked;
	}
	public void setTimesClicked(int timesClicked) {
		this.timesClicked = timesClicked;
	}
}
