package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadDemo {
public static void main(String[] args) {
	new DaemonThreadDemoClass();
	
	System.out.println("Main thread started");
	
	Thread.currentThread().setDaemon(true);  //This line should give exception. But It doesn't when child threads are created. Why ?
	
	while(true)
		System.out.println("main thread");
}
}

class DaemonThreadDemoClass{
	public DaemonThreadDemoClass() {
		// TODO Auto-generated constructor stub
		new Thread(()->{
			while(true)
				System.out.println("Child Thread..............");
		}).start();
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		es.execute(()->{
			while(true)
				System.out.println("Child Thread");
		});
	}
}