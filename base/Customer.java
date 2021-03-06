package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;

public class Customer
{
	public static int cust_id;
	public static String cust_name;
	public static int phn_no; 

	public Customer(){}
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
	public static boolean check_if_registered(int custID){
		ArrayList<Integer>a = new ArrayList<Integer>();
		Connect c = new Connect();
		c.getcustids(a);
		boolean f=false;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i)==custID)
			{
				f=true;
				break;
			}
		}
		return f;
	}
}