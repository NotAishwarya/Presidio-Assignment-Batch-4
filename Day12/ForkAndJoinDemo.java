package day12;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinDemo {
public static void main(String[] args) {
	String arr[] = {"a","b","c","a","g","d","a","f","a"};
	
	ForkJoinPool fjp = ForkJoinPool.commonPool();
	
	MyTask task1 = new MyTask(arr, 0, 3, "a" );
	MyTask task2 = new MyTask(arr, 3, 5, "a" );
	MyTask task3 = new MyTask(arr, 5, 7, "a" );
	MyTask task4 = new MyTask(arr, 7, 9, "a" );
	
	int total = fjp.invoke(task1) + fjp.invoke(task2) + fjp.invoke(task3) + fjp.invoke(task4);
	
	System.out.println("Total count of \"a\" is " + total);
	
}
}

class MyTask extends RecursiveTask<Integer>{

	String arr[];
	int start, end;
	int count = 0;
	String searchWord;
	
	public MyTask(String[] arr, int start, int end, String searchWord) {
		// TODO Auto-generated constructor stub
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.searchWord = searchWord;
	}
	
	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = start; i < end; i++ ) {
			if(arr[i].equalsIgnoreCase(searchWord))
				count++;
		}
		return count;
	}
	
}
