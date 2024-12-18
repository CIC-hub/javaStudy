package Exception;

public class Main4抛出异常 {

	public static void main(String[] args) {
		try {
			process2(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void process1() {
		throw new NullPointerException();
	}
	
	static void process2(String s) {
		try {
			process1();
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
