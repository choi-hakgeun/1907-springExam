package aop_step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
	public AopMain() {
		ApplicationContext ac =
				new FileSystemXmlApplicationContext("src/aop_step1/aop.xml");
		Dao dao = (Dao)ac.getBean("dao");
		dao.select();
		dao.delete();
	}
	public static void main(String[] args) {
		new AopMain();

	}

}
