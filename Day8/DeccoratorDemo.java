package Day8;

public class DeccoratorDemo {
public static void main(String[] args) {
	
	Food foodPlate = new Rice(new Sambar(new Prawn(new Prawn())));
	System.out.println("Cost of Rice, Sambar and two plates of Prawn  : " + foodPlate.getCost());
}
}

abstract class Food{
	public abstract int getCost();
}

abstract class NonVegFood extends Food{
	
}

abstract class VegFood extends Food{
	
}

class Rice extends VegFood{
	private Food food;
	
	public Rice() {
		// TODO Auto-generated constructor stub
	}
	
	public Rice(Food food) {
		this.food = food;
	}

	@Override
	public int getCost() {
		if(food == null)
			return 10;
		return 10 + food.getCost();
	}
	
}

class Sambar extends VegFood{
	private Food food;
	
	public Sambar() {
		// TODO Auto-generated constructor stub
	}
	
	public Sambar(Food food) {
		this.food = food;
	}

	@Override
	public int getCost() {
		if(food == null)
			return 5;
		return 5 + food.getCost();
	}
	
}


class Prawn extends NonVegFood{
	private Food food;
	
	public Prawn() {
		// TODO Auto-generated constructor stub
	}
	
	public Prawn(Food food) {
		this.food = food;
	}

	@Override
	public int getCost() {
		if(food == null)
			return 25;
		return 25 + food.getCost();
	}
	
}