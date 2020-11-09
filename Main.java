import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

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
		while(run){

			/*
				calling login prompt and cannot proceed untill successfull login
			*/

			card_user = mainMenuPrompt();

			/*
				stay in main menu until customer quits
			*/

			printCustomerMenu(card_user,run);

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
		Card registered_card_user = new Card();
		Customer user = new Customer();
		Card card_user = new Card();
		boolean check_pin=false;

		// asks user for ID, card number and pin until gets an registered user
		while(!check_pin){
			System.out.println("\nWelcome to the Royalty Bank\n\n");

			//taking input of registered customer ID 
			System.out.println("Enter the Registered CUSTOMER ID :: ");
			userID = input.nextInt();

			//checking if userID exists
			boolean check_user = user.check_if_registered(userID);
			if(check_user==true){

				//taking input of valid card number
				System.out.println("\nEnter the CARD NUMBER :: ");
				cardNo = input.nextInt();

				//checking if card number exists
				int check_cardNo = card_user.checkValid(cardNo);
				if(check_cardNo==1){

					//taking input of correct PIN
					System.out.print("\nEnter PIN :: ");
					pin = input.nextInt();

					//checking if PIN is correct
					check_pin = card_user.ValidPin(cardNo, pin);
					if(check_pin){

						// finding customer corresponding to provided ID, card number, and PIN 
						registered_card_user = card_user.find_user(cardNo);
					}
					else
						System.out.printf("\n\nIncorrect PIN\nPlease try again\n\n");
				}
				else if(check_cardNo==0)
					System.out.printf("\n\nThe provided card is already expired\n\n");
				else if(check_cardNo==-1)
					System.out.printf("\n\nNo such card exists\n\n");
			}
			else
				System.out.printf("\n\nNo customer is registered with the provided ID\nEnter a valid Customer ID\n\n");
		}

		return registered_card_user;

	}

	/*
		prints ATM menu for customer actions
	*/
	public static void printCustomerMenu(Card card_user, boolean run){
		Account accobj = new Account();
		Transaction trobj = new Transaction();
		int choice=0;

		//user menu
		while(choice < 1 || choice > 5){

			System.out.println("What would you like to do?\n\n");
			System.out.println(" 1 - CHANGE PIN");
			System.out.println(" 2 - SWOW ACCOUNT BALANCE");
			System.out.println(" 3 - PERFORM TRANSACTION");
			System.out.println(" 4 - SHOW ACCOUNT TRANSACTION HISTORY");
			System.out.println(" 5 - QUIT\n\n");
			System.out.println("ENTER CHOICE :: ");
			choice = input.nextInt();

			if(choice < 1 || choice > 5)
				System.out.println("Invalid choice.\nPlease try again\n");
		}

		//processing the choice

		switch(choice){

		case 1 : 
			changePIN(card_user, input);
			break;

		case 2 :
			accobj.showBalance(card_user, input);
			break;

		/*case 3 :
			Main.performTransac(card_user, input);
			break;*/

		case 4 :
			trobj.showTransacHistory(card_user, input);
			break;

		case 5 :
			run=false;
			break;

		default:
			printCustomerMenu(card_user, true);
		}
	}

	/*
		changes the pin of a customer
	*/
	public static void changePIN(int cardNo){
		int oldPin=0, newPin=0;
		Connection c = new Connection();
		Card card_user = new Card();
		System.out.println("Enter old PIN :: ");
		oldPin = input.nextInt();

		// verifying the pin
		boolean check_pin = card_user.ValidPin(cardNo, oldPin);
		if(check_pin==true){

			//entering new PIN
			System.out.println("Enter new PIN :: ");
			newPin = input.nextInt();

			int recheck_newPin=0;
			System.out.println("Again enter new PIN :: ");
			recheck_newPin = input.nextInt();

			if(newPin==recheck_newPin){

				updatePin(cardNo, newPin);
				System.out.println("PIN updated successfuly\n\n");
			}
			else
				System.out.println("Re-entered New PIN doesn't match\nPlease Try Again\n\n");
	
		}
		else
			System.out.println("\n\nIncorrect PIN\nPlease try again\n\n");
	}	

	/*public static void performTransac(Card card_user){
		//it processes the fund withdraw from an account
	}*/
}