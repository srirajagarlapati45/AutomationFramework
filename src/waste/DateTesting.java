package waste;

import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

import actions.Action_Keys;
import testBase.TestBase;

public class DateTesting extends TestBase {
	public static void main(String[] args) {
		Logger log=Logger.getLogger("Google");
		log.info("browser started");
		System.setProperty("webdriver.gecko.driver",relativePath()+"\\Drivers\\geckodriver.exe");
		 d = new FirefoxDriver();
		 log.info("browser started");
		d.get("https://www.google.com/");
		log.info("browser started");
		String xpath="//*[@id='lst-ib']";
		log.info("browser started");
		Action_Keys.dateAsInput(xpath, "mm/dd/yyyy", 6);
		
		
	}

}
