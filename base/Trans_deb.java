package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.Math.abs;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class Trans_deb extends Transaction
{
	static Scanner input = new Scanner( System.in );
	public Trans_deb(){}

	// prints transaction options for debit card
	public static void transac_list(Card obj)
	{
		System.out.println("\nSelect Transaction type:\n");
		System.out.println("1 - WITHDRAW");
		System.out.println("2 - DEPOSIT");
		System.out.println("3 - TRANSFER TO ANOTHER ACCOUNT");
		System.out.println("4 - QUIT\n\n");
		System.out.print("ENTER CHOICE :: ");
		int choice=0;
		choice=input.nextInt();
		System.out.print("\n");
		if(choice<=4 && choice>=1)
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
					transfer(obj);
					transac_list(obj);
					break;
				case 4:
					System.out.print("\n\nAre you sure you want to exit(Y/N)? :: ");
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

	// withdraws money from account linked to given card
	public static void withdraw(Card obj)
	{
		Trans_deb tdobj = new Trans_deb();
		Account accobj = new Account();
		Connect c=new Connect();
		c.connectpk(obj.acc_no,accobj);

		System.out.println("Your current account balance is Rs. "+accobj.acc_bal);
		System.out.print("\n");
		System.out.print("Enter amount to withdraw :: ");
		double amount=0;amount=input.nextInt();
		System.out.print("\n");

		// checking if amount if less than total account balance
		if(amount>accobj.acc_bal)
		{
			System.out.print("\nNot enough balance to withdraw this amount\n");
			return;
		}
		//checking if amount is valid or not (means positive nuber)
		else if(amount<0)
		{
			System.out.print("\nAmount can't be negative\n");
			return;
		}
		//checking if amount is less than one time withdrawl limit
		else if(amount>obj.limit)
		{
			System.out.print("\nAmount exceeds one time transfer limit\n");
			return;
		}
		//if all above conditios satisfy then performs withdrawl
		else
		{
			tdobj.bal_bef=accobj.acc_bal;
			double newbal=accobj.acc_bal-amount;
			c.updateAccbal(accobj.acc_no,newbal);
			System.out.println("Your new account balance is Rs. "+newbal);
			tdobj.amt=amount;
			
			tdobj.transac_via="Debit";
			tdobj.transac_type="Withdraw";

			
			tdobj.date_time=new SimpleDateFormat("dd-MM-yyyy").format(new Date());

			tdobj.bal_aft=newbal;
			tdobj.cust_id=obj.cust_id;
			tdobj.acc_no=obj.acc_no;
			c.addtransaction(tdobj);
			System.out.println("\n\n----------------------------------'Withdrawl Successfull!!'------------------------------\n");
		}
	}

	//deposits money in account linked to given debit card
	public static void deposit(Card obj)
	{
		Trans_deb tdobj = new Trans_deb();
		Account accobj = new Account();
		Connect c=new Connect();
		c.connectpk(obj.acc_no,accobj);

		System.out.println("Your current account balance is Rs. "+accobj.acc_bal);
		System.out.print("\n");
		System.out.print("Enter amount to deposit :: ");
		double amount=0;amount=input.nextInt();
		System.out.print("\n");

		//checking if amount is less than one time deposit limit
		if(amount>obj.limit)
		{
			System.out.print("\nAmount exceeds one time transfer limit\n");
			return;
		}
		//checking if user has entered a valid amount
		else if(amount<0)
		{
			System.out.print("\nAmount can't be negative\n");
			return;
		}
		//if above conditions satisfy then perform deposit of money
		else
		{
			tdobj.bal_bef=accobj.acc_bal;
			double newbal=accobj.acc_bal+amount;
			c.updateAccbal(accobj.acc_no,newbal);
			System.out.println("Your new account balance is Rs. "+newbal);
			tdobj.amt=amount;
			
			tdobj.transac_via="Debit";
			tdobj.transac_type="Deposit";

			
			tdobj.date_time=new SimpleDateFormat("dd-MM-yyyy").format(new Date());

			tdobj.bal_aft=newbal;
			tdobj.cust_id=obj.cust_id;
			tdobj.acc_no=obj.acc_no;
			c.addtransaction(tdobj);
			System.out.println("\n\n----------------------------------'Deposit Successfull!!'------------------------------\n");
		}
	}

	//transfers money from one account to another account
	public static void transfer(Card obj)
	{
		Trans_deb tdobj = new Trans_deb();
		Account accobj1 = new Account();
		Connect c=new Connect();
		c.connectpk(obj.acc_no,accobj1);

		System.out.println("Your current account balance is Rs. "+accobj1.acc_bal);
		System.out.print("\n");
		System.out.print("Enter amount to transfer :: ");
		int amount=0;amount=input.nextInt();
		System.out.print("\n\n");
		//checks if entered transfer amount is present in account or not
		if(amount>accobj1.acc_bal)
		{
			System.out.print("\nNot enough balance to transfer this amount\n");
			return;
		}
		//checks if amount is valid
		else if(amount<0)
		{
			System.out.print("\nAmount can't be negative\n");
			return;
		}
		//checks if amount if less than one time transfer limit
		else if(amount>obj.limit)
		{
			System.out.print("\nAmount exceeds one time transfer limit\n");
		}
		//if above conditions satisfy then performs transfer of money
		else
		{
			tdobj.bal_bef=accobj1.acc_bal;

			//taking input of account number in which amount is to be transferred
			System.out.print("Enter account no. of account where amount has to be transacted :: ");
			int id=0;id=input.nextInt();

			Account accobj2 = new Account();
			c.connectpk(id,accobj2);

			double newbal1=accobj1.acc_bal-amount,newbal2=accobj2.acc_bal+amount;
			c.updateAccbal(accobj1.acc_no,newbal1);
			c.updateAccbal(accobj2.acc_no,newbal2);
			System.out.println("Your new account balance is Rs. "+newbal1);
			tdobj.amt=amount;
			
			tdobj.transac_via="Debit";
			tdobj.transac_type=Integer.toString(id);

			
			tdobj.date_time=new SimpleDateFormat("dd-MM-yyyy").format(new Date());

			tdobj.bal_aft=newbal1;
			tdobj.cust_id=obj.cust_id;
			tdobj.acc_no=obj.acc_no;
			c.addtransaction(tdobj);
			System.out.println("\n\n----------------------------------'Transaction Successfull!!'------------------------------\n");
		}
	}
}
