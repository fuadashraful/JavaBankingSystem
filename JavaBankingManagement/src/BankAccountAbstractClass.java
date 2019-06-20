import java.io.Serializable;
import java.util.Random;
public abstract class BankAccountAbstractClass implements Serializable  {

	public String name,id,password,accountType,address;
	double accountBalance;


	public BankAccountAbstractClass(String name,String accountType,String password, double accountBalance,String address) {
		this.name = name;
		this.accountType = accountType;
		this.password = password;
		Random rand=new Random();
		this.id =""+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10) ; 
		this.accountBalance = accountBalance;
		this.address=address;
	}
	
	void deposit(double amount) {

		accountBalance+=amount;
		System.out.println("deposit done");
	}
	abstract public String withdraw(double amount);
}
