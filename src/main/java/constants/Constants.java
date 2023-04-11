package constants;

public class Constants {

	public class DOMAINS_URL{
		public static final String ABTASTY_LOGIN_PAGE = "https://app2.abtasty.com";
		public static final String SSO_LOGIN_PAGE = "https://app2.abtasty.com/ssologin";
		public static final String SMS_CODE_API = "WRITE HERE SMS CODE API URL WITH ENDPOINT";
	}

	public static class TestDataForSigningIn {


		//  Valid emails
		public static final String EMAIL = "test@gmail.com";
		public static final String NON_ABTASTY_USER_EMAIL = "HERE'S VALID NON ABTASTY USER'S EMAIL";
		public static final String EMAIL_SSO = "HERE'S SSO EMAIL";


		// Invalid emails
		public static final String INVALID_EMAIL_MISSED_AT_SIGN = "testgmail.com";
		public static final String INVALID_EMAIL_MISSED_DOMAIN = "test@";
		public static final String INVALID_EMAIL_WITH_INVALID_CHARACTERS = "te+02st@gmail.com";
		public static final String INVALID_EMAIL_WITH_CYRILLIC_LETTERS  = "тест@gmail.com";

		// Valid password
		public static final String PASSWORD = "testPassword123.";
		public static final String NON_ABTASTY_USER_PASSWORD = "HERE'S VALID NON ABTASTY USER'S PASSWORD";

		// Invalid passwords
		public static final String INVALID_PASSWORD_EMPTY_DATA = "";
		public static final String INVALID_PASSWORD_LESS_8_CHARACTERS = "testPa.";
		public static final String INVALID_PASSWORD_MORE_64_CHARACTERS = "testPassword123.testPassword123.testPassword123.testPassword123.t";
		public static final String INVALID_PASSWORD_NO_NUMBERS = "testPassword.";
		public static final String INVALID_PASSWORD_NO_SYMBOLS = "testPassword123";
		public static final String INVALID_PASSWORD_NO_UPPERCASE_CHARACTERS = "testpassword123.";

		// Error messages here
		public static final String ERROR_MESSAGE = "Please enter a valid email or password";
		public static final String ERROR_MESSAGE_INVALID_SMS = "Oups ! Le code que vous avez saisi est incorrect. Veuillez re'essayer";

		// Confirmation messages
		public static final String TITLE_TEXT = "WRITE HERE TITLE OF HOME PAGE TO MAKE SURE, THAT WE AUTHORIZED";
		public static final String LOGIN_PAGE_TITLE_TEXT = "Sign in to your account";
		public static final String INVALID_SMS_CODE = "7777777";
	}

	public static class TestDataForLogInWithSSO{
		public static final String SSO_TITLE = "AB Tasty - Experience Optimization Platform";
	}
}
