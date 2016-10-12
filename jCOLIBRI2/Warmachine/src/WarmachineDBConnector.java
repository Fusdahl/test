/**
 * DataBaseConnector.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garcú}.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 02/01/2007
 */
package src;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.*;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;  
import org.w3c.dom.Document;

import com.google.gson.Gson;

import jal.objects.Predicate;
import jcolibri.cbrcore.*;
import jcolibri.exception.InitializingException;
import jcolibri.util.FileIO;
import jdk.nashorn.internal.parser.JSONParser;
import models.Army;
import models.BaseMiniature;
import models.Miniature;
import models.Score;
import models.Solo;
import models.Unit;
import models.UnitAttachment;
import models.Warcaster;
import models.Warjack;
import utility.JsonNameMatcher;
import utility.MiniatureReader;

/**
 * Implements a data base connector using the <a href="www.hibernate.org">Hibernate package</a>.
 * <p>
 * The configuration file follows the schema defined in
 * <a href="DataBaseConnector.xsd">/doc/configfilesSchemas/DataBaseConnector.xsd</a>:
 * <p>
 * <img src="DataBaseConnectorSchema.jpg">
 * <p> 
 * There are several examples that incrementally show how to use this connector: Test1, Test2, Test3, Test4 and Test5.
 * 
 * @author Juan Antonio Recio Garcú}
 * @version 2.0
 * 
 * @see jcolibri.test.test1.Test1
 * @see jcolibri.test.test2.Test2
 * @see jcolibri.test.test3.Test3
 * @see jcolibri.test.test4.Test4
 * @see jcolibri.test.test5.Test5
 */
public class WarmachineDBConnector implements Connector {

	private static final String MINIATURE_TABLE = "miniature";
	private static final String ARMY_TABLE = "army";
	private static final String WARCASTER_TABLE = "warcaster";
	private static final String ARMY_MINIATURE_JUNCTION = "armyMiniatureMapping";
	private static final String JSON_FILEPATH = "E:\\jCOLIBRI2\\Warmachine\\data\\";
	
	SessionFactory sessionFactory;
	private String descriptionClassName;
	private String solutionClassName;
	private String justOfSolutionClassName;
	private String resultClassName;
	
	
	/* (non-Javadoc)
	 * @see jcolibri.cbrcore.Connector#close()
	 */
	public void close() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see jcolibri.cbrcore.Connector#deleteCases(java.util.Collection)
	 */
	public void deleteCases(Collection<CBRCase> cases) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see jcolibri.cbrcore.Connector#initFromXMLfile(java.io.File)
	 */
	public void initFromXMLfile(URL file) throws InitializingException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        //factory.setValidating(true);   
	        //factory.setNamespaceAware(true);
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document document = builder.parse( file.openStream() );
	        
	        String hcf = document.getElementsByTagName("HibernateConfigFile").item(0).getTextContent();
	        
	        String descriptionMapFile = document.getElementsByTagName("DescriptionMappingFile").item(0).getTextContent();
	        descriptionClassName = document.getElementsByTagName("DescriptionClassName").item(0).getTextContent();
	        
	        Configuration hbconfig = new Configuration();
	        hbconfig.configure(FileIO.findFile(hcf));
	        hbconfig.addURL(FileIO.findFile(descriptionMapFile));
	        
	        try{
		        String solutionMapFile = document.getElementsByTagName("SolutionMappingFile").item(0).getTextContent();
		        solutionClassName = document.getElementsByTagName("SolutionClassName").item(0).getTextContent();	 
		        hbconfig.addResource(solutionMapFile);
	        }catch(Exception e)
	        {
	        	org.apache.commons.logging.LogFactory.getLog(this.getClass()).info("Case does not have solution");
	        }
	        
	        try{
		        String justOfSolutionMapFile = document.getElementsByTagName("JustificationOfSolutionMappingFile").item(0).getTextContent();
		        justOfSolutionClassName = document.getElementsByTagName("JustificationOfSolutionClassName").item(0).getTextContent();	 
		        hbconfig.addResource(justOfSolutionMapFile);
	        }catch(Exception e)
	        {
	        	org.apache.commons.logging.LogFactory.getLog(this.getClass()).info("Case does not have justification of the solution");
	        }
	        
