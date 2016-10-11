package utility;

import java.util.List;

import models.Miniature;
import models.Solo;
import models.Unit;
import models.UnitAttachment;
import models.Warcaster;
import models.Warjack;

public class JsonNameMatcher {
	
	public static Miniature findMatchingWarcaster(Miniature miniature, List<Warcaster> warcasters) {
		String targetName = miniature.getMiniatureName();
		for(Warcaster warcaster : warcasters) {
			if(targetName.equals(warcaster.getMiniatureName())) {
				warcaster.addMiniatureInfo(miniature);
				return warcaster;
			}
		}
		return null;
	}
	
	public static Miniature findMatchingWarjack(Miniature miniature, List<Warjack> warjacks) {
		String targetName = miniature.getMiniatureName();
		for(Warjack warjack: warjacks) {
			if(targetName.equals(warjack.getMiniatureName())) {
				warjack.addMiniatureInfo(miniature);
				return warjack;
			}
		}
		return null;
	}
	
	public static Miniature findMatchingSolo(Miniature miniature, List<Solo> solos) {
		String targetName = miniature.getMiniatureName();
		for(Solo solo: solos) {
			if(targetName.equals(solo.getMiniatureName())) {
				solo.addMiniatureInfo(miniature);
				return solo;
			}
		}
		return null;
	}
	
	public static Miniature findMatchingUnit(Miniature miniature, List<Unit> units) {
		String targetName = miniature.getMiniatureName();
		for(Unit unit: units) {
			if(targetName.equals(unit.getMiniatureName())) {
				unit.addMiniatureInfo(miniature);
				return unit;
			}
		}
		return null;
	}
	
	public static Miniature findMatchingAttachment(Miniature miniature, List<UnitAttachment> unitAttachments) {
		String targetName = miniature.getMiniatureName();
		for(UnitAttachment unitAttachment: unitAttachments) {
			if(targetName.equals(unitAttachment.getMiniatureName())) {
				unitAttachment.addMiniatureInfo(miniature);
				return unitAttachment;
			}
		}
		return null;
	}
	

}
