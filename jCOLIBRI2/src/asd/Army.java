package asd;

import java.util.ArrayList;

import antlr.collections.List;
import jcolibri.cbrcore.Attribute;

public class Army implements jcolibri.cbrcore.CaseComponent {
	int caseId;
	int totalPointCost;
	ArrayList<Miniature> miniatures = new ArrayList<Miniature>();
	
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
		String retVal = "(caseID: " + caseId + " ; pointcost:" + totalPointCost + " ; " + "miniatures: " + System.lineSeparator();
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
}
