public class OrderOption implements OrderDAO {

	@Override
	public void CreateOrder(int orderid, int owner) {
		CustomerOption access = new CustomerOption();
		boolean check = access.controlID(owner);
		if (check) {
			Order.orderlist.add(new Order(orderid, owner));
			System.out.println("Order " + orderid + " created");
			ReadingInput.writeOutput("Order " + orderid + " created");
		} else {
			System.out.println(orderid + " nolu Siparis olusturulamadi müsteri sistemde kayitli degil C.ID= " + owner);
			ReadingInput.writeOutput(
					orderid + " nolu Siparis olusturulamadi müsteri sistemde kayitli degil C.ID= " + owner);
		}

	}

	@Override
	public void PayCheck(int orderid) {
		int size = Order.orderlist.size();
		int i;
		for (i = 0; i < size; i++) {
			if (orderid == Order.orderlist.get(i).getOrderNo()) {
				Order check = Order.orderlist.get(i);
				System.out.println("PayCheck for order " + orderid);
				ReadingInput.writeOutput("PayCheck for order " + orderid);
				int pizzasize = check.getTypePizza().size();
				int k;
				for (k = 0; k < pizzasize; k++) {
					System.out.println("	" + check.getTypePizza().get(k).getDescription() + " "
							+ (int) check.getTypePizza().get(k).getCost() + "$");
					ReadingInput.writeOutput("	" + check.getTypePizza().get(k).getDescription() + " "
							+ (int) check.getTypePizza().get(k).getCost() + "$");
				}
				int yaz = check.getTypeDrink().size();
				int j;
				for (j = 0; j < yaz; j++) {
					System.out.println("	SoftDrink 1$");
					ReadingInput.writeOutput("	SoftDrink 1$");
				}
				System.out.println("	Total: " + (int) check.getBill() + "$");
				ReadingInput.writeOutput("	Total: " + (int) check.getBill() + "$");

			}

		}

	}

	@Override
	public void AddDrink(int orderid) {
		int i;
		int size = Order.orderlist.size();
		for (i = 0; i < size; i++) {
			if (Order.orderlist.get(i).getOrderNo() == orderid) {
				Order.orderlist.get(i).setTypeDrink("True");
				Order.orderlist.get(i).setBill(1);

				break;
			}
		}

	}

	public void AddPizza(int index, String Type) {
		String[] parts = Type.split(" "); // americano sucuk salam;
		int partsize = parts.length;
		if (parts.length < 5) {
			int i;
			Pizza PlainPizza = null;
			for (i = 0; i < partsize; i++) {
				String part = parts[i];

				if (part.equals("AmericanPan")) {
					PlainPizza = new AmericanPan();
				} else if (part.equals("Neapolitan")) {
					PlainPizza = new Neapolitan();

				} else if (part.equals("Soudjouk")) {

					PlainPizza = new Soudjouk(PlainPizza);
				} else if (part.equals("Salami")) {

					PlainPizza = new Salami(PlainPizza);
				} else if (part.equals("HotPepper")) {

					PlainPizza = new Pepper(PlainPizza);
				} else if (part.equals("Onion")) {
					PlainPizza = new Onion(PlainPizza);

				}
			}
			double cost = PlainPizza.getCost();
			Order.orderlist.get(index).setTypePizza(PlainPizza);
			Order.orderlist.get(index).setBill(cost);
		} else {
			System.out.println("En fazla 3 eklenti olabilir.");
			ReadingInput.writeOutput("En fazla 3 eklenti olabilir.");
		}

	}

	@Override
	public boolean ControlOrder(int orderid) {
		int size = Order.orderlist.size();
		int i;
		Boolean check = false;
		for (i = 0; i < size; i++) {
			if (Order.orderlist.get(i).getOrderNo() == orderid) {
				check = true;
			}

		}
		return check;
	}

	@Override
	public void RemoveOrder(int orderid) {
		int size = Order.orderlist.size();
		int i;
		for (i = 0; i < size; i++) {
			if (orderid == Order.orderlist.get(i).getOrderNo()) {
				Order.orderlist.remove(Order.orderlist.get(i));
				break;
			}
		}

	}

}
