package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CyngarResultParser {

private static final String dataFilePath = "E:\\jCOLIBRI2\\Warmachine\\data\\wtc_2016_results.csv";
private static final String cygnarResultsFile = "E:\\jCOLIBRI2\\Warmachine\\data\\cygnar_wtc_results.data";
private static final Path writeFile = Paths.get(cygnarResultsFile);
private static final Path readFile = Paths.get(dataFilePath);

	public void readAndWriteCygnarResults() {
		Map<Integer, ArrayList<String>> map = createMatches();
		try {
			
		for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet())
		{
			ArrayList<String> val = entry.getValue();
			if(checkForCygnar(val)) {
				String writeableString = val.toString() + "\n";
				System.out.println(writeableString);
					Files.write(writeFile, writeableString.getBytes(), StandardOpenOption.APPEND);
			}
		    //System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
			/*
		try {
				
			
			BufferedReader br = new BufferedReader(new FileReader(dataFilePath));
			String currentLine;
			currentLine = br.readLine();
			while(currentLine != null) {
				String[] components = currentLine.split(",");
				ArrayList<String> searchable = new ArrayList<String>(Arrays.asList(components));
				if(searchable.contains("\"Cygnar\"")){
					String writeableString = searchable.toString() + "\n";
					System.out.println(writeableString);
					Files.write(file, writeableString.getBytes(), StandardOpenOption.APPEND);
				}
				currentLine = br.readLine();
			}
			br.close();
		} catch(Exception e) {
			throw new RuntimeException("We dun goofed while writing cygnar results! " + e.getMessage());
		}
		*/
	}
	
	private boolean checkForCygnar(ArrayList<String> list) {
		for(String str : list) {
			if(str.contains("Cygnar")) {
				return true;
			}
		}
		return false;
	}
	
	
	private Map<Integer, ArrayList<String>> createMatches() {
		Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		try {
			ArrayList<String> allEntries = new ArrayList<String>(Files.readAllLines(readFile)); 
			for(String item : allEntries) {
				String fixedItem = item.replace("\"", "");
				String[] temp = fixedItem.split(",");
				
				Integer key = Integer.parseInt(temp[0]);
				if(map.get(key) == null) {
					ArrayList<String> firstEntry = new ArrayList<String>(); 
					firstEntry.add(fixedItem);
					map.put(key, firstEntry);
				} else {
					ArrayList<String> updateEntry = map.get(key);
					updateEntry.add(fixedItem);
					map.put(key, updateEntry);
				}
			}
			return map;
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void main(String args[]) {
		CyngarResultParser parser = new CyngarResultParser();
		parser.readAndWriteCygnarResults();
	}
	
}
