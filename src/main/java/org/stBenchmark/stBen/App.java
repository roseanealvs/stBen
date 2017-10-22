package org.stBenchmark.stBen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.stBenchmark.stBen.util.RunnableThreadFactory;

/**
 * @author Roseane Alves
 *
 */
public class App 
{
	private static final int MAX_POOL_SIZE = 2;
	private static final int NUMBER_OF_REQUESTS = 3;
	
    public static void main( String[] args )
    {
    	
    	ExecutorService myExecutor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
//    	for (int i = 0; i < NUMBER_OF_REQUESTS; i++) {
    		myExecutor.submit(RunnableThreadFactory.getRunnableWriterUser());
//    		myExecutor.submit(RunnableThreadFactory.getRunnableReaderUser());
//    	}

    	myExecutor.shutdown();
    	
    }
}
