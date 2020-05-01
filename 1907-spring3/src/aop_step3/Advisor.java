package aop_step3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Advisor implements MethodInterceptor{
	
	SimpleDateFormat logTime =
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		//횡단적 관심사로 분리된 처리 내용
		System.out.println(logTime.format(new Date()));
		
		Object o = invocation.proceed();// 호출됨 메서드를 실행

		System.out.println(logTime.format(new Date()));

		return o;
	}

	
	
	
	
}
