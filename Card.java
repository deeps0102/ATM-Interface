public class Card
{
	private int card_no;
	private int exp_date;
	private String card_type;
	private int pin;
	private int cust_id = NULL;
	private int acc_no = NULL;

	public card(int card_no, int exp_date, int pin)
	{
		//defining the cunstructor
		this.setCard_no(card_no);
		this.setExp_date(exp_date);
		this.setCard_type(card_no);
		this.setPin(pin);
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
	public int chackValid(int cardNo){
		//checks if the card is valid
	}

	/*	checks if pin is correct or not
		returns true if pin is correct
		returns false if pin is incorrect
	*/
	public boolean ValidPin(int cardNo, int pin){

	}

	/* 
		returns the card information associated with provided card number and pin
	*/
	public Card find_user(int cardNo, int pin){

	}

	/*
		upadates the PIN of user
	*/
	public void updatePin(int cardNo, int newPin){
		
	}
}

