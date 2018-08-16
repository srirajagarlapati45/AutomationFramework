package waste;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import actions.Action_Keys;
import testBase.TestBase;

public class ScrollToAnElement extends TestBase {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",Action_Keys.relativePath()+"\\Drivers\\geckodriver.exe");
		 d = new FirefoxDriver();
	d.get("https://www.getpostman.com/docs/v6/postman/scripts/test_examples");
	/*WebElement element = d.findElement(By.xpath("//a[@href='https://s3.amazonaws.com/postman-static-getpostman-com/postman-docs/test_data_file.json']"));
	((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element);
	Thread.sleep(500);*/ 
	Action_Keys.scrollToReachAnElement("//a[@href='https://s3.amazonaws.com/postman-static-getpostman-com/postman-docs/test_data_file.json']");
	Thread.sleep(500); 
	}

}
