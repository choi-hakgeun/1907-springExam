package di_step4;

import java.sql.Connection;

public class MemberDao {
	MyConnection conn;
	
	public MemberDao(MyConnection conn) {
		this.conn = conn;
		conn.getConn();
		System.out.println("connection......");
	}
	
}
