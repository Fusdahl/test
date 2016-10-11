package asd;

import jcolibri.cbrcore.Attribute;

public class Miniature implements jcolibri.cbrcore.CaseComponent {
	int miniatureId;
	String miniatureName;
	//Expand this to an enum probably - Look at the tutorial
	int miniatureType;
	int spd;
	int str;
	int mat;
	int rat;
	int def;
	int arm;
	int cmd;
	int fieldAllowance;
	// ArrayList<Race> races;
	// ArrayList<Ability> normalAbilities;
	// ArrayList<Ability> specialAbilities;
	// ArrayList<Weapon> weapons;
	
	public int getMiniatureType() {
		return miniatureType;
	}

	public void setMiniatureType(int miniatureType) {
		this.miniatureType = miniatureType;
	}
	
	public String getMiniatureName() {
		return miniatureName.toLowerCase();
	}

	public void setMiniatureName(String miniatureName) {
		this.miniatureName = miniatureName.toLowerCase();
	}
	
	public int getMiniatureId() {
		return miniatureId;
	}

	public void setMiniatureId(int miniatureId) {
		this.miniatureId = miniatureId;
	}
	
	public Miniature() {};
	
	public Attribute getIdAttribute() {
		return new Attribute("caseId", this.getClass());
	}
	
	public String toString() {
		return "(name: " + miniatureName + "; spd: " + spd + "; str:" + str + "; mat:" + mat +"; rat:" + rat + "; def:" + def + "; arm:" + arm + "; cmd:" + cmd + "; FA:" + fieldAllowance + "; miniatureId: " + miniatureId +")"; 
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getRat() {
		return rat;
	}

	public void setRat(int rat) {
		this.rat = rat;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getArm() {
		return arm;
	}

	public void setArm(int arm) {
		this.arm = arm;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public int getFieldAllowance() {
		return fieldAllowance;
	}

	public void setFieldAllowance(int fieldAllowance) {
		this.fieldAllowance = fieldAllowance;
	}
	
	protected void addMiniatureInfo(Miniature miniature) {
		this.miniatureId = miniature.getMiniatureId();
		this.miniatureName = miniature.getMiniatureName();
		this.miniatureType = miniature.getMiniatureType();
		this.spd = miniature.getSpd();
		this.str = miniature.getStr();
		this.mat = miniature.getMat();
		this.rat = miniature.getRat();
		this.def = miniature.getDef();
		this.arm = miniature.getArm();
		this.cmd = miniature.getCmd();
		this.fieldAllowance = miniature.getFieldAllowance();
	}
}
