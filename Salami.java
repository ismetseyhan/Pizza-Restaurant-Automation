public class Salami extends PizzaDecorator {

	protected Pizza pizza;

	public Salami(Pizza pizza) {
		super(pizza);
		this.pizza=pizza;
		
		
	}
	
	@Override
	public double getCost() {
		
		return this.pizza.getCost()+3;
	}
	
	@Override
	public String getDescription() {
		
		return this.pizza.getDescription()+" Salami";
	}

}
