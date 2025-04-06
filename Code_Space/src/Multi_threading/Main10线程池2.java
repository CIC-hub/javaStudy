package Multi_threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main10线程池2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
		// 1秒后执行一次性任务:
//		ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
//		// 2秒后开始执行定时任务，每3秒执行:
		ses.scheduleAtFixedRate(new Task("fixed-rate"), 2,3, TimeUnit.SECONDS);
//		// 2秒后开始执行定时任务，以3秒为间隔执行:
//		ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
	}

}
