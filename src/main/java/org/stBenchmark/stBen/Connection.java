package org.stBenchmark.stBen;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class Connection {
	private static MongoClient MONGO_CONN; 
	
	public static MongoClient connect() {
		if (MONGO_CONN == null) {
			try {
				MONGO_CONN = new MongoClient( "localhost" , 27017 );
				Logging.getLogger(Connection.class).info("Connectado!");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		return MONGO_CONN;
	}
}
