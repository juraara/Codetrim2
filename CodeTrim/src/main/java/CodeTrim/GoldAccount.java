
package CodeTrim;

public class GoldAccount extends BankAccount
{
	private double overdraftLimit;
	
	public GoldAccount(String numberIn, String nameIn, double limitIn)
	{		
		super(numberIn, nameIn);
		overdraftLimit = limitIn;
	}
	
	public void setLimit(double limitIn)
	{
		overdraftLimit = limitIn;
	}
	
	
	public double getLimit()
	{
		return overdraftLimit;
	}

        @Override
public boolean withdraw(double amountIn) {
    if (amountIn > overdraftLimit) {
        return false; // no withdrawal was made
    }

    balance -= amountIn;
    return true; // money was withdrawn successfully
}	
	
}
