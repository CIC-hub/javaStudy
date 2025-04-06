package Multi_threading;

import java.util.concurrent.*;

public class Main9线程池 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = 2;
		int max = 4;
        ExecutorService es = Executors.newFixedThreadPool(4);
//		ExecutorService es = Executors.newCachedThreadPool();

    //Exception
//        ExecutorService es = new ThreadPoolExecutor(
//    	        min, max,
//    	        60L, TimeUnit.SECONDS,
//    	        new SynchronousQueue<Runnable>());
        for(int i=0;i<6;i++) {
			es.submit(new Task(""+i));
		}
		es.shutdown();	
	}
	



}

class Task implements Runnable{
	private final String name;
	
	public Task(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("start task" + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("end task " + name);
	}	
}