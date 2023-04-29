package customer;
import exceptions.DuplicateEmailException;

public class ValidationRules {
	
	//-------------Validate duplication of email------------
	public static void validateEmail(String email,String...emails) throws DuplicateEmailException
	{
		for(String e:emails)
		{
			if(e.equals(email))
				throw new DuplicateEmailException("this emailId already exist..please enter another");
		}
	}

}
