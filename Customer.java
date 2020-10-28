public class Customer
{
	private int Customer_id;
	private string c_name;
	private string c_address;
	private int c_phone_no; 

	public Customer(int Customer_id, string c_name, string c_address, int c_phone_no)
	{
		//defining the constructor
		this.setCustomerID(CustomerID);
		this.setC_name(c_name);
		this.setC_address(c_address);
		this.setC_phone_no(c_phone_no);
	}

	//returns customerID
	public int getCustomerID(){
		return Customer_id;
	}

	//set customerID
	public void setCustomerID(int Customer_id){
		this.Customer_id = Customer_id;
	}

	//returns customer name
	public string getC_name(){
		return this.c_name;
	}

	//sets customer name
	public void setC_name(string c_name){
		this.c_name = c_name;
	}

	//returns customer address
	public string getC_address(){
		return this.c_address;
	}

	//sets customer address
	public void setC_address(string c_address){
		this.c_address = c_address;
	}
	
	//returns customer phone number
	public int getC_phone_no(){
		return this.c_phone_no;
	}

	//sets customer phone number
	public void setC_phone_no(int c_phone_no){
		this.c_phone_no = c_phone_no;
	}
}
