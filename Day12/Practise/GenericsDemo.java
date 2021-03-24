package day12;

import java.lang.reflect.Field;

public class GenericsDemo {
public static void main(String[] args) throws Exception {
	PaintBrush<Paint> pb = PaintContainer.getPaintBrush();
	System.out.println(pb.getObj());
	
	PaintBrush<Water> wb = WaterContainer.getPaintBrush();
	System.out.println(wb.getObj());
	
}
}

class PaintContainer{
	public static PaintBrush<Paint> getPaintBrush() throws Exception{
		PaintBrush<Paint> brush = new PaintBrush<>();
		
		Field field = brush.getClass().getDeclaredField("obj");
		field.setAccessible(true);
		In in = field.getAnnotation(In.class);
		
		System.out.println(in.value());
		
		if(in != null)
			brush.setObj(new RedPaint());	
		return brush;
	}
}

class WaterContainer{
	public static PaintBrush<Water> getPaintBrush() throws Exception{
		PaintBrush<Water> brush = new PaintBrush<>();
		Field field = brush.getClass().getDeclaredField("obj");
		field.setAccessible(true);
		In in = field.getAnnotation(In.class);
		
		if(in != null)
			brush.setObj(new Water());	
		return brush;
	}
}


abstract class Paint{ }

class RedPaint extends Paint { }

class BluePaint extends Paint {	}

class Water {}

class PaintBrush <T>{
	
	//Paint paint - Not a good practice, because you cannot use This PaintBrush for other activities.
	//Object obj - Not a good practice because it doesn't give a compile time error, but gives a runtime error, when you cast it in a wrong way.
	
	@In //( value = "Yay!")
	T obj;
	
	public T getObj() {
		return this.obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
}