package daytwelveday12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockDemo {
public static void main(String[] args) {
	Crane crane=new Crane();
	Frog frog=new Frog();
	ExecutorService es=Executors.newFixedThreadPool(2);
	es.execute(()->{
		crane.eat(frog);
	});
	es.execute(()->{
		frog.escape(crane);
	}
	);
	es.shutdown();
}
}
class Crane
{
	public void eat(Frog frog)
	{
		frog.leaveCrane();;
	}
	synchronized public void spitfrog()
	{
		
	}
}
class Frog
{
	public void escape(Crane c)
	{
		c.spitfrog();
	}
	synchronized public void leaveCrane()
	{
		
	}
}