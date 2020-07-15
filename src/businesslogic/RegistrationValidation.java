package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation{
	
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		
		boolean isEmailValid=validEmail(email) ;
		boolean isPassValid= validPassword(password, confirmPassword);
		if(isEmailValid==true && isPassValid==true)
		return true;
		else
			return false;
	}
	
	private boolean validPassword(String password, String confirmPassword) {
		
		//Password field should not be empty.
		//Password and confirm password should match.
		//Must contain atleast 8 characters and atmost 20 characters.
		//Must have atleast one uppercase letter, 1 lowercase letter and 1 number.
		Pattern pattern1 = Pattern.compile("[A-Z]");
		Pattern pattern2 = Pattern.compile("[a-z]");
		Pattern pattern3 = Pattern.compile("[0-9]");
		Matcher matcher1 = pattern1.matcher(password);
		Matcher matcher2 = pattern2.matcher(password);
		Matcher matcher3 = pattern3.matcher(password);
		
		
		if(password.length()==0 ||  password != confirmPassword)
			return false;
		else if(password.length()<8 || password.length()>20)
					return false;
		else if(matcher1.find() && matcher2.find() && matcher3.find())
		return true;
		else
		return false;
	}
	private boolean validEmail(String email) {
		//Email can contain alphanumeric value
		//Allowed special characters - _, @, .[at, underscore, dot]
		//	Email should not be empty.
		Pattern pattern = Pattern.compile("[$&+,:;=\\\\?#|/'<>^*()%!-]");
		Matcher matcher = pattern.matcher(email);
		
	if(email.length()==0)
		return false;
	else if(matcher.find())
		return false;
	else
	return true;
	}
}

