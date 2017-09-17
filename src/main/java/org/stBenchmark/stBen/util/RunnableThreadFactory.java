package org.stBenchmark.stBen.util;

import org.stBenchmark.stBen.crud.Insert;
import org.stBenchmark.stBen.crud.Select;

public class RunnableThreadFactory {
	
	public static Runnable getRunnableWriterUser() {
		return new Runnable() {
    		@Override
    		public void run() {
    			new Executor<Insert>().executeCrud(Insert.class);
    		}
    	};
	}
	
	public static Runnable getRunnableReaderUser() {
		return new Runnable() {
    		@Override
    		public void run() {
    	    	new Executor<Select>().executeCrud(Select.class);
    		}
    	};
	}
}