	        try{
		        String resultMapFile = document.getElementsByTagName("ResultMappingFile").item(0).getTextContent();
		        resultClassName = document.getElementsByTagName("ResultClassName").item(0).getTextContent();	 
		        hbconfig.addResource(resultMapFile);
	        }catch(Exception e)
	        {
	        	org.apache.commons.logging.LogFactory.getLog(this.getClass()).info("Case does not have result");
	        }
	             
	        
	        sessionFactory = hbconfig.buildSessionFactory();
				
		} catch (Throwable ex) {
			throw new InitializingException(ex);
		}

	}

	// Personal code added here
	public Collection<CBRCase> retrieveAllCases(){
		
		java.util.ArrayList<CBRCase> res = new java.util.ArrayList<CBRCase>();
	
		try 
		{
			Session session;// = sessionFactory.openSession();				
			Transaction transaction; //= session.beginTransaction();
					
			List descList = null;
			HashMap<Object, CaseComponent> solList = null;
			HashMap<Object, CaseComponent> justSolList = null;
			HashMap<Object, CaseComponent> resList = null;
			
			
			if(solutionClassName != null)
			{
				session = sessionFactory.openSession();	
				transaction = session.beginTransaction();

				solList = new HashMap<Object, CaseComponent>();
				List l = session.createQuery("from " + solutionClassName).list();
				
				transaction.commit();
				session.close();
				
				for(Iterator iter = l.iterator(); iter.hasNext();)
				{
					CaseComponent cc = (CaseComponent)iter.next();
					solList.put(cc.getIdAttribute().getValue(cc), cc);
				}
			}
			if(justOfSolutionClassName != null)
			{
				session = sessionFactory.openSession();	
				transaction = session.beginTransaction();

				justSolList = new HashMap<Object, CaseComponent>();
				List l = session.createQuery("from " + justOfSolutionClassName).list();
				transaction.commit();
				session.close();

				for(Iterator iter = l.iterator(); iter.hasNext();)
				{
					CaseComponent cc = (CaseComponent)iter.next();
					justSolList.put(cc.getIdAttribute().getValue(cc), cc);
				}
			}
			if(resultClassName != null)
			{
				session = sessionFactory.openSession();	
				transaction = session.beginTransaction();

				resList = new HashMap<Object, CaseComponent>();
				List l = session.createQuery("from " + resultClassName).list();
				transaction.commit();
				session.close();

				for(Iterator iter = l.iterator(); iter.hasNext();)
				{
					CaseComponent cc = (CaseComponent)iter.next();
					resList.put(cc.getIdAttribute().getValue(cc), cc);
				}
			}

			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			//descList = session.createSQLQuery("SELECT * FROM *").list();
			descList = session.createQuery("from "+ descriptionClassName).list();			
			transaction.commit();
			session.close();

			for(Iterator iter = descList.iterator(); iter.hasNext();)
			{
				CBRCase _case = new CBRCase();
				Army desc = (Army)iter.next();
				addMiniaturesToArmy(desc);
				_case.setDescription(desc);
				
				if(solutionClassName != null)
				{
					CaseComponent cc = solList.get(desc.getIdAttribute().getValue(desc));
					if(cc != null)
						_case.setSolution(cc);
				}
				if(justOfSolutionClassName != null)
				{
					CaseComponent cc = justSolList.get(desc.getIdAttribute().getValue(desc));
					if(cc != null)
						_case.setJustificationOfSolution(cc);
				}						
				if(resultClassName != null)
				{
					CaseComponent cc = resList.get(desc.getIdAttribute().getValue(desc));
					if(cc != null)
						_case.setResult(cc);
				}
						
				res.add(_case);
				
			}
			
			//transaction.commit();
			//session.close();
			
		} catch (Exception e) {
			org.apache.commons.logging.LogFactory.getLog(this.getClass()).error(e);
		}
		org.apache.commons.logging.LogFactory.getLog(this.getClass()).info(res.size()+" cases read from the database.");
		return res;
	}
	
	private void addMiniaturesToArmy(Army army) {
		Session session;// = sessionFactory.openSession();				
		Transaction transaction; //= session.beginTransaction();
		session = sessionFactory.openSession();	
		transaction = session.beginTransaction();
		List descList = session.createSQLQuery("SELECT * FROM " + ARMY_MINIATURE_JUNCTION + " WHERE caseId = " + army.getCaseId()).list();
		transaction.commit();
		session.close();
		for(Iterator iter = descList.iterator(); iter.hasNext();)
		{
			Object[] obj = (Object[]) iter.next();
			Integer miniatureId = Integer.parseInt(String.valueOf(obj[1]));
			Integer miniatureCount = Integer.parseInt(String.valueOf(obj[2]));
			BaseMiniature currentMiniature = getMiniature(miniatureId);
			for(int i = 0; i < miniatureCount; ++i) {
				army.addMiniature(castMiniature(currentMiniature));
			}
			readScores(army);
			System.out.println(army);
		}
	}
	
	// Parameter should be an enum
	private Miniature castMiniature(BaseMiniature miniature) {
		Gson gson = new Gson();
		
		Miniature retVal = null;
		try {
			switch(miniature.getMiniatureType()) {
			case 1: {
				retVal = MiniatureReader.parseWarcaster(miniature.getMiniatureName());
			} break;
			case 2: {
				retVal = MiniatureReader.parseWarjack(miniature.getMiniatureName());
			} break;
			case 3: {
				retVal = MiniatureReader.parseSolo(miniature.getMiniatureName());
			} break;
			case 4: {
				retVal = MiniatureReader.parseUnit(miniature.getMiniatureName());
			} break;
			case 5: {
				retVal = MiniatureReader.parseAttachment(miniature.getMiniatureName());
			} break;
		}
			
		} catch (Exception e) {
			System.out.println("Crashed in cast Miniature with miniature ID: " + miniature.getMiniatureId() + " and miniature name: " + miniature.getMiniatureName());
			throw new RuntimeException(e);
		}
		
		return retVal;
	}
	
	private void readScores(Army army) {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILEPATH + "scores.json"));
			Score[] temp = gson.fromJson(br, Score[].class);
			System.out.println(temp);
			// This should be optimized...
			for(Score score : temp) {
				if (score != null && score.getCaseId() == army.getCaseId()) {
					army.addScore(score);
				}
			}
		} catch (Exception e) {
			System.out.println("Crashed in readScores with caseId: " + army.getCaseId());
			throw new RuntimeException(e);
		}
	}
	
	private BaseMiniature getMiniature(int miniatureId) {
		Session session;// = sessionFactory.openSession();				
		Transaction transaction; //= session.beginTransaction();
		session = sessionFactory.openSession();	
		transaction = session.beginTransaction();
		//Seems to call some kind of update of miniature for some reason.. WHY?
		BaseMiniature miniature = (BaseMiniature) session.createSQLQuery("SELECT * FROM " + MINIATURE_TABLE + " WHERE miniatureId = " + miniatureId).addEntity(BaseMiniature.class).list().get(0);
		//descList = session.createQuery("from "+ descriptionClassName).list();			
		transaction.commit();
		session.close();
		return miniature;
	}
	/*
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			ArrayList<Warcaster> test = new ArrayList<Warcaster>();
			Warcaster warcaster = new Warcaster();
			warcaster.setMiniatureName("haley2");
			warcaster.setFocus(8);
			warcaster.setWarcasterPoints(25);
			test.add(warcaster);
			test.add(warcaster);

			// 1. Java object to JSON, and save into a file
			System.out.println(gson.toJson(test));
			System.out.println("Hello");
			//gson.toJson(warcaster, new FileWriter("E:\\jCOLIBRI2\\src\\asd\\warcasters.json"));
			// 2. Java object to JSON, and assign to a String
			//String jsonInString = gson.toJson(warcaster);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	*/
	
	

	/* (non-Javadoc)
	 * @see jcolibri.cbrcore.Connector#retrieveSomeCases(jcolibri.cbrcore.CaseBaseFilter)
	 */
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see jcolibri.cbrcore.Connector#storeCases(java.util.Collection)
	 */
	public void storeCases(Collection<CBRCase> cases) {
		
		
		for(CBRCase c: cases)
		{
			Session session = sessionFactory.openSession();	
			Transaction transaction = session.beginTransaction();
				session.save(c.getDescription());
			transaction.commit();
			session.close();

			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			if(c.getSolution()!= null)
				session.saveOrUpdate(c.getSolution());
			transaction.commit();
			session.close();

			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			if(c.getJustificationOfSolution() != null)
				session.saveOrUpdate(c.getJustificationOfSolution());
			transaction.commit();
			session.close();

			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			if(c.getResult() != null)
				session.saveOrUpdate(c.getResult());
			transaction.commit();
			session.close();
		}
		

		org.apache.commons.logging.LogFactory.getLog(this.getClass()).info(cases.size()+" cases stored into the database.");

	}
}
