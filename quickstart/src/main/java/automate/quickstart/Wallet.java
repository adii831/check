package automate.quickstart;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Wallet extends AppiumEXtendedMethods {

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

	@Test(priority = 8)

	public void addCashHappyFlow() throws InterruptedException {

		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		Thread.sleep(5000);
		// scrollUpUntilTextFound(driver, "Our Top Dodos!");

		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
		walletIcons.click();
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		// clicking outside
		// touchAction.tap(PointOption.point(211,73)).perform();
		// back();
		WebElement addAmount = driver.findElement(MobileBy.className("android.widget.EditText"));
		addAmount.click();
		addAmount.sendKeys("28");
		WebElement addCash2 = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash2.click();
		Thread.sleep(5000);

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
		WebElement Okay = driver.findElement(MobileBy.AccessibilityId("Okay"));
		Okay.click();
		// openNotificationCenter();

	}

	@Test(priority = 7)
	public void addCashCancelPopUp() throws InterruptedException {

		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		Thread.sleep(5000);
		// scrollUpUntilTextFound(driver, "Our Top Dodos!");

		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
		walletIcons.click();
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		// clicking outside
		// touchAction.tap(PointOption.point(211,73)).perform();
		// back();
//		WebElement addAmount = driver.findElementByXPath("//XCUIElementTypeTextField");
//		addAmount.sendKeys("28");
//		WebElement addCash2 = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
//		addCash2.click();
		WebElement cancel = driver.findElement(MobileBy.AccessibilityId("Cancel"));
		cancel.click();
		WebElement Checkcancel = driver.findElement(MobileBy.AccessibilityId("Verify"));
		assertNotNull(Checkcancel, "cancel button of popup not working properly");

	}

	@Test(priority = 1)
	public void addCashComponent() throws InterruptedException {

		Thread.sleep(5000);

		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
		walletIcons.click();
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		Thread.sleep(5000);
		// Image
		List<WebElement> addCashComp = driver.findElements((By.className("android.widget.ImageView")));
		Thread.sleep(5000);

		addCashComp.add(driver.findElement(MobileBy.AccessibilityId("Add Cash*")));

		addCashComp.add(driver.findElement(MobileBy.className("android.widget.EditText")));
		addCashComp.add(driver.findElement(MobileBy.AccessibilityId(
				"*Note: If you are residing in the Restricted States of Andhra Pradesh, Arunachal Pradesh, Assam, Nagaland, Odisha, Sikkim, Tamil Nadu and Telangana, you will not be able to utilize any cash that you add to your Unutilized Wallet for joining/ participating in any paid contest/ game on StockyDodo.")));
		addCashComp.add(driver.findElement(MobileBy.AccessibilityId("Add Cash")));

		addCashComp.add(driver.findElement(MobileBy.AccessibilityId("Cancel")));
		assertEquals(addCashComp.size(), 6);

	}

	@Test(priority = 2)
	public void addamounBlank() throws InterruptedException {
		Thread.sleep(5000);
		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
		walletIcons.click();
		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		// clicking outside
		// touchAction.tap(PointOption.point(211,73)).perform();
		// back();
		WebElement editText = driver.findElement(MobileBy.className("android.widget.EditText"));
		editText.click();
		editText.sendKeys(" ");
		WebElement addCash2 = driver.findElement(MobileBy.AccessibilityId("Add Cash"));

		addCash2.click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[contains(@name, 'Toast')]")));

		// Get the toast message element
		// WebElement toastMessageElement = driver
		// .findElement(By.xpath("//XCUIElementTypeOther[contains(@name, 'Toast')]"));

		// Extract the text of the toast message
		// String toastMessageText = toastMessageElement.getAttribute("value");
		String pageSource = driver.getPageSource();
		// String toastMessage = extractToastMessage(pageSource);
		// System.out.println("Toast Message: " + toastMessage);
		// System.out.println(pageSource);
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");

		// String toasterMessage =
		// driver.findElementByXPath(toasterMessageXPath).getText();
		String amount = "Please enter some amount";
		Assert.assertEquals(toasterMessage, amount);
		System.out.println("Toaster Message: " + toasterMessage);

	}

	@Test(priority = 3)
	public void addamounInDecimal() throws InterruptedException {
		Thread.sleep(5000);
		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
	
		walletIcons.click();

		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		// clicking outside
		// touchAction.tap(PointOption.point(211,73)).perform();
		// back();
		WebElement editText = driver.findElement(MobileBy.className("android.widget.EditText"));
		editText.click();
		
		editText.sendKeys("27.5");
		String text = editText.getText();
		assertNotEquals("27.5", text, "user is able to add decimal amount");

	}

	@Test(priority = 4)
	public void addamounLessThan20() throws InterruptedException {
		Thread.sleep(5000);
		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
	
		walletIcons.click();

		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
		addCash.click();
		// clicking outside
		// touchAction.tap(PointOption.point(211,73)).perform();
		// back();
		WebElement editText = driver.findElement(MobileBy.className("android.widget.EditText"));
		editText.click();
		editText.sendKeys("17");
		WebElement addCash2 = driver.findElement(MobileBy.AccessibilityId("Add Cash"));

		addCash2.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
//	wait.until(ExpectedConditions
//			.visibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[contains(@name, 'Toast')]")));

		// Get the toast message element
		// WebElement toastMessageElement = driver
		// .findElement(By.xpath("//XCUIElementTypeOther[contains(@name, 'Toast')]"));

		// Extract the text of the toast message
		// String toastMessageText = toastMessageElement.getAttribute("value");
		String pageSource = driver.getPageSource();
		// String toastMessage = extractToastMessage(pageSource);
		// System.out.println("Toast Message: " + toastMessage);
//System.out.println(pageSource);
		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");

		String amount = "Enter an amount more than ₹20, Dodo!";
		Assert.assertEquals(toasterMessage, amount);
		System.out.println("Toaster Message: " + toasterMessage);

	}

//	public void addamountGreatherThan20() throws InterruptedException {
//		WebElement walletIcons = driver.findElement(MobileBy.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
//		walletIcons.click();
//		WebElement addCash = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
//		addCash.click();
//		WebElement editText = driver.findElement(MobileBy.className("android.widget.EditText"));
//		editText.sendKeys("55");
//		WebElement addCash2 = driver.findElement(MobileBy.AccessibilityId("Add Cash"));
//		addCash2.click();
//		String toasterMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().setMaxSearchSwipes(1).scrollForward().scrollIntoView("
//						+ "new UiSelector().textContains(\"pay later\"))"));
//		WebElement PayLater = driver.findElement(MobileBy.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.ListView[2]/android.view.View[5]"));
//		PayLater.click();
//		WebElement Simpl = driver.findElement(MobileBy.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]"));
//		Simpl.click();
//		WebElement success = driver.findElement(MobileBy.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.Button[1]"));
//		success.click();
//		List<IOSElement> successWalletIcon = driver.findElements((By.className("android.widget.ImageView")));
//		Thread.sleep(5000);
//
//		Thread.sleep(5000);
//
//		successWalletIcon.add(driver.findElement(MobileBy.AccessibilityId("Success!")));
//
//		// elements.add(driver.findElement(MobileBy.AccessibilityId("Date of Birth
//		// *")));
//		// Thread.sleep(5000);
//
//		Thread.sleep(5000);
//		successWalletIcon.add(driver.findElement(MobileBy.AccessibilityId("Your payment went through. Woohoo!")));
//
//		Thread.sleep(5000);
//		successWalletIcon.add(driver.findElement(MobileBy.AccessibilityId("Okay")));
//		assertEquals(successWalletIcon.size(), 4);
//
//	}

	@Test(priority = 9)
	public void Deeplinking() throws InterruptedException, IOException {
		Thread.sleep(5000);
		WebElement explore = driver.findElement(MobileBy.AccessibilityId("Explore\n" + "Tab 3 of 5"));
		explore.click();
		Thread.sleep(5000);
		WebElement bell = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[4]");	
		bell.click();
		Thread.sleep(5000);
		WebElement notifications = driver.findElementByXPath("//android.widget.ImageView[contains(@content-desc, 'Success')]");
		System.out.print(notifications.getText());
		boolean flag = notifications.getText().contains("Transactional");
		assertEquals(flag, true);
		getColor(notifications);
//	List<WebElement> notification = driver.findElementsByXPath("//XCUIElementTypeImage");
		Thread.sleep(5000);
//		getColor(notification.get(1));
//		getColor(notification.get(2));
//		getColor(notification.get(3));
		// Thread.sleep(1000);
		notifications.click();

		WebElement records = null;
		Thread.sleep(5000);
		records = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.Button[2]");
		assertNotNull(records);
	}

	@Test(priority = 5)
	public void sum() throws InterruptedException {
		Thread.sleep(5000);

		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
	
		walletIcons.click();
		String xpath =  "//*[contains(@content-desc, 'Unutilized Wallet') and contains(@content-desc, 'Cash Bonus') and contains(@content-desc, 'Winnings')]";
		WebElement element = driver.findElement(By.xpath(xpath));

		String elementText = element.getText();

		Pattern pattern = Pattern.compile("\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?"); // Regular expression pattern
		Matcher matcher = pattern.matcher(elementText);

		double total = 0;

		while (matcher.find()) {
			String number = matcher.group().replaceAll(",", ""); // Remove commas from the number
			double value = Double.parseDouble(number);
			total += value;
		}
		String xpath2 = "//android.widget.ImageView[contains(@content-desc, 'Current Balance')]";
		WebElement totalAmount = driver.findElement(By.xpath(xpath2));
		String elementText2 = totalAmount.getText();
		matcher = pattern.matcher(elementText2);
		while (matcher.find()) {
			String number = matcher.group().replaceAll(",", ""); // Remove commas from the number
			double value = Double.parseDouble(number);
			Assert.assertTrue(total == value, "Total amount mismatch");

			// System.out.println("Total: " + total+" "+ value); }

//int number = Integer.parseInt(ind);
//List<WebElement> Pelement = driver.findElements(By.xpath("//XCUIElementTypeOther"));
//System.out.println(Pelement.get(number).getText());

		}
	}

	@Test(priority = 6)
	public void withdrawlDisabled() throws IOException {
		WebElement walletIcons = driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]"));
	
		walletIcons.click();
		String xpath = "//*[contains(@content-desc, 'Unutilized Wallet') and contains(@content-desc, 'Cash Bonus') and contains(@content-desc, 'Winnings')]";
		WebElement element = driver.findElement(By.xpath(xpath));
		Pattern pattern = Pattern.compile("\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?"); // Regular expression pattern

		String elementText = element.getText();

		// String elementText = element.getText();
		String winningsText = "Winnings";
		int index = elementText.indexOf(winningsText);
		if (index != -1) {
			String winningsSubstring = elementText.substring(index + winningsText.length());
			Matcher matcher = pattern.matcher(winningsSubstring);
			if (matcher.find()) {
				String number = matcher.group().replaceAll(",", "");
				double winningsValue = Double.parseDouble(number);
				System.out.println("Winnings: " + winningsValue);
				WebElement withdrwal = driver.findElementByAccessibilityId("Withdraw Amount");

				if (winningsValue < 500.0) {
					assertTrue(isDisabled(getColor(withdrwal)), "withdrawl shuld be disabled");
				}
			}
		}

	}
}