package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;

public class Transaction
{
	public  int transac_id;
	public String transac_via;
	public String transac_type;
	public String date_time;
	public double bal_bef;
	public double bal_aft;
	public int cust_id;
	public int acc_no;
	public double amt;

	public Transaction(){};
	public Transaction(int transac_id, String transac_type, String date_time, double bal_bef, double bal_aft, double amt)
	{
		//define the constructor
		this.setTransac_id(transac_id);
		this.setTransac_via(transac_via);
		this.setTransac_type(transac_type);
		this.setDate_time(date_time);
		this.setBal_bef(bal_bef);
		this.setBal_aft(bal_aft);
		this.setAmt(amt);
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
	public String getDate_time(){
		return this.date_time;
	}

	//sets the date and time of the transaction
	public void setDate_time(String date_time){
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

	public double getAmt(){
		return this.amt;
	}

	//sets the the balance before the transaction
	public void setAmt(double amt){
		this.amt = amt;
	}
	//show and prints transaction history with data from transactions table
	public void show_transac_his(int cust_id)
	{
		ArrayList<Transaction> x;
		Connect c=new Connect();
		x=c.connectpk(cust_id);

		for(int i=1;i<x.size();i++)
		{
			if(x.get(i).transac_type.equalsIgnoreCase("Withdraw")==true)
			{
				System.out.println("\n"+String.valueOf(i) + "'Rs. "+x.get(i).amt+" were withdrawn from the account via "+x.get(i).transac_via+" card on "+x.get(i).date_time+"'\n");
			}
			else if(x.get(i).transac_type.equalsIgnoreCase("Deposit")==true)
			{
				System.out.println("\n"+String.valueOf(i) + "'Rs. "+x.get(i).amt+" were deposited into the account via "+x.get(i).transac_via+" card on "+x.get(i).date_time+"'\n");
			}
			else
			{
				System.out.println("\n"+String.valueOf(i) + "'Rs. "+x.get(i).amt+" were transferred from account with id "+x.get(i).acc_no+" to account with id "+x.get(i).transac_type+" on "+x.get(i).date_time+"'\n");
			}
		}
		System.out.print("\n");
	}

	public void performTransac(Card obj)
	{
		Trans_cre tcobj = new Trans_cre();
		Trans_deb tdobj = new Trans_deb();
		//checking if card is credit card or debit card
		if(obj.card_type.equals("Debit"))
		{
			tdobj.transac_list(obj);
		}
		else if(obj.card_type.equals("Credit"))
		{
			tcobj.transac_list(obj);
		}
	}
}