public class Main {

	public static void main(String[] args) {
		String inputfile = "input.txt"; //  default 
		String Customerfile = "customer.txt"; //default
		String Orderfile = "order.txt"; // default
		inputfile = args[0]; // input.txt
		Customerfile = args[1]; // customer.txt
		Orderfile = args[2]; // order.txt

		ReadingInput.deleteOutput();
		ReadingInput.readcustomer(Customerfile);
		ReadingInput.readorder(Orderfile);
		ReadingInput.readinput(inputfile);
		ReadingInput.writeCustomer(Customerfile);
		ReadingInput.writeOrder(Orderfile);

	}

}

