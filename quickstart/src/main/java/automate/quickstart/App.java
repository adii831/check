//package automate.quickstart;
////package automate.quickstart;
////
////
////
////import java.net.MalformedURLException;
////import java.net.URL;
////import java.util.concurrent.TimeUnit;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.remote.DesiredCapabilities;
////import org.testng.annotations.AfterClass;
////import org.testng.annotations.AfterTest;
////import org.testng.annotations.Test;
////
////import io.appium.java_client.AppiumBy;
////import io.appium.java_client.AppiumBy.ById;
////import io.appium.java_client.android.AndroidDriver;
////import io.appium.java_client.android.options.UiAutomator2Options;
////
/////**
//// * Hello world!
//// *
//// */
////
//////public class App
//////{
//////	
//////
//////public void appiumstarts() throws MalformedURLException {
//////	
//////
//////    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//////    desiredCapabilities.setCapability("platformName", "Android");
////////    desiredCapabilities.setCapability("appium:PlatformVersion", "11.0");
//////    desiredCapabilities.setCapability("appium:deviceName", "aditya");
//////    desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
//////    desiredCapabilities.setCapability("appium:app", "C:\\Users\\AdityaRaj\\Downloads\\Stocky_dodo_20.apk");
//////    desiredCapabilities.setCapability("appium:appWaitForLaunch", false);
//////    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//////    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//////    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//////    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//////   // desiredCapabilities.setCapability( "appWaitActivity",true);
//////
//////   
//////	
//////
//////	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
//////
//////
//////  
//////
//////	
//////}}
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
//
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.touch.WaitOptions;
//import io.appium.java_client.touch.offset.ElementOption;
//import org.openqa.selenium.Dimension;
//import java.time.Duration;
//import io.appium.java_client.MobileBy;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.MobileElement;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//
//import io.appium.java_client.touch.offset.ElementOption;
//import org.openqa.selenium.Dimension;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//
//import io.appium.java_client.touch.offset.ElementOption;
//import org.openqa.selenium.Dimension;
//@Test
//public class App {
//	 // private static boolean isAppInstalled(URL url, DesiredCapabilities caps) throws MalformedURLException {
//	        //AppiumDriver<MobileElement> driver = new AndroidDriver<>(url, caps);
//
////	        boolean appInstalled = driver.isAppInstalled(caps.getCapability("com.stocky_dodo.app").toString());
////
////	        driver.quit();
////
////	        return appInstalled;
////	    }
////
////	    private static void installApp(URL url, DesiredCapabilities caps) throws MalformedURLException {
////	        AppiumDriver<MobileElement> driver = new AndroidDriver<>(url, caps);
////
////	        driver.installApp("C:\\Users\\AdityaRaj\\Downloads\\Stocky_dodo_v1.0.0_qa.apk");
////
////	        driver.quit();
////
////	        System.out.println("App installed successfully");
////	    }
//	
//	
//
//	public void ConfigureAppium() throws MalformedURLException  {
//
//    // Set the Desired Capabilities
//    DesiredCapabilities caps = new DesiredCapabilities();
//    caps.setCapability("deviceName", "adi");
//    caps.setCapability("platformName", "Android");
//    caps.setCapability("appPackage", "com.stocky_dodo.app");
//    caps.setCapability("appium:app", "C:\\Users\\AdityaRaj\\Downloads\\Stocky_dodo_v1.0.0_qa.apk");
//    caps.setCapability("appActivity", "com.stocky_dodo.app.MainActivity");
//    caps.setCapability("appium:automationName", "UiAutomator2");
//    caps.setCapability("appium:appWaitForLaunch", false);
//    //caps.setCapability("UUID", "21b7da02");
//    //21b7da02
//
//    // Initialize the Appium driver
//    URL url = new URL("http://127.0.0.1:4723/wd/hub");
//  
//    boolean appInstalled = isAppInstalled(url, caps);
//
//    if (appInstalled) {
//        System.out.println("App is already installed");
//    } else {
//        installApp(url, caps);
//    }
//
//    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//
//    System.out.println("App launched successfully");
//
//    
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    WebElement element = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Next']"));
//    element.click();
//    WebElement popup = driver.findElement(By.id("com.google.android.gms:id/credentials_hint_picker_title"));
//
// // Check if the popup element is displayed
// if(popup.isDisplayed()) {
//	 WebElement element3 = driver.findElement(MobileBy.xpath("//android.widget.LinearLayout[@content-desc='079038 25832']/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
//	    element3.click();
//		
//	  //android.widget.LinearLayout[@content-desc='079038 25832']/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView
//     
// } else {
//	 WebElement myTextField = driver.findElement(By.className("android.widget.EditText"));
//	 myTextField.sendKeys("7903825832");
//	
// }
// WebElement myCheckbox = driver.findElement(By.xpath("//android.view.View[@content-desc='Agree to ']/android.widget.CheckBox"));
// myCheckbox.click();
// WebElement element2 = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
// element2.click();
// WebDriverWait wait = new WebDriverWait(driver, 10);
//WebElement element9 = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
// element9.click();
// WebElement balance = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='My Balance']"));
// balance.click();
// WebElement verify = driver.findElement(By.xpath("//android.view.View[@content-desc='Verify']"));
// verify.click();
// WebElement verifyPAN = driver.findElement(By.xpath("//android.view.View[@content-desc='Verify PAN Details']"));
// verifyPAN.click();
// List<WebElement> elementss = driver.findElements(By.className("android.widget.EditText"));
// 
// WebElement pan_name = elementss.get(0);
// //WebElement  = driver.findElement(By.className("android.widget.EditText").get(1));
// //WebElement pan_name = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));
// pan_name.click();
// pan_name.sendKeys("ADITYA RAJ");
// WebElement pan_num = elementss.get(1);
// pan_num.click();
//
//pan_num.sendKeys("DLRPR8502R");
////List<WebElement> delems = driver.findElements(By.className("android.view.View"));
//WebElement dob  = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]"));
//dob.click();
//
//
//WebElement PEN= driver.findElement(By.className("android.widget.Button"));
//PEN.click();
//WebElement input= driver.findElement(By.className("android.widget.EditText"));
////PEN.click();
//input.sendKeys("25101999");
//WebElement OK= driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='OK']"));
//OK.click();
//WebElement submit= driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Submit']"));
//submit.click();
////
//
////android.widget.Button[@content-desc='OK']
//
//
////
////
////android.widget.ImageView[@content-desc='My Balance']
// 
// //Play Tab 2 of 5
// wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Play Tab 2 of 5"))).click();
//
////wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=' Play Tab 2 of 5']"))).click();
// 
// //WebElement play = driver.findElement(By.id("00000000-0000-0277-0000-007000000004"));
// //play.click();
// 
// 
////Play Tab 2 of 5
////
//
//
// WebElement crypto = driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc='Crypto Tab 2 of 2']"));
// crypto.click();
// WebElement ContestCard = driver.findElement(By.id("00000000-0000-0277-0000-007000000004"));
// ContestCard.click();
//	
////android.widget.ImageView[@content-desc='Crypto Tab 2 of 2']
//	
////android.view.View[@content-desc='Crypto Select 5 Create a portfolio by choosing your 5 favorite assets. Win upto ₹ 1 Lakhs Play & Win!']
//   // android.widget.EditText
//WebElement element7 = null;
//	
////
// TouchAction touchAction = new TouchAction(driver);
// while (element7== null) {
//     try {
//         element7 = driver.findElement(MobileBy.AndroidUIAutomator(
//             "new UiScrollable(new UiSelector().scrollable(true).instance(1))"
//             + ".scrollIntoView(new UiSelector().xpath(\"//android.view.View[@content-desc='09 Mar 2023 05:00 PM - 06:30 PM']\").instance(1))"));
//     } catch (org.openqa.selenium.NoSuchElementException e) {
//         // Perform a scroll action
//         Dimension size = driver.manage().window().getSize();
//         int startX = size.width / 2;
//         int startY = (int) (size.height * 0.8);
//         int endY = (int) (size.height * 0.2);
//         touchAction.press(ElementOption.point(startX, startY))
//         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//         .moveTo(ElementOption.point(startX, endY))
//         .release()
//         .perform();
//     }
// }
//
// // Click the element
// element7.click();
//
//
//
// // Input text into the text field
//
//
//         // Locate and click on the input field to receive OTP
////         MobileElement otpField = driver.findElementById("YOUR_OTP_FIELD_ID");
////         otpField.click();
////
////         // Split the OTP into four digits and enter them in respective boxes
////         String otp = "1234"; // Replace with your actual OTP
////         for (int i = 0; i < 4; i++) {
////             WebElement otpBox = driver.findElement(By.xpath(" //android.widget.ImageView[@content-desc='Enter OTP You know what to do, Dodo. +91-7903825832 in 14 sec'+]"+"android.view.View"+i+"]android.view.View"));
////             otpBox.sendKeys(Character.toString(otp.charAt(i)));
////         }
////      
//       //  driver.quit();
//     
// 
// //WebElement OTP = driver.findElement(MobileBy.id("<otp_textfield_id>"));
////Wait for OTP to be received and then extract it from the message
//// Thread.sleep(10000); // Wait for 10 seconds for OTP to be received
//// String OTPMessage = driver.findElement(MobileBy.xpath("<otp_message_xpath>")).getText();
//// String OTPCode = OTPMessage.replaceAll("[^0-9]", ""); // Extracting OTP code from message
////
//// // Entering OTP code and clicking on Login button
//// OTP.sendKeys(OTPCode);
//// loginButton.click();
////android.widget.Button[@content-desc='Send OTP']
// 
//  //android.view.View[@content-desc='Agree to ']/android.widget.CheckBox
//   
//  //android.widget.Button[@content-desc='Next']
//    // Do some automation
//    // ...
//
//    // Close the app
//   
//  }
//	}
//
//	  
//
