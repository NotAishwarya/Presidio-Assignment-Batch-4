package day15;

import java.io.*;

public class FileDirectoryDemo {
public static void main(String[] args) {
	String dirName = "\\Users\\AISHWARYA\\eclipse-workspace\\basic\\src\\day14";
	
	File f1 = new File(dirName);
	System.out.println(f1.getAbsolutePath());
	
	if(f1.isDirectory()) {
		System.out.println("Is a directory");
		String[] s = f1.list();
		for(int i = 0 ;i < s.length ; i++) {
			System.out.println(s[i]);
		}
	}
	
}
}
