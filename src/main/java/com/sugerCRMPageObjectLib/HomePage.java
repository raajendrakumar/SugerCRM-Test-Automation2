package com.sugerCRMPageObjectLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sugarCRMGenericLib.WebDriverCommonLib;

public class HomePage extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	// ----------------------UI Elements----------------------//
	// ---For WarningAlertClose---//
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Open']//span[contains(@class,'sicon sicon-hamburger')]")
	private WebElement expbtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/nav/div/div[2]/div[3]/div[1]/a/span[1]/span")
	private WebElement orglt;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Organizations menu']")
	private WebElement OrBtn;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Create Organization']")
	private WebElement crorgdrpdn;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Create')]")
	private WebElement CreateBtn;
	// ---For WarningAlertClose---//
	@FindBy(how = How.XPATH, using = "//button[@class='close btn btn-link btn-invisible']")
	private WebElement waralt;

	// ---For SearchFiled---//
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Organizations - More']/i[@class='fa fa-caret-down']")
	private WebElement orgdrdwn;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Create Organization')]")
	private WebElement crorg;

	// ---For SearchIcon---//
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Company Name')]/following::input[@name='name']")
	private WebElement companyName;

	@FindBy(how = How.XPATH, using = "//input[@name='additional_names_c']")
	private WebElement AdditionalNames;

	@FindBy(how = How.XPATH, using = "//span[text()='Address']")
	private WebElement AddressTab;

	@FindBy(how = How.XPATH, using = "//textarea[@name='billing_address_street']")
	private WebElement PhyStreetfld;

	// ---For RefreshBtn---//
	@FindBy(how = How.XPATH, using = "//input[@name='billing_address_city']")
	private WebElement PhyCityfld;

	// ---For NavBox---//
	@FindBy(how = How.XPATH, using = "//input[@name='billing_address_state']")
	private WebElement PhyStatefld;

	// ---For SignOut---//
	@FindBy(how = How.XPATH, using = "//input[@name='billing_address_postalcode']")
	private WebElement PhyPostcodefld;

	// --------For SearchBtn---------//
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary' and @name='save_button' and contains(text(), 'Save')]")
	private WebElement savebtn;

	// --------For UserName----------------//
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'View Organizations')]")
	private WebElement viworgdrpdn;

	// ------------For MenuCloseBtn----------//
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Submissions - More']//i[@class='fa fa-caret-down']")
	private WebElement subarw;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary'][contains(text(),'Create')]")
	private WebElement subCreate;
	@FindBy(how = How.XPATH, using = "//div[@class='rc-handle-container']/following-sibling::table/tbody/tr[' + rnum + ']/td[1]/span/div//following::a")
	private WebElement orgcreated;

	// ---For popupselectoption---//
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	private WebElement subName;

	// ---For popupselectoption---//
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "DevTest_")
	private WebElement crdOrg;
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Submissions menu']//i")
	private WebElement subMenu;
	@FindBy(how = How.XPATH, using = "//div[@class='table-cell full-width flex']/input[@class='search-name']")
	private WebElement orgSch;

	@FindBy(how = How.XPATH, using = "//div[@class='subpanel-header ui-sortable-handle']//div//span//following-sibling::h4[text()='Submissions']")
	private WebElement subTab;

	@FindBy(how = How.XPATH, using = "//div[@id='Accounts_sidebar-nav-item']//descendant::span/child::span[contains(text(),'Organizations')]")
	private WebElement orgbtn;

	@FindBy(how = How.XPATH, using = "//span[@class='text-sm'][normalize-space()='Submissions']")
	private WebElement subSidebarBtn;
	@FindBy(how = How.XPATH, using = "//div[@data-subpanel-link='opportunities']//i[@class='sicon sicon-plus']")
	private WebElement sublnk;

	@FindBy(how = How.XPATH, using = "//span[@class='collapsed h-full w-full']//span[@class='h-full w-15 label-module-color-sidebar cursor-pointer label label-module label-module-size-lg label-module-color-red'][normalize-space()='Su']")
	private WebElement subSideBtn;
	// ---For PopupOkbtn---//
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[5]/div/div/div[1]/div[1]/div/div[3]/div/div/div[1]/div[2]/div[1]/span/span/div")
	private WebElement prostr;

	// ---For PopupCancelbtn---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Captive']/following::span[2]")
	private WebElement capName;

	// ---For SelectAttribute---//
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//div[@class='select2-search']/descendant::input[@type='text']")
	private WebElement reqfldSearch;

	// ---For SearchTextBox---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Program Manager']/following::span[2]")
	private WebElement promgr;

	// ---For MainSearchBtn---//
	@FindBy(how = How.XPATH, using = "//input[@name='date_received_c']")
	private WebElement recSub;

	// ---For PopupClosebtn---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Submission Type']/following::span[2]")
	private WebElement subtyp;

	// ----------------Staff Details PopUp-----//
	// ---For PopupStaffName---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Broker']/following::span[2]")
	private WebElement brk;

	// ---For PopupStaffCode---//
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//div[@class='select2-result-label'][normalize-space()='Search and Select...']")
	private WebElement brkSearch;

	// ---For PopupStaffMobile---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Captive Executive']/following::span[2]")
	private WebElement capexe;
	// ---For PopupStaffMobile---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Business Development Executive']/following::span[2]")
	private WebElement busexe;

	// ---For PopupStaffMobile---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Program Coordinator']/following::span[2]")
	private WebElement procor;

	// ---For Openview---//
	@FindBy(how = How.XPATH, using = "//input[@name='effective_date_c']")
	private WebElement effdate;

	// ---For PopupStaffMobile---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Line Of Business']/following::span[2]")
	private WebElement linbus;

	// ---For divpresent---//
	@FindBy(how = How.XPATH, using = "//img[@name='CalendarImg-3709812c']")
	private WebElement prodate;

	// Product Search

	// ---For ProductsearchOkbtn---//
	@FindBy(how = How.XPATH, using = "//input[@name='$PpyWorkPage$pQuote$pQuartileRank']")
	private WebElement orgName;

	// ---For ProductsearchOkbtn---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Casualty Line Of Coverage']/following::span[2]")
	private WebElement cascover;

	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary' and @role='button' and @name='save_button']")
	private WebElement pcsvbtn;

	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary' and @role='button' and @name='save_button']")
	private WebElement psdate;

	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//span[@class='text-overflow'][text()='Pod Structure']/following::span[2]")
	private WebElement prostru;

	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//div[@class='ellipsis_inline relate-field-container']//a[contains(@href,'Opportunities')]")
	private WebElement subNamelk;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='System Details']")
	private WebElement systemdetail;
	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//span[@data-fieldname='pega_case_no_c']/child::span/child::div")
	private WebElement ProspectNo;
	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//button[@aria-label='User Menu']//i[@class='sicon sicon-chevron-down']")
	private WebElement usermenu;
	// ---For ProductsearchCancelbtn---//
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Log Out']")
	private WebElement logout;

	// ----------------------Basic Functions----------------------//

	public void enterCreatedOrgName(int rnum) {
		buttonClick(orgcreated);
	}

	public void ClickOrBtn() {
		buttonClick(OrBtn);
	}

	public void Clickcrorgdrpdn() {
		buttonClick(crorgdrpdn);
	}

	public void mouseHoverexpbtn() {
		mouseHover(expbtn);
	}

	public void mouseClickexpbtn() {
		buttonClick(expbtn);
	}

	public void ClickCreateBtn() {
		waitForElementToBePresent(CreateBtn);
		buttonClick(CreateBtn);
	}

	public void Clickwaralt() {
		buttonClick(waralt);
	}

	public void Clickorgdrdwn() {
		buttonClick(orgdrdwn);
	}

	public void Clickcrorg() {
		buttonClick(crorg);
	}

	// ---enter AdditionalNames---//
	String company = "DevTest_" + getTimeStamp();

	public void enterOrgName(String compNme) {
		waitForElementToBePresent(companyName);
		entervalue(compNme, companyName);
	}

	// ---get select AdditionalNames---//
	public String getEnterorgname() {
		return getvalue(companyName);
	}

	// --------For enter AdditionalNames-----------//
	public void EnterAdditionalNames(String adname) {
		waitForElementToBePresent(AdditionalNames);
		entervalue(adname, AdditionalNames);
	}

	// --------For get AdditionalNames-----------//
	public String getEnteredAdditionalNames() {
		return getvalue(AdditionalNames);
	}

	public void ClickAddressTab() {
		buttonClick(AddressTab);
	}

	// --------For enter PhyStreetfld-----------//
	public void EnterPhyStreetfld(String Pstreet) {
		waitForElementToBePresent(PhyStreetfld);
		entervalue(Pstreet, PhyStreetfld);
	}

	// --------For get PhyStreetfld-----------//
	public String getEnteredPhyStreetfld() {
		return getvalue(PhyStreetfld);
	}

	// --------For enter PhyCityfld-----------//
	public void EnterPhyCityfld(String Pcity) {
		waitForElementToBePresent(PhyCityfld);
		entervalue(Pcity, PhyCityfld);
	}

	// --------For get PhyCityfld-----------//
	public String getEnteredPhyCityfld() {
		return getvalue(PhyCityfld);
	}

	// --------For enter PhyStatefld-----------//
	public void EnterPhyStatefld(String Pstate) {
		entervalue(Pstate, PhyStatefld);
	}

	// --------For get PhyStatefld-----------//
	public String getEnteredPhyStatefld() {
		return getvalue(PhyStatefld);
	}

	// --------For enter PhyPostcodefld-----------//
	public void EnterPhyPostcodefld(String Ppost) {
		entervalue(Ppost, PhyPostcodefld);
	}

	// --------For get PhyPostcodefld-----------//
	public String getEnteredPhyPostcodefld() {
		return getvalue(PhyPostcodefld);
	}

	public void Clicksavebtn() {
		buttonClick(savebtn);
	}

	public void ClickcrdOrg() {
		// waitForElementToBePresent(crdOrg);
		buttonClick(crdOrg);
	}

	public void Clickorgbtn() {
		// waitForElementToBePresent(orgbtn);
		buttonClick(orgbtn);
	}

	public void ClicksubCreate() {
		buttonClick(subCreate);
	}

	public void ClicksubSideBtn() {
		buttonClick(subSideBtn);
	}

	public void mouseHoversubTab() {
		waitForElementToBePresent(subTab);
		mouseHover(subTab);
	}

	public void Clicksublnk() {
		waitForElementToBePresent(sublnk);
		buttonClick(sublnk);
	}

	public void ClickcapName() {
		waitForElementToBePresent(capName);
		buttonClick(capName);
	}

	public void ClicksubSidebarBtn() {
		buttonClick(subSidebarBtn);
	}

	public void mouseHoversubSidebarBtn() {
		mouseHover(subSidebarBtn);
	}

	public void ClicksubMenu() {
		buttonClick(subMenu);
	}

	public void Clickorgcreated() {
		buttonClick(orgcreated);
	}

	String submissionName = "DevTest_" + getTimeStamp();

	public void entersubName(String subNme) {
		waitForElementToBePresent(subName);
		entervalue(subNme, subName);
	}

	// ---get select AdditionalNames---//
	public String getEntersubName() {
		return getvalue(subName);
	}

	// --------For enter PhyCityfld-----------//
	public void EnterreqfldSearch(String Searchfld) throws InterruptedException {
		entervalue(Searchfld, reqfldSearch);
		Thread.sleep(3000);
		reqfldSearch.sendKeys(Keys.ENTER);

	}

	// --------For get PhyCityfld-----------//
	public String getEnteredreqfldSearch() {
		return getvalue(reqfldSearch);
	}

	public void Clickpromgr() {
		buttonClick(promgr);
	}

	// --------For enter PhyCityfld-----------//
	public void EnterrecSubDate(String recSubDate) {
		entervalue(recSubDate, recSub);
		recSub.sendKeys(Keys.ENTER);

	}

	// --------For get PhyCityfld-----------//
	public String getEnterrecSub() {
		return getvalue(recSub);
	}

	public void Entereffdate(String effDate) {
		entervalue(effDate, effdate);
		effdate.sendKeys(Keys.ENTER);

	}

	// --------For get PhyCityfld-----------//
	public String getEntereffdate() {
		return getvalue(effdate);
	}

	public void Clicksubtype() throws InterruptedException {
		buttonClick(subtyp);
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		Action memtypAction = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
		memtypAction.perform();
		Thread.sleep(3000);
	}

	public void ClickProStucture() throws InterruptedException {
		buttonClick(prostru);
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		Action prostrAction = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
		prostrAction.perform();
		Thread.sleep(3000);
	}

	public void Clickbrk() {
		buttonClick(brk);
	}

	public void Clickbusexe() {
		buttonClick(busexe);
	}

	public void Clickcapexe() {
		buttonClick(capexe);
	}

	public void Clickprocor() {
		buttonClick(procor);
	}

	public void Clicklinbus() {
		buttonClick(linbus);
	}

	public void Clickcascover() {
		buttonClick(cascover);
		Actions actions = new Actions(driver);
		Action cascoverAction = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
		cascoverAction.perform();

	}

	public void Entercascover(String casCover) {
		entervalue(casCover, cascover);
		cascover.sendKeys(Keys.ENTER);

	}

	// --------For get PhyCityfld-----------//
	public String getEntercascover() {
		return getvalue(cascover);
	}

	public void EnterorgSch(String orgSearch) {
		entervalue(orgSearch, orgSch);
		orgSch.sendKeys(Keys.ENTER);

	}

	// --------For get PhyCityfld-----------//
	public String getorgSearch() {
		return getvalue(orgSch);
	}

	public void Clickpcsvbtn() {
		buttonClick(pcsvbtn);
	}

	public void ClicklsubNamelk() {
		buttonClick(subNamelk);
	}

	public void Clicksystemdetail() {
		waitForElementToBePresent(systemdetail);
		buttonClick(systemdetail);
	}

	public void TextProspectNo() {
		getText(ProspectNo);
	}

	// ---For selectSBU---//
	public void selectlogout(String logout) {
		selectvalue(logout, usermenu);
	}

	public void Clickusermenu() {
		buttonClick(usermenu);
	}

	public void Clicklogout() {
		buttonClick(logout);
	}
}
