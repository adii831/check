package automate.quickstart;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class EditProfile extends AppiumEXtendedMethods {
	@Test(priority = 1)
	public void editProfile() throws MalformedURLException, InterruptedException {
		setup();
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
		List<MobileElement> editProfile = driver.findElements(MobileBy.className("android.widget.ImageView"));
		editProfile.get(1).click();

		WebElement Photo = driver.findElement(MobileBy.AccessibilityId("Photo"));
		Photo.click();
		driver.findElement(MobileBy.AccessibilityId("Show roots")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
				.click();
		Thread.sleep(5000);
//      List<MobileElement> pics = driver.findElements(MobileBy.className("android.widget.ImageView"));
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
//       MobileElement Done =  driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc =~ '(?i)^(OK|Done(_button)?)$']"));
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
//       try {     MobileElement Done = driver.findElement(MobileBy.AccessibilityId("Done"));
//       Done.click();
//        
//     } catch (StaleElementReferenceException e) {
//    	 MobileElement Done = driver.findElement(MobileBy.AccessibilityId("Done"));
//         Done.click();
//        
//     }

		MobileElement EditName = driver.findElement(By.className("android.widget.EditText"));
		EditName.click();
		EditName.clear();
		EditName.sendKeys("aditya831");

		driver.navigate().back();

		List<MobileElement> DOB = driver.findElements(MobileBy.className("android.view.View"));
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
		WebElement OK = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='OK']"));
		OK.click();
		// MobileElement outside= driver.findElement(MobileBy.AccessibilityId("Profile
		// Name *"));
		driver.navigate().back();
		;
		WebElement Update = driver.findElement(MobileBy.AccessibilityId("Update"));
		Update.click();
//  TapOptions tapOptions1 = new TapOptions().withPosition(PointOption.point(479, 1072));
//  TapOptions tapOptions2 = new TapOptions().withPosition(PointOption.point(534, 71));
		(new TouchAction(driver)).press(PointOption.point(479, 71)).moveTo(PointOption.point(534, 1072)).release()
				.perform();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(25).scrollIntoView("
						+ "new UiSelector().textContains(\"StockyDodo\"))"))
				.click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(25).scrollIntoView("
						+ "new UiSelector().textContains(\"your profile details have been updated\"))"))
				.click();

	}

}
