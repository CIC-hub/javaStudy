package Multi_threading;

public class Main6中断线程 {
	public static void main(String[] args) throws InterruptedException{
		HelloThread2 t = new HelloThread2();
		t.start();
		Thread.sleep(1);
		t.running = false;
	}
}
class HelloThread2 extends Thread{
	public volatile boolean running = true;
	public void run() {
		int n = 0;
		while (running) {
			n++;
			System.out.println(n+"hello!");
		}
		System.out.println("end!");
	}
}