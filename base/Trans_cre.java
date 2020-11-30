package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.Math.abs;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class Trans_cre extends Transaction
{
	static Scanner input = new Scanner( System.in );
	public Trans_cre(){
		bal_bef=50000;
	}

	// prints the transaction options for credit card
	public static void transac_list(Card obj)
	{
		System.out.println("\nSelect Transaction type:\n");
		System.out.println("1 - WITHDRAW");
		System.out.println("2 - DEPOSIT");
		System.out.println("3 - QUIT\n\n");
		System.out.print("ENTER CHOICE :: ");
		int choice=0;
		choice=input.nextInt();
		if(choice<=3 && choice>=1)
		{
			switch(choice)
			{
				case 1:
					withdraw(obj);
					transac_list(obj);
					break;
				case 2:
					deposit(obj);
					transac_list(obj);
					break;
				case 3:
					System.out.print("\nAre you sure you want to exit(Y/N)? :: ");
					String s = input.nextLine();
					s=input.nextLine();
					System.out.print("\n\n");
					if(s.equalsIgnoreCase("Y"))
					{
						return;
					}
					else
					{
						transac_list(obj);
					}
					break;
			}
		}
		else
		{
			System.out.println("\nEnter a valid choice\n");
			transac_list(obj);
		}
	}

	// withdraws required amount from credit card
	public static void withdraw(Card obj)
	{
		Trans_cre tcobj = new Trans_cre();
		Account accobj = new Account();
		Connect c=new Connect();
		c.connectpk(obj.acc_no,accobj);

		System.out.println("\nYour credit card limit is Rs. "+accobj.acc_bal+" for Credit Transaction\n");
		System.out.print("Enter amount to withdraw :: ");
		int amount=0;amount=input.nextInt();
		System.out.print("\n\n");

		// checking if amount is less than one time withdrawl limit
		if(amount<obj.limit)
		{
			//checking if required withdrawl amount is present in account or not
			if(amount<accobj.acc_bal)
			{
				double newbal=accobj.acc_bal-amount;
				c.updateAccbal(accobj.acc_no,newbal);
				System.out.println("Your updated credit card limit is Rs. "+newbal);
				tcobj.amt=amount;
				tcobj.transac_via="Credit";
				tcobj.transac_type="Withdraw";

				tcobj.date_time=new SimpleDateFormat("dd-MM-yyyy").format(new Date());

				tcobj.bal_aft=newbal;
				tcobj.cust_id=obj.cust_id;
				tcobj.acc_no=obj.acc_no;
				c.addtransaction(tcobj);
				System.out.println("\n\n----------------------------------'Withdrawl Successfull!!'------------------------------\n");
			}
			else
			{
				System.out.print("\nNot enough balance to Withdraw entered amount\n");
			}
		}
		else if(amount<0)
		{
			System.out.print("\nAmount can't be Negative\n");
		}
		else
		{
			System.out.print("\nAmount exceeds one time transfer limit\n");
		}
	}

	// to perform deposit of money in credit card(basically returning the money to bank)
	public static void deposit(Card obj)
	{
		Trans_cre tcobj = new Trans_cre();
		Account accobj = new Account();
		Connect c=new Connect();
		c.connectpk(obj.acc_no,accobj);
		System.out.println("Your account balance is Rs. "+accobj.acc_bal+" for Credit Transaction");
		System.out.print("Enter amount to deposit :: ");
		int amount=0;amount=input.nextInt();
		System.out.print("\n");
		// checking if deposit amount is less than one time deposit limit
		if(amount<obj.limit)
		{
			// checking if deposit amount is less than maximum limit of card
			if((amount<(tcobj.bal_bef)-(accobj.acc_bal)) && amount>0)
			{
				double newbal=amount+accobj.acc_bal;
				c.updateAccbal(accobj.acc_no,newbal);
				System.out.println("Your new account balance is Rs. "+newbal);
				tcobj.amt=amount;
	
				tcobj.transac_via="Credit";
				tcobj.transac_type="Deposit";

				tcobj.date_time=new SimpleDateFormat("dd-MM-yyyy").format(new Date());

				tcobj.bal_aft=newbal;
				tcobj.cust_id=obj.cust_id;
				tcobj.acc_no=obj.acc_no;
				c.addtransaction(tcobj);
				System.out.println("\n\n---------------------------------'Deposit Successfull!!'-----------------------------\n");
				System.out.print("\nDeposit Successfull!\n\n");
			}
			else if(amount<0)
			{
				System.out.print("Amount can't be Negative\n\n");
			}
			else
			{
				System.out.print("Amount exceeds your accounts maximum balance limit for Credit Transaction\n\n");
			}
		}
		else
		{
			System.out.print("\nAmount exceeds one time transfer limit\n");
		}
	}
}