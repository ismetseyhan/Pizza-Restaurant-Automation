import java.util.ArrayList;

public class Order {
	private int OrderNo;
	private ArrayList<Pizza> TypePizza = new ArrayList<Pizza>();
	private ArrayList<String>TypeDrink = new ArrayList<String>();
	private double Bill;
	private int Owner;

	public static ArrayList<Order>orderlist=new ArrayList<Order>();
	
	public Order() {
		this.OrderNo = 0;
		this.Bill = 0;
	}

	public Order(int orderNo,int owner) {
		this.OrderNo = orderNo;
		this.Owner=owner;
		this.Bill=0;

	}

	public int getOrderNo() {
		return OrderNo;
	}

	public int getOwner() {
		return Owner;
	}

	public void setOwner(int owner) {
		this.Owner = owner;
	}

	public void setOrderNo(int orderNo) {
		this.OrderNo = orderNo;
	}

	public ArrayList<Pizza> getTypePizza() {
		return TypePizza;
	}

	public void setTypePizza(Pizza pizza) {
		this.TypePizza.add(pizza);
	}

	public ArrayList<String> getTypeDrink() {
		return TypeDrink;
	}

	public void setTypeDrink(String typeDrink) {
		this.TypeDrink.add(typeDrink);
		
		
	}

	public double getBill() {
		return Bill;
	}

	public void setBill(double bill) {
		this.Bill = this.Bill+bill;
	}
}
