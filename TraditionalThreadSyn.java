
public class TraditionalThreadSyn {
	public static void main(String[] agrs){	
		new TraditionalThreadSyn().init();
	}
	
	private void init(){ //使用
		final Outputer outputer = new Outputer();//static方法中不能用内部类的实例对象，静态方法可以不创建对象
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
		String xxx = "";//因为不知道Output名字
		
		public synchronized void output(String name){ //对代码临界区保护，但绝不能两个synchronized,会死锁
			int len = name.length();
			//synchronized(name){ //错，必须同一个对象
			//synchronized(xxx){ //对。针对同一个对象
			//synchronized(this){ //当不知道实例化的名字时候，该用法还可以写到两个方法中，对两个方法进行互斥
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			//}
			System.out.println();
		}
		
	}
}
