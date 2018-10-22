import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class ThreadPoolTest {
	public static void main(String[] agrs){	
		ExecutorService threadPool = Executors.newFixedThreadPool(16);
		//ExecutorService threadPool = Executors.newSingleThreadExecutor();线程死了，马上找新的替代
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int j =1;j<=100;j++)
		{
			final int task = j;
		threadPool.execute(new Runnable(){
			public void run(){
				for(int i=1;i<10;i++)
				{
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"  is loopig for :"+i+"for task of:"+task);
				}
			}
		});
		}
		System.out.println("All of the 10 tasks  have been committed");
		//threadPool.shutdown();
		Executors.newScheduledThreadPool(3).schedule(
				new Runnable(){
				public void run(){
					System.out.println("Boom!");
			}},
				10,
				TimeUnit.SECONDS);
	}
}
