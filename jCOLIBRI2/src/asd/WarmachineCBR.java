/**
 * Travel Recommender example for the jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garcú}.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 25/07/2006
 */
package asd;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import asd.TestDBServer;
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
					.findFile("asd/databaseconfig.xml"));
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

	public void cycle(CBRQuery query) throws ExecutionException {
		// Obtain configuration for KNN
		
	}

	public void postCycle() throws ExecutionException {
		System.out.println("Shutting down");
		_connector.close();
		TestDBServer.shutDown();
	}

	
	public static void main(String[] args) {
	
		WarmachineCBR recommender = getInstance();
		try
		{
			recommender.configure();
			recommender.preCycle();

			
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
