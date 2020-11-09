import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;

public class Transaction
{
	public int transac_id;
	public String transac_via;
	public String transac_type;
	public Date date_time;
	public double bal_bef;
	public double bal_aft;
	public int cust_id;
	public int acc_no;

	public Transaction(){};
	public Transaction(int transac_id, String transac_type, Date date_time, double bal_bef, double bal_aft)
	{
		//define the constructor
		this.setTransac_id(transac_id);
		this.setTransac_via(transac_via);
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
	public void setTransac_id(int transac_id){
		this.transac_id = transac_id;
	}

	//returns medium via which transaction occured
	public String getTransac_via(){
		return this.transac_via;
	}

	//returns medium via which transaction occured
	public void setTransac_via(String transac_via){
		this.transac_via = transac_via;
	}

	//returns type of the transaction
	public String getTransac_type(){
		return this.transac_type;
	}

	//sets the type of the transaction
	public void setTransac_type(String transac_type){
		this.transac_type = transac_type;
	}

	//returns date and time of the transaction
	public Date getDate_time(){
		return this.date_time;
	}

	//sets the date and time of the transaction
	public void setDate_time(Date date_time){
		this.date_time = date_time;
	}

	//returns the balance before the transaction
	public double getBal_bef(){
		return this.bal_bef;
	}

	//sets the the balance before the transaction
	public void setBal_bef(double bal_bef){
		this.bal_bef = bal_bef;
	}

	//returns the balance after the transaction
	public double getBal_aft(){
		return this.bal_aft;
	}

	//sets the balance after the transaction
	public void setBal_aft(double bal_aft){
		this.bal_aft = bal_aft;
	}
	//show and prints transaction history with data from transactions table
	public void show_transac_his(int transac_id)
	{
		ArrayList<Transaction>x = new ArrayList<Transaction>();
		Connect c=new Connect();
		c.connectpk(transac_id, x);
		for(int i=0;i<x.size();i++)
		{
			if(x.get(i).transac_type.equalsIgnoreCase("Withdrawl")==true)
			{
				System.out.println("Rs. "+abs(x.get(i).bal_bef-x.get(i).bal_aft)+" were withdrawn from the account with id "+x.get(i).acc_no+" via "+x.get(i).transac_via+" card on "+x.get(i).date_time.toString());
			}
			else if(x.get(i).transac_type.equalsIgnoreCase("Deposit")==true)
			{
				System.out.println("Rs. "+abs(x.get(i).bal_bef-x.get(i).bal_aft)+" were deposited into the account with id "+x.get(i).acc_no+" via "+x.get(i).transac_via+" card on "+x.get(i).date_time.toString());
			}
			else
			{
				System.out.println("Rs. "+abs(x.get(i).bal_bef-x.get(i).bal_aft)+" were transferred from account with id "+x.get(i).acc_no+" to account with id "+x.get(i).transac_type+" on "+x.get(i).date_time.toString());
			}
		}
	}
}