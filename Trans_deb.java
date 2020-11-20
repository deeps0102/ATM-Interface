import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.Math.abs;
import java.time.LocalDate;

public class Trans_deb// extends Transaction
{
	static Scanner input = new Scanner( System.in );
	public Trans_deb(){}
	/*public Trans_deb()
	{
		//define the constructor
	}*/

	public void transac_list()
	{
		System.out.println("\nSelect Transaction type:\n");
		System.out.println("1 - WITHDRAW");
		System.out.println("2 - DEPOSIT");
		System.out.println("3 - TRANSFER TO ANOTHER ACCOUNT");
		System.out.println("4 - QUIT\n\n");
		System.out.print("ENTER CHOICE :: ");
		int choice=0;
		choice=input.nextInt();
		if(choice<=4 && choice>=1)
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
					//
					transac_list();
					break;
				case 4:
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
