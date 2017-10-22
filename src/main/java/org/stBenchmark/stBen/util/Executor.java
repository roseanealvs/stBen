package org.stBenchmark.stBen.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.ListIterator;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Executor<T> {
	private MongoCollection<Document> collection;
	private long start;

	public Executor() {
		collection = getCollection();
	}
	
	public void executeCrud(Class<T> classe) {
		try {
			logStart(classe);
			
			Method method = classe.getMethod("executeCommand", MongoCollection.class);
			method.invoke(classe.newInstance(), collection);
			
			logEnd();
           
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | InstantiationException e) {
			Logging.getLogger(Executor.class).info("Erro ao ler o método requerido.");
		}
	}
	
	private void logEnd() {
		long end = System.currentTimeMillis();
		long time = end - start;
		Logging.getLogger(Executor.class).info("THREAD: "+Thread.currentThread().getName()+" - execução finalizada. Tempo total: "+time+" ms");
	}

	private void logStart(Class<T> classe) {
		Logging.getLogger(Executor.class).info("THREAD: "+Thread.currentThread().getName() + " - execução iniciada");
		start = System.currentTimeMillis();
	}
	
	private MongoCollection<Document> getCollection() {
		MongoClient mongo = Connection.connect();
		Logging.getLogger(Connection.class).info("Connectado!");
		MongoDatabase db = mongo.getDatabase("stBen_db");
		MongoCollection<Document> collection = db.getCollection("people");
		return collection;
	}
   
}
