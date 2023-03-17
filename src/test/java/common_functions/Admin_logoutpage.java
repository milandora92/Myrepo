package common_functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Admin_logoutpage {

WebDriver driver;

public Admin_logoutpage(WebDriver driver)
{
this.driver=driver;	
}
@FindBy(xpath="//a[@href='http://primusbank.qedgetech.com']//img")
WebElement logout_btn;

public boolean AdminLogout()
{
 this.logout_btn.click();
 String expected_url_text = "http://primusbank.qedgetech.com/";
 String actual_utl_text = driver.getCurrentUrl();
 if (expected_url_text.equalsIgnoreCase(actual_utl_text)) {
	 Reporter.log("Logout Successful");
	 return true;
	 }
 else {
	Reporter.log("Logout unsuccessful");
	return false;
}
}

}
