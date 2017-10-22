package org.stBenchmark.stBen.crud;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;

public class Select implements RequiredExecutor {
	private List<JSONObject> objetos;
	
	public List<JSONObject> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<JSONObject> objetos) {
		this.objetos = objetos;
	}

	@Override
	public void executeCommand(MongoCollection<Document> collection) {
		selectDocuments(collection);
	}
	
	private void selectDocuments(MongoCollection<Document> collection) {
		objetos = new ArrayList<>();
		
		collection.find().forEach((Block<Document>) doc -> {
			try {
				objetos.add((JSONObject)new JSONParser().parse(doc.toJson()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}
}
