package automate.quickstart;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

//package automate.quickstart;
//
public class Login extends AppiumEXtendedMethods {
	public void setup() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		// caps.setCapability("deviceName", "Sheetal");
		caps.setCapability("deviceName", "realme RMX3081");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.stocky_dodo.app");
		caps.setCapability("appActivity", "com.stocky_dodo.app.MainActivity");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("noReset", true);
		caps.setCapability("appium:appWaitForLaunch", false);
		caps.setCapability("adbExecTimeout", 60000);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//	@Test(priority = 1)
//	public void LoginComponent() throws InterruptedException, MalformedURLException {
//		setup();
//		WebElement cancel = driver.findElement(By.xpath(
//				"//android.widget.LinearLayout[@content-desc='Choose an Account']/android.widget.LinearLayout/android.widget.Button"));
//		cancel.click();
//		Thread.sleep(5000);
//		List<WebElement> log = driver.findElementsByXPath("//android.view.View[@content-desc='Login / Register']");
//
//		Thread.sleep(5000);
//		// Image
//		// List<WebElement> addCashComp =
//		// driver.findElements((By.className("android.widget.ImageView")));
//
//
//		log.add(driver.findElementByXPath("//android.view.View[@content-desc=\"Enter your mobile number\"]"));
//
//		log.add(driver.findElement(MobileBy.className("android.widget.EditText")));
//		log.add(driver.findElement(MobileBy.AccessibilityId("We will send a 4 digit code to your mobile number")));
//
//		log.add(driver.findElement(MobileBy.AccessibilityId("Send OTP")));
//		assertEquals(log.size(), 5);
//	}

	@Test(priority = 1)
	public void MobileFieldIsEnabled() throws MalformedURLException {
		setup();
		WebElement cancel = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[@content-desc='Choose an Account']/android.widget.LinearLayout/android.widget.Button"));
	cancel.click();
		
		assertTrue(driver.findElement(MobileBy.className("android.widget.EditText")).isEnabled());

	}

	@Test(priority = 2)
	public void LoginLessThanTen() throws IOException, CsvException

	{
//		WebElement cancel = driver.findElement(By.xpath(
//				"//android.widget.LinearLayout[@content-desc='Choose an Account']/android.widget.LinearLayout/android.widget.Button"));
//		cancel.click();
		// blockNotifcation();
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AdityaRaj\\Downloads\\automation_data.csv"));

		// Read the first row from the CSV file and get the data from the second column
		// skip the next row (the first row of data)
		List<String[]> rows = reader.readAll();

		// Get the data from the desired row and column
		int rowNum = 1; // The row number you want to read
		int colNum = 0; // The column number you want to read
		String data = rows.get(rowNum)[colNum];

		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement cancel = driver.findElement(By.xpath(
//				"//android.widget.LinearLayout[@content-desc='Choose an Account']/android.widget.LinearLayout/android.widget.Button"));
//		cancel.click();
		WebElement myTextField = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText"));

		myTextField.sendKeys(data);

		// ait.until(ExpectedConditions.invisibilityOf(driver.findElement(MobileBy.AccessibilityId("Login
		// / Register"))));
		// WebElement out= driver.findElement(MobileBy.AccessibilityId("Login /

		// Register"));
		driver.navigate().back();

		WebElement sOTP = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
		sOTP.click();
		WebElement sendOTP = null;
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		try {
			sendOTP = driver.findElement(MobileBy.AccessibilityId("Change number"));
			// Reporter.log("Element found: " + elementFound);
			if (sendOTP != null) {
				Reporter.log("Next Button is enabled ");
				Assert.assertNull(sendOTP);

			}
		} catch (Exception e) {
			Reporter.log("Send OTP button is not enabled as the number is less than 10 digit");
		}
		if (toasterMessage.equals("Oops! Please enter a valid 10 digit mobile number")) {
			Reporter.log("\nToaster message :- " + toasterMessage);

		}
//			String	 button_color = sOTP.getCssValue("background-color");
//			 Reporter.log(button_color);

	}

	@Test(priority = 3)
	public void LoginNegativeTestCaseZeroInput() throws IOException, CsvException, InterruptedException

	{
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AdityaRaj\\Downloads\\automation_data.csv"));

		// Read the first row from the CSV file and get the data from the second column
		// skip the next row (the first row of data)
		List<String[]> rows = reader.readAll();

		// Get the data from the desired row and column
		int rowNum = 2; // The row number you want to read
		int colNum = 0; // The column number you want to read
		String data = rows.get(rowNum)[colNum];
		// WebElement out= driver.findElement(MobileBy.AccessibilityId("Login /
		// Register"));
		// driver.navigate().back();;
		WebElement TextField = driver.findElement(MobileBy.className("android.widget.EditText"));
		TextField.click();
		TextField.clear();
		TextField.sendKeys(data);
		driver.navigate().back();
		;
		String getText = TextField.getText();
		String expectedInput = "0";
		Assert.assertEquals(getText, expectedInput, "Number input is not truncated correctly");
		// //WebElement out= driver.findElement(MobileBy.AccessibilityId("Login /
		// Register"));
		WebElement sendOTP = null;

		sendOTP = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
		sendOTP.click();
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		try {
			sendOTP = driver.findElement(MobileBy.AccessibilityId("Change number"));
			// Reporter.log("Element found: " + elementFound);
			if (sendOTP != null) {
				Reporter.log("Next Button is enabled ");
				Assert.assertNull(sendOTP);

			}
		} catch (Exception e) {
			Reporter.log("\nSend OTP button is not enabled as the number is not valid");
		}
		if (toasterMessage.equals("Oops! Please enter a valid 10 digit mobile number")) {
			Reporter.log("\nToaster message :- " + toasterMessage);

		}
		// driver.navigate().back();;
		TextField.click();
		TextField.clear();

		// Get the data from the desired row and column
		rowNum = 3; // The row number you want to read
		colNum = 0; // The column number you want to read
		data = rows.get(rowNum)[colNum];
		// String input="007903825832";
		TextField.sendKeys(data);
		Thread.sleep(1000);
		// driver.navigate().back();;
		String getText2 = TextField.getText();
		expectedInput = "7903825832";
		Assert.assertEquals(getText2, expectedInput, "Number input is not truncated correctly");

	}

	@Test(priority = 4)
	public void LoginTermandConditionNegativeTestCase() throws IOException, CsvException, InterruptedException {

		Thread.sleep(5000);

		WebElement TextField = driver.findElement(MobileBy.className("android.widget.EditText"));
		TextField.click();
		TextField.clear();
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AdityaRaj\\Downloads\\automation_data.csv"));

		// Read the first row from the CSV file and get the data from the second column
		// skip the next row (the first row of data)
		List<String[]> rows = reader.readAll();

		// Get the data from the desired row and column
		int rowNum = 4; // The row number you want to read
		int colNum = 0; // The column number you want to read
		String data = rows.get(rowNum)[colNum];
		TextField.sendKeys(data);

		WebDriverWait waits = new WebDriverWait(driver, 20);

		waits = new WebDriverWait(driver, 20);

		WebElement changeNumber = null;
		WebElement sendOTP = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));

		sendOTP.click();

		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		try {
			changeNumber = driver.findElement(MobileBy.AccessibilityId("Change number"));
			// Reporter.log("Element found: " + elementFound);
			if (changeNumber != null) {
				Reporter.log("Next Button is enabled ");
				Assert.assertNull(changeNumber);

			}
		} catch (Exception e) {
			Reporter.log("\nSend OTP button is not enabled as User has not accept term and conditions");
		}
		if (toasterMessage.equals("Please accept Terms & Conditions")) {
			Reporter.log("\nToaster message :- " + toasterMessage);

		}

	}

