package appTester;

import java.util.Scanner;
import static java.lang.System.*;
import static customer.ValidationRules.checkAllDetailsSignUp;


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
		   boolean exit=false;
		   while(!exit)	   {
			   try {
			 //-----------Menu----------------
			   out.println("menu:");
			   out.println("1.sign up 2.sign in");
			   out.println("3.update password 4.unsubscribe");
			   out.println("5.exit");
			   //--------switch case-----------
			   out.println("enter choice");
			  switch(sc.nextInt())
			  {
			  case 1:  //---------Signing up------------
				  if(track<custList.length)
				  {
				  out.println("enter customer details:first_name,last_name,Email,password,Dob(dd-MM-yyyy),Plan");
				  custList[track++]=checkAllDetailsSignUp(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),custList);
				  out.println("account created..");
				  }
				  else
					  System.out.println("list is full");
				  break;
				  
			  case 2:   //---------signing in------------
				  break;
				  
			  case 3:  //--------update password-----------
				  System.out.println("enter ur emailID");
				  break;
				  
			  case 4:  //----------unsubscribe----------------
				  break;
			  case 5: //--------------exit-------------
				  exit=true;
				  break;
			  default:
				out.println();  
			  }
			   }
			  catch(Exception e){
					out.println(e.getStackTrace());
			  }
			   }
		}
	}

	}
