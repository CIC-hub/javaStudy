package Multi_threading;

public class Main1创建新线程 {

	public static void main(String[] args) {
		Thread t1 = new Thread1();
		t1.start();
		
		Thread t2 = new Thread(new Runnable1());
		t2.start();
		
		Thread t3 = new Thread(() -> {
			System.out.println("start new thread t3");
		});
		t3.start();
	}
}

class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println("start new thread thread1");
	}
}

class Runnable1 implements Runnable{
	public void run() {
		System.out.println("start new thread Runnable1");
	}
}