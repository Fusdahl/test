package models;

public class Warcaster extends Miniature {
	int focus;
	int warcasterPoints;
	
	public String toString() {
		return super.toString() + "focus: " + focus + " ; warcasterPoints: " + warcasterPoints;
	}
	
	public int getFocus() {
		return focus;
	}
	public void setFocus(int focus) {
		this.focus = focus;
	}
	public int getWarcasterPoints() {
		return warcasterPoints;
	}
	public void setWarcasterPoints(int warcasterPoints) {
		this.warcasterPoints = warcasterPoints;
	}
	
}
