public class Transaction extends Account
{
	private int Transac_id;
	private string Transac_type;
	private Date date_time;
	private double bal_bef;
	private double bal_aft;

	public Transaction(int Customer_id, string c_name, string c_address, int c_phone_no, int Account_no, string Acc_type, double Acc_balance, int Transac_id, string Transac_type, Date date_time, double bal_bef, double bal_aft)
	{
		//define the constructor
		super(Customer_id, c_name, c_address, c_phone_no, Account_no, Acc_type, Acc_balance);
		this.setTransac_id(Transac_id);
		this.setTransac_type(Transac_type);
		this.setDate_time(date_time);
		this.setBal_bef(bal_bef);
		this.setBal_aft(bal_aft);
	}

	//returns id of the transaction
	public int getTransac_id(){
		return this.Transac_id;
	}

	//sets the id of the transaction
	public void setTransac_id(Transac_id){
		this.Transac_id = Transac_id;
	}

	//returns type of the transaction
	public string getTransac_type(){
		return this.Transac_type;
	}

	//sets the type of the transaction
	public void setTransac_type(Transac_type){
		this.Transac_type = Transac_type;
	}

	//returns date and time of the transaction
	public Date getDate_time(){
		return this.date_time;
	}

	//sets the date and time of the transaction
	public void setDate_time(date_time){
		this.date_time = date_time;
	}

	//returns the balance before the transaction
	public int getBal_bef(){
		return this.bal_bef;
	}

	//sets the the balance before the transaction
	public void setBal_bef(bal_bef){
		this.bal_bef = bal_bef;
	}

	//returns the balance after the transaction
	public int getBal_aft(){
		return this.bal_aft;
	}

	//sets the balance after the transaction
	public void setBal_aft(bal_aft){
		this.bal_aft = bal_aft;
	}

	public void addAccTransac(){
		//add an account Transaction
	}

	public void getAccTransHistory(){
		//prints Transaction history
	}

	public void printAccTransHistory(){
		//prints Transaction history
	}
} 
