
public class TraditionalThread{
	public static void main(String[] args){
	Thread thread = new Thread(){
	@Override
	public void run(){
		while(true){
			try{
			Thread.sleep(500);
			}catch (InterruptedException e) { 
				e.printStackTrace();
			} 
			System.out.println(Thread.currentThread().getName());
		}
	}
	};//一个线程在java中也是一个类
	thread.start(); //找到thread中的run()方法进行执行
	
	Thread thread2 = new Thread(new Runnable(){
		@Override
		public void run(){
			while(true){
				try{
				Thread.sleep(500);
				}catch (InterruptedException e) { 
					e.printStackTrace();
				} 
				System.out.println(Thread.currentThread().getName());
			}
		}
	});
	thread2.start(); //找到thread中的run()方法进行执行
 }
}