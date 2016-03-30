
public class LoyaltyAccount extends Account
{
	
	double bonus;
	
	public LoyaltyAccount()
	{
		super();
	}
	
	public LoyaltyAccount(String number)
	{
		super();
		
		this.number = number;
		this.balance = 0d;
		this.bonus = 0d;
	}

	void earnBonus()
	{
		this.balance += this.bonus;
		this.bonus = 0d;
	}
	
}
