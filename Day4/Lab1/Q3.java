package day4;

public class Q3 {
	
	
	//Higher type when initalized to lower data type, its possible, otherwise there is an error and it has to be explicitly typecasted.
	
	
	int i=10,i1='a';
	// char to int works
	 //int i2=0.0f ,i3=100000000000l,i4='a',i5=true,i6="hey", i7=0.3d;
	
	char a='c';	
	//char i2=0.0,i3=1000000000000000000,i4='a',i5=true,i6="hey"; 
	
	long l=10000000000006l;
	//long i2=0.0f ,i3=1000000000000l,i4='a',i5=true,i6="hey", i7=0.3d;
	
	
	float f=9.8f;
	//float i2=0.0f ,i3=1000000000l,i4='a',i5=true,i6="hey", i7=0.3d;
	
	double d=9.7d;
	//double i2=0.0f ,i3=1000000000l,i4='a',i5=true,i6="hey", i7=0.3d;
	
	byte b=123;
	//byte i2=0.0f ,i3=1000000000l,i4='a',i5=true,i6="hey", i7=0.3d;
	
	boolean bool=true;
	//boolean i2=0.0f ,i3=1000000000l,i4='a',i5=true,i6="hey", i7=0.3d;
	
	short s=234;
	//short i2=0.0f ,i3=1000000000l,i4='a',i5=true,i6="hey", i7=0.3d;
	
	public static void main(String[] args) {
		Q3 q3=new Q3();
		q3.check();
		
		
	}
	
	public void check() {
		
		i=a;
		i=(int) l;
		i=(int) f;
		i=(int) d;
		i=b;
		//Cant be typecaseted
		//i=bool;
		i=s;
		
		
		//a=(char) i;
		a=(char) l;
		System.out.println("here"+a);
		a=(char) f;
		System.out.println("we are here" + a);
		a=(char) d;
		System.out.println("over here" + a);
		a=(char) b;
		System.out.println("over here" + a);
		a=(char) s;
		
		l=i;
		l=a;
		l=(long) f;
		l=(long) d;
		l=b;
		l=s;
		
		
		//Conclusion - Higher order primitive data type when assigned to lower order primitive data type has to be type casted.
		
		
		
		
	}
}
