package lab2;

public class Q14 {
public static void main(String[] args) {
	
	Results r = new Results("Gandalf",0,90,80,70);
	System.out.println("Total mark of "+ r.name+" is " + r.totalMarksCalc() );
	
}
}


class Student{
	String name;
	int rollno;
}

class Exam extends Student{
	
	int math,bio,phy;
	
	
	
}

class Results extends Exam{
	int totalMarks;
	public Results(String mName,int mRollNo, int mMath,int mBio,int mPhy){
		name=mName;
		rollno=mRollNo;
		math=mMath;
		bio=mBio;
		phy=mPhy;
	}
	public int totalMarksCalc() {
		return totalMarks=math+bio+phy;
	}
}