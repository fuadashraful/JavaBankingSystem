import java.util.*;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;



public class MainMethod extends JFrame {/////////////////////////////////////////////////class starts

	static Scanner scan;
	static Container c;
	static JButton ButDepositNEXT,ButNextStu,ButNextCuurent,ButWithdrawNEXT,ButDeposit,ButWithdraw,ButBalance ,ButLoginpageLOG, ButGotoHomePage,ButNextSaving,ButLOG,ButNEW_BANK_ACCOUNT,ButSavingAccount,ButCurrentAccount,ButStudentAccount;
	static MainMethod frame;/////////////////   frame 
	static Font fWithdraw,fAfterLogInPage,fLogPage,fLogUserId,fGHP,fleb3,fLOG,fNEW_BANK,fleb1,fAcc,fNext,fleb2;
	
	static JLabel LebFinalStatus2,LebFinalStatus1,LebMinLim,lebSavingAccountMaaxLimxLim,lebStudentAccountM,lebSuccessful,LebWithdraw,lebLogPass,lebLogUserId,lebWrong,lebFillForm,leb1,leb2,leb3,lebtf1,lebtf2,lebtf3,lebtf4,lebtf5,lebtf6,lebtf7;
	static JTextField tfDeposit,tfWithdraw,tf1,tf2,tf3,tf4,tf5,tf6,tf7,tfLogUserId,tfLogPage,tfAfterLogInPage;
	static JPasswordField pass2,pass3,pass1;
	static String newUserId;
	static App getPrintObj ;
	static BankAccountAbstractClass A;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {/////////////////////////////////////////////////main starts
		getPrintObj=new App();
		getPrintObj.getObjectBack();
		frame=new MainMethod();
		frame.fontCreation() ;
		frame.ButtonCreation();
		frame.lebelAndCreation();
		frame.homePage();
	

		////////////////////////////////////      Action
		ButGotoHomePage.addActionListener(new ActionListener() {/////////////////////////////////////////////
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		
		    frame.getContentPane().removeAll();
				frame.repaint();
				frame.homePage();
				
			}
		});///////////////////////GotoHomePage  button end
		
