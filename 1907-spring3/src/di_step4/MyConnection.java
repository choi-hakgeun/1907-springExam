package di_step4;

import java.sql.Connection;

public class MyConnection {
	String userName;
	String passWord;
	Connection conn;
	
	public Connection getConn() {
		System.out.println(userName);
		System.out.println(passWord);
		return conn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
