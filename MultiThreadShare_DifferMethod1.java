
public class MultiThreadShare_DifferMethod1 {
	private static ShareData2 data2 = new ShareData2();
	public static void main(String[] agrs){	
		//final ShareData2 data2  = new ShareData2();

		new Thread(new Runnable(){
			public void run(){
				while(true)
				{
					data2.increcement();
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run(){
				while(true){
					data2.decrecement();
				}
			}
		}).start();
	}

}

class ShareData2{
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
