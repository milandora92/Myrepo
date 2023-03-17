package driver_factory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common_functions.Admin_LoginPage;
import common_functions.Admin_logoutpage;
import common_functions.Branch_update_Page;
import common_functions.Branches_add;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{
	
	String Inputfile = "C:\\Users\\hp\\eclipse-workspace\\Hybrid_primusbank\\TestInput\\Data Engine.xlsx";
	String Outputfile = "C:\\Users\\hp\\eclipse-workspace\\Hybrid_primusbank\\TestOutput\\Results.xlsx";
	String TCSheet = "TestCases";
	String TSSheet = "TestSteps";
@Test
	public void driver_script() throws Throwable
	{
		boolean res = false;
		String tctext = "";
		String tstext = "";
		ExcelFileUtil xl = new ExcelFileUtil(Inputfile);
		int TCrows = xl.nrow(TCSheet);
		int TSrows = xl.nrow(TSSheet);
		Reporter.log("No of rows in TestCases sheet are:"+TCrows+"  "+"No of rows in TestSteps sheet are:"+TSrows);
		for (int i = 1; i <= TCrows; i++) {
			if (xl.getcellData(TCSheet, i, 2).equalsIgnoreCase("Y")) {
				String TCID_cases = xl.getcellData(TCSheet, i, 0);
				for (int j = 1; j <= TSrows; j++) {
					String TCID_steps = xl.getcellData(TSSheet, j, 0);
					if (TCID_cases.equalsIgnoreCase(TCID_steps)) {
						String keyword = xl.getcellData(TSSheet, j, 3);
						if (keyword.equalsIgnoreCase("AdminLogin")) {
							Admin_LoginPage login = PageFactory.initElements(driver, Admin_LoginPage.class);
							String para1 = xl.getcellData(TSSheet, j, 5);
							String para2 = xl.getcellData(TSSheet, j, 6);
							res = login.AdminLogin(para1, para2);
							}
						else if (keyword.equalsIgnoreCase("AddBranch")) {
							Branches_add addbranch = PageFactory.initElements(driver, Branches_add.class);
							String para1 = xl.getcellData(TSSheet, j, 5);
							String para2 = xl.getcellData(TSSheet, j, 6);
							String para3 = xl.getcellData(TSSheet, j, 7);
							String para4 = xl.getcellData(TSSheet, j, 8);
							String para5 = xl.getcellData(TSSheet, j, 9);
							String para6 = xl.getcellData(TSSheet, j, 10);
							String para7 = xl.getcellData(TSSheet, j, 11);
							String para8 = xl.getcellData(TSSheet, j, 12);
							String para9 = xl.getcellData(TSSheet, j, 13);
							System.out.println(para1+para2+para3+para4+para5+para6+para7+para8+para9);
							res = addbranch.AddBranch(para1, para2, para3, para4, para5, para6, para7, para8, para9);
						}
						else if (keyword.equalsIgnoreCase("Branch_update_Page")) {
							Branch_update_Page branch_update = PageFactory.initElements(driver, Branch_update_Page.class);
							String para1 = xl.getcellData(TSSheet, j, 5);
							String para2 = xl.getcellData(TSSheet, j, 6);
							String para3 = xl.getcellData(TSSheet, j, 7);
							String para4 = xl.getcellData(TSSheet, j, 8);
							String para5 = xl.getcellData(TSSheet, j, 9);
							String para6 = xl.getcellData(TSSheet, j, 10);
							String para7 = xl.getcellData(TSSheet, j, 11);
							String para8 = xl.getcellData(TSSheet, j, 12);
							String para9 = xl.getcellData(TSSheet, j, 13);
							res = branch_update.verify_branch_updates(para1, para2, para3, para4, para5, para6, para7, para8, para9);
						}
						else if (keyword.equalsIgnoreCase("AdminLogout")) {
							Admin_logoutpage logout = PageFactory.initElements(driver, Admin_logoutpage.class);
							res = logout.AdminLogout();
							
						}
						if (res) {
							tstext = "Pass";
							xl.setcellData(TSSheet, j, 4, "Pass", Outputfile);
						}
						else {
							tstext = "Fail";
							xl.setcellData(TSSheet, j, 4, "Fail", Outputfile);
						}
						tctext = tstext;
					}
				}
			xl.setcellData(TCSheet, i, 3, tstext, Outputfile);
			}
			else {
				xl.setcellData(TCSheet, i, 3, "Blocked", Outputfile);
				Reporter.log("No test cases to execute");
			}
		}
		
	}

}
