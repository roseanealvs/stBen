package org.stBenchmark.stBen.config;

import java.util.Date;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

@SuppressWarnings("serial")
public class CustomPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {

	public CustomPerformanceMonitorInterceptor() {
    }

    public CustomPerformanceMonitorInterceptor(boolean useDynamicLogger) {
    	setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log log) throws Throwable {
        
        String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        log.info("Método "+name+" - execução iniciada em: "+new Date());
        try {
            return invocation.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            log.info("Método "+name+" - execução durou: "+time+" ms");
            log.info("Método "+name+" - execução finalizada em: "+new Date());
        }
    }
}
