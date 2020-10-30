public class Card
{
	private int card_no;
	private int exp_date;
	private string card_type;
	private int Pin;

	public card(int card_no, int exp_date, int Pin){
		this.setcard_no(card_no);
		this.setexp_date(exp_date);
		this.setcard_type(card_no);
		this.setPin(Pin);
	}

	//returns card number
	public int getcard_no(){
		return this.card_no;
	}

	//set card number
	public void setcard_no(int card_no){
		this.card_no = card_no;
	}

	//returns card number
	public int getexp_date(){
		return this.exp_date;
	}

	//set card number
	public void setexp_date(int exp_date){
		this.exp_date = exp_date;
	}

	//returns card number
	public int getPin(){
		return this.Pin;
	}

	//set card number
	public void setPin(int Pin){
		this.Pin = Pin;
	}

	//returns card number
	public string getcard_type(){
		return this.card_type;
	}

	//set card number
	public void setcard_type(int card_no){
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
	public boolean ValidPin(int pin){

	}

	/* 
		returns the card information associated with provided card number and pin
	*/
	public Card find_user(int cardNo, int pin){

	}
}
