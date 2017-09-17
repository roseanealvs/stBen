package org.stBenchmark.stBen.crud;

import java.util.ListIterator;

import org.bson.Document;
import org.json.simple.JSONArray;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;

public class Select implements RequiredExecutor {
	@Override
	public void executeCommand(MongoCollection<Document> collection, ListIterator<JSONArray> files) {
		selectDocuments(collection, files);
	}
	
	private void selectDocuments(MongoCollection<Document> collection, ListIterator<JSONArray> files) {

		collection.find().forEach((Block<Document>) doc -> {
			files.add((JSONArray)JSON.parse(doc.toString()));
		});
	
	}
}
