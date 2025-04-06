package Multi_threading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Basic_Grammar.inout;

public class Main8线程同步 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		var q = new TaskQueue();
		var ts = new ArrayList<Thread>();
		for (int i = 0; i < 5; i++) {
			var t = new Thread() {
				public void run() {
                    // 执行task:
					while (true) {
						try {
							String s = q.getTask();
							System.out.println("execute task: "+ s);
						} catch (InterruptedException  e) {
							// TODO: handle exception
							return;
						}
					}
				}
			};
			t.start();
			ts.add(t);
		}
		var add = new Thread(() -> {
			for(int i=0;i<10;i++) {
				//放入task
				String s = "t-" + Math.random();
				System.out.println("add task: " + s);
				q.addTask(s);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		});
		add.start();
		add.join();
		Thread.sleep(100);
		for(var t:ts) {
			t.interrupt();
		}
	}

}

class TaskQueue{
	Queue<String> queue = new LinkedList<String>();
	
	public synchronized void addTask(String s) {
		this.queue.add(s);
		this.notifyAll();
	}
	
	public synchronized String getTask() throws InterruptedException{
		while(queue.isEmpty()) {
			this.wait();
		}
		return queue.remove();
	}
}