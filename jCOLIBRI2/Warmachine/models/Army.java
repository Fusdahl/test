package models;

import java.util.ArrayList;

import antlr.collections.List;
import jcolibri.cbrcore.Attribute;

public class Army implements jcolibri.cbrcore.CaseComponent {
	int caseId;
	int totalPointCost;
	ArrayList<Miniature> miniatures = new ArrayList<Miniature>();
	ArrayList<Score> scores = new ArrayList<Score>();
	
	public Army() {};
	
	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	
	public Attribute getIdAttribute() {
		return new Attribute("caseId", this.getClass());
	}
	
	public String toString() {
		String retVal = "(caseID: " + caseId + " ; armyCost:" + totalPointCost + " ; " + "miniatures: " + System.lineSeparator();
		for(Miniature miniature : miniatures) {
			retVal += "\t" + miniature.toString() + System.lineSeparator();
		}
		return retVal;
	}
	
	public int getTotalPointCost() {
		return totalPointCost;
	}

	public void setTotalPointCost(int totalPointCost) {
		this.totalPointCost = totalPointCost;
	}
	
	public void addMiniature(Miniature miniature) {
		miniatures.add(miniature);
	}
	
	public void addScore(Score score) {
		scores.add(score);
	}
	
	public Score findScore(Race targetRace) {
		for(Score score : scores) {
			if(score.getRace().equals(targetRace)) {
				return score;
			}
		}
		//Should not get here -> Error Handling
		return null;
	}

}
