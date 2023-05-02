package customer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import EnumClasses.ServicePlan;
import exceptions.CustomerException;

public class ValidationRules 
{
	
	public static Customer checkAllDetailsSignUp(String first_name, String last_name, String email,String password, String dob, String plan,List<Customer> custList) throws CustomerException
	{
		String validEmail=validateEmail(email,custList);
		LocalDate validDob =LocalDate.parse(dob,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		ServicePlan validPlan=ServicePlan.valueOf(plan.toUpperCase());
		//check if age >21
		return new Customer(first_name,last_name,validEmail,password,validDob,validPlan);
		
	}
	
	//-------------Validate duplication of email------------
	private static String validateEmail(String email,List<Customer> custList) throws CustomerException
	{
		Customer cInstant=new Customer(email);   //wrapping email in Customer--suing overloaded constructor
	
		//-----------using contains------------
		if(custList.contains(cInstant))
			throw new CustomerException("this emailId already exist..please enter another");
		
//---using for each and using equals meth of Customer-----------
		//		for(Customer c:custList)
//		{
//			if(c.equals(cInstant))
//				throw new CustomerException("this emailId already exist..please enter another");
//		} 
		
		
		//at this point no duplication
		return email;
}
}