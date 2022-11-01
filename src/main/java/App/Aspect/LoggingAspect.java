package App.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect //an aspect is a modularization of a concern that cuts across multiple classes
@Configuration
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Used to log information to a file before any of the methods in the data layer are called
     * @param joinPoint represents the functions that are going to be executed
     */
    @Before("execution (* App.Repository.*.*(..))")
    public void logBefore(JoinPoint joinPoint){

        log.info("Intercepted method call of {}", joinPoint.getSignature().getName());

    }

}
