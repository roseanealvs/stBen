package org.stBenchmark.stBen;

import java.util.ListIterator;

import org.json.simple.JSONArray;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * @author Roseane Alves
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	App app = new App();
    	
    	DBCollection collection = app.getCollection();
		
		ListIterator<JSONArray> files = new Reader().readAllDataFromDirectory();
		
    	app.insertAllDocuments(collection, files);
    	
    }

	private void insertAllDocuments(DBCollection collection, ListIterator<JSONArray> files) {
		Logging.getLogger(App.class).info("Inserção iniciada...");
		long startTime = System.currentTimeMillis();	
    	
		Crud mInsert = new Crud();

		while ( files.hasNext() ) {
			mInsert.insertDocuments(collection, files.next());
		}
		
		long totalTime = (System.currentTimeMillis() - startTime);
    	Logging.getLogger(App.class).info("Inserção concluída em " + totalTime + " milisegundos.");
	}

	private DBCollection getCollection() {
		MongoClient mongo = Connection.connect();
		DB db = mongo.getDB("stBen_db");
		DBCollection collection = db.getCollection("people");
		return collection;
	}
   
}
