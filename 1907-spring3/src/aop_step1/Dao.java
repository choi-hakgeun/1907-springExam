package aop_step1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dao {
	SimpleDateFormat logTime =
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");
	public void select() {
		System.out.println("select...............");
		System.out.println(logTime.format(new Date()));
	}
	public void view() {
		System.out.println("view...............");
		System.out.println(logTime.format(new Date()));
	}
	public void modify() {
		System.out.println("modify...............");
		System.out.println(logTime.format(new Date()));
	}
	
	public void insert() {
		System.out.println("insert...............");
		System.out.println(logTime.format(new Date()));
	}
	public void delete() {
		System.out.println("delete...............");
		System.out.println(logTime.format(new Date()));
	}
}
