package models;

import jcolibri.cbrcore.Attribute;

public class Miniature extends BaseMiniature {
	int pointCost;
	int spd;
	int str;
	int mat;
	int rat;
	int def;
	int arm;
	int cmd;
	int fieldAllowance;
	int hp;
	// ArrayList<Race> races;
	// ArrayList<Ability> normalAbilities;
	// ArrayList<Ability> specialAbilities;
	// ArrayList<Weapon> weapons;
	
	public int getPointCost() {
		return pointCost;
	}

	public void setPointCost(int pointCost) {
		this.pointCost = pointCost;
	}
	
	public Miniature() {};
	
	public String toString() {
		return "(name: " + miniatureName + "; pointCost: " + pointCost + "; spd: " + spd + "; str:" + str + "; mat:" + mat +"; rat:" + rat + "; def:" + def + "; arm:" + arm + "; cmd:" + cmd + "; FA:" + fieldAllowance + "; miniatureId: " + miniatureId +")"; 
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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
	
	public void addMiniatureInfo(Miniature miniature) {
		this.miniatureId = miniature.getMiniatureId();
		this.miniatureName = miniature.getMiniatureName();
		this.miniatureType = miniature.getMiniatureType();
		this.pointCost = miniature.getPointCost();
		this.spd = miniature.getSpd();
		this.str = miniature.getStr();
		this.mat = miniature.getMat();
		this.rat = miniature.getRat();
		this.def = miniature.getDef();
		this.arm = miniature.getArm();
		this.cmd = miniature.getCmd();
		this.fieldAllowance = miniature.getFieldAllowance();
		this.hp = miniature.getHp();
	}
	
}
