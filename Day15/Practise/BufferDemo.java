package day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferDemo {
public static void main(String[] args) throws Exception {
	final int EOF = -1;
	
	byte b[] = new byte[2];
	
	FileInputStream fis = new FileInputStream("abc.txt");
	FileOutputStream fos = new FileOutputStream("abcd.txt");
	
	System.out.println(fis.available());
	
	int reading = 0;
	
	while((reading = fis.read(b)) != EOF) {
		//System.out.println(((char)reading));
		fos.write(b);
	}
	
	fis.close();
	fos.close();
	
}
}
