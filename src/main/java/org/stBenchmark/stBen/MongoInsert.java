package org.stBenchmark.stBen;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class MongoInsert {
	
	/**
	  * Inserts a batch of 1 to 1000 documents
	  */
	public void insertDocuments(DBCollection collection, JSONArray records) {
		
		List<DBObject> dbObjects = new ArrayList<>();
    	
		for ( Object jsonObj : records  ) {
			dbObjects.add((DBObject) JSON.parse(jsonObj.toString()));
		}
//		collection.drop();
		collection.insert(dbObjects);
	}

}
