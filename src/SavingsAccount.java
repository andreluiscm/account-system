
public class SavingsAccount extends Account
{

	public SavingsAccount()
	{
		super();
	}
	
	public SavingsAccount(String number)
	{
		super();
		
		this.number = number;
		this.balance = 0d;
	}
	
	void earnInterest()
	{
		this.balance *= 1.01;
	}

}
