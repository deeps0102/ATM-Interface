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
	
	public int num_Accounts(){
		//returns number of accounts a Customer has
	}

	public void getAccSummary(){
		// prints the summary of the account of an user
	}

	public void printAccSummary(){
		// prints the summary of the account of an user
	}

}
