package common_functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Admin_LoginPage {

	WebDriver driver;
	public Admin_LoginPage(WebDriver driver)
	{
		this.driver = driver;	
	}
	@FindBy(xpath = "//input[@id='txtuId']")
	WebElement UserName;
	@FindBy(xpath = "//input[@id='txtPword']")
	WebElement Password;
	@FindBy(xpath = "//input[@id='login']")
	WebElement Login_btn;

	public boolean AdminLogin(String username, String password)
	{
		this.UserName.sendKeys(username);
		this.Password.sendKeys(password);
		this.Login_btn.click();
		String expected_url_text = "adminflow";
		String actual_url_text = driver.getCurrentUrl();
		if (actual_url_text.toLowerCase().contains(expected_url_text.toLowerCase())) {
			Reporter.log("Successfully logged in to the application"+ "    "+ actual_url_text+"     "+expected_url_text,true);
			return true;
		}
		else {
			String error = driver.switchTo().alert().getText();
			Reporter.log("Login unsuccessful"+error,true);
			return false;
		}
	}
}

