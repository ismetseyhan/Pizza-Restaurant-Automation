import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReadingInput {

	public static ArrayList<Customer> CustomerList = new ArrayList<Customer>();

	public static void readcustomer(String customerfile) {

		try {
			File file = new File(customerfile); //customer
			FileReader fileReader = new FileReader(file);
			String line;
			BufferedReader br = new BufferedReader(fileReader);
			CustomerOption access = new CustomerOption();
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				int partsize = parts.length - 1;
				int part0 = Integer.parseInt(parts[0]);
				String part1 = parts[1];
				String part2 = parts[2];
				String part3 = parts[3];
				String part4 = "";
				int i;
				for (i = 4; i <= partsize; i++) {
					if (i == partsize) {
						part4 = part4 + parts[i];
					} else {
						part4 = part4 + parts[i] + " ";
					}

				}
				access.addcustomer(new Customer(part0, part1, part2, part3, part4));

			}

		} catch (IOException fsf) {
			System.out.println("Daha önceden olusturulmus Customer dosyasi olmadan devam ediliyor");
			writeOutput("Daha önceden olusturulmus Customer dosyasi olmadan devam ediliyor");

		}

	}

	public static void readorder(String orderfile) {
		try {
			File file = new File(orderfile);
			FileReader fileReader = new FileReader(file);
			String line;
			CustomerOption access = new CustomerOption();
			OrderOption oaccess = new OrderOption();
			BufferedReader br = new BufferedReader(fileReader);
			int sahip = 0;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				int sizeline = parts.length;
				int sizeorderlist = Order.orderlist.size();
				if (parts[0].equals("Order:")) {
					sahip = 0;
					int orderno = Integer.parseInt(parts[1]); // id
					int owner = Integer.parseInt(parts[2]); // owner
					Order.orderlist.add(new Order(orderno, owner));
					sahip = orderno;

				} else if (parts[0].equals("AmericanPan") || parts[0].equals("Neapolitan")) {
					int i;

					for (i = 0; i < sizeorderlist; i++) {
						if (sahip == Order.orderlist.get(i).getOrderNo()) {
							oaccess.AddPizza(i, line);

						}

					}

				} else if (parts[0].equals("Softdrink") || parts[0].equals("Drink") || parts[0].equals("drink")) {

					oaccess.AddDrink(sahip);

				}

			}

		} catch (

		IOException fsf) {
			System.out.println("input.txt yok");

		}

	}

	public static void readinput(String inputfile) {
		try {
			File file = new File(inputfile);
			FileReader fileReader = new FileReader(file);
			String line;
			BufferedReader br = new BufferedReader(fileReader);
			CustomerOption access = new CustomerOption();
			OrderOption oaccess = new OrderOption();
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				int partsize = parts.length - 1;
				int sizelist = CustomerList.size() - 1;
				String part0 = parts[0];

				if (part0.equals("AddCustomer")) {
					int part1 = Integer.parseInt(parts[1]); // 33
					String part2 = parts[2]; // name
					String part3 = parts[3]; // surname
					String part4 = parts[4]; // no
					String part5 = "";
					int i;
					for (i = 5; i <= partsize; i++) {
						if (i == partsize) {
							part5 = part5 + parts[i];
						} else {
							part5 = part5 + parts[i] + " ";
						}
					}

					boolean check = access.controlID(part1);
					if (check) {
						System.out.println("Bu müsteri zaten mevcut CID=" + part1);
						writeOutput("Bu müsteri zaten mevcut CID=" + part1);

					} else {
						CustomerList.add(new Customer(part1, part2, part3, part4, part5));
						System.out.println("Customer" + " " + part1 + " " + part2 + " added");
						writeOutput("Customer" + " " + part1 + " " + part2 + " added");

					}

				} else if (part0.equals("RemoveCustomer")) {
					int part1 = Integer.parseInt(parts[1]); // 33

					boolean check = access.controlID(part1);
					int i;

					if (check) {
						for (i = 0; i <= sizelist; i++) {
							if (CustomerList.get(i).getId() == part1) {
								Customer sil = CustomerList.get(i);
								int siparisno = sil.getId();
								int sizeord = Order.orderlist.size();
								int k;
								for (k = 0; k < sizeord; k++) {
									if (Order.orderlist.get(k).getOwner() == siparisno) {
										Order.orderlist.remove(Order.orderlist.get(k));
										break;
									}
								}
								access.deletecustomer(sil);
								break;

							}
						}
					} else {
						System.out.println("Silmek istediginiz müsteri zaten ekli degil RID=" + part1);
						writeOutput("Silmek istediginiz müsteri zaten ekli degil RID=" + part1);
					}

				} else if (part0.equals("CreateOrder")) {
					int part1 = Integer.parseInt(parts[1]); // siparis no
					int part2 = Integer.parseInt(parts[2]); // sahip
					oaccess.CreateOrder(part1, part2);
				} else if (part0.equals("RemoveOrder")) {
					int part1 = Integer.parseInt(parts[1]);
					oaccess.RemoveOrder(part1);
					System.out.println("Order " + part1 + " removed");
					writeOutput("Order " + part1 + " removed");

				} else if (part0.equals("AddPizza")) {
					OrderOption accces = new OrderOption();
					int owner = Integer.parseInt(parts[1]);
					boolean check = accces.ControlOrder(owner);
					if (check) {
						int part1 = Integer.parseInt(parts[1]); // siparis no
						int i, k, ordersize;
						String type = "";
						for (k = 2; k <= partsize; k++) {
							if (k == partsize) {
								type = type + parts[k];
							} else {
								type = type + parts[k] + " ";

							}

						}
						ordersize = Order.orderlist.size() - 1;

						for (i = 0; i <= ordersize; i++) {
							if (part1 == Order.orderlist.get(i).getOrderNo()) {
								oaccess.AddPizza(i, type);
								System.out.println(
										parts[2] + " pizza added to order " + Order.orderlist.get(i).getOrderNo());
								writeOutput(parts[2] + " pizza added to order " + Order.orderlist.get(i).getOrderNo());
								break;
							}

						}

					} else {
						System.out.println(
								"Pizza Siparise eklenemedi Eklenmek istenen OrderID sistemde yok OrderID=" + owner);
						writeOutput("Pizza Siparise eklenemedi Eklenmek istenen OrderID sistemde yok OrderID=" + owner);
					}

				} else if (part0.equals("AddDrink")) {
					OrderOption accces = new OrderOption();
					int owner = Integer.parseInt(parts[1]);
					boolean check = accces.ControlOrder(owner);
					if (check) {
						oaccess.AddDrink(owner);
						System.out.println("Drink added to order " + owner);
						writeOutput("Drink added to order " + owner);

					}

				} else if (part0.equals("PayCheck")) {
					int owner = Integer.parseInt(parts[1]); // hesap no
					oaccess.PayCheck(owner);

				} else if (part0.equals("List")) {
					access.customerlist();

				}

			}
		} catch (

		IOException fsf) {
			System.out.println("input yok");

		}

	}

	public static void writeCustomer(String customerfile) {
		try {
			File dosya = new File(customerfile);
			FileWriter yazici = new FileWriter(dosya, false);
			BufferedWriter yaz = new BufferedWriter(yazici);
			int size = ReadingInput.CustomerList.size();
			int i;
			Collections.sort(ReadingInput.CustomerList, new Comparator<Customer>() {

				@Override
				public int compare(Customer o1, Customer o2) {
					Integer p1 = o1.getId();
					Integer p2 = o2.getId();
					return p1.compareTo(p2);
				}
			});
			for (i = 0; i < size; i++) {
				Customer customer = ReadingInput.CustomerList.get(i);
				yaz.write(customer.getId() + " " + customer.getName() + " " + customer.getSurname() + " "
						+ customer.getTelno() + " " + customer.getAddress() + "\n");

			}

			yaz.close();
		} catch (Exception hata) {
			hata.printStackTrace();
		}

	}

	public static void writeOrder(String Orderfile) {
		try {
			File dosya = new File(Orderfile);
			FileWriter yazici = new FileWriter(dosya, false);
			BufferedWriter yaz = new BufferedWriter(yazici);
			Collections.sort(Order.orderlist, new Comparator<Order>() {

				@Override
				public int compare(Order o1, Order o2) {
					Integer p1 = o1.getOrderNo();
					Integer p2 = o2.getOrderNo();
					return p1.compareTo(p2);
				}
			});
			int ordersize = Order.orderlist.size();
			int i, k, j;
			for (i = 0; i < ordersize; i++) {
				Order order = Order.orderlist.get(i);
				int orderid = Order.orderlist.get(i).getOrderNo();
				int ownerid = Order.orderlist.get(i).getOwner();
				int typepizza = order.getTypePizza().size();
				int typedrink = order.getTypeDrink().size();
				yaz.write("Order:" + " " + orderid + " " + ownerid + "\n");
				for (k = 0; k < typepizza; k++) {
					yaz.write(order.getTypePizza().get(k).getDescription() + "\n");
				}
				for (j = 0; j < typedrink; j++) {
					yaz.write("Softdrink\n");

				}

			}
			yaz.close();
		} catch (Exception hata) {

			hata.printStackTrace();
		}

	}

	public static void deleteOutput() {
		try {
			File sil = new File("output.txt");
			sil.delete();
		} catch (Exception hata) {
			int z = 5;
		}

	}

	public static void writeOutput(String word) {
		try {
			File dosya = new File("output.txt");
			FileWriter yazici = new FileWriter(dosya, true);
			BufferedWriter yaz = new BufferedWriter(yazici);
			yaz.write(word + "\n");
			yaz.close();
		} catch (Exception hata) {
			hata.printStackTrace();
		}

	}

}
