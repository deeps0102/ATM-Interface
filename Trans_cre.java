import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.Math.abs;
import java.time.LocalDate;

public class Trans_cre// extends Transaction
{
	static Scanner input = new Scanner( System.in );
	public Trans_cre(){}
	/*public Trans_cre()
	{
		//define the constructor
	}*/

	public void transac_list()
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
					//
					transac_list();
					break;
				case 2:
					//
					transac_list();
					break;
				case 3:
					return;
			}
		}
		else
		{
			System.out.println("\nEnter a valid choice\n");
			transac_list();
		}

	}
}