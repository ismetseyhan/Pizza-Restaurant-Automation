import java.util.Collections;
import java.util.Comparator;
import java.util.jar.Attributes.Name;

public class CustomerOption implements CustomerDAO {

	@Override
	public boolean controlID(int id) {
		int i, k;
		boolean deger = false;
		i = ReadingInput.CustomerList.size() - 1;
		for (k = 0; k <= i; k++) {
			if (id == ReadingInput.CustomerList.get(k).getId()) {
				deger = true;
				break;
			}

		}
		return deger;
	}

	@Override
	public void addcustomer(Customer musteri) {
		ReadingInput.CustomerList.add(musteri);

	}

	@Override
	public void deletecustomer(Customer musteri) {
		ReadingInput.CustomerList.remove(musteri);
		System.out.println("Customer " + musteri.getId() + " removed");
		ReadingInput.writeOutput("Customer " + musteri.getId() + " removed");

	}

	@Override
	public void customerlist() {
		System.out.println("Customer List:");
		ReadingInput.writeOutput("Customer List:");
		int size = ReadingInput.CustomerList.size();
		int i;
		Collections.sort(ReadingInput.CustomerList, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				Customer p1 = (Customer) o1;
				Customer p2 = (Customer) o2;
				return p1.getName().compareToIgnoreCase(p2.getName());
			}

		});
		for (i = 0; i < size; i++) {
			Customer customer = ReadingInput.CustomerList.get(i);
			System.out.println(customer.getId() + " " + customer.getName() + " " + customer.getSurname() + " "
					+ customer.getTelno() + " " + customer.getAddress());
			ReadingInput.writeOutput(customer.getId() + " " + customer.getName() + " " + customer.getSurname() + " "
					+ customer.getTelno() + " " + customer.getAddress());

		}
	}
}
