/**
 * Travel Recommender example for the jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garcú}.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 25/07/2006
 */
package src;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.TestDBServer;
import utility.UserInputHelper;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.connector.DataBaseConnector;
import jcolibri.examples.TravelRecommender.gui.AutoAdaptationDialog;
import jcolibri.examples.TravelRecommender.gui.QueryDialog;
import jcolibri.examples.TravelRecommender.gui.ResultDialog;
import jcolibri.examples.TravelRecommender.gui.RetainDialog;
import jcolibri.examples.TravelRecommender.gui.RevisionDialog;
import jcolibri.examples.TravelRecommender.gui.SimilarityDialog;
import jcolibri.exception.ExecutionException;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.selection.SelectCases;
import jcolibri.method.reuse.NumericDirectProportionMethod;
import jcolibri.util.FileIO;
import models.Army;
import models.Race;
import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import es.ucm.fdi.gaia.ontobridge.OntologyDocument;


/**
 * Implementes the recommender main class
 * @author Juan A. Recio-Garcia
 * @version 1.0
 */
public class WarmachineCBR implements StandardCBRApplication {

	private static WarmachineCBR _instance = null;
	public  static WarmachineCBR getInstance()
	{
		if(_instance == null)
		   _instance = new WarmachineCBR();
		return _instance;
	}
	
	private WarmachineCBR()
	{
	}
	
	/** Connector object */
	Connector _connector;
	/** CaseBase object */
	CBRCaseBase _caseBase;
	
	public void configure() throws ExecutionException {
		try {
			//Emulate data base server
			TestDBServer.init();
			
			// Create a data base connector
			_connector = new WarmachineDBConnector();
			
			_connector.initFromXMLfile(jcolibri.util.FileIO
					.findFile("src/databaseconfig.xml"));
			//_connector.initFromXMLfile("");
			_caseBase = new LinealCaseBase();
			
		} catch (Exception e) {
			throw new ExecutionException(e);
		}
	}
	
	public CBRCaseBase preCycle() throws ExecutionException {
		// Load cases from connector into the case base
		_caseBase.init(_connector);		
		// Print the cases
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for(CBRCase c: cases)
			System.out.println(c.toString());
		return _caseBase;
	}
	
	public void parseQuery(String filePath) {
		
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		ArrayList<CBRCase> kBestCases = retrieveKBestCases();
		
	}

	public void postCycle() throws ExecutionException {
		System.out.println("Shutting down");
		_connector.close();
		TestDBServer.shutDown();
	}
	
	private ArrayList<CBRCase> retrieveKBestCases() {
		ArrayList<CBRCase> kBestCases = new ArrayList<CBRCase>();
		// TODO More of this can be moved to Retrieval class
		System.out.println("Please enter the type of retrieval you want. 1 -> One list against one race. 2 -> One list against a subset of races. 3 -> One all-comers. 4 -> Two-list all comers");
		Scanner reader = new Scanner(System.in);
		int retrievalPriority = reader.nextInt();
		//Needed to consume \n
		reader.nextLine();
		Retrieval retrievalHelper = new Retrieval(_caseBase);
		switch(retrievalPriority) {
		case 1: {
			// One list against one race
			System.out.println("Please specify the opponents race: ");
			String inputRace = reader.nextLine().toLowerCase();
			Race targetRace = UserInputHelper.RaceConverter(inputRace);
			
			// TODO: k should be user input I guess!! 
			int k = 2;
			kBestCases = retrievalHelper.SimpleRetrieval(targetRace, k);
			System.out.println("The " + k + " best cases:");
			for(CBRCase c : kBestCases) {
				System.out.println( ((Army) c.getDescription()).findScore(targetRace).toString());
			}
		} break;
		case 2: {
			// One list against a subset of races
			System.out.println("Please specify the races separated by , : ");
			String enemyRaces = reader.nextLine().toLowerCase();
		} break;
		case 3: {
			// One all-comers
		} break;
		case 4: {
			// two-list all comers
		} break;
		}
		reader.close();
		return null;
	}

	
	public static void main(String[] args) {
		WarmachineCBR recommender = getInstance();
		try
		{
			recommender.configure();
			recommender.preCycle();
			recommender.cycle(null);
			
			
			boolean cont = true;
			while(cont)
			{
				//recommender.cycle(null);
				//int ans = javax.swing.JOptionPane.showConfirmDialog(null, "CBR cycle finished, query again?", "Cycle finished", javax.swing.JOptionPane.YES_NO_OPTION);
				//cont = (ans == javax.swing.JOptionPane.YES_OPTION);
				cont = false;
			}
			recommender.postCycle();
		}catch(Exception e)
		{
			org.apache.commons.logging.LogFactory.getLog(WarmachineCBR.class).error(e);
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
		}
		System.exit(0);
	}
}
