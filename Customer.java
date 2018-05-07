public class Customer {
	private int Id;
	private String Name;
	private String Surname;
	private String Telno;
	private String Address;
	
	
	public Customer(int id,String name,String surname,String telno,String address) {
		this.Id=id;
		this.Name=name;
		this.Surname=surname;
		this.Telno=telno;
		this.Address=address;
		
	}
	
	

	public int getId() {
		return Id;
	}



	public void setId(int id) {
		this.Id = id;
	}



	public String getSurname() {
		return Surname;
	}



	public void setSurname(String surname) {
		Surname = surname;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		this.Name = name;
	}



	public String getTelno() {
		return Telno;
	}



	public void setTelno(String telno) {
		this.Telno = telno;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	

}
