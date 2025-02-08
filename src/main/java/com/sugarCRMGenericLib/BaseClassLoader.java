package com.sugarCRMGenericLib;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.sugerCRMPageObjectLib.HomePage;
import com.sugerCRMPageObjectLib.SugarCRMLogin;

public class BaseClassLoader extends WebDriverCommonLib {

	public SugarCRMLogin slgn;
	public HomePage home;
	public WebDriverCommonLib wcl;

	@BeforeClass
	public void LoadMethods() throws Exception {
		try {

			logger.info("Started Loading Methods");
			home = PageFactory.initElements(driver, HomePage.class);
			wcl = PageFactory.initElements(driver, WebDriverCommonLib.class);
			ast = new SoftAssert();
			logger.info("Completed Loading Methods");
			wcl.waitforpageload();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
