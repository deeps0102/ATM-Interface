import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

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