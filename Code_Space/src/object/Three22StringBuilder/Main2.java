package object.Three22StringBuilder;

public class Main2 {

	public static void main(String[] args) {
		Adder adder = new Adder();
		adder.add(2)
		.add(3)
		.inc()
		.add(10);
		System.out.println(adder.value());
	}

}

class Adder{
	private int sum = 0;
	
	public Adder add(int n ) {
		sum += n;
		return this;
	}
	
	public Adder inc() {
		sum++;
		return this;
	}
	
	public int value() {
		return sum;
	}
}
