package di_step2;

public class DiMain {

	public DiMain(DB sql ) {
		sql.getIrum();
	}
	public static void main(String[] args) {
		Oracle sql = new Oracle();
		new DiMain(sql);

	}

}
