package day15;

import java.io.*;

public class SequenceInputStreamDemo {
public static void main(String[] args) throws Exception {
	
	ByteArrayInputStream bis = new ByteArrayInputStream("This is a trap".getBytes());
	StringBufferInputStream sis = new StringBufferInputStream(" Not really!");
	SequenceInputStream sqis = new SequenceInputStream(bis, sis);
	
	int ch;
	while((ch = sqis.read()) != -1) {
		System.out.print((char)ch);
	}
	
}
}
