package aop_anno;

public class BoardDao implements Dao{
	public void select() {
		System.out.println("board select...............");
	}
	public void view() {
		System.out.println("board view...............");
	}
	public void modify() {
		System.out.println("board modify...............");
	}
	
	public void insert() {
		System.out.println("board insert...............");
	}
	public void delete() {
		System.out.println("board delete...............");
	}
}
