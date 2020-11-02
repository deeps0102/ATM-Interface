public class Account
{
	private int acc_no;
	private String acc_type;
	private double acc_bal;
	private int cust_id = NULL;

	public Account(int acc_no, String acc_type, double acc_bal)
	{
		//defining the constructor
		this.setAcc_no(acc_no);
		this.setAcc_type(acc_type);
		this.setAcc_bal(acc_bal);
	}

	//returns account number of customer
	public int getAcc_no(){
		return this.acc_no;
	}

	//sets account number of customer
	public void setAcc_no(int acc_no){
		this.acc_no = acc_no;
	}

	//returns the type of account(like saving or current)
	public String getAcc_type(){
		return this.acc_type;
	}

	//sets the type of account(like saving or current)
	public void setAcc_type(String acc_type){
		this.acc_type = acc_type;
	}

	//returns the balance in customer's account
	public double getAcc_bal(){
		return this.acc_bal;
	}

	//sets the balance of customer's account
	public void setAcc_bal(double acc_bal){
		this.acc_bal = acc_bal;
	}
	
	/*
		returns account balance using account number
	*/
	public double showAccBalance(int AccNo){

	}

=======
public class Account extends Customer
{
	private int Account_no;
	private string Acc_type;
	private double Acc_balance;

	public Account(int Customer_id, string c_name, string c_address, int c_phone_no, int Account_no, string Acc_type, double Acc_balance)
	{
		//defining the constructor
		super(Customer_id, c_name, c_address, c_phone_no);
		this.setAccount_no(Account_no);
		this.setAcc_type(Acc_type);
		this.setAcc_balance(Acc_balance);
	}

	//returns account number of customer
	public int getAccount_no(){
		return this.Account_no;
	}

	//sets account number of customer
	public void setAccount_no(Account_no){
		this.Account_no = Account_no;
	}

	//returns the type of account(like saving or current)
	public string getAcc_type(){
		return this.Acc_type;
	}

	//sets the type of account(like saving or current)
	public void setAcc_type(Acc_type){
		this.Acc_type = Acc_type;
	}

	//returns the balance in customer's account
	public double getAcc_balance(){
		return this.Acc_balance;
	}

	//sets the balance of customer's account
	public void setAcc_balance(Acc_balance){
		this.Acc_balance = Acc_balance;
	}
	
