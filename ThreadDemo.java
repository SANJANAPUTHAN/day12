package daytwelveday12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
public ThreadDemo() {
	ExecutorService es=Executors.newFixedThreadPool(1);
	es.execute(()->{System.out.println("executor called...");});
	es.shutdown();
	
}
public static void main(String[] args) throws Exception {
	new ThreadDemo();
	for(int i=0;i<5;i++)
	{
		System.out.println(i);
		Thread.sleep(1000);
	}
}
}
