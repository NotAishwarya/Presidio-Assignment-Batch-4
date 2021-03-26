package day15;

import java.io.*;

public class FileDemo {
public static void main(String[] args) {
	File f1 = new File("abc.txt");
	System.out.println("File name " + f1.getName());
	System.out.println("File Path " + f1.getAbsolutePath());
	System.out.println(f1.exists()? "exists" : "Not existent");
	System.out.println(f1.canWrite()? " IsWriteable" : "NotWritable");
	System.out.println(f1.isDirectory()? "is a dir": "is not a directory");
}
}
