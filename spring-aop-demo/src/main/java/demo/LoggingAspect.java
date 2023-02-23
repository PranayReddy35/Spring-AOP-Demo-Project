package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* demo.ShoppingCart.checkout(..))")
	public void beforeLogger(JoinPoint jp) {
		
		//System.out.println(jp.getSignature());
		
		String arg=jp.getArgs().clone()[0].toString();
		
		System.out.println("Before Loggers with Argument: "+ arg);
	}

	@After("execution(* *.*.checkout(..))")
	public void afterLogger() {
		
		System.out.println("After Loggers.");
		
	}
	
	@Pointcut("execution(* demo.ShoppingCart.quantity(..))")
	public void afterReturningPointCut() {
		
	}
	
	@AfterReturning(pointcut = "afterReturningPointCut()",returning="retVal") 
	public void afterReturning(String retVal) {
		System.out.println("After Returning : " + retVal);
	}
	
	
}
