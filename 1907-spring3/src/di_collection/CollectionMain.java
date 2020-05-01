package di_collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di_step4.Assembler;

public class CollectionMain {
	public CollectionMain() {
		ApplicationContext ac = 
				new FileSystemXmlApplicationContext("src/di_collection/collection.xml");

		//CollectionTest coll = (CollectionTest)ac.getBean("coll");

		//list
		MyColl coll = (MyColl)ac.getBean("coll");
		
		System.out.println("list...................");
		List<String> list = coll.getList();
		for(String str : list) {
			System.out.println(str);
		}
		
		//set
		System.out.println("set....................");
		Set<String> set = coll.getSet();
		for(String str : set) {
			System.out.println(str);
		}
		
		//map
		System.out.println("map........................");
		Map<String, String> map = coll.getMap();
		Set<String> keys = map.keySet();
		for(String k : keys) {
			System.out.println(k + " : " + map.get(k));
		}
		//prop
		System.out.println("properties..................");
		Properties props = coll.getProps();
		Set<Object> propKey = props.keySet();
		for(Object k : propKey) {
			System.out.println(k + " : " +  props.get(k));
		}
	}
	
	
	public static void main(String[] args) {
		new CollectionMain();

	}

}
