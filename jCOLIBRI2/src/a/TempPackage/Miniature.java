package a.TempPackage;

import jcolibri.cbrcore.Attribute;

public class Miniature implements jcolibri.cbrcore.CaseComponent {
	String caseId;
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
	
	public Miniature() {};
	
	public Attribute getIdAttribute() {
		return new Attribute("caseId", this.getClass());
	}
	
	public String toString() {
		return "(" + caseId + " ; " + spd + " ; " + str + " ; " + mat + ")"; 
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
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
}
