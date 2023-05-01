package customer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import EnumClasses.ServicePlan;
import exceptions.DuplicateEmailException;

public class ValidationRules 
{
	
	public static Customer checkAllDetailsSignUp(String first_name, String last_name, String email,String password, String dob, String plan,Customer[] custList) throws DuplicateEmailException
	{
		Customer cInstant=new Customer(email);
		String validEmail=validateEmail(cInstant,custList);
		LocalDate validDob =LocalDate.parse(dob,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		ServicePlan validPlan=ServicePlan.valueOf(plan);
		return new Customer(first_name,last_name,validEmail,password,validDob,validPlan);
		
	}
	
	//-------------Validate duplication of email------------
	private static String validateEmail(Customer cInstant,Customer[] custList) throws DuplicateEmailException
	{
		for(Customer c:custList)
		{
			if(c.equals(cInstant))
				throw new DuplicateEmailException("this emailId already exist..please enter another");
		} 
		//at this point no duplication
		return cInstant.getEmail();
}
}