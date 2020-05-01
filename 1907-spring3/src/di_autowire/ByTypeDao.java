package di_autowire;

public class ByTypeDao {
	DB abc;

	public DB getAbc() {
		return abc;
	}

	// 필드명에 상관없이 유형이 동일하면 자동 주입 */
	public void setAbc(DB abc) {
		this.abc = abc;
		abc.getIrum();
	}
	
	
}
