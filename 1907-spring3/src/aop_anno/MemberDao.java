package aop_anno;

public class MemberDao implements Dao{
	
	public void select() {
		System.out.println("member select...............");
	}
	public void view() {
		System.out.println("member view...............");
	}
	public void modify() {
		System.out.println("member modify...............");
	}
	
	public void insert() {
		System.out.println("member insert...............");
	}
	public void delete() {
		System.out.println("member delete...............");
	}
}
