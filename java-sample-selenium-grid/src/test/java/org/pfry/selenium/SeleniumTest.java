package org.pfry.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
	
	@Test
	public void chromeTest() throws MalformedURLException{
		String hubURL = "http://selenium-hub-selenium.192.168.42.163.nip.io/wd/hub";
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL(hubURL),capabilities);
		doTest(driver); 
	}
	
	@Test
	public void firefoxTest() throws MalformedURLException{
		String hubURL = "http://selenium-hub-selenium.192.168.42.163.nip.io/wd/hub";
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL(hubURL),capabilities);
		doTest(driver); 
	}	

	private void doTest(WebDriver driver) {
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
	}

}
