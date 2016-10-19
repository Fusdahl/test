package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import models.JuniorWarcaster;
import models.Solo;
import models.Unit;
import models.UnitAttachment;
import models.Warcaster;
import models.WarcasterAttachment;
import models.Warjack;

public class MiniatureReader {
	private static final String JSON_FILEPATH = "E:\\jCOLIBRI2\\Warmachine\\data\\";

	public static Warcaster parseWarcaster(String warcasterName) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "warcasters.json"));
			Warcaster[] temp = gson.fromJson(br, Warcaster[].class);
			for(Warcaster warcaster : temp) {
				if(warcasterName.equals(warcaster.getMiniatureName())) {
					return warcaster;
				}
			}
		} catch(FileNotFoundException e) {
			throw new RuntimeException("crashed in parseWarcaster from queryParser");
		}
		return null;
	}
	
	public static Warjack parseWarjack(String warjackName) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "warjacks.json"));
			Warjack[] temp = gson.fromJson(br, Warjack[].class);
			for(Warjack warjack : temp) {
				if(warjack != null && warjackName.equals(warjack.getMiniatureName())) {
					return warjack;
				}
			}
		} catch(FileNotFoundException e) {
			throw new RuntimeException("crashed in parseWarcaster from queryParser");
		}
		return null;
	}
	
	public static Solo parseSolo(String soloName) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "solos.json"));
			Solo[] temp = gson.fromJson(br, Solo[].class);
			for(Solo solo : temp) {
				if(soloName.equals(solo.getMiniatureName())) {
					return solo;
				}
			}
		} catch(FileNotFoundException e) {
			throw new RuntimeException("crashed in parseWarcaster from queryParser");
		}
		return null;
	}
	
	public static Unit parseUnit(String unitName) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "units.json"));
			Unit[] temp = gson.fromJson(br, Unit[].class);
			for(Unit unit : temp) {
				if(unitName.equals(unit.getMiniatureName())) {
					return unit;
				}
			}
		} catch(FileNotFoundException e) {
			throw new RuntimeException("crashed in parseWarcaster from queryParser");
		}
		return null;
	}
	
	public static UnitAttachment parseUnitAttachment(String attachmentName) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "unitAttachments.json"));
			UnitAttachment[] temp = gson.fromJson(br, UnitAttachment[].class);
			for(UnitAttachment unitAttachment : temp) {
				if(attachmentName.equals(unitAttachment.getMiniatureName())) {
					return unitAttachment;
				}
			}
		} catch(FileNotFoundException e) {
			throw new RuntimeException("crashed in parseWarcaster from queryParser");
		}
		return null;
	}
	
	public static WarcasterAttachment parseWarcasterAttachment(String attachmentName) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "warcasterAttachment.json"));
			WarcasterAttachment[] temp = gson.fromJson(br, WarcasterAttachment[].class);
			for(WarcasterAttachment warcasterAttachment : temp) {
				if(attachmentName.equals(warcasterAttachment.getMiniatureName())) {
					return warcasterAttachment;
				}
			}
		} catch(FileNotFoundException e) {
			throw new RuntimeException("crashed in parseWarcaster from queryParser");
		}
		return null;
	}
	
	public static JuniorWarcaster parseJuniorWarcaster(String juniorCaster) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "juniorWarcasters.json"));
			JuniorWarcaster[] temp = gson.fromJson(br, JuniorWarcaster[].class);
			for(JuniorWarcaster juniorWarcaster: temp) {
				if(juniorCaster.equals(juniorWarcaster.getMiniatureName())) {
					return juniorWarcaster;
				}
			}
		} catch(Exception e) {
			throw new RuntimeException("crashed in parseWarcaster from queryParser" + e.getMessage());
		}
		return null;
	}
	
}
