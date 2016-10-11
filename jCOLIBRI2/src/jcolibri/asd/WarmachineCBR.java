package jcolibri.asd;

import a.TempPackage.Miniature;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.connector.DataBaseConnector;
import jcolibri.examples.TravelRecommender.TravelRecommender;
import jcolibri.exception.ExecutionException;

public class WarmachineCBR implements StandardCBRApplication {

	private static WarmachineCBR instance = null;
	private Connector connector;
	private CBRCaseBase caseBase;
	
	private WarmachineCBR() {
		
	}
	
	public static WarmachineCBR getInstance() {
		if(instance == null) {
			instance = new WarmachineCBR();
		}
		return instance;
	}
	
	
	@Override
	public void configure() throws ExecutionException {
		// TODO Auto-generated method stub
		try {
			//a.warmachine.database.WarmachineDBConnect.init();
			jcolibri.test.database.HSQLDBserver.init();
			
			connector = new WarmachineDBConnector();
			connector.initFromXMLfile(jcolibri.util.FileIO.findFile("jcolibri/asd/databaseconfig.xml"));
			caseBase = new LinealCaseBase();
		} catch(Exception e){
			throw new ExecutionException(e);
		}
	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		caseBase.init(connector);
		java.util.Collection<CBRCase> cases = caseBase.getCases();
		System.out.println("CASES: " + cases.size());
		for(CBRCase c:cases) {
			System.out.println(c);
			System.out.println("hello");
		}
		return caseBase;
	}

	@Override
	public void cycle(CBRQuery query) throws ExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postCycle() throws ExecutionException {
		// TODO Auto-generated method stub
		connector.close();
		//a.warmachine.database.WarmachineDBConnect.shutDown();
		jcolibri.test.database.HSQLDBserver.shutDown();
	}
	
	private CBRQuery createTestQuery() {
		return new CBRQuery();
	}
	
	public static void main(String[] args) {
		WarmachineCBR cbr = getInstance();
		//TestDescription miniature = new TestDescription();
		//miniature.setArm(5);
		//System.out.println(miniature.getArm());
		try {
			cbr.configure();
			cbr.preCycle();

			boolean cont = true;
			while(cont) {
				CBRQuery query = cbr.createTestQuery();
			
				cbr.cycle(query);
				int ans = javax.swing.JOptionPane.showConfirmDialog(null, "CBR cycle finished, query again?", "Cycle finished", javax.swing.JOptionPane.YES_NO_OPTION);
				cont = (ans == javax.swing.JOptionPane.YES_OPTION);
			}
			cbr.postCycle();
		} catch(Exception e) {
			org.apache.commons.logging.LogFactory.getLog(TravelRecommender.class).error(e);
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
		}
		System.exit(0);
		
	}

}
