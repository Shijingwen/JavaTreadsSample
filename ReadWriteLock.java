import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;;;
public class ReadWriteLock {
	public static void main(String[] args){
		final Queue3 q3 = new Queue3();
		for(int i =0;i<3;i++)
		{		

			new Thread(){
				public void run(){
					while(true){
						q3.get();
					}
				}
			}.start();
			
			new Thread(){
				public void run(){
					while(true){
						q3.put(new Random().nextInt(10000));
					}
				}
			}.start();
			
			new Thread(){
				public void run(){
					while(true){
						q3.get();
					}
				}
			}.start();
			

		}
	}
}
class Queue3{
	private Object data = null;//share
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	public void get() {
		rwl.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+" be ready to read");
			System.out.println(Thread.currentThread().getName()+" have read data:"+data);
		}catch(Throwable  e){
			e.printStackTrace();
		}finally{
			rwl.readLock().unlock();
		}
	}
	public void put(Object data){	
		rwl.writeLock().lock();
		try {		
			System.out.println(Thread.currentThread().getName()+" be ready to write");		
			this.data = data;
			System.out.println(Thread.currentThread().getName()+" have written data:"+data);
		} catch (Throwable  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rwl.writeLock().unlock();
		}

	}
}
