public interface OrderDAO {
	void CreateOrder(int orderid,int owner);
	void RemoveOrder(int orderid);
	void PayCheck(int orderid);
	void AddPizza(int index,String Type);
	void AddDrink(int orderid);
	boolean ControlOrder(int orderid);
	

}
