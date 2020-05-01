package aop_step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
	public AopMain() {
		ApplicationContext ac =
				new FileSystemXmlApplicationContext("src/aop_step2/aop.xml");
		
		Advisor ad = (Advisor)ac.getBean("advisor");
		
		ad.before();
		ad.after();
		ad.around();
		
		
	}
	public static void main(String[] args) {
		new AopMain();

	}

}
