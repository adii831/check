package automate.quickstart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Registration extends AppiumEXtendedMethods {
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

	@Test
	public void splashScreen() {

	}

	@Test
	public void sendOTPisDisable() throws IOException {
		WebElement sOTP = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
		assertTrue("send otp is not disabled", isDisabled(getColor(sOTP)));

	}

@Test(priority = 1)

	public void registrationLessThanTen() throws IOException, CsvException {
		
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
		WebElement cancel = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[@content-desc='Choose an Account']/android.widget.LinearLayout/android.widget.Button"));
		cancel.click();
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

	@Test(priority = 2)
	public void registrationNegativeTestCaseZeroInput() throws IOException, CsvException, InterruptedException {
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

	public void RegistrationPositveTestCase()
			throws IOException, CsvException, InterruptedException, NoSuchElementException

	{

		try {
			blockNotifcation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebElement out= driver.findElement(MobileBy.AccessibilityId("Login /
		// Register"));
		// driver.navigate().back();;
		// WebDriverWait wait = new WebDriverWait(driver, 5);

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

		// Find all the locators present on the screen using a locator strategy that is
		// appropriate for your application
//
//		// Find the first visible paragraph element and retrieve its text content
//		WebElement currentParagraph = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]"));
//		 // Define the maximum number of times you want to scroll down
//        int max_scrolls = 10;
//        int scroll_count = 0;
//
//        // Define a list to store the text of all locators
//        List<String> locator_text = new ArrayList<>();
//
//        while (scroll_count < max_scrolls) {
//            // Get all locators that are currently visible on the screen
//            List<WebElement> locators = driver.findElements(MobileBy.xpath("//*[not(self::script)][text()]"));
//
//            // Get the text of each locator and add it to the list
//            for (WebElement locator : locators) {
//                locator_text.add(locator.getText());
//            }
//
//            // Scroll down to the bottom of the page
//            (WebElement)driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\".*\").instance(0));");
//
//            // Wait for the page to load
//            Thread.sleep(2000);
//
//            // Increase the scroll count
//            scroll_count++;
//        }
//
//        // Print the text of all locators
//        for (String text : locator_text) {
//            System.out.println(text);
//        }
//
//        // Close the app
//      
//    
//
//
//
//        // Quit the driver

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

		// Disable the button (assuming this changes the background color)
		// ...

		// Get the background color of the button when it is disabled
//				String disabledColor = sOTP.getCssValue("background-color");
//
//				// Compare the two colors to validate the button's status
//				if (!enabledColor.equals(disabledColor)) {
//				    System.out.println("button is enabled");
//				} else {
//					   System.out.println("button is enabled");
//				    // The button's background color does not change when it is enabled or disabled,
//				    // so you may need to use a different validation method.
//				}

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
	// [r=210,g=255,b=64] bright shade of green with a yellowish tint.

	@Test(priority = 3)

	public void RegistrationTermandConditionNegativeTestCase() throws IOException, CsvException, InterruptedException

	{

		// WebElement out= driver.findElement(MobileBy.AccessibilityId("Login /
		// Register"));
//		     driver.navigate().back();;
//		    WebDriverWait wait = new WebDriverWait(driver, 5);
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
	public void registrationTellUsNegativeTestCase() throws InterruptedException, IOException, CsvException { // Find
																												// all
																												// elements
																												// with
		Thread.sleep(5000); // ID
		// "notification_stack_scroller"

		WebElement Name = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"));
		Name.click();

		// Create a CSVReader object and specify the path to your CSV file
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AdityaRaj\\Downloads\\automation_data.csv"));

		// Read the first row from the CSV file and get the data from the second column
		// skip the next row (the first row of data)
		List<String[]> rows = reader.readAll();

		// Get the data from the desired row and column
		int rowNum = 1; // The row number you want to read
		int colNum = 1; // The column number you want to read
//		  for (int i = 0; i < rows.size(); i++) {
//			    String[] row = rows.get(i);
//			    System.out.print("Row " + i + ": ");
//			    for (String cell : row) {
//			        System.out.print(cell + ", ");
//			    }
//			    System.out.println(); // Print a new line after each row
//			}

		String data = rows.get(rowNum)[colNum];
		Name.sendKeys(data);
		String errorData = data;

		WebElement Gender = driver.findElement(MobileBy.xpath(" //android.view.View[@content-desc='Male']"));
		Gender.click();
		WebElement emailField = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"));
		emailField.click();
		rowNum = 1; // The row number you want to read
		colNum = 2;

		String email = rows.get(rowNum)[colNum];

		emailField.sendKeys(email);
		driver.navigate().back();

		WebElement emailwarning = driver.findElement(MobileBy.AccessibilityId("Enter valid email"));

		if (emailwarning.isDisplayed())

		{
			emailField.clear();
			rowNum = 2; // The row number you want to read
			colNum = 2;

			data = rows.get(rowNum)[colNum];

			emailField.click();

			emailField.sendKeys(data);
		}
		driver.navigate().back();
		WebElement emailwarningforempty = driver.findElement(MobileBy.AccessibilityId("Email cannot be empty"));

		if (emailwarningforempty.isDisplayed()) {
			emailField.clear();
			rowNum = 3; // The row number you want to read
			colNum = 2;

			data = rows.get(rowNum)[colNum];
			emailField.click();

			emailField.sendKeys(data);
		}
		WebElement TellUs = driver
				.findElement(MobileBy.xpath("//android.view.View[@content-desc='Tell us about yourself']"));
		TellUs.click();
		// WebElement nextButton=
		// driver.findElement(MobileBy.AccessibilityId("Next"));

		TellUs.click();
		WebElement nextButton = driver.findElement(MobileBy.AccessibilityId("Next"));
		WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(nextButton)); // Wait for the element to be visible on the page

		Thread.sleep(5000);

		nextButton.click();
		WebElement elementFound = null;

		try {
			elementFound = driver.findElement(MobileBy.AccessibilityId("Select your Dodo avatar"));
			// Reporter.log("Element found: " + elementFound);
			// driver.navigate().back();
			if (elementFound != null) {

				Reporter.log(errorData);
				Assert.assertNull(elementFound);

			}
		} catch (Exception e) {
			// Reporter.log("Element not found!");
		} finally {
			driver.navigate().back();
			Thread.sleep(2000);

		}

	}

	@Test(priority = 6)
	public void ReferralNegative() {
		WebElement referral = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout"
				+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
				+ "android.widget.FrameLayout/android.view.View/android.view.View/android.view.View"
				+ "/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/"
				+ "android.widget.EditText[3]"));
		// String toasterMessage=null;
		referral.click();
		referral.clear();
		// Blank value
		referral.sendKeys(" ");
		driver.findElement(MobileBy.AccessibilityId("Apply")).click();
		// toasterMessage =
		// driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//	
		try {
			WebElement applied = null;
			applied = driver.findElement(MobileBy.AccessibilityId("Applied"));
			if (applied.isDisplayed()) {
				Assert.assertNull(applied);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		referral.click();

		// invalid but 6 digit
		referral.sendKeys("123");
		driver.findElement(MobileBy.AccessibilityId("Apply")).click();
		try {
			WebElement applied = null;
			applied = driver.findElement(MobileBy.AccessibilityId("Applied"));
			if (applied.isDisplayed()) {
				Assert.assertNull(applied);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void Referralpositivecase() {
		WebElement referral = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout"
				+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
				+ "android.widget.FrameLayout/android.view.View/android.view.View/android.view.View"
				+ "/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/"
				+ "android.widget.EditText[3]"));
		referral.click();
		referral.clear();
		referral.sendKeys("SHE100");
		driver.findElement(MobileBy.AccessibilityId("Apply")).click();
		try {
			WebElement applied = null;
			applied = driver.findElement(MobileBy.AccessibilityId("Applied"));
			if (applied.isDisplayed()) {
				Assert.assertNotNull(applied);
				System.out.println(referral.isEnabled());
				assertFalse(referral.isEnabled());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//	if(toasterMessage!=null)
//	{
//		Reporter.log(toasterMessage+"\n");
//		
//
//	}

	}

	@Test(priority = 8)
	public void RegistrationProfileName_NegativeTestCase() throws InterruptedException, IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AdityaRaj\\Downloads\\automation_data.csv"));

		// Read the first row from the CSV file and get the data from the second column
		// skip the next row (the first row of data)
		List<String[]> rows = reader.readAll();

		Thread.sleep(5000);
		WebElement nextButton = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Next']"));
		nextButton.click();
		// WebElement outside=
		// driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='* Your
		// Profile Name Required']"));
		// driver.navigate().back();;
//		     WebElement profileName = driver.findElement(By.className("android.widget.EditText"));
//		        profileName.click();
//		     
//		        profileName.sendKeys("Aditya");

//		        WebElement warningMessage= driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='That profile name is taken, Try another.']"));
//			    
//			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			 
//			   try { 
//				   WebElement warningMessage1= driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='That profile name is taken, Try another.']"));
//				    
//   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		        	int x_coord = 542;
//		            int y_coord = 1418;
//		            if (warningMessage1.isDisplayed())
//		            {
//
//		            TouchAction touchAction = new TouchAction(driver);
//		            touchAction.tap(PointOption.point(x_coord, y_coord)).perform();
//
//	   }}
//		        catch (StaleElementReferenceException e) {
//		            
//		        }
		int rowNum = 4; // The row number you want to read
		int colNum = 3; // The column number you want to read
		String data = rows.get(rowNum)[colNum];

		Thread.sleep(5000);
		// WebElement elementFound = driver.findElement(MobileBy.AccessibilityId("Select
		// your Dodo avatar"));
		Thread.sleep(5000);
//		//WebElement avatar = driver.findElement(MobileBy.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View/android.view.View[8]/android.view.View/android.widget.ImageView[2]"));

//		TouchAction touchAction = new TouchAction(driver);
//
//		int endX = avatar.getLocation().getX() + (avatar.getSize().getWidth() / 2);
//		int endY = avatar.getLocation().getY() + (avatar.getSize().getHeight() / 2);
//
//		int startX = elementFound.getLocation().getX() + (elementFound.getSize().getWidth() / 2);
//		int startY = elementFound.getLocation().getY() + (elementFound.getSize().getHeight() / 2);
//
//		touchAction.press(ElementOption.element(avatar, startX, startY))
//				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
//				.moveTo(ElementOption.element(elementFound, endX, endY)).release().perform();
//
		Thread.sleep(5000);
		WebElement avatar1 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.ImageView"));

		WebElement profileName = driver.findElement(By.className("android.widget.EditText"));

//		WebElement element = driver.findElement(By.id("myElementId"));
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
//		        + "new UiSelector().resourceId(\"" + element.getId() + "\"))"));

		profileName.click();
		profileName.sendKeys(data);
		driver.navigate().back();
		Thread.sleep(2000);

		WebElement nextScreen = driver.findElement(By.className("android.widget.Button"));
		// driver.navigate().back();;
		nextScreen.click();
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		// toaster message
		// Reporter.log(toasterMessage);
// avatar.click();
		profileName.click();
		profileName.clear();
		driver.navigate().back();
		avatar1.click();
		Thread.sleep(2000);
		WebElement NextScreen = driver.findElement(MobileBy.AccessibilityId("Next"));
		NextScreen.click();
		toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		// toaster message
		// Reporter.log(toasterMessage);
		// WebElement profileName =
		// driver.findElement(By.className("android.widget.EditText"));

		profileName.click();

		// Get the data from the desired row and column
		rowNum = 1; // The row number you want to read
		colNum = 3; // The column number you want to read
		data = rows.get(rowNum)[colNum];

		profileName.sendKeys(data);
		driver.navigate().back();
		WebElement warningMessage = null;

		warningMessage = driver
				.findElement(MobileBy.xpath("//android.view.View[@content-desc='Please enter Profile Name']"));

		if (warningMessage == null) {
			Reporter.log(warningMessage.getText());
			Assert.assertNotNull(warningMessage);
		}
		rowNum = 2; // The row number you want to read
		colNum = 3; // The column number you want to read
		data = rows.get(rowNum)[colNum];
		profileName.click();
		profileName.clear();
		profileName.sendKeys(data);
		driver.navigate().back();
		warningMessage = null;
		warningMessage = driver.findElement(MobileBy.xpath(
				"//android.view.View[@content-desc='Profile name cannot start with a number or special character']"));
//					       toasterMessage=null;
//					       toasterMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		if (warningMessage == null) {
			// Reporter.log(warningMessage.getText());
			Assert.assertNotNull(warningMessage);
		}
		WebElement NextSC = driver.findElement(MobileBy.AccessibilityId("Next"));
		NextSC.click();

		rowNum = 3; // The row number you want to read
		colNum = 3; // The column number you want to read
		profileName.click();
		data = rows.get(rowNum)[colNum];

		profileName.sendKeys(data);
		Reporter.log(data);
		driver.navigate().back();
		warningMessage = null;
		Thread.sleep(2000);
		NextSC = driver.findElement(MobileBy.AccessibilityId("Next"));
		NextSC.click();
		warningMessage = driver.findElement(MobileBy.xpath(
				"//android.view.View[@content-desc='Profile name cannot start with a number or special character']"));
//						       toasterMessage=null;
//						       toasterMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		if (warningMessage == null) {
			// Reporter.log(warningMessage.getText());
			Assert.assertNotNull(warningMessage);
		}
//					driver.closeApp();
//					driver.launchApp();
//					WebElement icon =null;
//					
//					   icon = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]"));
//
//					  if (icon != null) {
//				        	 Reporter.log("Next Button is enabled ");
//				             Assert.assertNull(icon);

	}

	public void profileName() throws InterruptedException {
		Thread.sleep(5000);
		// WebElement nextButton =
		// driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Next']"));
		// nextButton.click();
		// WebElement outside=
		// driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='* Your
		// Profile Name Required']"));
		// driver.navigate().back();;
		WebElement profileName = driver.findElement(By.className("android.widget.EditText"));
		profileName.click();

		profileName.sendKeys("Aditya");

		WebElement warningMessage = driver.findElement(
				MobileBy.xpath("//android.view.View[@content-desc='That profile name is taken, Try another.']"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			WebElement warningMessage1 = driver.findElement(
					MobileBy.xpath("//android.view.View[@content-desc='That profile name is taken, Try another.']"));

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			int x_coord = 542;
			int y_coord = 1418;
			if (warningMessage1.isDisplayed()) {

				TouchAction touchAction = new TouchAction(driver);
				touchAction.tap(PointOption.point(x_coord, y_coord)).perform();

			}
		} catch (StaleElementReferenceException e) {

		}
		WebElement avatar = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.ImageView"));
		// avatar.click();
		avatar.click();
		WebElement nextScreen = driver.findElement(By.className("android.widget.Button"));
		driver.navigate().back();
		;
		nextScreen.click();
		driver.closeApp();
		driver.launchApp();
		WebElement icon = null;

		icon = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]"));

		if (icon != null) {
			Reporter.log("Next Button is enabled ");
			Assert.assertNull(icon);

		}
	}

	public void tellUsAbout() {
		WebElement Name = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"));
		Name.click();
		Name.sendKeys("ADITYA RAJ");
		WebElement Gender = driver.findElement(MobileBy.xpath(" //android.view.View[@content-desc='Male']"));
		Gender.click();
		WebElement emailField = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"));
		emailField.click();
		emailField.sendKeys("aditya@gmail.com");
		WebElement TellUs = driver
				.findElement(MobileBy.xpath("//android.view.View[@content-desc='Tell us about yourself']"));
		TellUs.click();
		WebElement nextButton = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Next']"));
		nextButton.click();

		// WebElement outside=
		// driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='* Your
		// Profile Name Required']"));
		driver.navigate().back();
		;
		WebElement profileName = driver.findElement(By.className("android.widget.EditText"));
		profileName.click();

		profileName.sendKeys("Aditya");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			int x_coord = 542;
			int y_coord = 1418;

			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(PointOption.point(x_coord, y_coord)).perform();

		} catch (StaleElementReferenceException e) {

		}
		WebElement avatar = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.ImageView"));
		// avatar.click();
		avatar.click();
		WebElement nextScreen = driver.findElement(By.className("android.widget.Button"));
		driver.navigate().back();
		;
		nextScreen.click();

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		// Continue with further actions in your test
		// ...

		// Close the driver
		driver.quit();
//		    WebDriverWait waitss = new WebDriverWait(driver, 30);
//		    WebElement Skip = waitss.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Follow this walkthrough to join your first contest! Tap to start")));
//		   
//		    Skip.click();
//		    WebElement Skipbutton    =waitss.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Step 1: Choose Asset Class Equity is chosen for you, for now! Tap anywhere to continue")));
//		    
//		    Skipbutton.click();

	}

////@Test
	public void LogIn() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		// caps.setCapability("deviceName", "Sheetal");
		caps.setCapability("deviceName", "adi");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.stocky_dodo.app");
		caps.setCapability("appActivity", "com.stocky_dodo.app.MainActivity");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("noReset", true);
		// caps.setCapability("appium:appWaitForLaunch", false);
		caps.setCapability("adbExecTimeout", 60000);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// WebElement out= driver.findElement(MobileBy.AccessibilityId("Login /
		// Register"));
		driver.navigate().back();
		;
		new WebDriverWait(driver, 5);
		try {
			WebElement myTextField = driver.findElement(By.className("android.widget.EditText"));
			myTextField.click();
			myTextField.sendKeys("7903825832");

		} catch (StaleElementReferenceException e) {
			WebElement myTextField = driver.findElement(By.className("android.widget.EditText"));
			myTextField.click();
			myTextField.sendKeys("7903825832");
		}

		new WebDriverWait(driver, 5);
		WebElement myCheckbox = driver
				.findElement(By.xpath("//android.view.View[@content-desc='Agree to ']/android.widget.CheckBox"));
		myCheckbox.click();
		WebElement Send = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
		Send.click();
		new WebDriverWait(driver, 20);
		WebElement verify = driver.findElement(MobileBy.AccessibilityId("Verify"));
		// verify.click();

	}

	@Test(priority = 10)
	public void RegistrationPushDeeplinking() throws InterruptedException {
		Thread.sleep(5000);
		driver.openNotifications();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(2).scrollIntoView("
						+ "new UiSelector().textContains(\"welcome to the flock\"))"))
				.click();
		WebElement edit = null;
		edit = driver.findElement(MobileBy.AccessibilityId(" Edit"));
		assertNotNull(edit);
		tearDown();

	}

	@Test(priority = 9)
	public void RegistrationInAppDeeplinking() throws InterruptedException, MalformedURLException {
		setup();
		WebElement bell = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[4]");	
		bell.click();
		String xpath = "//*[contains(@content-desc, 'welcome to the flock. Some cash is always welcome!')]";
		WebElement Inapp = driver.findElement(By.xpath(xpath));
		Inapp.click();
		Thread.sleep(5000);
		
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		assertNotNull(addCash);

	}

	public void tearDown() {
		// Tear down method to close the driver
		if (driver != null) {
			driver.quit();
		}
		Reporter.log("clear");
	}
}
