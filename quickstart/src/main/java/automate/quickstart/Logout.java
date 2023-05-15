package automate.quickstart;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Logout extends AppiumEXtendedMethods {
	@BeforeMethod
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

			System.out.println("hello");
		
	}

	@AfterMethod
	public void tear() {
		driver.terminateApp("com.stocky_dodo.app");

		// Quit the driver
		driver.quit();
	}
	@Test(priority =1)
	public void Logoutnegative() throws InterruptedException {
		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollIntoView("
						+ "new UiSelector().textContains(\"Logout\"))"));

		WebElement Logout = driver.findElement(MobileBy.AccessibilityId("Logout"));
		Logout.click();

	//	WebElement logoutsure = driver.findElement(MobileBy.AccessibilityId("Are you sure you want to logout?"));

		WebElement Logoutcancel = driver.findElement(MobileBy.AccessibilityId("Cancel"));
		Logoutcancel.click();

		Thread.sleep(5000);
		WebElement element=null;
	 element= driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		

		assertNotNull(element);

	}
	@Test(priority =2)
	public void Logoutpositive() throws InterruptedException {
		WebElement element9 = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		element9.click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollIntoView("
						+ "new UiSelector().textContains(\"Logout\"))"));

		WebElement Logout = driver.findElement(MobileBy.AccessibilityId("Logout"));
		Logout.click();

		//WebElement logoutsure = driver.findElement(MobileBy.AccessibilityId("Are you sure you want to logout?"));
		WebElement logoutYes = driver.findElement(MobileBy.AccessibilityId("Yes"));
		//WebElement cancel = null;
		Thread.sleep(5000);
		logoutYes.click();

	}
}