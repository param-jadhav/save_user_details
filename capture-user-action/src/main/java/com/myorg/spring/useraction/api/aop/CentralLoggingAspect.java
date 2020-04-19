package com.myorg.spring.useraction.api.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.fasterxml.jackson.databind.ObjectMapper;
@Aspect
@Component
public class CentralLoggingAspect {
	org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(CentralLoggingAspect.class);
	// log configuration for resource
	@Pointcut(value = "execution(* com.javatechie.spring.mockito.api.*.*.*(..) )")
	public void myPintcut() {

	}
	@Around("myPintcut()")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint
				.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		// will get method arguments
		Object[] argArray = proceedingJoinPoint.getArgs();
		final StopWatch stopWatch = new StopWatch();

		// Measure method execution time
		stopWatch.start();
		// Log method execution time
		log.info(className + "." + methodName + "() " + ":: arguments :"
				+ mapper.writeValueAsString(argArray) + "exe time : "
				+ stopWatch.getTotalTimeMillis() + " - ms");
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();
		log.info(className + " :" + methodName + "Response : "
				+ mapper.writeValueAsString(result) + "exe time : "
				+ stopWatch.getTotalTimeMillis() + "-ms");
		return result;
	}
}