	@Test(priority = 5)
	public void LoginPositveTestCase() throws IOException, CsvException, InterruptedException {

		WebElement TextField = driver.findElement(MobileBy.className("android.widget.EditText"));
		TextField.click();
		TextField.clear();
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AdityaRaj\\Downloads\\automation_data.csv"));

		// Read the first row from the CSV file and get the data from the second column
		// skip the next row (the first row of data)
		List<String[]> rows = reader.readAll();

		// Get the data from the desired row and column
		int rowNum = 5; // The row number you want to read
		int colNum = 0; // The column number you want to read
		String data = rows.get(rowNum)[colNum];
		TextField.sendKeys(data);

		WebDriverWait waits = new WebDriverWait(driver, 20);
		WebElement TermNdConditions = driver.findElement(MobileBy.AccessibilityId("Terms & Conditions"));
		TermNdConditions.click();
		// WebElement elementB =
		// driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.ListView/android.widget.ListView/android.view.View[2]/android.widget.TextView"));

		// Create a loop to scroll until the element is visible

		// Create a new UiScrollable object

		WebElement scrollable = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(25).scrollIntoView("
						+ "new UiSelector().textContains(\"Acceptance of\"))"));
		// Wait for a short time to allow the screen to update
		Thread.sleep(500);

		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		WebElement sOTP = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
		Color color = getColor(sOTP);
		// Get the background color of the button when it is enabled
//		String enabledColor = sOTP.getCssValue("background-color");
		// WebElement myCheckboxes =
		// driver.findElement(MobileBy.className("android.widget.CheckBoxssv"));
		WebElement myCheckbox = driver.findElement(MobileBy.className("android.widget.CheckBox"));
		myCheckbox.click();
		System.out.println(isDisabled(color));
		waits = new WebDriverWait(driver, 20);
		getColor(sOTP);

		sOTP.click();

		WebElement ChangeNumber = driver.findElement(MobileBy.AccessibilityId("Change number"));
		ChangeNumber.click();
		Thread.sleep(5000);
		rowNum = 4; // The row number you want to read
		colNum = 0; // The column number you want to read
		data = rows.get(rowNum)[colNum];
		TextField.click();
		TextField.clear();
		TextField.sendKeys(data);
//		 driver.navigate().back();
		WebElement sOTPs = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
		sOTPs.click();
		// Switch to Message app

	}

}