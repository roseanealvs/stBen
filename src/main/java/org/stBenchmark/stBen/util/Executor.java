package org.stBenchmark.stBen.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ListIterator;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class Executor<T> {
	private ListIterator<JSONArray> files;
	private MongoCollection<Document> collection;
	
	public Executor() {
		files = new Reader().readAllDataFromDirectory();
		collection = getCollection();
	}
	@LogExecutionTime
	public void executeCrud(Class<T> classe) {
		try {
			Method method = classe.getMethod("executeCommand", MongoCollection.class, ListIterator.class);
			method.invoke(classe.newInstance(), collection, files);
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | InstantiationException e) {
			Logging.getLogger(Executor.class).info("Erro ao ler o método requerido.");
		}
	}
	
	private MongoCollection<Document> getCollection() {
		MongoClient mongo = Connection.connect();
		MongoDatabase db = mongo.getDatabase("stBen_db");
		MongoCollection<Document> collection = db.getCollection("people");
		return collection;
	}
   
}
