package appTester;

import static customer.ValidationRules.changePlanPaySubscription;
import static customer.ValidationRules.checkAllDetailsSignUp;
import static customer.ValidationRules.signIn;
import static java.lang.System.in;
import static java.lang.System.out;
import static utils.HardcoreCustList.populateCustList;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

import EnumClasses.Menu;
import EnumClasses.ServicePlan;
import customer.Customer;


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
					for (Menu menu : Menu.values())
						out.println(menu);
					
					// --------switch case-----------
					out.println("enter choice");

					switch (sc.nextInt()) {
					case 1: // ---------Signing up------------
						
						out.println("enter customer details:first_name,last_name,Email,password,Dob(yyyy-MM-dd),Plan,registrationDate");
						custList.add(checkAllDetailsSignUp(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(),sc.next(), custList));
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
					
					case 8:  //---------pay subscription if not paid for more than one month---------
						// ----step 1--sign in
						out.println("enter ur emailID and password");
						index = signIn(sc.next(), sc.next(), custList);
						// succesfully signed in
						// ----step 2--check if lastSubscriptionDate> 1 month then show option for changing plan,paying subscription 
						LocalDate lastSubscriptionDate=custList.get(index).getLastSubscriptinDate();
						if(Period.between( lastSubscriptionDate,LocalDate.now()).getMonths()>1)
						{
							out.println("you are late on paying subscription amount");
							out.println("do you want to pay subscription and continue:y/n");
							char isNewPlan=sc.next().toLowerCase().charAt(0);
							if(isNewPlan=='y') {
							out.println("enter plan");
							changePlanPaySubscription(index, sc.next(), custList);
							out.println("subscription renewed");
						}
							else
								out.println("renew subscription ");
						}
						else
							out.println("subscription is still valid.");
							out.println("Subscription ends on :"+custList.get(index).getLastSubscriptinDate().plusMonths(1));
					
						break;
						
					case 9:// for admin------------chack the custList and remove access of customer if lastSubsciptionDate is more than 3 months
						ListIterator<Customer> custItr=custList.listIterator();
						while(custItr.hasNext()) {
							double period=Period.between(LocalDate.now(),custItr.next().getLastSubscriptinDate()).getMonths();
							if(period>3)
								custItr.remove();			
						}
						
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
