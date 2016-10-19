package models;

import java.util.ArrayList;

import antlr.collections.List;
import jcolibri.cbrcore.Attribute;

public class Army implements jcolibri.cbrcore.CaseComponent {
	int caseId;
	int totalPointCost = 0;
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
			if(miniature != null) {
				retVal += "\t" + miniature.toString() + System.lineSeparator();
			}
		}
		return retVal;
	}
	
	public ArrayList<Miniature> getMiniatures() {
		return miniatures;
	}
	
	public int getTotalPointCost() {
		return totalPointCost;
	}

	public void setTotalPointCost(int totalPointCost) {
		this.totalPointCost = totalPointCost;
	}
	
	public void addMiniature(Miniature miniature) {
		miniatures.add(miniature);
		//So ugly, but who cAREAS
		if(miniature instanceof Warcaster && !(miniature instanceof JuniorWarcaster)) {
			totalPointCost -= ((Warcaster)miniature).getWarcasterPoints();
		} else if(miniature != null){
			totalPointCost += miniature.getPointCost();
		}
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
	
	public Warcaster getWarcaster() {
		for(Miniature miniature : miniatures) {
			if(miniature instanceof Warcaster && !(miniature instanceof JuniorWarcaster)) {
				return (Warcaster) miniature;
			}
		}
		return null;
	}

}
