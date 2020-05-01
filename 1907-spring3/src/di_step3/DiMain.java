package di_step3;

public class DiMain {

	public DiMain(DB db) {
		db.getIrum();
	}
	
	public static void main(String[] args) {
		Assembler ass = new Assembler();
		DB db = ass.getDb();
		DiMain dm = new DiMain(db);

	}

}
