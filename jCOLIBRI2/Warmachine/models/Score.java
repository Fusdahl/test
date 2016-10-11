package models;

public class Score {
	private int caseId;
	private int wins;
	private int losses;
	private Race race;
	
	public Score(int caseId, int wins, int losses, Race race) {
		this.caseId = caseId;
		this.wins = wins;
		this.losses = losses;
		this.race = race;
	}
	
	public String toString() {
		return "Score against  "+ race + ": " + wins + ", " + losses;
	}
	
	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	
	public int getRecord() {
		return wins - losses;
	}
	
}
