package automate.quickstart;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

//package automate.quickstart;
//
public class SignUp extends Configuration{
	
//	@Test
	public void Registration()

	{
//		  for (int i = 0; i < 2; i++) {
//	            Dimension size = driver.manage().window().getSize();
//	            int startX = size.width / 2;
//	            int startY = (int) (size.height * 0.8);
//	            int endX = size.width / 2;
//	            int endY = (int) (size.height * 0.2);
//
//	            TouchAction swipe = new TouchAction(driver)
//	                    .press(PointOption.point(startX, startY))
//	                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//	                    .moveTo(PointOption.point(endX, endY))
//	                    .release();
//	            swipe.perform();
//	        }
		  WebElement element = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Next']"));
		    element.click();
		  //  WebElement popup = driver.findElement(By.id("com.google.android.gms:id/credentials_hint_picker_title"));

		 // Check if the popup element is displayed
//		 if(popup.isDisplayed()) {
//			 WebElement element3 = driver.findElement(MobileBy.xpath("//android.widget.LinearLayout[@content-desc='079038 25832']/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
//			    element3.click();
				
			  //android.widget.LinearLayout[@content-desc='079038 25832']/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView
		     
	//	 }
//		 else {
		    WebDriverWait wait = new WebDriverWait(driver, 10);

			 MobileElement myTextField = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText"));
		//	myTextField.click();
			 myTextField.sendKeys("7903825832");
//			 }
			
		 
		 MobileElement myCheckbox = driver.findElement(By.xpath("//android.view.View[@content-desc='Agree to ']/android.widget.CheckBox"));
		 myCheckbox.click();
		 MobileElement element2 = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Send OTP']"));
		 element2.click();
		
		try {
		    // Find an element on the screen
			MobileElement Profile= driver.findElement(MobileBy.AccessibilityId("Did a Dodo refer you?"));

		    // Check if the element is displayed
		    if (Profile.isDisplayed()) {
		        System.out.println("User is registering for the first Time");
		        MobileElement Referal = driver.findElement(By.className("android.widget.EditText"));
		        Referal.click();
		        Referal.sendKeys("BHA100");
		        Profile.click();
		        MobileElement applycode = driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Apply Code']"));
		   applycode.click();
		   MobileElement Name = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"));
		     Name.click();
		     Name.sendKeys("ADITYA RAJ");
		     MobileElement Gender= driver.findElement(MobileBy.xpath(" //android.view.View[@content-desc='Male']"));
		     Gender.click();
		     MobileElement emailField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"));
		     emailField.click();
		     emailField.sendKeys("aditya@gmail.com");
		     MobileElement TellUs= driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='Tell us about yourself']"));
		    TellUs.click();
		     MobileElement nextButton= driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Next']"));
		     nextButton.click();
		// wait = new WebDriverWait(driver, 15);

		     WebElement profileName = driver.findElement(By.className("android.widget.EditText"));
		        profileName.click();
		        wait = new WebDriverWait(driver, 15);
		        profileName.sendKeys("Arpita");
		        
		        WebElement warningMessage= driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='That profile name is taken, Try another.']"));
//	         WebElement outer= driver.findElement(By.xpath("//android.view.View[@content-desc='* Your Profile Name']"));
//   outer.click();
		        //clickOnPoint(870,1088);
	        MobileElement outside= driver.findElement(MobileBy.xpath("//android.view.View[@content-desc='* Your Profile Name   Required']"));
		    System.out.println("elemnt found");
	    // outside.click();
//	        List<MobileElement> delems = driver.findElements(By.className("android.view.View"));
////		        System.out.println(delems.get(3).getAttribute("accessbiltyId"));
//			    delems.get(1).click();
////			    delems.
			    
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			   try { 
		        if(warningMessage.isDisplayed())
		        {//WebElement warningMessages= driver.findElement(MobileBy.AccessibilityId("That profile name is taken, Try another."));
//		        	int i=1;
//		        	System.out.println(i);
//		        	
//		        	profileName.click();
//		        	profileName.clear();
//		        	profileName.sendKeys("Arpita"+i);
//	        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        	int x_coord = 542;
		            int y_coord = 1418;

		            // Use TouchAction to click on the specified coordinates
		            TouchAction touchAction = new TouchAction(driver);
		            touchAction.tap(PointOption.point(x_coord, y_coord)).perform();
//		        	// clickOnPoint(219,895);
		        	
//		        	if(!warningMessage.isDisplayed())
//		        	{
//		        		break;
//		        	}
		        		
		        	//i++;
		        	}
			   }
		        catch (StaleElementReferenceException e) {
		            
		        }
		        	//warningMessage=warningMessages;}
		      //  WebElement avatar = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.ImageView"));
			    
			   WebElement avatar = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.ImageView"));
			    //avatar.click();
			   avatar.click();
			        WebElement nextScreen = driver.findElement(By.className("android.widget.Button"));
			        outside.click();
					nextScreen.click();
					
		       
			        WebDriverWait waits = new WebDriverWait(driver, 10);


			    
			        wait = new WebDriverWait(driver, 5);
		 
			        WebElement walkthrough = driver.findElement(MobileBy.xpath("	\r\n"
			        		+ "//android.view.View[@content-desc='Skip']"));
			        walkthrough.click();
			       } else {
		        System.out.println("User is already Registered");
		    }
		} catch (NoSuchElementException e) {
		    
			
		}
		
	}
}
