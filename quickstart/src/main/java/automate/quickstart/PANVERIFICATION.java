package automate.quickstart;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;

public class PANVERIFICATION extends Configuration{
	  
	@Test
public void PAN()
{
	

    
//  automation  
    WebElement element = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Next']"));
    element.click();
    WebElement popup = driver.findElement(By.id("com.google.android.gms:id/credentials_hint_picker_title"));

 // Check if the popup element is displayed
 if(popup.isDisplayed()) {
	 WebElement element3 = driver.findElement(MobileBy.xpath("//android.widget.LinearLayout[@content-desc='079038 25832']/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
	    element3.click();
		
	  //android.widget.LinearLayout[@content-desc='079038 25832']/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView
     
 }
   
	 MobileElement myTextField = driver.findElement(By.className("android.widget.EditText"));
	 myTextField.sendKeys("7903825832");
	
 
 MobileElement myCheckbox = driver.findElement(By.xpath("//android.view.View[@content-desc='Agree to ']/android.widget.CheckBox"));
 myCheckbox.click();
 MobileElement element2 = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
 element2.click();
 WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element9 = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]"));
 element9.click();
// WebElement balance = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='My Balance']"));
// balance.click();
// WebElement verify = driver.findElement(By.xpath("//android.view.View[@content-desc='Verify']"));
// verify.click();
// WebElement verifyPAN = driver.findElement(By.xpath("//android.view.View[@content-desc='Verify PAN Details']"));
// verifyPAN.click();
// List<MobileElement> elementss = driver.findElements(By.className("android.widget.EditText"));
// 
// MobileElement pan_name = elementss.get(0);
// //WebElement  = driver.findElement(By.className("android.widget.EditText").get(1));
// //WebElement pan_name = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));
// pan_name.click();
// pan_name.sendKeys("ADITYA RAJ");
// MobileElement pan_num = elementss.get(1);
// pan_num.click();
//
//pan_num.sendKeys("DLRPR8502R");
////List<WebElement> delems = driver.findElements(By.className("android.view.View"));
//MobileElement dob  = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]"));
//dob.click();
//
//
//WebElement PEN= driver.findElement(By.className("android.widget.Button"));
//PEN.click();
////driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//try {
//    WebElement input = driver.findElement(By.className("android.widget.EditText"));
//input.clear();
//input.sendKeys("25/10/1999");
//} catch (Exception e) {
//    System.out.println("Error sending keys to input field: " + e.getMessage());
//}
//WebElement OK= driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='OK']"));
//OK.click();
//MobileElement submit= driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Submit']"));
//submit.click();
MobileElement Profile= driver.findElement(By.className("android.view.View"));
Profile.click();

   
  }
	}

	  

