public class Pepper extends PizzaDecorator {

	protected Pizza pizza;

	public Pepper(Pizza pizza) {
		super(pizza);
		this.pizza=pizza;
		
		
	}
	
	@Override
	public double getCost() {
		
		return this.pizza.getCost()+1;
	}
	
	@Override
	public String getDescription() {
		
		return this.pizza.getDescription()+" HotPepper";
	}

}
