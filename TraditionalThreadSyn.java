
public class TraditionalThreadSyn {
	public static void main(String[] agrs){	
		new TraditionalThreadSyn().init();
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
	class Outputer{
		String xxx = "";//��Ϊ��֪��Output����
		
		public synchronized void output(String name){ //�Դ����ٽ���������������������synchronized,������
			int len = name.length();
			//synchronized(name){ //������ͬһ������
			//synchronized(xxx){ //�ԡ����ͬһ������
			//synchronized(this){ //����֪��ʵ����������ʱ�򣬸��÷�������д�����������У��������������л���
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			//}
			System.out.println();
		}
		
	}
}
