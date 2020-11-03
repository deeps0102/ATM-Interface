import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class Customer
{
	private int cust_id;
	private String cust_name;
	private int phn_no; 

	public Customer(int cust_id, String cust_name, int phn_no)
	{
		//defining the constructor
		this.setCustomerID(cust_id);
		this.setCust_name(cust_name);
		this.setPhn_no(phn_no);
	}

	//returns customerID
	public int getCustomerID(){
		return this.cust_id;
	}

	//set customerID
	public void setCustomerID(int cust_id){
		this.cust_id = cust_id;
	}

	//returns customer name
	public String getCust_name(){
		return this.cust_name;
	}

	//sets customer name
	public void setCust_name(String cust_name){
		this.cust_name = cust_name;
	}
	
	//returns customer phone number
	public int getPhn_no(){
		return this.phn_no;
	}

	//sets customer phone number
	public void setPhn_no(int phn_no){
		this.phn_no = phn_no;
	}

	/*
		checks if customer is registered or not
	*/
	public boolean check_if_registered( int userID){
		;
	}
}