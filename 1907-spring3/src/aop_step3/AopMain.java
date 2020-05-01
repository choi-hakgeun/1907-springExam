package aop_step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
	public AopMain() {
		ApplicationContext ac =
				new FileSystemXmlApplicationContext("src/aop_step3/aop.xml");
		
		Dao dao = (Dao)ac.getBean("proxy");
		dao.select();
		
		
	}
	public static void main(String[] args) {
		new AopMain();

	}

}
