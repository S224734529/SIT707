package sit707_week4;

import org.junit.Assert;
import org.junit.Test;


public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "224734529";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Pamuditha Senadeera";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
    public void testEmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("abc", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameCorrectPasswordAndEmptyValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());

        Assert.assertFalse(LoginForm.validateCode(null));
    }

    @Test
    public void testCorrectUsernameCorrectPasswordAndWrongValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());

        Assert.assertFalse(LoginForm.validateCode("abcd"));
    }

    @Test
    public void testCorrectUsernameCorrectPasswordAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());

        Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}