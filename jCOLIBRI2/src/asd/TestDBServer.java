/**
 * HSQLDBserver.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garcú}.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 04/07/2007
 */
package asd;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import jcolibri.test.database.SqlFile;
import jcolibri.util.FileIO;

import org.hsqldb.Server;


/**
 * Creates a data base server with the tables for the examples/tests using the HSQLDB library.
 * @author Juan A. Recio-Garcia
 * @version 1.0
 */
public class TestDBServer 
{
    static boolean initialized = false;

    private static Server server;

    /**
     * Initialize the server
     */
    public static void init()
    {
	if (initialized)
	    return;
        org.apache.commons.logging.LogFactory.getLog(TestDBServer.class).info("Creating data base ...");

	server = new Server();
	server.setDatabaseName(0, "miniature");
	server.setDatabasePath(0, "mem:miniature;sql.enforce_strict_size=true");
	
	server.setLogWriter(null);
	server.setErrWriter(null);
	server.setSilent(true);
	server.start();

	initialized = true;
	try
	{
	    Class.forName("org.hsqldb.jdbcDriver");

	    PrintStream out = new PrintStream(new ByteArrayOutputStream());
	    Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/miniature", "sa", "");
	    SqlFile file = new SqlFile(new
	    File(FileIO.findFile("asd/MiniatureAndArmy.sql").getFile()),false,new HashMap());
	    // Last input is whether to fail on errors or not. IMPORTANT
	    file.execute(conn,out,out, false);
	    
	    
	    org.apache.commons.logging.LogFactory.getLog(TestDBServer.class).info("Data base generation finished");
	    
	} catch (Exception e)
	{
	    org.apache.commons.logging.LogFactory.getLog(TestDBServer.class).error(e);
	}

    }

    /**
     * Shutdown the server
     */
    public static void shutDown()
    {

	if (initialized)
	{
		System.out.println("Server stopped");
	    server.stop();
	    initialized = false;
	}
    }

    /**
     * Testing method
     */
    public static void main(String[] args)
    {
    	TestDBServer.init();
    	System.out.println(server.getDatabaseName(0, true));
    	TestDBServer.shutDown();
    	System.exit(0);
	
    }

}
