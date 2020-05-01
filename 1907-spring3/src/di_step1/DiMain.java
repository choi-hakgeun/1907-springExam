package di_step1;

public class DiMain {

	public DiMain(MySql sql ) {
		sql.getIrum();
	}
	public static void main(String[] args) {
		MySql sql = new MySql();
		new DiMain(sql);

	}

}
