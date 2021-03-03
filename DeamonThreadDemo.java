package daytwelveday12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeamonThreadDemo {
	public DeamonThreadDemo() {
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			while(true)
			{
				System.out.println("child thread 1....");
			}
		});
		es.execute(()->{
			while(true)
			{
				System.out.println("child thread 2 executed....");
			}
		});
		es.shutdown();
	}
public static void main(String[] args) {
	new DeamonThreadDemo();
	new AnotherThread();
	System.out.println("main thread");
	Thread.currentThread().setDaemon(true);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.exit(0);
}
}
class AnotherThread {
	public AnotherThread() {
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			
				System.out.println("child thread 3....");
			
		});
	}
}
