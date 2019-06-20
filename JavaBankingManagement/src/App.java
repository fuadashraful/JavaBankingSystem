import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class App {
	ArrayList<BankAccountAbstractClass> users=new ArrayList<>();
	public void NewAccount(BankAccountAbstractClass member)
	{

		users.add(member);
	}
	BankAccountAbstractClass getObject(String uId){
		for(BankAccountAbstractClass temp:users)
		{
			if(uId.equals(temp.id))
			{
				System.out.println("Found");
				return temp;
			}
			
		}
		System.out.println("Not Found");
		return null;
	}
	void printAllAtFile() {
		FileOutputStream fout=null;
		ObjectOutputStream out=null;
		try {
			fout=new FileOutputStream("DATA.txt");
			out=new ObjectOutputStream(fout);
			out.writeObject(users);
			out.flush();
			out.close();
			System.out.println("writing done");
		}
		catch(Exception e) {
		}
	}
	void getObjectBack(){
		try {
			FileInputStream in1=new FileInputStream("DATA.txt");
			ObjectInputStream in=new ObjectInputStream(in1);
			users=(ArrayList<BankAccountAbstractClass>)in.readObject();
			in.close();
			in1.close();
			System.out.println("read done");  
		} catch (Exception e) {
		}
	}
}
