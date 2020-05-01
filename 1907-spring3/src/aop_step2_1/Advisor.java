package aop_step2_1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Advisor {
	Dao member;
	
	SimpleDateFormat logTime =
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");
	
	public void before() { // advice(시간적 개념)
		System.out.println(logTime.format(new Date()));
		member.select(); // joinPoint(공간적 개념)
	}
	
	public void after() {
		member.delete();
		System.out.println(logTime.format(new Date()));
	}
	public void around() {
		System.out.println(logTime.format(new Date()));
		member.insert();
		System.out.println(logTime.format(new Date()));
	}

	public Dao getMember() {
		return member;
	}

	public void setMember(Dao member) {
		this.member = member;
	}

	
	
	
	
}
