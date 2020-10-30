import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		// init Scanner
		Scanner input = new Scanner(System.in);

		Customer user;
		Card card_user;

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
					boolean check_pin = card_user.ValidPin(pin);
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
		
	}

	public static void withdrawFunds(){
		//it processes the fund withdraw from an account
	}

	public static void depositFunds(){
		//it processes the fund deposit to an account
	}

	public static void transferFunds(){
		//it processes transferring of funds from one account to another
	}

	public static void changePIN(){
		//changes the pin of an customer
	}

	public static void showTransHistory(){
		//shows the transaction history for an account
	}
}
