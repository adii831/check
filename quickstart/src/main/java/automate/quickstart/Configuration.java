package automate.quickstart;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Configuration {
	 public void clickOnPoint(int x, int y) {
	        // Get the screen size
		 TouchAction touchAction = new TouchAction(driver);

		// Get device screen dimensions
		

		// Generate random x and y coordinates within the screen bounds
		
		// Use TouchAction to perform tap/click on the random point
		touchAction.tap(PointOption.point(x, y)).perform();
	    }
    public AppiumDriver<MobileElement> driver;
    public DesiredCapabilities caps = new DesiredCapabilities();
    @BeforeTest
  
    public void configureAppium() throws MalformedURLException {
        // Set the Desired Capabilities
     //  caps.setCapability("deviceName", "realme RMX3081");
      caps.setCapability("deviceName", "adi");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.stocky_dodo.app");
        caps.setCapability("appActivity", "com.stocky_dodo.app.MainActivity");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appWaitForLaunch", false);
        caps.setCapability("appium:app", "C:\\Users\\AdityaRaj\\Downloads\\Stocky_dodo_v1.0.1_qa (1).apk");

        // Initialize the Appium driver
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, caps);

         
          //  driver.installApp("C:\\Users\\AdityaRaj\\Downloads\\Stocky_dodo_v1.0.1_qa (1).apk");
            System.out.println("App installed successfully");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }
//    private boolean isAppInstalled(URL url, DesiredCapabilities caps) {
     
//        boolean appInstalled = driver.isAppInstalled(caps.getCapability("appPackage").toString());
//        driver.quit();
//
//        return appInstalled;
//    }

//    private void installApp(URL url, DesiredCapabilities caps) {
//    	 driver = new AndroidDriver<MobileElement>(url, caps);
//        driver = new AndroidDriver<MobileElement>(url, caps);
       
    //}

//    public AppiumDriver<MobileElement> getDriver() {
//        return driver;
//    }
}
