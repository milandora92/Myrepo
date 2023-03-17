package common_functions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Branch_update_Page {
	
WebDriver driver;

public Branch_update_Page(WebDriver driver)
{
this.driver=driver;	
}


@FindBy(xpath="//tbody/tr[2]/td[7]/a[1]/img[1]")
WebElement edit_btn;
@FindBy(xpath="//input[@id='txtbnameU']")
WebElement BranchName;
@FindBy(name="txtadd1u")
WebElement Address_1;
@FindBy(name="txtadd2u")
WebElement Address_2;
@FindBy(name="txtadd3U")
WebElement Address_3;
@FindBy(name="txtareaU")
WebElement Area;
@FindBy(name="txtzipu")
WebElement zip_code;
@FindBy(name="drlst_countryU")
WebElement Country;
@FindBy(name="lst_stateU")
WebElement State;
@FindBy(name="LST_cityU")
WebElement city;
@FindBy(name="btnupdate")
WebElement Update_btn;

public boolean verify_branch_updates(String para1, String para2, String para3,String para4,String para5,String para6,String para7,String para8,String para9)
{
	Branch click_branch = PageFactory.initElements(driver, Branch.class);
	click_branch.branch_btn.click();
	this.edit_btn.click();
	this.BranchName.sendKeys(para1);
	this.Address_1.sendKeys(para2);
	this.Address_2.sendKeys(para3);
	this.Address_3.sendKeys(para4);
	this.Area.sendKeys(para5);
	this.zip_code.sendKeys(para6);
	this.Country.sendKeys(para7);
	this.State.sendKeys(para8);
	this.city.sendKeys(para9);
	this.Update_btn.click();
	String actual_alert_message = driver.switchTo().alert().getText();
	String expected_alert_message = "Sucessfully";
	driver.switchTo().alert().accept();
	if (actual_alert_message.toLowerCase().contains(expected_alert_message.toLowerCase())) {
		Reporter.log("Branch update Sucessful",true);
		return true;
	}
	else {
		Reporter.log("Branch not updated");
		return false;
	}
	
}
}
