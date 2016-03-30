import java.util.Scanner;

public class BankSystem
{
	
	List list;

	public BankSystem()
	{
		super();
	}
	
	void run()
	{
		list = new List();
		Node accountNode;
		Node accountNode2;
		
		System.out.println("--------------------------------------------------------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		while (true)
		{
			System.out.println("Bank System Menu");
			System.out.println("Choose an option:");
			System.out.println("[1] - Insert a Bank Account");
			System.out.println("[2] - Insert a Savings Account");
			System.out.println("[3] - Insert a Loyalty Account");
			System.out.println("[4] - Credit an account");
			System.out.println("[5] - Debit an account");
			System.out.println("[6] - Check balance");
			System.out.println("[7] - Check bonus (Loyalty Account only)");
			System.out.println("[8] - Make a transfer between two accounts");
			System.out.println("[9] - Earn interest (Savings Account only)");
			System.out.println("[10] - Earn bonus (Loyalty Account only)");
			System.out.println("[11] - Remove an account");
			System.out.println("[12] - Print all registered accounts");
			System.out.println("[13] - Quit");
			input = scanner.next();
			
			switch (input)
			{
			case "1":
				System.out.println("Enter with your desired account number:");
				input = scanner.next();
				
				insert(1, input);
				
				break;
				
			case "2":
				System.out.println("Enter with your desired account number:");
				input = scanner.next();
				
				insert(2, input);
				
				break;
				
			case "3":
				System.out.println("Enter with your desired account number:");
				input = scanner.next();
				
				insert(3, input);
				
				break;
				
			case "4":
				System.out.println("Enter with the account number:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					System.out.println("Enter with the amount of money you want to credit in:");
					input = scanner.next();
					
					accountNode.account.makeCredit(Double.parseDouble(input));
					
					if (accountNode.account instanceof LoyaltyAccount)
					{
						((LoyaltyAccount) (accountNode.account)).bonus += Double.parseDouble(input) * 0.01;
					}
					
					System.out.println("Done");
				}
				else
				{
					System.out.println("Could not find an account with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;

			case "5":
				System.out.println("Enter with the account number:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					System.out.println("Enter with the amount of money you want to debit from:");
					input = scanner.next();
					
					accountNode.account.makeDebit(Double.parseDouble(input));
					
					System.out.println("Done");
				}
				else
				{
					System.out.println("Could not find an account with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "6":
				System.out.println("Enter with the account number:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					System.out.println("Node: " + accountNode + "\tAccount: " + accountNode.account + "\tAccount Number: " + accountNode.account.number + "\tBalance: " + accountNode.account.balance);
				}
				else
				{
					System.out.println("Could not find an account with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "7":
				System.out.println("Enter with the account number:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					if (accountNode.account instanceof LoyaltyAccount)
					{
						System.out.println("Node: " + accountNode + "\tAccount: " + (LoyaltyAccount) accountNode.account + "\tAccount Number: " + ((LoyaltyAccount) accountNode.account).number + "\tBonus: " + ((LoyaltyAccount) (accountNode.account)).bonus);
					}
					else
					{
						System.out.println("Can not check bonus from this account, it must be a Loyalty Account");
					}
				}
				else
				{
					System.out.println("Could not find an account with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "8":
				System.out.println("Enter with the account number of the account you want to transfer from:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					System.out.println("Enter with the account number of the account you want to transfer to:");
					input = scanner.next();
					
					accountNode2 = list.search(input, false);
					
					if (accountNode2 != null)
					{
						System.out.println("Enter with the amount of money you want to transfer:");
						input = scanner.next();
						
						accountNode.account.makeDebit(Double.parseDouble(input));
						accountNode2.account.makeCredit(Double.parseDouble(input));
						
						System.out.println("Done");
					}
					else
					{
						System.out.println("Could not find an account (receiver) with this account number");
					}
				}
				else
				{
					System.out.println("Could not find an account (sender) with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "9":
				System.out.println("Enter with the account number:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					if (accountNode.account instanceof SavingsAccount)
					{
						((SavingsAccount) accountNode.account).earnInterest();
						
						System.out.println("\n(Earning interest)\n");
						System.out.println("Done");
					}
					else
					{
						System.out.println("Can not earn interest from this account, it must be a Savings Account");
					}
				}
				else
				{
					System.out.println("Could not find an account with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "10":
				System.out.println("Enter with the account number:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					if (accountNode.account instanceof LoyaltyAccount)
					{
						((LoyaltyAccount) accountNode.account).earnBonus();
						
						System.out.println("\n(Earning bonus)\n");
						System.out.println("Done");
					}
					else
					{
						System.out.println("Can not earn bonus from this account, it must be a Loyalty Account");
					}
				}
				else
				{
					System.out.println("Could not find an account with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "11":
				System.out.println("Enter with the account number of the account you want to delete:");
				input = scanner.next();
				
				accountNode = list.search(input, false);
				
				if (accountNode != null)
				{
					list.remove(accountNode.account.number);
					
					System.out.println("\n(Deleting)");
					System.out.println("\nDone");
				}
				else
				{
					System.out.println("Could not find an account with this account number");
				}
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "12":
				list.print();
				
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
				
			case "13":
				list = list.free();
				accountNode = null;
				accountNode2 = null;
				
				scanner.close();
				input = null;
				
				System.out.println("\nShutting down the system");
				System.out.println("--------------------------------------------------------------------------------");
				
				System.exit(0);
				
				break;
				
			default:
				System.out.println("Wrong option");
				System.out.println("--------------------------------------------------------------------------------");
				
				break;
			}
		}
	}
	
	void insert(int accountType, String accountNumber)
	{
		if (accountType == 1)
		{
			list.insertHead(new BankAccount(accountNumber));
		}
		else if (accountType == 2)
		{
			list.insertHead(new SavingsAccount(accountNumber));
		}
		else if (accountType == 3)
		{
			list.insertHead(new LoyaltyAccount(accountNumber));
		}
		
		System.out.println("--------------------------------------------------------------------------------");
	}

}
