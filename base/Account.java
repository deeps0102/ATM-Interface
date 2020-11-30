package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;

public class Account
{
	public int acc_no;
	public double acc_bal;
	public int cust_id;

	public Account(){}
	public Account(int acc_no, double acc_bal, int cust_id)
	{
		//defining the constructor
		this.setAcc_no(acc_no);
		this.setAcc_bal(acc_bal);
		this.setCustid(cust_id);
	}

	//returns account number of customer
	public int getAcc_no(){
		return this.acc_no;
	}

	//sets account number of customer
	public void setAcc_no(int acc_no){
		this.acc_no = acc_no;
	}

	//returns the balance in customer's account
	public double getAcc_bal(){
		return this.acc_bal;
	}

	//sets the balance of customer's account
	public void setAcc_bal(double acc_bal){
		this.acc_bal = acc_bal;
	}

	//returns Customer id of customer
	public int getCustid(){
		return this.cust_id;
	}

	//sets Customer id of customer
	public void setCustid(int cust_id){
		this.cust_id = cust_id;
	}
	
	//returns account balance using account number
	public static void showAccBalance(int AccNo){
		Connect c = new Connect();
		Account obj = new Account();
		c.connectpk(AccNo, obj);
		System.out.println("\nYour account balance is Rs. "+obj.acc_bal+"\n");
	}
}