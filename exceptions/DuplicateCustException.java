package exceptions;

@SuppressWarnings("serial")
public class DuplicateCustException extends Exception{
	
	public DuplicateCustException(String errMesg)
	{
		super(errMesg);
	}

}
