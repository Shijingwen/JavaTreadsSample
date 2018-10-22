
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
	};//һ���߳���java��Ҳ��һ����
	thread.start(); //�ҵ�thread�е�run()��������ִ��
	
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
	thread2.start(); //�ҵ�thread�е�run()��������ִ��
 }
}