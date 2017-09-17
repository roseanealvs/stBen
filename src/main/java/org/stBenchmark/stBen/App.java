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
	
    public static void main( String[] args )
    {
    	ExecutorService myExecutor = Executors.newFixedThreadPool(3);
    	Runnable user1 = RunnableThreadFactory.getRunnableWriterUser();
    	Runnable user2 = RunnableThreadFactory.getRunnableWriterUser();
    	Runnable user3 = RunnableThreadFactory.getRunnableWriterUser();
    	
    	myExecutor.submit(user1);
    	myExecutor.submit(user2);
    	myExecutor.submit(user3);
    	
    	myExecutor.shutdown();
    	

    }
}
