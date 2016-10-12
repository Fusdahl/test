package models;

import jcolibri.cbrcore.Attribute;

public class BaseMiniature implements jcolibri.cbrcore.CaseComponent {
	int miniatureId;
	String miniatureName;
	//Expand this to an enum probably - Look at the tutorial
	int miniatureType;
	
	public int getMiniatureId() {
		return miniatureId;
	}

	public void setMiniatureId(int miniatureId) {
		this.miniatureId = miniatureId;
	}

	public String getMiniatureName() {
		return miniatureName;
	}

	public void setMiniatureName(String miniatureName) {
		this.miniatureName = miniatureName;
	}

	public int getMiniatureType() {
		return miniatureType;
	}

	public void setMiniatureType(int miniatureType) {
		this.miniatureType = miniatureType;
	}

	public Attribute getIdAttribute() {
		return new Attribute("caseId", this.getClass());
	}
	

}
