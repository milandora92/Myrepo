package common_functions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Branch {

	@FindBy (xpath="//a[@href='admin_banker_master.aspx']//img")
	WebElement branch_btn;
	@FindBy(xpath="//input[@id='BtnNewBR']")
	WebElement new_branch_btn;

	public void Branch_click()
	{
	branch_btn.click();
	new_branch_btn.click();
	}
}
