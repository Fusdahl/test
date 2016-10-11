package src;

import java.util.ArrayList;

import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import models.Army;
import models.Race;

public class Retrieval {
	
	CBRCaseBase caseBase;
	
	public Retrieval(CBRCaseBase caseBase) {
		this.caseBase = caseBase;
	}

	// This shit needs some unit testing LOL
	public ArrayList<CBRCase> SimpleRetrieval(Race targetRace, int kBest) {
		ArrayList<CBRCase> retVal = new ArrayList<CBRCase>();
		ArrayList<CBRCase> cases = (ArrayList<CBRCase>) caseBase.getCases();
		
		for(CBRCase currentCase : cases) {
			int currentCaseScore = ((Army) currentCase.getDescription()).findScore(targetRace).getRecord();
			if (retVal.size() == kBest && currentCaseScore > findLowestScore(retVal, targetRace)) {
				int worstScorePosition = findLowestScorePosition(retVal, targetRace);
				retVal.set(worstScorePosition, currentCase);
			} else if(retVal.size() < kBest ){
				retVal.add(currentCase);
			}
		}
		return retVal;
	}
	
	public ArrayList<CBRCase> subsetRetrieval(ArrayList<Race> targetRaces, int kBest) {
		return null;
	}
	
	public ArrayList<CBRCase> allComersRetrieval(int kBest) {
		return null;
	}
	
	public ArrayList<CBRCase> twoListRetrieval(int kBest) {
		return null;
	}
	
	// Need to test this method!
	public int findLowestScorePosition(ArrayList<CBRCase> currentBestCases, Race targetRace) {
		int lowestScorePosition = 0;
		int currentLowestScore = Integer.MAX_VALUE;
		for(int i = 0; i < currentBestCases.size(); ++i) {
			Army army = (Army) currentBestCases.get(i).getDescription();
			int armyScore = army.findScore(targetRace).getRecord();
			
			if(armyScore < currentLowestScore) {
				lowestScorePosition = i;
				currentLowestScore = armyScore;
			}
		}
		return lowestScorePosition;
	}
	
	private int findLowestScore(ArrayList<CBRCase> currentBestCases, Race targetRace) {
		Integer lowestScore = null;
		for(CBRCase c : currentBestCases) {
			Army army = (Army) c.getDescription();
			int armyScore = army.findScore(targetRace).getRecord();
			if(lowestScore == null || armyScore < lowestScore) {
				lowestScore = armyScore;
			}
		}
		return lowestScore;
	}
}
