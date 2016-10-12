package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import models.Solo;
import models.Unit;
import models.UnitAttachment;
import models.Warcaster;
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
				if(warjackName.equals(warjack.getMiniatureName())) {
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
	
	public static UnitAttachment parseAttachment(String attachmentName) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "units.json"));
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
	
}
