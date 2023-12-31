package atm;

import java.io.*;
import java.text.*;
import java.util.*;

public class OptionMenu extends Account{
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException{
		int x=1;
		do {
			try {
				data.put(12345678, 9679);
				data.put(75840825, 2405);
				
				System.out.println("Welcome to ATM Project");
				System.out.println("Enter Your customer no.");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your pin : ");
				setPinNumber(menuInput.nextInt());
			}catch (Exception e) {
				System.out.println("\n"+"Invalid Character(s).Only Numbers."+"\n");
				x=2;
			}
			
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			
			if(data.containsKey(cn) && data.get(cn) == pn) {
				getAccountType();
			}else
				System.out.println("\n"+"Wrong Customer Number or Pin Number!"+"\n");
		}while(x==1);
	}
	public void getAccountType() {
		System.out.println("Select the Account you want to access : ");
		System.out.println("Type - 1 : Checking Account.");
		System.out.println("Type - 2 : Savings Account.");
		System.out.println("Type - 3 : Exit.");
		
		int selection = menuInput .nextInt();
		
		switch(selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSavings();
			break;
		case 3:
			System.out.println("Thank you for using the ATM, bye. \n");
			break;
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
			getAccountType();
		}
	}
	public void getChecking() {
		System.out.println("Checking Account : ");
		System.out.println("Type - 1 : View Balance.");
		System.out.println("Type - 2 : Withdraw fund.");
		System.out.println("Type - 3 : Diposit fund.");
		System.out.println("Type - 4 : Exit.");
		
		System.out.println("Choice : ");
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance : "+moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDipositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using the ATM, bye. \n");
			break;
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
			getChecking();
		}
	}
	public void getSavings() {
		System.out.println("Savings Account : ");
		System.out.println("Type - 1 : View Balance.");
		System.out.println("Type - 2 : Withdraw fund.");
		System.out.println("Type - 3 : Diposit fund.");
		System.out.println("Type - 4 : Exit.");
		
		System.out.println("Choice : ");
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Savings Account Balance : "+moneyFormat.format(getSavingsBalance()));
			getAccountType();
			break;
		case 2:
			getSavingsWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingsDipositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using the ATM, bye. \n");
			break;
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
			getSavings();
		}
	}

}
