package aop_step2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Advisor {
	Dao dao;
	SimpleDateFormat logTime =
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");
	
	public void before() { // advice(시간적 개념)
		System.out.println(logTime.format(new Date()));
		dao.select(); // joinPoint(공간적 개념)
	}
	
	public void after() {
		dao.delete();
		System.out.println(logTime.format(new Date()));
	}
	public void around() {
		System.out.println(logTime.format(new Date()));
		dao.insert();
		System.out.println(logTime.format(new Date()));
	}
	
	
	
	public Dao getDao() { return dao; }
	public void setDao(Dao dao) { this.dao = dao;	}
	
	
	
	
	
	
	
}
