package day15;

import java.io.*;
class OnlyExt implements FilenameFilter{
	String ext;
	public OnlyExt(String e) {
		ext="."+e;  
	}
	public boolean accept(File dir, String name){
		return name.endsWith(ext);
	}   
}


public class DirListOnly{
	public static void main(String args[]){
		String dirname="C:\\Users\\AISHWARYA\\eclipse-workspace\\basic\\src\\day15";
		File f1=new File(dirname);
		FilenameFilter only=new OnlyExt("java");
		String s[]=f1.list(only);
		for (int i=0;i<s.length;i++){
			System.out.println(s[i]); 
		}    
	}   
}
