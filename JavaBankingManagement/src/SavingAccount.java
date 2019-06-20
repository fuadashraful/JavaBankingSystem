public class SavingAccount extends  BankAccountAbstractClass{

	public SavingAccount(String name,String accountType,String password, double accountBalance,String address) {
		super(name,accountType, password, accountBalance,address);
	
	}
	public String withdraw(double amount) {
	
		if(accountBalance>=amount && 100<=(accountBalance-amount) && amount<=40000.0)
		{
			accountBalance-=amount;
			System.out.println(amount+" removed "+accountBalance);
			System.out.println("done");
			return "";
		}
		else {
		return "Insufficient balance or limit crossed";
		}
	}
}
