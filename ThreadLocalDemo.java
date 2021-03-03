package daytwelveday12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
public static void main(String[] args) {
	ExecutorService es=Executors.newFixedThreadPool(2);
	es.execute(()->{
		Office.getLaptop("sanjana");
		Office.closeMyLapTop();
		
	});
	es.execute(()->{
		Office.getLaptop("sanj");
		Office.getLaptop("sanj");
	});
}
}
class Laptop
{
	String name;
	Laptop(String name)
	{
		System.out.println("laptop created...");
		this.name=name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	@Override
	public String toString() {
		return name;
	}
}
class Office
{
	private static ThreadLocal locker=new ThreadLocal();
	public static Laptop getLaptop(String name)
	{
		Laptop laptop=(Laptop)locker.get();
		if(laptop==null) {
			laptop=new Laptop(name);
			locker.set(laptop);
		}
		return laptop;
	}
	public static void closeMyLapTop() {
		Laptop laptop=(Laptop)locker.get();
		if(laptop!=null) {
			locker.remove();
		}
	}
}