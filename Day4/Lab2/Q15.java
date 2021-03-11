package lab2;

public class Q15 {
public static void main(String[] args) {
	House h = new House();
	h.SetDoorArea(20);
	h.SetWindowArea(30);
	h.calcPrice();
}
}

class House{
	Door d = new Door();
	Window w = new Window();
	
	public void SetDoorArea(int area) {
		d.area=area;
	}
	
	public void SetWindowArea(int area) {
		w.area = area;
	}
	
	public void calcPrice() {
		System.out.println("Price of door is " + d.getPrice(100) + " \nPrice of window is " + w.getPrice(200));
	}
	
	
}

class Door{
	int area;
	
	public int getPrice(int cost) {
		return cost*this.area;
	}
	
}

class Window{
	int area;
	
	public int getPrice(int cost) {
		return cost*this.area;
	}
}
