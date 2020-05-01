package aop_anno;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Advisor {
	
	SimpleDateFormat logTime =
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");

	@Before("execution(* aop_anno.Dao.*(..))")
	public Object beforeMethod(JoinPoint point) {
		System.out.println(logTime.format(new Date()));
		return null;
	}
	
	@Around("execution(* modify(..))")
	public Object aroundMethod(ProceedingJoinPoint point) {
		
		try {
			System.out.println(logTime.format(new Date()));
			point.proceed();
			System.out.println(logTime.format(new Date()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
