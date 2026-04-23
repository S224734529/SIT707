package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

	@Test
	public void testLoginSuccessWithValidInputs() {
		Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "1998-04-25"));
	}

	@Test
	public void testLoginFailWrongUsername() {
		Assert.assertFalse(LoginService.login("wronguser", "ahsan_pass", "1998-04-25"));
	}

	@Test
	public void testLoginFailWrongPassword() {
		Assert.assertFalse(LoginService.login("ahsan", "wrongpass", "1998-04-25"));
	}

	@Test
	public void testLoginFailWrongDob() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
	}

	@Test
	public void testLoginFailNullUsername() {
		Assert.assertFalse(LoginService.login(null, "ahsan_pass", "1998-04-25"));
	}

	@Test
	public void testLoginFailNullPassword() {
		Assert.assertFalse(LoginService.login("ahsan", null, "1998-04-25"));
	}

	@Test
	public void testLoginFailNullDob() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
	}

	@Test
	public void testLoginFailEmptyUsername() {
		Assert.assertFalse(LoginService.login("", "ahsan_pass", "1998-04-25"));
	}

	@Test
	public void testLoginFailEmptyPassword() {
		Assert.assertFalse(LoginService.login("ahsan", "", "1998-04-25"));
	}

	@Test
	public void testLoginFailEmptyDob() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
	}

	@Test
	public void testLoginFailInvalidDobFormat() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "01-01-1998"));
	}

	@Test
	public void testLoginFailImpossibleDate() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "1998-02-30"));
	}

	@Test
	public void testLoginSuccessWithTrimmedInputs() {
		Assert.assertTrue(LoginService.login("  ahsan  ", "  ahsan_pass  ", " 1998-04-25 "));
	}
}