package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jcolibri.cbrcore.CBRCase;
import models.Army;
import models.Miniature;

public class Retain {
	private static final String caseIdFilePath = "E:\\jCOLIBRI2\\Warmachine\\data\\caseId.data";
	private static final String caseBaseFilePath= "E:\\jCOLIBRI2\\Warmachine\\src\\MiniatureAndArmy.sql";
	private static final String baseInsertMappingString = "insert into armyMiniatureMapping(caseId, miniatureId)  values(";
	private static final String baseInsertArmyString="\ninsert into army(caseId) values(";
	private static Path caseIdFile = Paths.get(caseIdFilePath);

	
	public static void retainCase(CBRCase selectedCase) {
		try {
			Army selectedArmy = (Army)selectedCase.getDescription();
			List<String> lines = new ArrayList<String>();
			int currentCaseId = readCaseId();
			String insertArmyString = baseInsertArmyString + currentCaseId + ");";
			lines.add(insertArmyString);
			for(Miniature currentMiniature : selectedArmy.getMiniatures()) {
				String insertString = baseInsertMappingString;
				insertString += currentCaseId + ", " + currentMiniature.getMiniatureId() + ");";
				lines.add(insertString);
			}
			Path file = Paths.get(caseBaseFilePath);
			System.out.println("file: " + file);
			System.out.println(lines);
			incrementCaseId();
			//Files.write(file, lines, Charset.forName("UTF-8"));
		    Files.write(file, lines, StandardOpenOption.APPEND);

		} catch (Exception e) {
			
		}
	}
	
	private static int readCaseId() {
		try(BufferedReader br = new BufferedReader(new FileReader(caseIdFilePath))) {
		    String line = br.readLine();
		    return Integer.parseInt(line);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private static void incrementCaseId() {
		try {
			
		List<String> fileContent = new ArrayList<>(Files.readAllLines(caseIdFile, StandardCharsets.UTF_8));
		int currentId = Integer.parseInt(fileContent.get(0));
		fileContent.set(0, Integer.toString(currentId + 1));
		Files.write(caseIdFile, fileContent, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException("Crashed wile incrementing case id in retain." + e.getMessage());
		}
	}

}
