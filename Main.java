import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;

public class Main
{
	//init scanner
	static Scanner input = new Scanner( System.in );
	public static void main(String args[])
	{
		Database obj = new Database();
		Card card_user = new Card();

		//creating database
		obj.init();

		boolean run = true;
		System.out.println("\n                                  WELCOME TO ROYALTY BANK");
		System.out.println("\n                         (At any moment to exit enter -1 as input)\n\n");
		while(run){

			//calling login prompt and cannot proceed untill successfull login
			card_user=mainMenuPrompt();

			//stay in main menu until customer quits
			if(card_user.card_no==-1)
			{
				run=false;
			}
			else
			{
				run=CustomerMenu(card_user);
			}

		}

		//droping database
		obj.drop();
	}

	/*
		prints ATM login menu
	*/
	public static Card mainMenuPrompt(){
		
		//inits
		int userID=0, cardNo=0, pin=0;
		String dummy="";
		Connect c = new Connect();
		Customer user = new Customer();
		Card card_user = new Card();
		Card registered_card_user = new Card();
		boolean check_pin=false;

		// asks user for ID, card number and pin until gets an registered user
		while(!check_pin){
			//taking input of registered customer ID 
			System.out.print("Enter the Registered USER ID :: ");
			userID = input.nextInt();
			if(userID==-1)
			{
				dummy = input.nextLine();
				System.out.print("\n\nAre you sure you want to exit(Y/N)? :: ");
				String s = input.nextLine();
				System.out.print("\n\n");
				if(s.equalsIgnoreCase("Y"))
				{
					registered_card_user.card_no=-1;
					return registered_card_user;
				}
			}
			else
			{
				//checking if userID exists
				boolean check_user = user.check_if_registered(userID);
				if(check_user==true){
					String name = c.getname(userID);
					System.out.println("\nWELCOME "+name+"!");
					//taking input of valid card number
					System.out.print("\nEnter the CARD NUMBER :: ");
					cardNo = input.nextInt();
					if(cardNo==-1)
					{
						dummy = input.nextLine();
						System.out.print("\nAre you sure you want to exit(Y/N)? :: ");
						String s = input.nextLine();
						System.out.print("\n\n");
						if(s.equalsIgnoreCase("Y"))
						{
							registered_card_user.card_no=-1;
							return registered_card_user;
						}
					}
					else
					{
						//checking if card number exists
						int check_cardNo = card_user.checkValid(cardNo);
						if(check_cardNo==1){
							//taking input of correct PIN
							System.out.print("\nEnter PIN :: ");
							pin = input.nextInt();
							if(pin==-1)
							{
								dummy = input.nextLine();
								System.out.print("\n\nAre you sure you want to exit(Y/N)? :: ");
								String s = input.nextLine();
								System.out.print("\n\n");
								if(s.equalsIgnoreCase("Y"))
								{
									registered_card_user.card_no=-1;
									return registered_card_user;
								}
							}
							else
							{
								//checking if PIN is correct
								check_pin = card_user.ValidPin(cardNo, pin);
								if(check_pin){

									// finding customer corresponding to provided ID, card number, and PIN 
									registered_card_user = card_user.find_user(cardNo);
								}
								else
									System.out.printf("\n\nIncorrect PIN\nPlease try again\n\n");
							}
						}
						else if(check_cardNo==0)
							System.out.printf("\n\nThe provided card is already expired\n\n");
						else if(check_cardNo==-1)
							System.out.printf("\n\nEnter valid card number\n\n");
					}
				}
				else
				{
					System.out.printf("\nUser not registered\nEnter a Registered User ID...\n\n\n");

				}
			}
		}

		return registered_card_user;
	}

	/*
		prints ATM menu for customer actions
	*/
	public static boolean CustomerMenu(Card card_user){
		Account accobj = new Account();
		Transaction trobj = new Transaction();
		int choice=0;
		boolean run=true;

		//user menu
		while(choice < 1 || choice > 5){

			System.out.println("\nWhat would you like to do?\n");
			System.out.println(" 1 - CHANGE PIN");
			System.out.println(" 2 - SWOW ACCOUNT BALANCE");
			System.out.println(" 3 - PERFORM TRANSACTION");
			System.out.println(" 4 - SHOW ACCOUNT TRANSACTION HISTORY");
			System.out.println(" 5 - QUIT\n\n");
			System.out.print("ENTER CHOICE :: ");
			choice = input.nextInt();

			System.out.print("\n");
			if(choice < 1 || choice > 5)
				System.out.println("\nInvalid choice.\nPlease try again\n");
		}

		//processing the choice

		switch(choice){

		case 1 : 
			changePIN(card_user.card_no);
			run=CustomerMenu(card_user);
			break;

		case 2 :
			accobj.showAccBalance(card_user.acc_no);
			run=CustomerMenu(card_user);
			break;

		/*case 3 :
			Main.performTransac(card_user, input);
			CustomerMenu(card_user);
			break;*/

		case 4 :
			trobj.show_transac_his(card_user.cust_id);
			run=CustomerMenu(card_user);
			break;

		case 5 :
			run=false;
			break;

		default:
			run=CustomerMenu(card_user);
		}
		if(choice==5) run=false;
		return run;
	}

	/*
		changes the pin of a customer
	*/
	public static void changePIN(int cardNo){
		int oldPin=0, newPin=0;
		Connect c = new Connect();
		Card card_user = new Card();
		System.out.print("Enter old PIN :: ");
		oldPin = input.nextInt();

		// verifying the pin
		boolean check_pin = card_user.ValidPin(cardNo, oldPin);
		if(check_pin==true){

			//entering new PIN
			System.out.print("Enter new PIN :: ");
			newPin = input.nextInt();

			int recheck_newPin=0;
			System.out.print("Again enter new PIN :: ");
			recheck_newPin = input.nextInt();

			if(newPin==recheck_newPin){

				c.updatePin(cardNo, newPin);
				System.out.println("\nPIN updated successfuly\n\n");
			}
			else
				System.out.println("\nRe-entered New PIN doesn't match\nPlease Try Again\n\n");
	
		}
		else
			System.out.println("\n\nIncorrect PIN\nPlease try again\n\n");
	}	

	/*public static void performTransac(Card card_user){
		//it processes the fund withdraw from an account
	}*/
}