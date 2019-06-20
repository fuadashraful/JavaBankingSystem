public class StudentAccount extends  BankAccountAbstractClass{

	public StudentAccount(String name,String accountType,String password, double accountBalance,String address) {
		super(name, accountType, password, accountBalance,address);	
	}
	public String withdraw(double amount) {
		
		if(accountBalance>=amount && 100<=(accountBalance-amount) && amount<=10000.0)
		{
			accountBalance-=amount;
			System.out.println("done");
			return "";
		}
		else {
		return "Insufficient balance or limit crossed";
		}
	}
}
