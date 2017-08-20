package org.stBenchmark.stBen.crud;

import java.util.ListIterator;

import org.bson.Document;
import org.json.simple.JSONArray;

import com.mongodb.client.MongoCollection;

public interface RequiredExecutor {
	public void executeCommand(MongoCollection<Document> collection, ListIterator<JSONArray> files);
}
