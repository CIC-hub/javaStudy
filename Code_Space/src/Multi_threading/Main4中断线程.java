package Multi_threading;

public class Main4中断线程 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Thread t = new MyThread();
		t.start();
		Thread.sleep(1);
		t.interrupt();
		t.join();
		System.out.println("end");
	}

}

class MyThread extends Thread{
	public void run() {
		int n = 0;
		while (! isInterrupted()) {
			n++;
			System.out.println(n + "hello!");
		}
	}
}