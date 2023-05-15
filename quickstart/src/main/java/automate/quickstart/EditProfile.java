package automate.quickstart;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class EditProfile extends AppiumEXtendedMethods {
	Boolean quitDriver = true;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		if (quitDriver) {
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

			System.out.println("hello");
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Tear down method to close the driver
		if (quitDriver) {
			driver.quit();

		}

	}

	@Test(priority = 3)
	public void ProfileNameAlreadyTaken() throws MalformedURLException, InterruptedException {

		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();
		WebElement EditName = driver.findElement(By.className("android.widget.EditText"));
		EditName.click();
		EditName.clear();
		EditName.sendKeys("sheetal");
		driver.navigate().back();
//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollIntoView("
//						+ "new UiSelector().textContains(\"Male\"))"));
		WebElement Update = driver.findElement(MobileBy.AccessibilityId("Update"));
		Update.click();
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		System.out.println(toasterMessage);
	}

	@Test(priority = 4)
	public void ProfileNameEmpty() throws InterruptedException, IOException {
		Thread.sleep(5000);
		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();
		Thread.sleep(5000);
		WebElement EditName = driver.findElement(By.className("android.widget.EditText"));
		EditName.click();
		EditName.clear();
		EditName.sendKeys("");
		driver.navigate().back();
//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollIntoView("
//						+ "new UiSelector().textContains(\"Male\"))"));
		WebElement Update = driver.findElement(MobileBy.AccessibilityId("Update"));
		Update.click();
		Boolean statusBoolean = (isDisabled(getColor(Update)));
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		System.out.println(toasterMessage);
		assertTrue(statusBoolean);

		

	}

	@Test(priority = 1)
	public void ProfileNamelessThanthree() throws InterruptedException, IOException {
		Thread.sleep(5000);
		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();
		Thread.sleep(5000);
		WebElement EditName = driver.findElement(By.className("android.widget.EditText"));
		EditName.click();
		EditName.clear();
		EditName.sendKeys("ad");
		driver.navigate().back();
//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollIntoView("
//						+ "new UiSelector().textContains(\"Male\"))"));
		WebElement Update = driver.findElement(MobileBy.AccessibilityId("Update"));
		Update.click();
		Boolean statusBoolean = (isDisabled(getColor(Update)));
		Thread.sleep(5000);

		
		WebElement warningMessage = driver.findElementByAccessibilityId("Profile name should be atleast 3 characters long");
		
		assertEquals(warningMessage.getText(), "Profile name should be atleast 3 characters long");
		assertTrue(statusBoolean);

	}

	@Test(priority = 6)
	public void DOB_negativeOutofrange1() throws InterruptedException, MalformedURLException {

		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();
		Thread.sleep(5000);
		List<WebElement> DOB = driver.findElements(MobileBy.className("android.view.View"));
//		System.out.println(DOB.get(5).getText());
		DOB.get(5).click();
		Thread.sleep(5000);

		WebElement PEN = driver.findElement(MobileBy.className("android.widget.Button"));
		PEN.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			WebElement input = driver.findElement(MobileBy.className("android.widget.EditText"));
			input.clear();
			input.sendKeys("25/10/1922");

		} catch (Exception e) {
			Reporter.log("Error sending keys to input field: " + e.getMessage());
		}
		WebElement OK = driver.findElement(MobileBy.AccessibilityId("OK"));
		OK.click();
		WebElement outOfRange = null;

		outOfRange = driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='Out of range.']"));
		Assert.assertNotNull(outOfRange);
		// WebElement outside= driver.findElement(MobileBy.AccessibilityId("Profile
		// Name *"));
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test(priority = 7)
	public void DOB_negativeOutOfRange2() throws InterruptedException, MalformedURLException {

		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();

		Thread.sleep(5000);
		List<WebElement> DOB = driver.findElements(MobileBy.className("android.view.View"));
		DOB.get(5).click();

		WebElement PEN = driver.findElement(MobileBy.className("android.widget.Button"));
		PEN.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			WebElement input = driver.findElement(MobileBy.className("android.widget.EditText"));
			input.clear();

		} catch (Exception e) {
			Reporter.log("Error sending keys to input field: " + e.getMessage());
		}
		WebElement OK = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='OK']"));
		OK.click();
		WebElement invalidFormat = null;
		invalidFormat = driver.findElement(MobileBy.AccessibilityId("Invalid format."));

		Assert.assertNotNull(invalidFormat);
		// WebElement outside= driver.findElement(MobileBy.AccessibilityId("Profile
		// Name *"));
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test(priority = 8)
	public void Gender() throws InterruptedException, IOException {
		System.gc();
		Thread.sleep(5000);
		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollForward().scrollIntoView("
						+ "new UiSelector().textContains(\"Male\"))"));
		Thread.sleep(5000);
		WebElement Male = driver.findElement(MobileBy.AccessibilityId("Male"));
		Male.click();
		Thread.sleep(5000);
		WebElement Female = driver.findElement(MobileBy.AccessibilityId("Female"));
		// getColor(Male);
		System.out.println(Female.isSelected() + "AND MALE RADIO " + Male.isSelected());

		// Female.click();
		Thread.sleep(5000);
		WebElement Other = driver.findElement(MobileBy.AccessibilityId("Other"));
		Other.click();
		System.out.print(Female.isSelected() + "AND MALE RADIO" + Male.isSelected());
		WebElement Update = driver.findElement(MobileBy.AccessibilityId("Update"));
		Update.click();

		driver.navigate().back();
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void hamburger_profile() throws InterruptedException, MalformedURLException {

		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();

	}

	@Test(priority = 1)

	public void checkElements() throws MalformedURLException, InterruptedException {

		Thread.sleep(5000);
		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		System.out.println("hello11");
		element9.click();
		System.out.println("hello1");
		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();
		Thread.sleep(5000);
		System.out.println("hello2");
		List<WebElement> elements = driver.findElements((By.className("Profile Name *")));
		Thread.sleep(5000);

		elements.add(driver.findElement(MobileBy.className("android.widget.EditText")));

		Thread.sleep(5000);

		elements.add(driver.findElement(By.className("android.view.View")));
		Thread.sleep(5000);
		elements.add(driver.findElement(MobileBy.className("android.widget.ImageView")));
		Thread.sleep(5000);

		// elements.add(driver.findElement(MobileBy.AccessibilityId("Date of Birth
		// *")));
		// Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollForward().scrollIntoView("
						+ "new UiSelector().textContains(\"Male\"))"));
		Thread.sleep(5000);
		elements.add(driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='Select Gender ']")));

		Thread.sleep(5000);
		elements.add(driver.findElement(MobileBy.AccessibilityId("Male")));
		Thread.sleep(5000);
		elements.add(driver.findElement(MobileBy.AccessibilityId("Female")));
		Thread.sleep(5000);
		elements.add(driver.findElement(MobileBy.AccessibilityId("Other")));
		Thread.sleep(5000);
		elements.add(driver.findElement(MobileBy.AccessibilityId("Update")));
		System.out.println(elements.size() + " elements found");
		assertEquals(elements.size(), 8);

	}

	@Test(priority = 12)
	public void editProfile() throws MalformedURLException, InterruptedException {
		quitDriver = false;
		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");

		Thread.sleep(5000);
		List<WebElement> editProfile = driver.findElements(MobileBy.className("android.widget.ImageView"));
		editProfile.get(1).click();

		WebElement Photo = driver.findElement(MobileBy.AccessibilityId("Photo"));
		Photo.click();
		driver.findElement(MobileBy.AccessibilityId("Show roots")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
				.click();
		Thread.sleep(5000);
//      List<WebElement> pics = driver.findElements(MobileBy.className("android.widget.ImageView"));
//     pics.get(7).click();
		TapOptions tapOptions = new TapOptions().withPosition(PointOption.point(155, 1206));
		(new TouchAction(driver)).tap(tapOptions).perform();

//       try {   WebElement camera = driver.findElement(MobileBy.AccessibilityId("Camera"));
//       camera.click();
//       Thread.sleep(5000);
//       TapOptions tapOptions = new TapOptions().withPosition(PointOption.point(542, 2025));
//       (new TouchAction(driver)).tap(tapOptions).perform();
////       WebElement Shutter = driver.findElement(MobileBy.AccessibilityId("\"Shutter\" button"));
////       Shutter.click();
//       Thread.sleep(10000);
//       WebElement Done =  driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc =~ '(?i)^(OK|Done(_button)?)$']"));
//       Done.click();
//        
//     } catch (StaleElementReferenceException e) {
//    	 WebElement camera = driver.findElement(MobileBy.AccessibilityId("Camera"));
//         camera.click();
//    	 WebElement Shutter = driver.findElement(MobileBy.AccessibilityId("Shutter"));
//         Shutter.click();
//    	
//        
//     }
//       try {     WebElement Done = driver.findElement(MobileBy.AccessibilityId("Done"));
//       Done.click();
//        
//     } catch (StaleElementReferenceException e) {
//    	 WebElement Done = driver.findElement(MobileBy.AccessibilityId("Done"));
//         Done.click();
//        
//     }

		WebElement EditName = driver.findElement(By.className("android.widget.EditText"));
		EditName.click();
		EditName.clear();
		EditName.sendKeys("aditya831");

		driver.navigate().back();

		List<WebElement> DOB = driver.findElements(MobileBy.className("android.view.View"));
		DOB.get(5).click();

		WebElement PEN = driver.findElement(MobileBy.className("android.widget.Button"));
		PEN.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			WebElement input = driver.findElement(MobileBy.className("android.widget.EditText"));
			input.clear();
			input.sendKeys("25/10/1999");

		} catch (Exception e) {
			Reporter.log("Error sending keys to input field: " + e.getMessage());
		}
		WebElement OK = driver.findElement(MobileBy.AccessibilityId("OK"));
		OK.click();
		// WebElement outside= driver.findElement(MobileBy.AccessibilityId("Profile
		// Name *"));
		driver.navigate().back();
		;
		WebElement Update = driver.findElement(MobileBy.AccessibilityId("Update"));
		Update.click();
//  TapOptions tapOptions1 = new TapOptions().withPosition(PointOption.point(479, 1072));
//  TapOptions tapOptions2 = new TapOptions().withPosition(PointOption.point(534, 71));

	}

	@Test(priority = 9)
	public void Account_settings_Edit_Profile() throws InterruptedException, IOException {
		
		Thread.sleep(5000);

		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();
		Thread.sleep(5000);
		WebElement accountSetting = driver.findElement(MobileBy.AccessibilityId("Account Settings"));
		accountSetting.click();
		WebElement editProfile = driver.findElement(MobileBy.AccessibilityId("Edit Profile"));
		editProfile.click();
		WebElement EditName = driver.findElement(By.className("android.widget.EditText"));
		EditName.click();
		EditName.clear();
		EditName.sendKeys("aditya832");
		driver.navigate().back();
		WebElement Update = driver.findElement(MobileBy.AccessibilityId("Update"));
		Update.click();
		Thread.sleep(5000);

	}

	@Test(priority = 13)
	public void ProfileDeepLinking() throws InterruptedException {
		driver.openNotifications();
//		(new TouchAction(driver)).press(PointOption.point(479, 71)).moveTo(PointOption.point(534, 1072)).release()
//				.perform();
		// Thread.sleep(5000);
//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(25).scrollIntoView("
//						+ "new UiSelector().textContains(\"StockyDodo\"))"))
//				.click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(2).scrollIntoView("
						+ "new UiSelector().textContains(\"your profile details have been updated\"))"))
				.click();
		WebElement edit = null;
		edit = driver.findElement(MobileBy.AccessibilityId(" Edit"));
		assertNotNull(edit);
	}

	@Test(priority = 10)
	public void ProfileDeepLinkingInApp() throws InterruptedException {
		Thread.sleep(5000);
		WebElement bell = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[4]"));
		bell.click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(2).scrollIntoView("
						+ "new UiSelector().textContains(\"your profile details have been updated\"))"))
				.click();
		Thread.sleep(5000);
		WebElement edit = null;
		edit = driver.findElement(MobileBy.AccessibilityId(" Edit"));
		assertNotNull(edit);

	}

	@Test(priority = 11)
	public void MobileNumberNotEditable() throws MalformedURLException, InterruptedException {

		Thread.sleep(5000);
		WebElement element = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element.click();

		// caps.setCapability("appium:app",
		// "C:\\Users\\cool\\AppData\\Local\\Android\\Sdk\\tools\\bin\\Stocky_dodo_v1.0.1_qa.apk");
		Thread.sleep(5000);
		WebElement profile = driver.findElement(MobileBy.className("android.view.View"));
		profile.click();
		WebElement mobileField = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.view.View[8]"));
		String isenabled = mobileField.getAttribute("clickable");
		Assert.assertEquals(isenabled, "false");
	}

}
