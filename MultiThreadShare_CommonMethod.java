public class MultiThreadShare_CommonMethod {
	public static void main(String[] agrs){	
		ShareData1 data1  = new ShareData1();
		new Thread(data1).start();
		new Thread(data1).start();
	}
}
	class ShareData1 implements Runnable{
		private int count = 10000;  //代码相同时候共享
		public void run(){
			while(true){
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count--;
				System.out.println("Thread:"+Thread.currentThread().getName()+",count is:"+count);
			}
		}
	}

