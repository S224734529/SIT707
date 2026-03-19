package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/savvy/Downloads/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Pamuditha");
		
		// Last name
		WebElement lastName = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastName);
		lastName.sendKeys("Senadeera");
		
		//Phone Number
		WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + phoneNumber);
		phoneNumber.sendKeys("0435126630");

		// Email
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + email);
		email.sendKeys("pamuditha.senadeera99@gmail.com");

		// Password
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		password.sendKeys("Rasanjana.99");

		// Confirm password
		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + confirmPassword);
		confirmPassword.sendKeys("Rasanjana.99");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(.,'Create account')]"));
		createAccountButton.click();

		sleep(3);
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("officeworks_registration.png");

		try {
			Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
	//Alternative website with selenium
	
	public static void github_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/savvy/Downloads/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		
		// Find first input field which is email
		WebElement element = driver.findElement(By.id("email"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Pamuditha.rasanjana999@gmail.com");
		

		// Password
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		password.sendKeys("Rasanjana.99");

		// Username
		WebElement username = driver.findElement(By.id("login"));
		System.out.println("Found element: " + username);
		username.sendKeys("Pamuditha1234598765");
	
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(.,'Create account')]"));
		createAccountButton.click();

		sleep(3);
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("github_registration.png");

		try {
			Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
