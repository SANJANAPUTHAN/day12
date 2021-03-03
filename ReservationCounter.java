package daytwelveday12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReservationCounter {
public static void main(String[] args) {
	Reservation r=new Reservation();
	ExecutorService es=Executors.newFixedThreadPool(2);
	es.execute(()->{
		Thread.currentThread().setName("sanjana");
		synchronized(r)
		{
			r.getTicket(1000);
			r.getchange();
		}
	});
	es.execute(()->{
		Thread.currentThread().setName("anu");
		synchronized(r)
		{
			r.getTicket(500);
			r.getchange();
		}
	});
	es.shutdown();
}
}
class Reservation
{
	int amt;
	public void getTicket(int amt)
	{
		this.amt=amt;
		String name=Thread.currentThread().getName();
		System.out.println("ticket sold to "+name+ " "+amt);
		
	}
	public void getchange()
	{
		String name=Thread.currentThread().getName();
		System.out.println("ticket change given to name "+" "+(amt-100));
	}
}