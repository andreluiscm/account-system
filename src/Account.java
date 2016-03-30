
public abstract class Account
{
	
	String number;
	double balance;
	
	void makeCredit(double value)
	{
		this.balance += value;
	}
	
	void makeDebit(double value)
	{
		this.balance -= value;
	}

}
