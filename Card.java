import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class Card
{
	static Scanner input = new Scanner( System.in );
	private int card_no;
	private Date exp_date;
	private String card_type;
	private int pin;
	private int cust_id = NULL;
	private int acc_no = NULL;
	private double limit;

	public Card();
	public Card(int card_no, int exp_date, int pin, double limit)
	{
		//defining the cunstructor
		this.setCard_no(card_no);
		this.setExp_date(exp_date);
		this.setCard_type(card_no);
		this.setPin(pin);
		this.limit=limit;
	}

	//returns card number
	public int getCard_no(){
		return this.card_no;
	}

	//set card number
	public void setCard_no(int card_no){
		this.card_no = card_no;
	}

	//returns card number
	public int getExp_date(){
		return this.exp_date;
	}

	//set card number
	public void setExp_date(int exp_date){
		this.exp_date = exp_date;
	}

	//returns card number
	public int getPin(){
		return this.pin;
	}

	//set card number
	public void setPin(int pin){
		this.pin = pin;
	}

	//returns card number
	public String getCard_type(){
		return this.card_type;
	}

	//set card number
	public void setCard_type(int card_no){
		int temp = card_no;
		while(temp>=10)
			temp /= 10;
		if(temp==1)
			this.card_type = "debit card";
		else
			this.card_type = "credit card";
	}

	/*	checks if card is valid or not
	  	returns 1 if valid
	  	returns -1 if not valid
	 	returns 0 if expired
	*/
	public int checkValid(int cardNo){
		//checks if the card is valid
		Connection c=new Connection();
		ArrayList<int>x=new ArrayList<int>();
		c.getcardnos(x);
		int f=-1;
		for(int i=0;i<x.size();i++)
		{
			if(x.get(i)==cardNo)
			{
				f=0;
				break;
			}
		}
		if(f==0)
		{
			Card obj = new Card();
			c.connectpk(cardNo, obj);
			Date date = new Date();
			if(obj.exp_date.compareTo(date)>0)
			{
				f=1;
			}
		}
		return f;
	}

	/*	checks if pin is correct or not
		returns true if pin is correct
		returns false if pin is incorrect
	*/
	public boolean ValidPin(int cardNo, int pin_ent){
		Connection c=new Connection();
		Card temp = new Card();
		c.connectpk(cardNo, temp);
		if(temp.pin==pin_ent)
		{
			return true;
		}
		return false;
	}

	/* 
		returns the card information associated with provided card number and pin
	*/
	public Card find_user(int cardNo){
		Card temp = new Card();
		connectpk(cardNo, temp);
		return temp;
	}
}