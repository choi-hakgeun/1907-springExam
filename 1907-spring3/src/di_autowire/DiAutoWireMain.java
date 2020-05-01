package di_autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DiAutoWireMain {

	public DiAutoWireMain() {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("src/di_autowire/autowire_name.xml");

		ByNameDao dao = (ByNameDao)context.getBean("dao");
		
		ByTypeDao dao2 = (ByTypeDao)context.getBean("dao2");
	
	}
	
	public static void main(String[] args) {
		new DiAutoWireMain();

	}

}
