public class Onion extends PizzaDecorator {

	protected Pizza pizza;

	public Onion(Pizza pizza) {
		super(pizza);
		this.pizza=pizza;
		
		
	}
	
	@Override
	public double getCost() {
		
		return this.pizza.getCost()+2;
	}
	
	@Override
	public String getDescription() {
		
		return this.pizza.getDescription()+" Onion";
	}

}
