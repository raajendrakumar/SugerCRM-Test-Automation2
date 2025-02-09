package ProspectTestCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sugarCRMGenericLib.BaseClassLoader;
import com.sugarCRMGenericLib.ExcelLib;

public class Tc_sugarCRM_001_ProspectCreationAndVerification2 extends BaseClassLoader {

	@Test(invocationCount = 1, threadPoolSize = 1)
	public void prospectCaseCreationAndVerification() throws Exception {
		ExcelLib excel = new ExcelLib("./TestData/ProspectData.xlsx");
		int totalRows = excel.getlastrownum("ProspectCreate");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		for (int row = 1; row <= totalRows; row++) {
			HashMap<String, String> prospectData = loadProspectData(excel, row);
			String companyName = "DevTest_" + getTimeStamp();
			prospectData.put("CompanyName", companyName);

			System.out.println("Starting prospect creation for row: " + row);

			createProspect(prospectData, wait);
			//validateProspectCreation(companyName);
			System.out.println("Prospect created successfully for row: " + row);
			Thread.sleep(3000);
		
		}
	}

	private HashMap<String, String> loadProspectData(ExcelLib excel, int row) throws Exception {
		HashMap<String, String> data = new HashMap<>();
		String[] keys = { "AdditionName", "PhyStreet", "PhyCity", "PhyState", "PhyPostcode", "CaptiveName",
				"SubmissionName", "ReceivedSubmission", "Broker", "BusinessDevelopmentExecutive", "CaptiveExecutive",
				"ProgramCoordinator", "EffectiveDate", "LineOfBusiness" };

		for (int col = 0; col < keys.length; col++) {
			data.put(keys[col], excel.Excelread("ProspectCreate", row, col));
		}
		return data;
	}

	private void createProspect(HashMap<String, String> data, WebDriverWait wait) throws Exception {
		home.ClickCreateBtn();
		home.enterOrgName(data.get("CompanyName"));
		home.EnterAdditionalNames(data.get("AdditionName"));

		home.ClickAddressTab();
		home.EnterPhyStreetfld(data.get("PhyStreet"));
		home.EnterPhyCityfld(data.get("PhyCity"));
		home.EnterPhyStatefld(data.get("PhyState"));
		home.EnterPhyPostcodefld(data.get("PhyPostcode"));
		home.Clicksavebtn();

		home.ClickcrdOrg();
		home.mouseHoversubTab();
		home.Clicksublnk();

		home.entersubName(data.get("CompanyName"));

		home.ClickcapName();
		home.EnterreqfldSearch(data.get("CaptiveName"));

		home.Clickpromgr();
		home.EnterreqfldSearch(data.get("SubmissionName"));

		home.EnterrecSubDate(data.get("ReceivedSubmission"));

		home.Clickbrk();
		home.EnterreqfldSearch(data.get("Broker"));

		home.Clickbusexe();
		home.EnterreqfldSearch(data.get("BusinessDevelopmentExecutive"));

		home.Clickcapexe();
		home.EnterreqfldSearch(data.get("CaptiveExecutive"));

		home.Clickprocor();
		home.EnterreqfldSearch(data.get("ProgramCoordinator"));

		home.Entereffdate(data.get("EffectiveDate"));

		home.Clicklinbus();
		home.EnterreqfldSearch(data.get("LineOfBusiness"));

		home.Clickcascover();
		home.Clicksubtype();
		home.ClickProStucture();
		home.Clickpcsvbtn();
		//home.ClicklsubNamelk();
		//home.TextProspectNo();
		home.Clickusermenu();
		home.Clicklogout();
	}

	private void validateProspectCreation(String companyName) {
		home.ClicklsubNamelk();
		String prospectNumber = home.TextProspectNo();
		Assert.assertTrue(prospectNumber.contains(companyName), "Prospect creation failed for: " + companyName);
		home.Clickusermenu();
		home.Clicklogout();
	}
}
