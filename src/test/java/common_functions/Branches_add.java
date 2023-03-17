package common_functions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Branches_add {

	WebDriver driver;
	
	public Branches_add(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//a[@href='admin_banker_master.aspx']//img")
	WebElement Branches_btn;
	@FindBy(xpath="//input[@id='BtnNewBR']")
	WebElement New_branches_btn;
	@FindBy(xpath="//input[@id='txtbName']")
	WebElement BranchName;
	@FindBy(name="txtAdd1")
	WebElement Address_1;
	@FindBy(name="Txtadd2")
	WebElement Address_2;
	@FindBy(name="txtadd3")
	WebElement Address_3;
	@FindBy(name="txtArea")
	WebElement Area;
	@FindBy(name="txtZip")
	WebElement zip_code;
	@FindBy(name="lst_counrtyU")
	WebElement Country;
	@FindBy(name="lst_stateI")
	WebElement State;
	@FindBy(name="lst_cityI")
	WebElement city;
	@FindBy(name="btn_insert")
	WebElement Submit_btn;

	public boolean AddBranch(String para1, String para2, String para3,String para4,String para5,String para6,String para7,String para8,String para9) throws Throwable
	{
		Branch branch_select = PageFactory.initElements(driver, Branch.class);
		branch_select.Branch_click();
		this.BranchName.sendKeys(para1);
		this.Address_1.sendKeys(para2);
		this.Address_2.sendKeys(para3);
		this.Address_3.sendKeys(para4);
		this.Area.sendKeys(para5);
		this.zip_code.sendKeys(para6);
		this.Country.sendKeys(para7);
		this.State.sendKeys(para8);
		this.city.sendKeys(para9);
		this.Submit_btn.click();
		String actual_alert_text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expected_alert_text = "sucessfully";
		if (actual_alert_text.toLowerCase().contains(expected_alert_text.toLowerCase())) {
			Reporter.log("Branch created successfully"+actual_alert_text+"   "+expected_alert_text);
			return true;
		}
		else {
			Reporter.log("Brach not created"+actual_alert_text+"   "+expected_alert_text);
			return false;
		}
		
	}

}
