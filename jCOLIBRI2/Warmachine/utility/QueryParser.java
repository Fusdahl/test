package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;

import jcolibri.cbrcore.CBRQuery;
import models.Army;
import models.Solo;
import models.Unit;
import models.Warcaster;
import models.Warjack;

public class QueryParser {
	private static final String QUERY_FILEPATH = "E:\\jCOLIBRI2\\Warmachine\\queries\\";


	public CBRQuery parseQuery(int queryNumber) {
		CBRQuery retVal = new CBRQuery();
		Army army = new Army();
		try {
			BufferedReader br = new BufferedReader(new FileReader(QUERY_FILEPATH + "query" + queryNumber + ".json"));
			String currentLine;
			currentLine = br.readLine();
			while(currentLine != null) {
				String[] components = currentLine.split(":");
				String miniatureType = components[0];
				String miniatureName = components[1];
				switch(miniatureType) {
				case "warcaster": {
					army.addMiniature(MiniatureReader.parseWarcaster(miniatureName));
				} break;
				case "warcasterWarjack": {
					army.addMiniature(MiniatureReader.parseWarjack(miniatureName));
				} break;
				case "solo": {
					army.addMiniature(MiniatureReader.parseSolo(miniatureName));
				} break;
				case "unit": {
					army.addMiniature(MiniatureReader.parseUnit(miniatureName));
				} break;
				default:
					br.close();
					throw new RuntimeException("Missed all switches when parsing query!");
				}
				
				currentLine = br.readLine();
			}
			retVal.setDescription(army);
			br.close();
		} catch(FileNotFoundException e) {
			throw new RuntimeException("Crashed when parsing query number: " + queryNumber + " File not found: " + QUERY_FILEPATH + "query" + queryNumber + ".json" );
		} catch(IOException e) {
			throw new RuntimeException("Crashed when parsing query number: " + queryNumber + " IOException");
		}
		
		return retVal;
	}
	
	
}
