package web.service;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		if (username == null || password == null || dob == null) {
			return false;
		}

		username = username.trim();
		password = password.trim();
		dob = dob.trim();

		if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
			return false;
		}

		if (!isValidDate(dob)) {
			return false;
		}

		if ("ahsan".equals(username)
				&& "ahsan_pass".equals(password)
				&& "1998-04-25".equals(dob)) {
			return true;
		}

		return false;
	}

	private static boolean isValidDate(String dob) {
		try {
			LocalDate.parse(dob);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}