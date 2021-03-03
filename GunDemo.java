package daytwelveday12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GunDemo {
public static void main(String[] args) {
	Gun gun=new Gun();
	ExecutorService es=Executors.newFixedThreadPool(2);
	es.execute(()->{
		for(int i=0;i<5;i++)
		{
			gun.fillgun();
		}});
	es.execute(()->{
		for(int i=0;i<5;i++)
		{
			gun.shootgun();
		}
	});
	es.shutdown();
}
}
class Gun
{
	boolean flag;
	synchronized public void fillgun()
	{
		if(flag)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("fill gun");
		flag=true;
		notify();
	}
	synchronized public void shootgun()
	{
		if(!flag)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("gun shoot");
		flag=false;
		notify();
	}
}