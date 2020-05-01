package aop_aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
	public AopMain() {
		ApplicationContext ac =
				new FileSystemXmlApplicationContext("src/aop_aspectj/aop.xml");
		
		Dao dao = (Dao)ac.getBean("member");
		dao.select();
		dao.modify();
		dao.delete();
		dao.view();
		dao.insert();
		
		
		
	}
	public static void main(String[] args) {
		new AopMain();

	}

}
