import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogDemo {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger(LogDemo.class.getName());// getlogger is a static method of logmanager
																	// class,so we dont need to create an object for
																	// it..we cxan access directly using classname
		log.debug("Execution started");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\eshwar\\Desktop\\JAVA_PRACTICE\\Log4jDemo\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.debug("Chrome browser got launched");
		;
		driver.manage().window().maximize();
		log.debug("Chrome browser has maximized");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		log.debug("Navigated to Omayo Application");
		driver.findElement(By.xpath("//a[contains(.,'compendiumdev')]")).click();
		log.debug("Clicked on Compendium Link");
		driver.navigate().back();
		log.debug("Navigated back to Omayo Home");
		driver.navigate().forward();
		log.debug("Navigated forward to compendium page");
		if (driver.getTitle().equalsIgnoreCase("Basic Web Page Title")) {
			log.info("Correct page is displayed");
		} else {
			log.error("Test Failed");

		}
		driver.close();
		log.debug("Driver got closed");
	}

}
