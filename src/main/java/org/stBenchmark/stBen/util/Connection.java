package org.stBenchmark.stBen.util;


import com.mongodb.MongoClient;

public class Connection {
	private static MongoClient MONGO_CONN; 
	
	public static MongoClient connect() {
		if (MONGO_CONN == null) {
			MONGO_CONN = new MongoClient( "localhost" , 27017 );
			
		}
		return MONGO_CONN;
	}
}
