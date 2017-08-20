package org.stBenchmark.stBen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stBenchmark.stBen.crud.Insert;
import org.stBenchmark.stBen.util.Executor;

/**
 * @author Roseane Alves
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
		new Executor<Insert>().executeCrud(Insert.class);
    }
}
