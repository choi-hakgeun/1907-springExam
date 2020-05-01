package di_step3;

// 사용될 객체를 비즈니스 로직이 있는 클래스에서 작업하지 않고
// 외부에 둠으로 주요한 비즈니스 로직을 보호
public class Assembler {
	DB db;
	public DB getDb() {
		return new MsSql();
	}
}
