import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
	private static int data = 0;
	//private static Map<Thread,Integer> threadData = new HashMap<Thread,Integer>();
	public static void main(String[] agrs){	
		for (int i=0;i<5;i++){
		new Thread(new Runnable(){
			public void run(){
				data = new Random().nextInt();
				//threadData.put(Thread.currentThread(),data);
				System.out.println(Thread.currentThread().getName()+"had pu data:"+data);
				new A().get();
				new B().get();
			}
		}).start();
		}
	}
	
	static class A {//Ä£¿é
		public int get(){
			//int data = threadData.get(Thread.currentThread());
			System.out.println("A from"+Thread.currentThread().getName()+" get data:"+data);
			return data;
		}
	}
	
	static class B{
		public int get(){
			System.out.println("B from"+Thread.currentThread().getName()+" get data:"+data);
			return data;
		}
	}

}
