package utility;

import java.util.regex.Pattern;

public class ValidationUtils {
	 private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
	    private static final Pattern MOBILE_PATTERN = Pattern.compile("\\d{10}");

	    public static boolean validateEmail(String email) {
	        return EMAIL_PATTERN.matcher(email).matches();
	    }

	    public static boolean validateMobile(String mobile) {
	        return MOBILE_PATTERN.matcher(mobile).matches();
	    }

}
