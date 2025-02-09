package ProspectTestCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sugarCRMGenericLib.BaseClassLoader;
import com.sugarCRMGenericLib.ExcelLib;

@Listeners(com.sugarCRMGenericLib.SampleListner.class)
public class Tc_sugerCRM_001_ProspectCreationAndVerification extends BaseClassLoader {

	@Test(invocationCount = 2)
	public void prospectCaseCreationAndVarification() throws Exception {

		ExcelLib prcase = new ExcelLib("./TestData/ProspectData.xlsx");
		int rows = prcase.getlastrownum("ProspectCreate");
		System.out.println("Number of rows in Excel: " + rows);
		String companyName = "DevTest_" + getTimeStamp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int n = 1; n <= rows; n++) {
			HashMap<String, String> Prospectdata = new HashMap<String, String>();

			System.out.println("Starting iteration for row: " + n);

			home.ClickCreateBtn();

			Prospectdata.put("CompanyName", companyName);
			home.enterOrgName(companyName);

			Prospectdata.put("AdditionName", prcase.Excelread("ProspectCreate", n, 0));
			Prospectdata.put("PhyStreet", prcase.Excelread("ProspectCreate", n, 1));
			Prospectdata.put("PhyCity", prcase.Excelread("ProspectCreate", n, 2));
			Prospectdata.put("PhyState", prcase.Excelread("ProspectCreate", n, 3));
			Prospectdata.put("PhyPostcode", prcase.Excelread("ProspectCreate", n, 4));
			Prospectdata.put("CaptiveName", prcase.Excelread("ProspectCreate", n, 5));
			Prospectdata.put("SubmissionName", prcase.Excelread("ProspectCreate", n, 6));
			Prospectdata.put("ReceivedSubmission", prcase.Excelread("ProspectCreate", n, 7));
			Prospectdata.put("Broker", prcase.Excelread("ProspectCreate", n, 8));
			Prospectdata.put("BusinessDevelopmentExecutive", prcase.Excelread("ProspectCreate", n, 9));
			Prospectdata.put("CaptiveExecutive", prcase.Excelread("ProspectCreate", n, 10));
			Prospectdata.put("ProgramCoordinator", prcase.Excelread("ProspectCreate", n, 11));
			Prospectdata.put("EffectiveDate", prcase.Excelread("ProspectCreate", n, 12));
			Prospectdata.put("LineOfBusiness", prcase.Excelread("ProspectCreate", n, 13));

			System.out.println("Values for row " + n + ": " + Prospectdata);

			home.EnterAdditionalNames(Prospectdata.get("AdditionName"));
			home.ClickAddressTab();
			home.EnterPhyStreetfld(Prospectdata.get("PhyStreet"));
			home.EnterPhyCityfld(Prospectdata.get("PhyCity"));
			home.EnterPhyStatefld(Prospectdata.get("PhyState"));
			home.EnterPhyPostcodefld(Prospectdata.get("PhyPostcode"));
			home.Clicksavebtn();

			home.ClickcrdOrg();
			home.mouseHoversubTab();
			home.Clicksublnk();

			Thread.sleep(2000);
			home.entersubName(companyName);

			home.ClickcapName();
			home.EnterreqfldSearch(Prospectdata.get("CaptiveName"));

			// This seems like a duplicate
			// key. Consider renaming.
			home.Clickpromgr();
			home.EnterreqfldSearch(Prospectdata.get("SubmissionName"));

			home.EnterrecSubDate(Prospectdata.get("ReceivedSubmission"));

			home.Clickbrk();
			home.EnterreqfldSearch(Prospectdata.get("Broker"));

			home.Clickbusexe();
			home.EnterreqfldSearch(Prospectdata.get("BusinessDevelopmentExecutive"));

			home.Clickcapexe();
			home.EnterreqfldSearch(Prospectdata.get("CaptiveExecutive"));

			home.Clickprocor();
			home.EnterreqfldSearch(Prospectdata.get("ProgramCoordinator"));

			home.Entereffdate(Prospectdata.get("EffectiveDate"));

			home.Clicklinbus();
			home.EnterreqfldSearch(Prospectdata.get("LineOfBusiness"));

			home.Clickcascover();
			home.Clicksubtype();
			home.ClickProStucture();
			home.Clickpcsvbtn();
			home.ClicklsubNamelk();
			home.TextProspectNo();
			Thread.sleep(3000);
			System.out.println("Finished iteration for row: " + n);

		}

	}

}