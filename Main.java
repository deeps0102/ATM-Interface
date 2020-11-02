import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		// init Scanner
		Scanner input = new Scanner(System.in);

		Customer user;
		Card card_user;
		Account account_user;

		boolean run = true;

		while(run){

			/*
				calling login prompt and cannot proceed untill successfull login
			*/
			card_user = Main.mainMenuPrompt(input);
			/*
				stay in main menu until customer quits
			*/
			Main.printCustomerMenu(card_user, input);
		}
	}

	/*
		prints ATM login menu
	*/
	public static Card mainMenuPrompt(Scanner input){
		
		//inits
		int userID;
		int cardNo;
		int pin;
		Card registered_card_user;

		// asks user for ID, card number and pin until gets an registered user
		while(registered_card_user == NULL){
			System.out.printf("\nWelcome to the Royalty Bank\n\n");

			//taking input of registered customer ID 
			System.out.print("Enter the Registered CUSTOMER ID :: ");
			userID = input.nextInt();

			//checking if userID exists
			boolean check_user = user.check_if_registered(userID);
			if(check_user){

				//taking input of valid card number
				System.out.print("\nEnter the CARD NUMBER :: ");
				cardNo = input.nextInt();

				//checking if card number exists
				int check_cardNo = card_user.checkValid(cardNo);
				if(check_cardNo==1){

					//taking input of correct PIN
					System.out.print("\nEnter PIN :: ");
					pin = input.nextInt();

					//checking if PIN is correct
					boolean check_pin = card_user.ValidPin(cardNo, pin);
					if(check_pin){

						// finding customer corresponding to provided ID, card number, and PIN 
						registered_card_user = card_user.find_user(cardNo, pin);
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
	public static void printCustomerMenu(Card card_user, Scanner input){
		
		//init
		int choice;

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
				Main.changePIN(card_user, input);
				break;

		case 2 :
				Main.showBalance(card_user, input);
				break;

		case 3 :
				Main.performTransac(card_user, input);
				break;

		case 4 :
				Main.showTransacHistory(card_user, input);
				break;

		case 5 :
				input.nextLine();
				break;
		}

		//redisplay this menu unless the user wants to quit
		if(choice!=5)
			Main.printCustomerMenu(card_user, input);
	}

	/*
		changes the pin of a customer
	*/
	public static void changePIN(Card card_user, Scanner input){
		int oldPin;
		int newPin;

		System.out.print("Enter old PIN :: ");
		oldPin = input.nextInt();

		// verifying the pin
		boolean check_pin = card_user.ValidPin(card_user.card_no, oldPin);
		if(check_pin){

			//entering new PIN
			System.out.print("Enter new PIN :: ");
			newPin = input.nextInt();

			int recheck_newPin;
			System.out.print("Again enter new PIN :: ");
			recheck_newPin = input.nextInt();

			if(newPin==recheck_newPin){

				updatePin(card_user.card_no, newPin);
				System.out.print("PIN updated successfuly\n\n");
			}
			else
				System.out.print("Re-entered New PIN doesn't match\nPlease Try Again\n\n");
	
		}
		else
			System.out.printf("\n\nIncorrect PIN\nPlease try again\n\n");
	}

	/*
		display balance of customer account
	*/
	public static void showBalance(Card card_user, Scanner input){

		double balance;
		balance = account_user.showAccBalance(card_user.AccNo);

		System.out.println("Your Account Balance is :: " + balance + "\n\n");

	}

	/*
		displays tranaction history of an account
	*/
	public static void showTransacHistory(Card card_user, Scanner input){

	}	

	public static void performTransac(Card card_user, Scanner input){
		//it processes the fund withdraw from an account
	}

	

}
