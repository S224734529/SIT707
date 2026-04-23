package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/savvy/Downloads/chromedriver-mac-arm64/chromedriver");

		driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

	private void loadLoginPage() {
		driver.navigate().to(
				"/Users/savvy/Documents/Deakin/2026T1/Software Quality Testing - SIT707/OnTrack Tasks/7.1P/7.1P-resources/pages/login.html");
	}

	private void performLogin(String username, String password, String dob) {
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		if (username != null) {
			ele.sendKeys(username);
		}

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		if (password != null) {
			ele.sendKeys(password);
		}

		ele = driver.findElement(By.id("dob"));
		ele.clear();
		if (dob != null) {
			ele.sendKeys(dob);
		}

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
	}

	@Test
	public void testLoginSuccess() {
		loadLoginPage();
		performLogin("ahsan", "ahsan_pass", "1998-04-25");

		String title = driver.getTitle();
		Assert.assertEquals("success", title);

		String status = driver.findElement(By.id("login-status")).getText();
		Assert.assertEquals("success", status);
	}

	@Test
	public void testLoginFailWrongUsername() {
		loadLoginPage();
		performLogin("wronguser", "ahsan_pass", "1998-04-25");

		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailWrongPassword() {
		loadLoginPage();
		performLogin("ahsan", "wrongpass", "1998-04-25");

		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailWrongDob() {
		loadLoginPage();
		performLogin("ahsan", "ahsan_pass", "2000-01-01");

		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailEmptyUsername() {
		loadLoginPage();
		performLogin("", "ahsan_pass", "1998-04-25");

		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailEmptyPassword() {
		loadLoginPage();
		performLogin("ahsan", "", "1998-04-25");

		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailEmptyDob() {
		loadLoginPage();
		performLogin("ahsan", "ahsan_pass", "");

		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailInvalidDobFormat() {
		loadLoginPage();
		performLogin("ahsan", "ahsan_pass", "25-04-1998");

		Assert.assertEquals("fail", driver.getTitle());
	}
}