package automate.quickstart;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Wallet extends AppiumEXtendedMethods {

	public void addCash() throws InterruptedException {
		Thread.sleep(5000);
		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
		walletIcons.click();
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();

	}

	public void addCashComponent() throws InterruptedException {
		Thread.sleep(5000);
		// Image
		List<MobileElement> addCashComp = driver.findElements((By.className("android.widget.ImageView")));
		Thread.sleep(5000);

		addCashComp.add(driver.findElement(MobileBy.AccessibilityId("Add Cash*")));

		addCashComp.add(driver.findElement(MobileBy.className("android.widget.EditText")));
		addCashComp.add(driver.findElement(MobileBy.AccessibilityId(
				"*Note: If you are residing in the Restricted States of Andhra Pradesh, Assam, Nagaland, Odisha, Sikkim and Telangana, you will not be able to utilize any cash that you add to your Unutilized Wallet for joining/ participating in any paid contest/ game on StockyDodo.")));
		addCashComp.add(driver.findElement(MobileBy.AccessibilityId("Add Cash")));

		addCashComp.add(driver.findElement(MobileBy.AccessibilityId("Cancel")));
		assertEquals(addCashComp.size(), 6);

	}

	public void addamounLessThan20() throws InterruptedException {
		Thread.sleep(5000);
		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
		walletIcons.click();
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		WebElement editText = driver.findElement(MobileBy.className("android.widget.EditText"));
		editText.sendKeys("20");
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		System.out.println(toasterMessage);
	}

	public void addamountGreatherThan20() throws InterruptedException {
		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
		walletIcons.click();
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		WebElement editText = driver.findElement(MobileBy.className("android.widget.EditText"));
		editText.sendKeys("55");
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollForward().scrollIntoView("
						+ "new UiSelector().textContains(\"pay later\"))"));
		WebElement PayLater = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.ListView[2]/android.view.View[5]"));
		PayLater.click();
		WebElement Simpl = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]"));
		Simpl.click();
		WebElement success = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.Button[1]"));
		success.click();
		List<MobileElement> successWalletIcon = driver.findElements((By.className("android.widget.ImageView")));
		Thread.sleep(5000);

		Thread.sleep(5000);

		successWalletIcon.add(driver.findElement(MobileBy.AccessibilityId("Success!")));

		// elements.add(driver.findElement(MobileBy.AccessibilityId("Date of Birth
		// *")));
		// Thread.sleep(5000);

		Thread.sleep(5000);
		successWalletIcon.add(driver.findElement(MobileBy.AccessibilityId("Your payment went through. Woohoo!")));

		Thread.sleep(5000);
		successWalletIcon.add(driver.findElement(MobileBy.AccessibilityId("Okay")));
		assertEquals(successWalletIcon.size(), 4);

	}
}