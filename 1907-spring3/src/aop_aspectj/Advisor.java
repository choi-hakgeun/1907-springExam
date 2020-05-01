package aop_aspectj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;

public class Advisor {
	
	SimpleDateFormat logTime =
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");

	public Object beforeMethod(JoinPoint point) {
		System.out.println(logTime.format(new Date()));
		return null;
		
	}
	
	
}
