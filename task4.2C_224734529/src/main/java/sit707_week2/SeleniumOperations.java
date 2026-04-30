package sit707_week2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/savvy/Documents/Boarding Pass/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        sleep(1);
        return driver;
    }

    public static String bunnings_login_page(String url, String username, String password, boolean rememberMe) {
        WebDriver driver = openBrowser(url);

        try {
        	// Username field
            WebElement usernameField = driver.findElement(By.name("username"));
  
            usernameField.sendKeys(username);

            // Password field
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys(password);

            // Remember Me checkbox
            WebElement rememberCheckbox = driver.findElement(By.name("rememberMe"));
            if (rememberMe && !rememberCheckbox.isSelected()) {
                rememberCheckbox.click();
            }

            // Login button
            WebElement loginButton = driver.findElement(By.id("login-submit"));
            loginButton.click();


            sleep(1);

            return driver.getCurrentUrl();

        } finally {
            driver.quit();
        }
    }
}
	
