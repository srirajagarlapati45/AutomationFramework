package waste;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import actions.Action_Keys;
import common.FindElement;
import testBase.TestBase;

public class RightClick extends TestBase {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",relativePath()+"\\Drivers\\geckodriver.exe");
		 d = new FirefoxDriver();
		d.get("https://www.google.com/");
		String xpath="//*[@id='lst-ib']";
		//Action_Keys.dateAsInput(xpath, "mm/dd/yy", 6);
		
		
		Action_Keys.openNewTab(xpath);
		
		/*Action_Keys.rightClick(xpath);
		//FindElement.searchClickableElement(d, xpath).sendKeys(Keys.ARROW_DOWN);
		//FindElement.searchClickableElement(d, xpath).sendKeys(Keys.ARROW_DOWN);
		try {
			Robot ro=new Robot();
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
