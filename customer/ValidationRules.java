package customer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;

import EnumClasses.ServicePlan;
import exceptions.CustomerException;

public class ValidationRules {

	public static Customer checkAllDetailsSignUp(String first_name, String last_name, String email, String password,
			String dob, String plan, List<Customer> custList)
			throws CustomerException, DateTimeParseException, IllegalArgumentException {
		String validEmail = validateEmail(email, custList); // validate uniqueness of email
		CheckPasswordStrength(password);                  //validate strength of password
		LocalDate validDob = parseDOB_validateAge(dob); // validate age>21
		ServicePlan validPlan = parseAndvalidateServicePlan(plan); // validate service plan
		return new Customer(first_name, last_name, validEmail, password, validDob, validPlan);

	}

	public static int signIn(String email, String password, List<Customer> custList) throws CustomerException {
		Customer customer = new Customer(email);
		int index = custList.indexOf(customer);
		if (index == -1)
			throw new CustomerException("you have not subscribed..please Sign Up first");
		else {
			if (!(custList.get(index).getPassword().equals(password)))
				throw new CustomerException("wrong password...try again");
		}
		return index;
	}

	// -------------1.Validate duplication of email------------
	private static String validateEmail(String email, List<Customer> custList) throws CustomerException {
		Customer cInstant = new Customer(email); // wrapping email in Customer--suing overloaded constructor

		// -----------using contains method------------
		if (custList.contains(cInstant))
			throw new CustomerException("this emailId already exist..please enter another");

		// ---using for each and using equals meth of Customer-----------
		// for(Customer c:custList)
//		{
//			if(c.equals(cInstant))
//				throw new CustomerException("this emailId already exist..please enter another");
//		} 

		// at this point no duplication
		return email;
	}

	// --------------2.check strength of password--------//length>8, contains an
	// uppercase,a symbol,a number
	private static void CheckPasswordStrength(String password) throws CustomerException {
		if (password.length() > 8)
		// password length>8
		{
			boolean isSymbol=false;
			boolean isUpperCase = false;
			boolean isLowerCase = false;
			boolean isDigit = false;
			
			//-----------checking for sepcial symbol-----------
			if ((password.contains("&")) || (password.contains("*")) || (password.contains("^"))
					|| (password.contains("$")) || (password.contains("#")) || (password.contains("%"))
					|| (password.contains("@")) || (password.contains("!")) || (password.contains("~")))
				 
					isSymbol=true;
			
            //---------checking for uppercase,lowercase and a digit using for loop--------
				for (int i = 0; i < password.length(); i++) 
				{
                  if(Character.isUpperCase(password.charAt(i))) 
                	  isUpperCase=true;
                  if(Character.isLowerCase(password.charAt(i))) 
                	  isLowerCase=true;
                  if(Character.isDigit(password.charAt(i))) 
                	  isDigit=true;
				}
				//check for uppercase,lowercase,special symbol and a number--if not then throw exception
				
				if(!(isUpperCase||isLowerCase||isDigit||isSymbol))  //throw exception if(true)
					throw new CustomerException("password must contain atleast"
							+ " one special symbol,one uppercase,one lowercase and a digit");
					
			
		} else
			throw new CustomerException("very weak password strength");

	}

	// --------------3.checking age>21-------------------
	private static LocalDate parseDOB_validateAge(String dob) throws CustomerException, DateTimeParseException {
		LocalDate validDob = LocalDate.parse(dob);
		if ((Period.between(validDob, LocalDate.now())).getYears() < 21)
			throw new CustomerException("age is below 21 so not allowed to subscribe..");
		return validDob;
	}

	// --------------4.checking valid service plan-------
	private static ServicePlan parseAndvalidateServicePlan(String plan) throws IllegalArgumentException {
		return ServicePlan.valueOf(plan.toUpperCase());

	}
}