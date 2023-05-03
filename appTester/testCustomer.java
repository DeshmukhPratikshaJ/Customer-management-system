package appTester;

import customer.Customer;
import static customer.ValidationRules.checkAllDetailsSignUp;
import static customer.ValidationRules.signIn;
import static utils.HardcoreCustList.populateCustList;
import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import EnumClasses.ServicePlan;


public class testCustomer {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(in)) {
			// ---------service plans------------------
			out.println("we have following plans:");
			for (ServicePlan plan : ServicePlan.values())
				out.println(plan);

			// ---------customer array----------
			ArrayList<Customer> custList = populateCustList();
			
//		   //------------alrdy existing customer details-----------------
//		   for(Customer c:custList)
//			   System.out.println(c);

			boolean exit = false;
			while (!exit) {
				try {
					// -----------Menu----------------
					out.println("menu:");
					out.println("1.sign up 2.sign in");
					out.println("3.update password 4.unsubscribe");
					out.println("5.list of all customers 6.sort customer by emailID ");
					System.out.println("7.sort customers by servicePlan and name 0.exit");
					// --------switch case-----------
					out.println("enter choice");

					switch (sc.nextInt()) {
					case 1: // ---------Signing up------------
						
						out.println("enter customer details:first_name,last_name,Email,password,Dob(yyyy-MM-dd),Plan");
						custList.add(checkAllDetailsSignUp(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), custList));
						out.println("account created..");
						break;

					case 2: // ---------signing in------------
						out.println("enter email and password");
						int index=signIn(sc.next(), sc.next(), custList);
						out.println(custList.get(index).getFirst_name()+" signed in successfully");
						break;

					case 3: // --------update password-----------
						
						// ----step 1--sign in
						out.println("enter ur emailID and password");
						index = signIn(sc.next(), sc.next(), custList);
						// succesfully signed in
						// ------step 2--update password
						System.out.println("enter new password");
						custList.get(index).setPassword(sc.next());
						out.println("password updated successfully");
						break;

					case 4: // ----------unsubscribe----------------
						
						// ----step 1--sign in
						out.println("enter ur emailID and password");
						index = signIn(sc.next(), sc.next(), custList);
						// succesfully signed in
						// ----step 2--unsubscribe
						out.println("unsubscribed account:" + custList.remove(index)); // OR custList.remove(cust);
                        break;
                       
					case 5: //-------list of all customer names and email conatct-----------
						System.out.println("names of all the customers");
						for(Customer c:custList)
						   out.println(c.getFirst_name()+" "+c.getEmail());
						break;
						
					case 6: //-------sort customers list by email-----Natural Order of sorting
						
						Collections.sort(custList);
						
						for(Customer c:custList)
							   System.out.println(c);
						break;
						
					case 7: //--------sort customers list by service plan and name----custom order of sorting
						
						Collections.sort(custList, new Comparator<Customer>()
						{
							@Override
							public int compare(Customer o1, Customer o2) {
					//int planOrder=o1.getPlan().compareTo(o2.getPlan());//compares the ordinal value
								int planOrder=o1.getPlan().name().compareTo(o2.getPlan().name());// calls copareTo of string
								if(planOrder==0) 
								   {
								  String name1=o1.getFirst_name();
								  String name2=o2.getFirst_name();
									return name1.compareTo(name2);
									}
								else
									return planOrder;
							}
							});  //end of java statement
						
						for(Customer c:custList)
							   System.out.println(c);
						break;

					case 0: // --------------exit-------------
						exit = true;
						break;
					default:
						out.println();
					}
				} catch (Exception e) {
					out.println(e.getStackTrace());
				}
			}
		}
	}

}
