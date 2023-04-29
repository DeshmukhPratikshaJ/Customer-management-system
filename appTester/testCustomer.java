package appTester;

import java.util.Scanner;
import static java.lang.System.*;
import static customer.acceptCustDetails.*;
import  java.time.*;
import customer.ValidationRules;
import java.time.format.DateTimeFormatter;


import EnumClasses.ServicePlan;
//----------import package and class files-------
import customer.*;

public class testCustomer {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(in))
		{
			//---------service plans------------------
			out.println("we have following plans:");
			for(ServicePlan plan:ServicePlan.values())
				out.println(plan);
			
			//---------customer array----------
		   Customer[] custList=new Customer[100];
		   int track=0;
		   
		   //-----------Menu----------------
		   out.println("menu:");
		   out.println("1.sign up 2.sign in");
		   out.println("3.update password 4.unsubscribe");
		   out.println("5.exit");
		   //--------switch case-----------
		   int choice;
		   String email;
		   do {
			   out.println("enter choice");
			   choice=sc.nextInt();
			  switch(choice)
			  {
			  case 1:  //---------Signing up------------
				  out.println("enter emailID");
				  email=sc.next();
				  ValidationRules.validateEmail(email);
				  out.println("enter first name,last name,DOB(dd-MM-yyyy),service plan");
				  custList[track++]=acceptDetails(sc.next(),sc.next(),email,sc.next(),LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd-MM-yyyy")),ServicePlan.valueOf(sc.next()));
				  out.println("account created..");
				  break;
				  
			  case 2:   //---------signing in------------
				  break;
				  
			  case 3:  //--------update password-----------
				  System.out.println("enter ur emailID");
				  break;
				  
			  case 4:  //----------unsubscribe----------------
				  break;
			  case 5: //--------------exit-------------
				  break;
			  default:
				out.println();  
			  }
			   
			   
		   }while(choice>0);
		}
		catch(Exception e){
			out.println(e.getStackTrace());
		}
		

	}

}
