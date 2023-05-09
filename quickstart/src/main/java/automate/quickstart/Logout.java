package automate.quickstart;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Logout extends AppiumEXtendedMethods {
	public void Logoutnegative() throws InterruptedException {

		WebElement Logout = driver.findElement(MobileBy.AccessibilityId("Update"));
		Logout.click();

		WebElement logoutsure = driver.findElement(MobileBy.AccessibilityId("Are you sure you want to logout?"));

		WebElement Logoutcancel = driver.findElement(MobileBy.AccessibilityId("Cancel"));

		Thread.sleep(5000);
		WebElement element=null;
	 element= driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
		

		assertNotNull(element);

	}

	public void Logoutpositive() throws InterruptedException {

		WebElement Logout = driver.findElement(MobileBy.AccessibilityId("Update"));
		Logout.click();

		WebElement logoutsure = driver.findElement(MobileBy.AccessibilityId("Are you sure you want to logout?"));
		WebElement logoutYes = driver.findElement(MobileBy.AccessibilityId("Yes"));
		MobileElement cancel = null;
		Thread.sleep(5000);
		cancel = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[@content-desc='Choose an Account']/android.widget.LinearLayout/android.widget.Button"));
		if (cancel == null)
			assertNotNull(cancel);

	}
}