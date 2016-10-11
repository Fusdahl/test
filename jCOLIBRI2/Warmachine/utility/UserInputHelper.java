package utility;

import models.Race;

public class UserInputHelper {

	public static Race RaceConverter(String inputString) {
		switch (inputString) {
			case "cygnar": {
				return Race.CYGNAR;
			} 
			case "khador": {
				return Race.KHADOR;
			}
			case "retribution": {
				return Race.RETRIBUTION;
			}
			case "mercs": {
				return Race.MERCS;
			}
			case "minions": {
				return Race.MINIONS;
			}
			case "circle": {
				return Race.CIRCLE;
			}
			case "convergence": {
				return Race.CONVERGENCE;
			}
			case "cryx": {
				return Race.CRYX;
			}
			case "menoth": {
				return Race.MENOTH;
			}
			case "legion": {
				return Race.LEGION;
			}
			case "skorne": {
				return Race.SKORNE;
			}
			case "Trollblood": {
				return Race.TROLLBLOOD;
			}
			
		}
		// Should not get here -> Throw exception
		return null;
	}
}
