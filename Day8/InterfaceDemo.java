package Day8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceDemo {
public static void main(String[] args) {
	Human aishu = new Human();
	
	Doctor doctorAishu = (Doctor) Proxy.newProxyInstance(aishu.getClass().getClassLoader(), 
							new Class[] {Doctor.class}, new MyInvocationHandler(new AlopathyMedCollege()));
	
	doctorAishu.doCure();
	
}
}

class MyInvocationHandler implements InvocationHandler{
	private Doctor doctor;
	
	public MyInvocationHandler(Doctor doctor) {
		// TODO Auto-generated constructor stub
		this.doctor = doctor;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Over here!!");
		method.invoke(doctor);
		return null;
	}
	
}
class Human{
	
}

interface Doctor{
	public void doCure();
}

class AlopathyMedCollege implements Doctor{
	@Override
	public void doCure() {
		// TODO Auto-generated method stub
		System.out.println("Alopathy logic implemented........");
		
	}
}

class AyurvedhaMedCollege implements Doctor{
	@Override
	public void doCure() {
		// TODO Auto-generated method stub
		System.out.println("Alopathy logic implemented........");
		
	}
}

