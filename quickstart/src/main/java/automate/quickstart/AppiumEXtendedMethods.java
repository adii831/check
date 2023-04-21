package automate.quickstart;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumEXtendedMethods {
	public AndroidDriver<MobileElement> driver;
	public Color getColor(WebElement element) throws IOException
	{
		 
		// Get the location and size of the element
		Point location = element.getLocation();
		Dimension size = element.getSize();

		// Take a screenshot of the element
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Crop the screenshot to the area of the element
		BufferedImage fullImage = ImageIO.read(screenshot);
		BufferedImage croppedImage = fullImage.getSubimage(location.getX(), location.getY(),
		        size.getWidth(), size.getHeight());

		// Get the color of the center pixel of the element
		Color color = new Color(croppedImage.getRGB(size.getWidth() / 2, size.getHeight() / 2));
		System.out.println("The color of the center pixel of the element is: " + color);
		return color;
	}
	public static boolean isDisabled(Color color) {
	    // Check if the red, green, and blue color components are equal
	    if (color.getRed() == color.getGreen() && color.getGreen() == color.getBlue()) {
	        // Check if the color is a shade of gray (i.e., red = green = blue)
	        if (color.getRed() == 203) { // Replace 203 with the specific shade of gray you want to check for
	            return true;
	        }
	    }
	    return false;
	}

	public void blockNotifcation() throws IOException {
		String packageName = "com.your.package.name"; // replace with your app's package name
		String adbCommand = "adb shell cmd appops set " + packageName + " RUN_IN_BACKGROUND ignore";
		Process process = Runtime.getRuntime().exec(adbCommand);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			Reporter.log(line);
		}
	}

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

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


}
