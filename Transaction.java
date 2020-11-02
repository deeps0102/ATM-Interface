public class Transaction
{
	private int transac_id;
	private String transac_type;
	private Date date_time;
	private double bal_bef;
	private double bal_aft;
	private int cust_id = NULL;
	private int acc_no = NULL;

	public Transaction(int transac_id, String transac_type, Date date_time, double bal_bef, double bal_aft)
	{
		//define the constructor
		this.setTransac_id(transac_id);
		this.setTransac_type(transac_type);
		this.setDate_time(date_time);
		this.setBal_bef(bal_bef);
		this.setBal_aft(bal_aft);
	}

	//returns id of the transaction
	public int getTransac_id(){
		return this.transac_id;
	}

	//sets the id of the transaction
	public void setTransac_id(transac_id){
		this.transac_id = transac_id;
	}

	//returns type of the transaction
	public String getTransac_type(){
		return this.transac_type;
	}

	//sets the type of the transaction
	public void setTransac_type(transac_type){
		this.transac_type = transac_type;
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