		ButNextSaving.addActionListener(new ActionListener() {///////////////////////////////////////////////

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean i=false;
				i=frame.checkValidity("SavingAccount");
				if(i) {

					frame.getContentPane().removeAll();
					frame.repaint();
					frame.suuAccountCrePage();
					
					
				}							

			}
		});////////////////////////////////// button Next end
		
		
		ButSavingAccount.addActionListener(new ActionListener() {/////////////////////////////////////////////

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.savingAccountPage();
				frame.textFieldCreation();
				
			}
		});////////////////////////////End of saving Account Button
		
		ButNextCuurent.addActionListener(new ActionListener() {////////////////////////////////////////////////

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean i=false;
				i=frame.checkValidity("CurrentAccount");
				if(i) 
				{
					frame.getContentPane().removeAll();
					frame.repaint();
					frame.suuAccountCrePage();
				}


			}
		});////////////////////////////////// button Next end
		
		ButCurrentAccount.addActionListener(new ActionListener() {//////////////////////////////////////////////
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.currentAccountPage();
				frame.textFieldCreation();


			}
		});////////////////////////////End of current Account Button
		
		
		ButNextStu.addActionListener(new ActionListener() {////////////////////////////////////////////////////

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean i=false;
				i=frame.checkValidity("StudentAccount");
				if(i) {
					frame.getContentPane().removeAll();
					frame.repaint();
					frame.suuAccountCrePage();
				}


			}
		});////////////////////////////////// button Next end
		
		ButStudentAccount.addActionListener(new ActionListener() {////////////////////////////////////////////////

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.studentAccountPage();
				frame.textFieldCreation();
			}
		});
		
		
		
	     ////////////////////////////End of Student Account Button
		
		
		//// I am at here
		
		ButNEW_BANK_ACCOUNT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.newBankAccountpage();

			}
		});/////////////////////////////////////end of New Bank Account button
		

		ButBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfAfterLogInPage.setText("                                             "+A.accountBalance);

			}
		});/////////////////////////////////////////ButBalance end
		ButDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.depositPage();
				
				
			}
		});//////////////////////////////////////////  ButDeposit   end
		
		ButWithdrawNEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double temp=Double.parseDouble(tfWithdraw.getText());
				System.out.println("first :"+A.accountBalance);
				String result=A.withdraw(temp);
				
				if(result.length()==0)
				{
					frame.getContentPane().removeAll();
					frame.repaint();
					System.out.println("last : "+A.accountBalance);
					LebFinalStatus1.setText( "Your Present Balance is : "+A.accountBalance);
					frame.add(LebFinalStatus1);
					
					
					frame.add(LebFinalStatus2);
					
					frame.add(ButGotoHomePage);/////////////////////
					
				}
				else {
					tfAfterLogInPage.setText("Error :"+result);
				}
				
			}
		});
		
		
		ButDepositNEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double temp=Double.parseDouble(tfDeposit.getText());
				A.deposit(temp);
				
				
					frame.getContentPane().removeAll();
					frame.repaint();
					LebFinalStatus1.setText( "Your Present Balance is : "+A.accountBalance);
					
					frame.add(LebFinalStatus1);
					
					LebFinalStatus2=new JLabel( "Thank You");
					LebFinalStatus2.setBounds(100,250,150,40);
					LebFinalStatus2.setFont(fLogUserId);
					frame.add(LebFinalStatus2);
					frame.add(ButGotoHomePage);/////////////////////
					
					
				
				
			}
		});
		
		
		
		
		
		ButWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.withdrawPage();
				
				

			}
		});/////////////////////////////////////////       Withdraw  end
		
		ButLoginpageLOG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				A=getPrintObj.getObject(tfLogUserId.getText());
				try {
					if(A!=null)
					{
						if(A.password.equals(pass1.getText())) {
							frame.getContentPane().removeAll();
							frame.repaint();
							frame.afterLogin();
						}
						else {
							throw new Exception("");
						}
					}
					else {
						throw new Exception("");
					}
				}
				catch(Exception e)
				{
					tfLogPage.setText("Wrong User ID And Password");
				}

			}
		});/////////////////////////////////ButLoginpageLOG end

		ButLOG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.logInPage();
				


			}
		});////////////////////////////////////////////////////////////ButLOG end
		

		frame.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				getPrintObj.printAllAtFile();
			}
		}
				);

		////////////////////////////////////Action


		frame.setVisible(true);

	}/////////////////////////////////////////////////main Ends


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	void homePage()
	{
		tf1.setText("");
		pass2.setText("");
		pass3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		tfWithdraw.setText("");
		tfAfterLogInPage.setText("");
		tfLogPage.setText("");
		tfLogUserId.setText("");
		pass1.setText("");
		
		tfDeposit.setText("");
		
		
 
		frame.add(ButLOG);
		frame.add(ButNEW_BANK_ACCOUNT);
	}



	void newBankAccountpage(){////////////////////////////////////////////////////////////////////
		
 
//		frame.add(leb2);
		frame.add(ButSavingAccount);
		frame.add(ButStudentAccount);
		frame.add(ButCurrentAccount);
	}

	void  savingAccountPage() {///////////////////////////////////////////////////////////////////////////
		frame.add(lebFillForm);
		frame.add(ButNextSaving);
	}

	void  studentAccountPage() {//////////////////////////////////////////////////////////////////////
		frame.add(lebFillForm);
		frame.add(ButNextStu);
	}
	void  currentAccountPage() {/////////////////////////////////////////////////////////////////////////////

		frame.add(lebFillForm);
		frame.add(ButNextCuurent);

	}

	void textFieldCreation() {//////////////////////////////////////////////////////////////////////////////////
		
	//////////////////////////	for form fill
		frame.add(lebtf1);
		
		frame.add(tf1); 

		frame.add(lebtf2);

		frame.add(pass2);

		frame.add(lebtf3);

		frame.add(pass3);

		frame.add(lebtf4);
		
		frame.add(tf4);
		
		frame.add(lebtf5);
		
		frame.add(tf5);
		
		frame.add(tf6);

	}





	public MainMethod() {///////////////////////////////////////////////////////////////////////////////////////////
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Bank By Fuad Ashraful");
		setResizable(false);
		
		///setting color to background
 	getContentPane().setBackground(new Color(70,80,70));
		
	 

	}



	void suuAccountCrePage() {//////////////////////////////////////////////////////////////////////////////////////////
		lebtf7.setText( "Your Id:"+newUserId);
		frame.add(leb3);
		frame.add(lebtf6);
		frame.add(lebtf7);
		frame.add(ButGotoHomePage);
	}

	boolean checkValidity(String temp){////////////////////////////////////////////////////////////////////////////////
		try {
			String fil1=tf1.getText();
			String fil2=pass2.getText();
			String fil3=pass3.getText();
			double fil4=Double.parseDouble(tf4.getText());
			String fil5=tf5.getText();
			if(fil4<=100.0)
			{
				throw new Exception("Low Balance , Increase Your Balance and Try Again. minimum Balance 100");
			}
			else if(!fil2.equals(fil3))
			{
				throw new Exception("Password Not Matched");	 
			}
			BankAccountAbstractClass user;
			if(temp.equals("SavingAccount"))
			{
				user=new SavingAccount(fil1,"Saving Account",fil2,fil4,fil5);

				getPrintObj.NewAccount(user);
				newUserId=user.id;
				
			}
			else if(temp.equals("CurrentAccount"))
			{
				user=new CurrentAccount(fil1,"Current Account",fil2,fil4,fil5);

				getPrintObj.NewAccount(user);
				newUserId=user.id;
			}
			else if(temp.equals("StudentAccount"))
			{
				user=new StudentAccount(fil1,"Student Account",fil2,fil4,fil5);

				getPrintObj.NewAccount(user);
				newUserId=user.id;
			}


			return true;
		}

		catch(Exception e)
		{
			if(e.getMessage().equals("empty String"))
			{
				tf6.setText("                                                                                           Empty Fill");
				return false;
			}

			tf6.setText("                     "+e.getMessage());
			return false;
		}
	}
	void logInPage() {//////////////////////////////////////////////////////////////////////////////////////////

		
		frame.add(lebLogUserId);
		
		frame.add(tfLogUserId); 

		
		frame.add(lebLogPass);
		
		frame.add(pass1);

		
		frame.add(ButLoginpageLOG);
		
		frame.add(tfLogPage); 

	}
	void afterLogin() {
		frame.add(ButDeposit);
		frame.add(ButWithdraw);
		frame.add(ButBalance);
		tfAfterLogInPage.setText("");
		frame.add(tfAfterLogInPage); 
	}
	void withdrawPage(){
		
		frame.add(ButWithdrawNEXT);

		frame.add(LebWithdraw);
		
		frame.add(tfWithdraw); 
		
		frame.add(tfAfterLogInPage); ////////////////Wrong Fill
			
		frame.add(LebMinLim);
		
		frame.add(lebSavingAccountMaaxLimxLim);
		
		frame.add(lebStudentAccountM);
	}

	
	
	
	
	
	void depositPage(){
		
		
		frame.add(ButDepositNEXT);
		
		frame.add(LebWithdraw);
		
		frame.add(tfDeposit); 
		tfAfterLogInPage.setText("");
		frame.add(tfAfterLogInPage); ////////////////Wrong Fill
		
	}
	
	
	
	void ButtonCreation(){
	
		ButWithdrawNEXT=new JButton("Next");/////////
		ButWithdrawNEXT.setBounds(200,300,200,45);
		ButWithdrawNEXT.setFont(fWithdraw);
		

		ButDepositNEXT=new JButton("Next");/////////
		ButDepositNEXT.setBounds(200,300,200,45);
		ButDepositNEXT.setFont(fWithdraw);
		
		
		ButDeposit=new JButton("Deposit Money");/////////
		ButDeposit.setBounds(200,100,200,45);
		ButDeposit.setFont(fAfterLogInPage);
		
		ButWithdraw=new JButton("Withdraw Money");/////////
		ButWithdraw.setBounds(200,220,200,45);
		ButWithdraw.setFont(fAfterLogInPage);
		
		ButBalance=new JButton("Account Balance");/////////
		ButBalance.setBounds(200,340,200,45);
		ButBalance.setFont(fAfterLogInPage);
		
		
		ButLoginpageLOG=new JButton("LOG IN");/////////
		ButLoginpageLOG.setBounds(50,300,200,30);
		ButLoginpageLOG.setFont(fLOG);
		

		
		ButGotoHomePage=new JButton("Go to Home Page");/////////
		ButGotoHomePage.setBounds(180,380,250,30);
		ButGotoHomePage.setFont(fGHP);
		
		
		
		ButNextSaving=new JButton("Next");//////////////////  submit works for next
		ButNextSaving.setBounds(250,500,100,20);
		ButNextSaving.setFont(fNext);
		
		
		ButNextCuurent=new JButton("Next");///////////////
		ButNextCuurent.setBounds(250,500,100,20);
		ButNextCuurent.setFont(fNext);
		
		ButNextStu=new JButton("Next");///////////////////
		ButNextStu.setBounds(250,500,100,20);
		ButNextStu.setFont(fNext);
		
		

		ButCurrentAccount=new JButton("Current Account");/////////
		ButCurrentAccount.setBounds(50,390,300,20);
		ButCurrentAccount.setFont(fAcc);
		
		ButStudentAccount=new JButton("Student Account");/////////
		ButStudentAccount.setBounds(150,310,300,20);
		ButStudentAccount.setFont(fAcc);
		
		
		ButSavingAccount=new JButton("Saving Account");/////////
		ButSavingAccount.setBounds(50,100,300,20);
		ButSavingAccount.setFont(fAcc);
	
		
		ButNEW_BANK_ACCOUNT=new JButton("Create new AC");/////////
		ButNEW_BANK_ACCOUNT.setBounds(320,300,200,30);
		ButNEW_BANK_ACCOUNT.setFont(fNEW_BANK);
		

		ButLOG=new JButton("LOG In Your account");/////////
		ButLOG.setBounds(50,200,200,30);
		ButLOG.setFont(fLOG);
	
	}
	
	void fontCreation() {
		fWithdraw=new Font("Arial",Font.BOLD,15);
		fAfterLogInPage=new Font("Arial",Font.BOLD,15);
		fNext=new Font("Arial",Font.BOLD,25);
		fAcc=new Font("Arial",Font.BOLD,25);
		fLogUserId=new Font("Arial",Font.BOLD,18);
 
		fLogPage=new Font("Arial",Font.BOLD,20);
		fleb3=new Font("Arial",Font.BOLD,30);
		
 
		 
	 
		
		fleb2=new Font("Arial",Font.BOLD,20);
		fLOG=new Font("Arial",Font.BOLD,15);
		fNEW_BANK=new Font("Arial",Font.BOLD,15);
		fNext=new Font("Arial",Font.BOLD,25);
		fNext=new Font("Arial",Font.BOLD,25);
		fLOG=new Font("Arial",Font.BOLD,15);
		fGHP=new Font("Arial",Font.BOLD,20);
		fWithdraw=new Font("Arial",Font.BOLD,15);
	}
	
	
	void lebelAndCreation()
	{
		LebWithdraw=new JLabel( "Enter Amount");
		LebWithdraw.setBounds(240,180,200,40);
		LebWithdraw.setFont(fLogUserId);
	
		tfDeposit=new JTextField(100);	
		tfDeposit.setBounds(200,210,200,50);
		tfDeposit.setFont(fLogPage);
		
		lebStudentAccountM=new JLabel( "For Student Account, Max Limit of Withdraw is : 10000");
		lebStudentAccountM.setBounds(2,34,400,40);
		
		lebSavingAccountMaaxLimxLim=new JLabel( "For Saving Account, Max Limit of Withdraw is : 40000");
		lebSavingAccountMaaxLimxLim.setBounds(2,18,400,40);
		
		LebMinLim=new JLabel( "You Must Keep Minimum 100 tk in Your Account");
		LebMinLim.setBounds(2,2,400,40);
		
		tfWithdraw=new JTextField(100);	
		tfWithdraw.setBounds(200,210,200,50);
		tfWithdraw.setFont(fLogPage);
		
		
		tfAfterLogInPage=new JTextField(100);	
		tfAfterLogInPage.setBounds(0,500,600,50);
		tfAfterLogInPage.setFont(fLogPage);
		tfAfterLogInPage.setEnabled( false );
		
		tfLogPage=new JTextField(100);	
		tfLogPage.setBounds(0,500,600,50);
		tfLogPage.setFont(fLogPage);
		
		pass1=new JPasswordField(100)	;
		pass1.setBounds(180,250,380,40);
		
		lebLogPass=new JLabel( "Enter Password:");
		lebLogPass.setBounds(10,250,150,40);
		lebLogPass.setFont(fLogUserId);
		
		tfLogUserId=new JTextField(100);	
		tfLogUserId.setBounds(180,150,380,40);
		
		lebLogUserId=new JLabel( "Enter User ID:");
		lebLogUserId.setBounds(10,150,150,40);
		lebLogUserId.setFont(fLogUserId);
		
		lebtf7=new JLabel( "Your Id:");
		lebtf7.setBounds(40,300,500,40);
		lebtf7.setFont(fleb3);
		
		lebtf6=new JLabel( "Keep Safe Your User ID.");
		lebtf6.setBounds(40,220,590,40);
		lebtf6.setFont(fleb3);
		
		leb3=new JLabel( "Account Creation Successful");
		leb3.setBounds(87,150,500,40);
		leb3.setFont(fleb3);

		tf6=new JTextField(100);	
		tf6.setBounds(0,450,600,25);
		tf6.setEnabled( false );
		
		tf5=new JTextField(100);	
		tf5.setBounds(200,380,350,30);
		
 
		
		
	 
		
		lebtf5 =new JLabel( "Enter Address : ");
		lebtf5.setBounds(15,380,200,30);
		
		tf4=new JTextField(100);	
		tf4.setBounds(200,300,350,30);
		
		lebtf4 =new JLabel( "Enter Balance : ");
		lebtf4.setBounds(15,300,200,30);
		
		pass3=new JPasswordField(100)	;
		pass3.setBounds(200,220,350,30);
		
		lebtf3 =new JLabel( "Again Enter The Password:");
		lebtf3.setBounds(15,220,200,30);
		
		pass2=new JPasswordField(100)	;
		pass2.setBounds(200,150,350,30);
		
		lebtf2 =new JLabel( "Enter A Password :");
		lebtf2.setBounds(15,150,200,30);
		
		lebtf1 =new JLabel( "Enter You Full Name :");
		lebtf1.setBounds(15,80,200,30);
		
		tf1=new JTextField(100);	
		tf1.setBounds(200,80,350,30);
		
		lebFillForm =new JLabel( " Fill the form Corrently ");
		lebFillForm.setBounds(2,2,200,20);
		
		lebFillForm =new JLabel( " Fill the form Corrently ");
		lebFillForm.setBounds(2,2,200,20);
		
		lebFillForm =new JLabel( " Fill the form Corrently ");
		lebFillForm.setBounds(2,2,200,20);
		
		leb2=new JLabel( " Select Account type ");
		leb2.setBounds(196,100,400,100);
		leb2.setFont(fleb2);
		
 
		
		LebFinalStatus1=new JLabel();
		LebFinalStatus1.setBounds(100,150,599,40);
		LebFinalStatus1.setFont(fLogUserId);
		
		LebFinalStatus2=new JLabel( "Thank You");
		LebFinalStatus2.setBounds(100,250,150,40);
		LebFinalStatus2.setFont(fLogUserId);

	}
}
//////////////////////////////////////////////////////////////////class Ends


