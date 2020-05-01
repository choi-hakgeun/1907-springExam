package di_step4;

public class Assembler {
	DB db;
	public Assembler(DB db) {
		this.db = db;
	}
	
	public DB getDb() {
		return db;
	}
	
}
