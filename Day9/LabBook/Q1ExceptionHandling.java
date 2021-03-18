package day9;

import java.io.IOException;

public class Q1ExceptionHandling {
public static void main(String[] args) throws IOException {
	throw new IOException();
	
	//If throws clause isn't used, compilation doesn't happen.
	//If you don't catch the object, the program terminates.
}
}
