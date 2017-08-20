package org.stBenchmark.stBen.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.bson.Document;
import org.json.simple.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;

public class Insert implements RequiredExecutor{
	@Override
	public void executeCommand(MongoCollection<Document> collection, ListIterator<JSONArray> files) {

		while ( files.hasNext() ) {
			insertDocuments(collection, files.next());
		}
	}
	
	/**
	  * Inserts a batch of 1 to 1000 documents
	  */
	private void insertDocuments(MongoCollection<Document> collection, JSONArray records) {
		
		List<Document> documents = new ArrayList<>();
	
		for ( Object jsonObj : records  ) {
			documents.add(new Document((BasicDBObject) JSON.parse(jsonObj.toString())));
		}

		collection.insertMany(documents);
		collection.drop();
	}

}
