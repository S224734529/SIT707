package sit707_week2;

import org.junit.Assert;


import org.junit.Before;
import org.junit.Test;

public class MainTest {
	
	private final String LOGIN_URL = "https://www.bunnings.com.au/login";

	
	public MainTest() {
		System.out.println("MainTest");
	}
	
	@Before
	public void setup() {
		System.out.println("Before...");
	}
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224734529";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Senadeera Arachchige Pamuditha Rasanjana Senadeera";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testBlankEmailAndBlankPassword() {
        String currentUrl = SeleniumOperations.bunnings_login_page(LOGIN_URL, "", "",false);

        Assert.assertTrue(
            "Login should fail when email and password are blank",
            currentUrl.contains("/login")
        );
    }

    @Test
    public void testValidEmailBlankPassword() {
        String currentUrl = SeleniumOperations.bunnings_login_page(
            LOGIN_URL,
            "test@example.com",
            "",false
        );

        Assert.assertTrue(
            "Login should fail when password is blank",
            currentUrl.contains("/login")
        );
    }

    @Test
    public void testBlankEmailWithPassword() {
        String currentUrl = SeleniumOperations.bunnings_login_page(
            LOGIN_URL,
            "",
            "Password123",
            false
        );

        Assert.assertTrue(
            "Login should fail when email is blank",
            currentUrl.contains("/login")
        );
    }

    @Test
    public void testInvalidEmailFormat() {
        String currentUrl = SeleniumOperations.bunnings_login_page(
            LOGIN_URL,
            "invalidemail",
            "Password123",
            false
        );

        Assert.assertTrue(
            "Login should fail when email format is invalid",
            currentUrl.contains("/login")
        );
    }

    @Test
    public void testWrongEmailAndWrongPassword() {
        String currentUrl = SeleniumOperations.bunnings_login_page(
            LOGIN_URL,
            "wronguser@example.com",
            "WrongPassword123",
            false
        );

        Assert.assertTrue(
            "Login should fail for incorrect login details",
            currentUrl.contains("/login")
        );
    }

    @Test
    public void testSuccessfulLogin() {
        String currentUrl = SeleniumOperations.bunnings_login_page(
            LOGIN_URL,
            "s224734529@deakin.edu.au",
            "Pass@123",
            false
        );

        Assert.assertFalse(
            "Successful login should move away from login page",
            currentUrl.contains("/login")
        );
    }
}