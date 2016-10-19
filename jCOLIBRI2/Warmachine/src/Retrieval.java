package src;

import java.util.ArrayList;

import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import models.Army;
import models.Race;
import models.Warcaster;

public class Retrieval {
	
	CBRCaseBase caseBase;
	CBRQuery query;
	Army queryArmy;
	
	public Retrieval(CBRCaseBase caseBase, CBRQuery userQuery) {
		this.caseBase = caseBase;
		query = userQuery;
		queryArmy = (Army) userQuery.getDescription();
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
	
	public ArrayList<CBRCase> simpleStructuralSimilarity() {
		ArrayList<CBRCase> retVal = new ArrayList<CBRCase>();
		ArrayList<CBRCase> cases = (ArrayList<CBRCase>) caseBase.getCases();
		
		//Look for armies using the same warcaster as the query.
		for(CBRCase currentCase : cases) {
			Army currentArmy = ((Army) currentCase.getDescription());
			//If names are equal, it's the same warcaster.
			if(currentArmy.getWarcaster() != null && currentArmy.getWarcaster().getMiniatureName().equals(queryArmy.getWarcaster().getMiniatureName())) {
				retVal.add(currentCase);
			}
		}
		// No army in the case base has the same warcaster. -> compare battle group?
		if(retVal.isEmpty()) {
			
		}
		return retVal;
	}
}
