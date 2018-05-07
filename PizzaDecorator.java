public abstract class PizzaDecorator implements Pizza {
	
	protected Pizza pizza;
	
	public PizzaDecorator(Pizza pizza) {
		
		this.pizza=pizza;
	}
	
	

	@Override
	public double getCost() {
		
		return this.pizza.getCost();
	}
	
	@Override
	public String getDescription() {
		
		return this.pizza.getDescription();
	}


	
}
