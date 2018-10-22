
public class MultiThreadShare_DifferMethod2 {

	public static void main(String[] agrs){	
		ShareData3 data1 = new ShareData3();
		new Thread(new MyRunnable1(data1)).start();
		new Thread(new MyRunnable2(data1)).start();
	}
	
}

class MyRunnable1 implements Runnable{
	private ShareData3 data1;
	
	public MyRunnable1(ShareData3 data1){
		this.data1 = data1;
	}
	
	public void run(){
		while(true){
			data1.increcement();
		}
	}
	
}

class MyRunnable2 implements Runnable{
	private ShareData3 data1;
	
	public MyRunnable2(ShareData3 data1){
		this.data1 = data1;
	}
	
	public void run(){
		while(true){
			data1.decrecement();
		}
	}
	
}

class ShareData3{
	private int count = 0;
	public void increcement(){
		    try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			System.out.println("Thread:"+Thread.currentThread().getName()+",coutn is:"+count);
		}
	public void decrecement(){
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			count--;
			System.out.println("Thread:"+Thread.currentThread().getName()+",coutn is:"+count);
		}
}
