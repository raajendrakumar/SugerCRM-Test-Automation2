package com.sugerCRMPageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.sugarCRMGenericLib.Constants;
import com.sugarCRMGenericLib.WebDriverCommonLib;

public class SugarCRMLogin extends WebDriverCommonLib {
	WebDriver driver;
	WebDriverCommonLib wcl = new WebDriverCommonLib();

	// ----------------------Constructor----------------------//
	public SugarCRMLogin(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//

	// ---For User Name---//
	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	@CacheLookup
	private WebElement username1;

	// ---For Password---//
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	@CacheLookup
	private WebElement password1;

	// ---For Login Button---//
	@FindBy(how = How.XPATH, using = "//a[@name='login_button']")
	private WebElement slogin;

	// ----------------------Basic functions----------------------//

	// ---For EnterUserName---//
	public void enterUserName(String uname) {
		waitForElementToBePresent(username1);
		entervalue(uname, username1);

	}

	// ---For EnterPassword---//
	public void enterPassword(String pass) {
		waitForElementToBePresent(password1);
		entervalue(pass, password1);
	}

	// ---For ClickLoginBtn---//
	public void clickLoginBtn() {
		waitForElementToBePresent(slogin);
		buttonClick(slogin);

	}

	// Login Function
	public void slogin() {
		try {
			wcl.waitforpageload();
			logger.info("Login Started");
			entervalue(Constants.Username1, username1);
			entervalue(Constants.Password1, password1);
			buttonClick(slogin);
			logger.info("Logged in Successfully");
		} catch (Exception e) {
			ast.assertTrue(false, "Unable to Login");
			logger.error("Login Failed " + e.getMessage());
		}

	}

}
