package utility;

import models.Army;

public class ArmyValidator {

	public static boolean validateArmy(Army army) {
		if(army.getTotalPointCost() > 75 || army.getTotalPointCost() < 73) {
			return false;
		} else {
			return true;
		}
	}
	
}
