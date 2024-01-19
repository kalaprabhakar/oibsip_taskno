package com.kuu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kuu.controller.MainController;
import com.kuu.model.Account;

@SpringBootApplication
public class AtmInterfaceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AtmInterfaceApplication.class, args);
		
		
		
		MainController controller = ctx.getBean("atmcontroller" , MainController.class);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		
		System.out.println("**********Welcome TO New Bank ATM**********");
		System.out.println("Enter Your Account Number :");
		int accno = Integer.parseInt(br.readLine());
		System.out.println("Enter Your 4 Digit PIN : ");
		int pin = Integer.parseInt(br.readLine());
		
		
		boolean flag = controller.login(accno, pin);
		
		while(flag) {
			System.out.println("********Services********");
			System.out.println("==============================");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposite");
			System.out.println("3. Transfer");
			System.out.println("4. Mini Statement");
			System.out.println("5. Quit");
			
			int option =  Integer.parseInt(br.readLine());
			
			switch(option) {
			case 1 :
				System.out.println("******Withdraw*****");
				System.out.println("======================");
				System.out.println("Enter The Amount :");
				float amount =  Float.parseFloat(br.readLine());
				
				controller.withdraw(amount, accno);
				break;
			case 2 :
				
				System.out.println("******* Deposite *******");
				System.out.println("===============================");
				System.out.println("Enter Amount :");
				float depoamount = Float.parseFloat(br.readLine());
				controller.diposite(depoamount ,accno);
				break;
			case 3 :
				
				System.out.println("******* Transfer *******");
				System.out.println("=============================");
				System.out.println("Enter The Account Number :");
				int rec_acc = Integer.parseInt(br.readLine());
				System.out.println("Enter Amount :");
				float amount1 = Float.parseFloat(br.readLine());
				controller.transfer(accno, rec_acc, amount1);
				break;
				
			case 4 :
				
				System.out.println("******Mini Statement******");
				Account ac =controller.miniStatement(accno);
				System.out.println("Account Number :" +ac.getAcc_no() );
				System.out.println("Name : "+ ac.getName());
				System.out.println("Account Type :" +ac.getAcctype());
				System.out.println("Balance :" +ac.getBal());
				
				break ;
			case 5 :
				System.out.println("********** Thanks You  Visit Again **********");
				System.exit(0);
			}
		}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
