package exceptions;

@SuppressWarnings("serial")
public class DuplicateEmailException extends Exception{
	
	public DuplicateEmailException(String errMesg)
	{
		super(errMesg);
	}

}
