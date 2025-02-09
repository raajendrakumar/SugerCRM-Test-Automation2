package com.sugarCRMGenericLib;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class WebDriverCommonLib extends Browser {

	public static String data;
	protected static Select s;
	public static String parentWindow = null;
	public Alert alt;
	static Random random = new Random();
	public static String output;
	public static String value;
	// --- Wait Statements------------//

	// Wait Statement to wait still page to be loaded
	public void waitforpageload() {
		try {
			logger.info("Waiting for page to load");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			logger.info("page to load completed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Message: " + e.getMessage());
		}
	}

	// Wait Statement to wait still Element to be loaded
	public static void waitForElementToBePresent(WebElement element) {
		try {
			logger.info("Waiting for Element Present");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Completed Waiting for Element Present");
		} catch (Exception e) {
			ast.assertTrue(false, "Message: " + e.getMessage());
		}

	}

	// --------Highlight elements---------------------//

	public static void highLightElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid black;');", element);

			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Message: " + e.getMessage());
		}

	}

	// -----Alert Handling------------------------//
	// ---Accept alert-----//
	public void acceptAlert() {
		try {
			alt = driver.switchTo().alert();
			alt.accept();
			logger.info("Alert Accepted");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to accept Alert Message");
		}

	}

	// ---Alert Message-----//
	public String getAlertmsg() {
		try {
			alt = driver.switchTo().alert();
			alt.getText();
			logger.info("Alert Message " + alt.getText());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Retrive Alert Message");
		}
		return alt.getText();
	}

	// ---Dismiss alert-----//
	public void dismissAlert() {
		try {
			alt = driver.switchTo().alert();
			alt.dismiss();
			logger.info("Alert Dismissed");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to dismiss Alert Message");
		}
	}

	// ----------Capture Image----------------------//

	// ---Capture Full Screen image----//
	public static void Capture(ITestResult result, String filename) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./" + filename + "/" + result.getName() + ".png"));
			logger.info("Testcase failed and screenshot taken");
		} catch (Exception e) {
			ast.assertTrue(false, "Unable to Take Element ScreenShot");
			logger.error("Unable to Take ScreenShot " + e.getMessage());
		}

	}

	// ---Capture Element image----//
	public static void Captureelement(WebElement element) {
		Screenshot screenshot = new AShot().takeScreenshot(driver, element);
		try {
			ImageIO.write(screenshot.getImage(), "PNG",
					new File(System.getProperty("user.dir") + "\\ErrorScreenshots\\ElementScreenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Take Element ScreenShot");
			logger.error("Unable to Take ScreenShot " + e.getMessage());
		}
	}

	public static void selectByTxt(WebElement element, String text) {
		try {
			waitForElementToBePresent(element);
			s = new Select(element);
			s.selectByVisibleText(text);
			logger.info("Selected Dropdown by Text " + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + text);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}

	public static void selectDrpdwnByTxt(WebElement element, String text) {
		try {
			waitForElementToBePresent(element);
			Select sel = new Select(element);
			List<WebElement> dropdown = sel.getOptions();
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText().trim();
				if (drop_down_values.contains(text)) {
					sel.selectByVisibleText(text);
					logger.info("Selected Dropdown by Visible Text " + text);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + text);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}

	public void selectDrpdwnRamdomly(WebElement element) {
		try {
			int index = Integer.parseInt(AutoNumericvalue(1));
			waitForElementToBePresent(element);
			Select sel = new Select(element);
			List<WebElement> dropdown = sel.getOptions();

			if (index > 1) {
				sel.selectByIndex(dropdown.size() - 1);
			} else {
				sel.selectByIndex(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + value);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}

	public static void selectDrpdwnByIndex(WebElement element, int index) {
		try {
			waitForElementToBePresent(element);
			s = new Select(element);
			s.selectByIndex(index);
		} catch (Exception e) {
			ast.assertTrue(false, "Unable to Select Dropdown " + index);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}

	public void selectDrpdwnByValue(WebElement element, String value) {
		try {
			waitForElementToBePresent(element);
			Select sel = new Select(element);
			List<WebElement> dropdown = sel.getOptions();
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText().trim();
				if (drop_down_values.contains(value)) {
					sel.selectByVisibleText(value);
					break;
				} else {
					ast.assertTrue(false, value + " Not Found");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + value);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}

	public String getselectDrpdwnValue(WebElement element) {
		try {
			highLightElement(driver, element);
			Select sel = new Select(element);
			sel.getFirstSelectedOption();
			value = sel.getFirstSelectedOption().getText().trim();
		} catch (Exception e) {
			ast.assertTrue(false, "Unable to get Selected Dropdown Value " + value);
			logger.error("Unable to get Selected Dropdown Value " + e.getMessage());
		}
		return value;

	}

	public void switchToWindow(WebDriver driver) {
		parentWindow = driver.getWindowHandle();
		// System.out.println(parentWindow);
		Iterator<String> it = driver.getWindowHandles().iterator();
		while (it.hasNext()) {
			String popup = it.next().toString();
			// System.out.println(popup);
			if (!popup.contains("parentWindow")) {
				logger.info("switched to new window");
				driver.switchTo().window(popup);
				waitforpageload();
			} else {
				ast.assertTrue(false, "Unable to switch to new window");
				logger.error("Unable to switch to new window");
			}
		}
	}

	public void switchToMainWindow(WebDriver driver) {
		try {
			driver.close();
			driver.switchTo().window(parentWindow);

			logger.info("switched to Main window");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to switch to Parent window");
			logger.error("Unable to switch to Parent window " + e.getMessage());

		}
	}

	// For Entering Value
	public static void entervalue(String value, WebElement element) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			element.clear();
			element.sendKeys(value);
			logger.info("Entered value is " + value);
		} else {
			ast.assertTrue(false, "Unable to enter value on element ");
			logger.error("Unable to enter value on element ");
		}

	}

	// For Entering Value
	public static void enterNumvalue(String value, WebElement element, WebDriver driver) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			element.clear();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value=" + value + ";", element);
			logger.info("Entered value is " + value);
		} else {
			ast.assertTrue(false, "Unable to enter value on element ");
			logger.error("Unable to enter value on element ");
		}

	}

	// ---For Selecting value---//
	public static void selectvalue(String value, WebElement element) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			selectDrpdwnByTxt(element, value);
			logger.info("selected value is " + value);
		} else {
			ast.assertTrue(false, "Unable to select value of element ");
			logger.info("Unable to select value of element ");
		}
	}

	// ---For Selecting---//
	public static void selectvalue(int index, WebElement element) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			selectDrpdwnByIndex(element, index);
			logger.info("selected value is " + element.getText());
		} else {
			ast.assertTrue(false, "Unable to select value of element ");
			logger.info("Unable to select value of element ");
		}
	}

	// For CheckBox Select
	public static void checkboxselect(WebElement element) {
		try {
			if (!element.isSelected()) {
				highLightElement(driver, element);
				element.click();
				logger.info("Clicked on checkbox");
			} else {
				logger.info("Checkbox already selected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select CheckBox");
			logger.error("Unable to Select CheckBox " + e.getMessage());
		}

	}

	// For CheckBox DeSelect
	public static void checkboxdeselect(WebElement element) {
		try {
			if (element.isSelected()) {
				highLightElement(driver, element);
				element.click();
				logger.info("checkbox Deselected");
			} else {
				logger.info("Checkbox already Deselected");
			}
		} catch (Exception e) {
			ast.assertTrue(false, "Unable to Select CheckBox");
			logger.error("Unable to Select CheckBox " + e.getMessage());
		}

	}

	// ---checkboxIsselected---//
	public static boolean checkboxIsselected(WebElement element) {
		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean radiobtnIsselected(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isButtonEnabled(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	// For Button Click
	public static void buttonClick(WebElement element) {
		if (element.isEnabled()) {
			highLightElement(driver, element);
			element.click();
			logger.info("Clicked on" + element);
		} else {
			ast.assertTrue(false, "Unable to Click on element");
			logger.error("Unable to Click on element");
		}

	}

	// For Button Click
	public static void selectRadioButton(WebElement element) {
		try {
			if (!element.isSelected()) {
				element.click();
				logger.info("Radio Button selected");
			} else {
				logger.info("Radio Button already selected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Radio Button");
			logger.error("Unable to Select Radio Button " + e.getMessage());
		}

	}

	// For Get Value
	public static String getvalue(WebElement element) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			logger.info("Value of element is " + element.getAttribute("value"));
		} else {
			ast.assertTrue(false, "Unable to get value of element ");
			logger.error("Unable to get value of element ");
		}

		value = element.getAttribute("value").trim();
		return value;
	}

	// For Get Value
	public static int getintvalue(WebElement element) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			logger.info("Value of element is " + element.getAttribute("value"));
		} else {
			ast.assertTrue(false, "Unable to get integer type value of element ");
			logger.error("Unable to get value of element ");
		}

		value = element.getAttribute("value");
		int result = Integer.parseInt(value);
		return result;
	}

	// For Get Text
	public static String getText(WebElement element) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			logger.info("Value of element is " + element.getText().trim());

		} else {
			ast.assertTrue(false, "Unable to get value of element");
			logger.error("Unable to get value of element");
		}
		value = element.getText().trim();
		return value;
	}

	// For Get Text
	public static String getvisibleText(WebElement element) {
		if (IsElementPresent(element)) {
			highLightElement(driver, element);
			logger.info("Value of element is " + element.getText().trim());

		} else {
			ast.assertTrue(false, "Unable to get value of element");
			logger.error("Unable to get value of element");
		}
		value = element.getText().trim();
		return value;
	}

	public static boolean IsElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			ast.assertTrue(false, "Element not found" + e.getMessage());
			return false;
		}

	}

	public static String AutoalphaNumericvalue(int range) {
		if (range > 1) {
			StringBuilder sb1 = new StringBuilder();
			char[] chars = "OoredooOutReach1234567890".toCharArray();
			for (int i = 0; i < range; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb1.append(c);
			}
			output = sb1.toString();

		} else {
			ast.assertTrue(false, "Input Range should be >0");
		}
		return output;
	}

	public static String AutoNumericvalue(int range) {
		if (range > 0) {
			StringBuilder sb1 = new StringBuilder();
			char[] chars = "123456789".toCharArray();
			for (int i = 0; i < range; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb1.append(c);
			}
			output = sb1.toString();
		} else {
			ast.assertTrue(false, "Input Range should be >0");
		}
		return output;
	}

	public static String Autoalphavalue(int range) {
		if (range > 0) {
			StringBuilder sb1 = new StringBuilder();
			char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
			for (int i = 0; i < range; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb1.append(c);
			}
			output = sb1.toString();
		} else {
			ast.assertTrue(false, "Input Range should be >0");
		}
		return output;
	}

	public static String autoVehiclenum() {
		StringBuilder sb1 = new StringBuilder();
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < 2; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb1.append(c);
		}

		StringBuilder sb2 = new StringBuilder();
		char[] num = "1234567890".toCharArray();
		for (int i = 0; i < 2; i++) {
			char c = num[random.nextInt(num.length)];
			sb2.append(c);
		}
		StringBuilder sb3 = new StringBuilder();
		char[] chars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < 2; i++) {
			char c = chars1[random.nextInt(chars1.length)];
			sb3.append(c);
		}

		StringBuilder sb4 = new StringBuilder();
		char[] num1 = "1234567890".toCharArray();
		for (int i = 0; i < 4; i++) {
			char c = num1[random.nextInt(num1.length)];
			sb4.append(c);
		}
		output = sb1.toString() + "-" + sb2.toString() + "-" + sb3.toString() + "-" + sb4.toString();
		// System.out.println("WareHouse Name: "+output+"\n");
		return output;
	}

	public static String getTimeStamp() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyHHmm");
		return formatter.format(date);
	}

	// Date Selection
	public static String Today() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// Date Selection
	public static String monthyear() {
		Date date = new Date();
		SimpleDateFormat df2 = new SimpleDateFormat("MMM,yyyy");
		String dateText = df2.format(date);
		return dateText;
	}

	// Date Selection
	public static void selectDateFromCalender(String date) {
		String val[] = date.split("/");
		if (Integer.parseInt(val[0]) <= 9) {
			if (val[0].length() > 1) {
				char a[] = val[0].toCharArray();
				val[0] = String.valueOf(a[1]);
			}
		}

		List<WebElement> el = driver.findElements(By.xpath("//td[text()='" + val[0] + "']"));
		driver.findElement(By.xpath("(//td[text()='" + val[0] + "'])[" + el.size() + "]")).click();
	}

	// Time Selection
	public static String currenttme() {
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return timeFormat.format(date);
	}

	// Date Selection
	public String day() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// Date Selection
	public String month() {
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// Date Selection
	public String year() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// Date Selection
	public static String getModifieddate(int d, int m, int y) throws Exception {
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		@SuppressWarnings("unused")
		Date date = new Date();
		cal.add(Calendar.YEAR, y);
		cal.add(Calendar.MONTH, m);
		cal.add(Calendar.DATE, d);
		String var = dateFormat.format(cal.getTime());
		return var;

	}

	public static void sliderleft(WebElement slider) {
		int x = 10;
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(slider, ((width * x) / 100), 0).click();
		move.build().perform();
	}

	public static void sliderright(WebElement slider) {

		int x = 10;
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(slider, 0, ((width * x) / 100)).click();
		move.build().perform();
	}

	public void mouseHover(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			logger.info("Mouse Hover Element Moved...");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			actions.moveToElement(element).perform();
			logger.info("Completed Waiting for Element Present");
		} catch (Exception e) {
			ast.assertTrue(false, "Message: " + e.getMessage());
		}
	}

}
