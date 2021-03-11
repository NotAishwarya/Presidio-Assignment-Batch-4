package day4;

public class Q13 {
public static void main(String[] args) {
	int student[][]= {
			{99,89,78,85}, //Student 1
			{81,90,92,83}, //Student 2
			{70,80,82,94} //Student 3
	};
	
	int result[]=new int[student.length];
	for(int i=0;i<student.length;i++) {
		for(int j=0;j<student[i].length;j++) {
			result[i]+=student[i][j];
		}
		System.out.println("The result of student "+(i+1)+" is "+result[i]);
	}
	
	
	
}

}
