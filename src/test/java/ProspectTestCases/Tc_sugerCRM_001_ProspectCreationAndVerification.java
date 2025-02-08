package ProspectTestCases;

import java.util.HashMap;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.sugarCRMGenericLib.BaseClassLoader;
import com.sugarCRMGenericLib.ExcelLib;

@Listeners(com.sugarCRMGenericLib.SampleListner.class)
public class Tc_sugerCRM_001_ProspectCreationAndVerification extends BaseClassLoader {
	HashMap<String, String> Prospectdata = new HashMap<String, String>();

	@Test
	public void prospectCaseCreationAndVarification() throws Exception {

		ExcelLib prcase = new ExcelLib("./TestData/ProspectData.xlsx");
		int rows = prcase.getlastrownum("ProspectCreate");
		System.out.println(rows);

		home.ClickCreateBtn();
		Thread.sleep(4000);
		Prospectdata.put("CompanyName", "DevTest_" + getTimeStamp());
		home.enterOrgName(Prospectdata.get("CompanyName"));
		Thread.sleep(4000);
		for (int n = 1; n <= rows; n++) {
			Prospectdata.put("AdditionName", prcase.Excelread("ProspectCreate", n, 0));
			Prospectdata.put("PhyStreet", prcase.Excelread("ProspectCreate", n, 1));
			Prospectdata.put("PhyCity", prcase.Excelread("ProspectCreate", n, 2));
			Prospectdata.put("PhyState", prcase.Excelread("ProspectCreate", n, 3));
			Prospectdata.put("PhyPostcode", prcase.Excelread("ProspectCreate", n, 4));
			Thread.sleep(2000);
			System.out.println("Value sent to sendKeys: " + Prospectdata);
			home.EnterAdditionalNames(Prospectdata.get("AdditionName"));
			Thread.sleep(2000);
			home.ClickAddressTab();
			Thread.sleep(2000);
			home.EnterPhyStreetfld(Prospectdata.get("PhyStreet"));
			Thread.sleep(2000);
			home.EnterPhyCityfld(Prospectdata.get("PhyCity"));
			Thread.sleep(2000);
			home.EnterPhyStatefld(Prospectdata.get("PhyState"));
			Thread.sleep(2000);
			home.EnterPhyPostcodefld(Prospectdata.get("PhyPostcode"));
			Thread.sleep(2000);
			home.Clicksavebtn();
			Thread.sleep(4000);
			home.mouseHoverexpbtn();
			Thread.sleep(4000);
			home.ClicksubSidebarBtn();
			Thread.sleep(4000);
			home.ClicksubCreate();
			Thread.sleep(4000);

			Prospectdata.put("submissionName", "DevTest_" + getTimeStamp());
			home.entersubName(Prospectdata.get("submissionName"));
			Thread.sleep(2000);

			home.ClickcapName();
			Thread.sleep(2000);
			Prospectdata.put("CaptiveName", prcase.Excelread("ProspectCreate", n, 5));
			home.EnterreqfldSearch(Prospectdata.get("CaptiveName"));
			Thread.sleep(2000);
			home.Clickpromgr();
			Thread.sleep(2000);
			Prospectdata.put("SubmissionName", prcase.Excelread("ProspectCreate", n, 6));
			home.EnterreqfldSearch(Prospectdata.get("SubmissionName"));
			Thread.sleep(2000);

			Prospectdata.put("ReceivedSubmission", prcase.Excelread("ProspectCreate", n, 7));
			home.EnterrecSubDate(Prospectdata.get("ReceivedSubmission"));

			home.Clickbrk();
			Thread.sleep(2000);
			Prospectdata.put("Broker", prcase.Excelread("ProspectCreate", n, 8));
			home.EnterreqfldSearch(Prospectdata.get("Broker"));
			Thread.sleep(2000);

			home.Clickbusexe();
			Thread.sleep(2000);
			Prospectdata.put("BusinessDevelopmentExecutive", prcase.Excelread("ProspectCreate", n, 9));
			home.EnterreqfldSearch(Prospectdata.get("BusinessDevelopmentExecutive"));
			Thread.sleep(2000);

			home.Clickcapexe();
			Thread.sleep(2000);
			Prospectdata.put("CaptiveExecutive", prcase.Excelread("ProspectCreate", n, 10));
			home.EnterreqfldSearch(Prospectdata.get("CaptiveExecutive"));
			Thread.sleep(2000);

			home.Clickprocor();
			Thread.sleep(2000);
			Prospectdata.put("ProgramCoordinator", prcase.Excelread("ProspectCreate", n, 11));
			home.EnterreqfldSearch(Prospectdata.get("ProgramCoordinator"));
			Thread.sleep(2000);

			Prospectdata.put("EffectiveDate", prcase.Excelread("ProspectCreate", n, 12));
			home.Entereffdate(Prospectdata.get("EffectiveDate"));
			Thread.sleep(2000);

			home.Clicklinbus();
			Thread.sleep(3000);
			Prospectdata.put("LineOfBusiness", prcase.Excelread("ProspectCreate", n, 13));
			home.EnterreqfldSearch(Prospectdata.get("LineOfBusiness"));
			Thread.sleep(2000);

			home.Clickcascover();
			Thread.sleep(2000);

			home.Clicksubtype();
			Thread.sleep(2000);
			home.ClickProStucture();

			Thread.sleep(2000);
			home.Clickpcsvbtn();
		}

	}
}
