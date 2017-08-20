package org.stBenchmark.stBen.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfiguration {
	 @Pointcut("execution(public void org.stBenchmark.stBen.util.Executor.executeCrud(..))")
	    public void monitor() { }
	 
	 @Bean
	    public CustomPerformanceMonitorInterceptor customPerformanceMonitorInterceptor() {
	        return new CustomPerformanceMonitorInterceptor(true);
	    }
	 
	 @Bean
	    public Advisor customPerformanceMonitorAdvisor() {
	        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	        pointcut.setExpression("org.stBenchmark.stBen.config.AopConfiguration.monitor()");
	        return new DefaultPointcutAdvisor(pointcut, customPerformanceMonitorInterceptor());
	    }
	
	   
}
