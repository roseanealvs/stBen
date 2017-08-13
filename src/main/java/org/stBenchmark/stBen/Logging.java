package org.stBenchmark.stBen;

import org.apache.log4j.Logger;

public class Logging {
	
	public static Logger getLogger(Class<?> myClass) {
		return Logger.getLogger(myClass);
	}
}
