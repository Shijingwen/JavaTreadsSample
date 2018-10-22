import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] agrs){	
		new LockTest().init();
	}
	
	private void init(){ //ʹ��
		final Outputer outputer = new Outputer();//static�����в������ڲ����ʵ�����󣬾�̬�������Բ���������
		new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						Thread.sleep(10);
					}catch(InterruptedException e){
						e.printStackTrace();
						}
					outputer.output("ffffff");
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						Thread.sleep(10);
					}catch(InterruptedException e){
						e.printStackTrace();
						}
					outputer.output("qqqqqq");
				}
			}
		}).start();
	}
	static class Outputer{
		
		Lock lock = new ReentrantLock();
		public void output(String name){ //�Դ����ٽ���������������������synchronized,������
			int len = name.length();
			lock.lock();
	        try{
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
	        }finally{
			lock.unlock();
			}
			System.out.println();
		}
		
	}
}
