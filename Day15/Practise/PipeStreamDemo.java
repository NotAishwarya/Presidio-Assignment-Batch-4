package day15;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PipeStreamDemo {
public static void main(String[] args) throws Exception {
	PipedInputStream pis = new PipedInputStream();
	PipedOutputStream pos = new PipedOutputStream(pis);
	
	ExecutorService es = Executors.newFixedThreadPool(2);
	
	es.execute(()->{
		int i =0;
		try {
			while((i = pis.read() )!= -1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});
	
	es.execute(()->{
		while(true) {
			try {
				pos.write("Hey you! You are the best!!!......".getBytes());
				Thread.sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	});
}
}
