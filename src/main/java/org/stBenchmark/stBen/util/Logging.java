package org.stBenchmark.stBen.util;

import org.apache.log4j.Logger;

public class Logging {
	
	public static Logger getLogger(Class<?> myClass) {
		return Logger.getLogger(myClass);
	}
}
