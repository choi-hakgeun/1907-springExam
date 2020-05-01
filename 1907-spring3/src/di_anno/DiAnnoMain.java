package di_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DiAnnoMain {
	public DiAnnoMain() {
		ApplicationContext ac =
				new FileSystemXmlApplicationContext("src/di_anno/anno.xml");
		
		AnnoDao dao = (AnnoDao)ac.getBean("dao");
		
	}
	
	
	public static void main(String[] args) {
		new DiAnnoMain();

	}

}
