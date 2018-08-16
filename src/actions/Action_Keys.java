package actions;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.core.exceptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import bsh.StringUtil;
import common.FindElement;
import excel.ExcelUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import robotFrameWork.Robot_Keys;
import testBase.TestBase;

public class Action_Keys extends TestBase {
	
	public static String parentwindow=null;
	public static String alertText=null;
	public static String textobj=null;
	/*public static Screen s=new Screen();
	public static Pattern p;*/
	public static AppiumDriver<MobileElement> and ;
	
	public static void input(String testObj, String testData){
		
		WebElement element=FindElement.searchClickableElement(d, testObj);
		WebDriverWait wait = new WebDriverWait(d, 10);
	
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
	log.info(testObj+" --->Element cleared");
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(testData);
		log.info(testData+" --->String entered in--> "+testObj);
		
		
	}
	public static boolean isElementPresent(String locatorKey) {
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
		    d.findElement(By.xpath(locatorKey));
		   return true;
		} catch (NoSuchElementException e) {
		   return false;
		}
	}

	public static void clickBtn(String testObj){
			
			//By obj=By.xpath(testObj);
		
			//d.findElement(By.xpath(testObj)).click();
		
		
			try {
				FindElement.searchClickableElement(d, testObj).click();
				log.info(testObj+"  ---->element clicked");
			} catch (Exception e) {
				log.error("Unable to find----> "+testObj);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	/*	List<WebElement> items=null;
		System.out.println(testObj);
		
		try{	System.out.println("try block");
		items=d.findElements(By.xpath(testObj));}
		catch(Exception  e){
			e.printStackTrace();}
		
		if(items.size() > 0)
		System.out.println(testObj+"--------->"+items.size());
		
		
			
		d.findElement(By.xpath(testObj)).click();
		*/
	
	
	}
		
		
		
		
	
	
	
	public static void clickLnk(String testObj){
		FindElement.searchClickableElement(d, testObj).click();
	}
	
	public static void selectVaue(String testObj, String testData){
		Select s = new Select(FindElement.searchClickableElement(d, testObj.trim()));
		s.selectByVisibleText(testData);
	}
	
	public static  void handle(){
		try{
		sleep(3000);
		for (String winHandle : d.getWindowHandles()) {
			System.out.println(winHandle);
		    d.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		log.info("Focus is shifted to a new window");
		}}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	
	public   void ctsHandle(){
		for (String winHandle : d.getWindowHandles()) {
			
		    d.switchTo().window(winHandle);
		    WebDriverWait wait = new WebDriverWait(d, 120);
			WebElement locator = d.findElement(By.xpath(""));
		    
		    // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		}
	
	public  static void swithtoFrame(String k){
		try{
			System.out.println("Swithching to frame  "+k);WebDriver frame=d.switchTo().frame(k);
		log.info("Switched to framename--->  "+k);
			System.out.println(frame.getTitle());}
		catch(Exception e){
			ReportActionKeys.writeLogInCaseOfFail(k+" is invalid");
			ReportActionKeys.addScreenShotInReport("Invalid FrameName");
			try {
				throw new Exception ("invalid frame Name",e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public   void swithtoFrameByIndex(int i){
	
		try {
			WebDriver frame=d.switchTo().frame(i);
			log.info("Switched to frameindex--->  "+i);
			frame.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void sitchToFrameByElement(String xpath){
		try {
			d.switchTo().frame((FindElement.searchClickableElement(d, xpath)));
			log.info("Switched to frameByElement--->  "+xpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("unable to Switch to frameByElement--->  "+xpath);
			e.printStackTrace();
		}
	}
	
	public static  void backTomainwin(){
		try {
			d.switchTo().defaultContent();
			log.info("back from frame");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("unable to switch back from frame");
			e.printStackTrace();
		}
	}
	
	public static   void ddown(String drop, String text){
		  
		try{
		boolean matched = false;
		  
		WebElement mySelectElement = FindElement.searchClickableElement(d, drop);
		Select dropdown= new Select(mySelectElement);
		implictwait(3000);
		dropdown.selectByVisibleText(text);
		log.info("Selected "+text+"  from dropdown");
		}
		catch(Exception e){
			log.error("unable to select "+text+"  from dropdown");
			e.printStackTrace();
		}
		/*List<WebElement> options=dropdown.getOptions();
	
		
		for(WebElement option:options){
			if(text.equals(option.getText())){
				matched=true;
				
			}
		}
		if(!matched){
			
				ReportActionKeys.writeLogInCaseOfFail(text+" is invalid");
				ReportActionKeys.addScreenShotInReport("Invalid text");
			try {
				throw new Exception("Cannot locate element with text: "+text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		else{
		dropdown.selectByVisibleText(text);
	}
		
		if(!text.equals(dropdown.getFirstSelectedOption().getText())){
			ReportActionKeys.writeLogInCaseOfFail(text+" is not matched with dropdown text");
			ReportActionKeys.addScreenShotInReport("Invalid text");
			try {throw new Exception("selected option is wrong: "+text);}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}*/
		
	
	}
	
	
	
	
	
	public   void ddownbyvalue(String drop,String value){
		WebElement mySelectElement = FindElement.searchClickableElement(d, drop);
		Select dropdown= new Select(mySelectElement);
		implictwait(3000);
		
		dropdown.selectByValue(value);
		
	}
	
	public static   void ddownbyindex(String drop,int index){
		WebElement mySelectElement = FindElement.searchClickableElement(d, drop);
		Select dropdown= new Select(mySelectElement);
		implictwait(3000);
		dropdown.selectByIndex(index);}
	
	
	public   void cleartextbox(String ele){
		FindElement.searchClickableElement(d, ele).clear();
	}
	
	public   void explictwaiting(int t,String element){
		WebDriverWait wait = new WebDriverWait(d, t);
		WebElement locator = d.findElement(By.xpath(element));
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	public static void takeScreenShot(String filename){
		 File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
        // String date=DatePicker();  
         
		 try {
			 
			 FileUtils.copyFile(scrFile, new File(relativePath()+"\\screenshots\\"+ filename+".png"));
				
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void implictwaitForAndriod(int time)
	{
		and.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS );
	}
	public static void getAndriodScreenshot(AppiumDriver and,String filename){
		 File scrFile = ((TakesScreenshot)and).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
       // String date=DatePicker();  
        
		 try {
			 
			 FileUtils.copyFile(scrFile, new File("E:\\appium\\"+ filename+".png"));
				
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static  void windowMaximize(){
		d.manage().window().maximize();
		log.info("Window Maximised");
	}
	
	
	public   void sleep(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeBrowser(){
		try {
			d.close();
			log.info("Window closed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Unable to close Window ");
			e.printStackTrace();
		}
	}
	public void goToURL(String url){
		d.get(url);
		log.info("URL entred");
	}
public static void customerIdSearch(String xpathofImg,String custId){
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String parent=d.getWindowHandle();
		FindElement.searchClickableElement(d, xpathofImg).click();
		for (String winHandle : d.getWindowHandles()) {
		    d.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		d.manage().window().maximize();
		
		Action_Keys.ddownbyindex("//select[@name='customerSearch']",1);
		FindElement.searchClickableElement(d, "//input[@id='txtCID']").sendKeys(custId);
		FindElement.searchClickableElement(d,"//input[@id='txtCID']/following::img").click();
		FindElement.searchClickableElement(d,"//input[@id='txtCID']/following::input[1]").click();
		FindElement.searchClickableElement(d,"//input[@id='txtCID']/preceding::img").click();
			d.switchTo().window(parent);}

public static void AcceptAlret(){
System.out.println("checking alert");

try {
	WebDriverWait wait = new WebDriverWait(d, 30 /*timeout in seconds*/);
	if(wait.until(ExpectedConditions.alertIsPresent())==null)
	{ log.info("alert was not present");
		System.out.println("alert was not present");}
	else
		log.info("alert was  present");
	    System.out.println("alert was present");
	d.switchTo().alert().dismiss();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
catch (Error e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	//d.switchTo().defaultContent();

	
}
public static String gettextofAlert(){
	alertText=d.switchTo().alert().getText();
	System.out.println(alertText+"<--------alert");
	log.info("text from alert----> "+alertText);
	//d.switchTo().defaultContent();
	return alertText;
}


public static String getNumericsofAlert(){
	 alertText=d.switchTo().alert().getText();
	alertText = alertText.replaceAll("\\D+","");
	System.out.println(alertText+"<--------alert");
	//d.switchTo().defaultContent();
	return alertText;
}



public static void setAlretText(String xpath){
	FindElement.searchClickableElement(d, xpath).sendKeys(alertText);
}

public static void printAlretText(){
	System.out.println(alertText);
}

public static void saveText(String xpath){
	textobj=FindElement.searchClickableElement(d, xpath).getText();
}
public static void useSavedText(String xpath){
	FindElement.searchClickableElement(d, xpath).sendKeys(textobj);
}

public static void swithToDefaultContent(){
	d.switchTo().defaultContent();

	
}
public static void closeChildWindow(String parent){
	String y=d.getWindowHandle();
	for (String winHandle : d.getWindowHandles()) {
		sleep(10000);
		String x =d.switchTo().window(winHandle).getCurrentUrl();
		   if(!parent.equalsIgnoreCase(x)){
			   
			   System.out.println(x+"<----------");
		   
		 
			
			
			if(!x.equalsIgnoreCase("http://192.168.0.32:9090/Base_4.8.0/Login/about.jsp")){
				d.manage().window().maximize();
			 
			d.close();
			}}
		   
		 }
	d.switchTo().window(y);
	System.out.println(d.getCurrentUrl()+"-------At Last");
}

public static String getVoucherNumber(String xpath){
String	voucher=d.switchTo().alert().getText();
	 voucher=voucher.replaceAll("\\D+","");
	// d.findElement(By.xpath(xpath)).sendKeys(voucher);
return voucher;
}

public static void setvoucher(String xpath){
	Action_Keys.getVoucherNumber(xpath);
}

public static void imageSearch(String xpathofImg,String requiredString){
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String parent=d.getWindowHandle();
	d.findElement(By.xpath(xpathofImg)).click();
	for (String winHandle : d.getWindowHandles()) {
	    d.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	d.manage().window().maximize();
	
	
	
	FindElement.searchClickableElement(d,"//input[@name='likeclause']/following::img[1]").click();
	Action_Keys.swithtoFrame("ifrm1");
	
	System.out.println("-------->"+"  entered into frame");
	Action_Keys.scrollDown();
	System.out.println("------>"+"  scrolling");
	FindElement.searchClickableElement(d,"//font[contains(text(),'"+requiredString+"')]").click();
	System.out.println("------>"+"  done");
	d.switchTo().window(parent);
}

public static void goldImageSearch(String xpathofImg,String requiredString){
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	d.findElement(By.xpath(xpathofImg)).click();
	for (String winHandle : d.getWindowHandles()) {
	    d.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	d.manage().window().maximize();
	
	
	
	FindElement.searchClickableElement(d,"//input[@name='likeclause']/following::img[1]").click();
	Action_Keys.swithtoFrame("ifrm1");
	
	System.out.println("-------->"+"  entered into frame");
	Action_Keys.scrollDown();
	System.out.println("------>"+"  scrolling");
	FindElement.searchClickableElement(d,"//font[contains(text(),'"+requiredString+"')]").click();
	System.out.println("------>"+"  done");
	
}




public static void scrollDown(){
	
	try {
		JavascriptExecutor jse = (JavascriptExecutor)d;
		jse.executeScript("window.scrollBy(0,250)", "");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void scrollToReachAnElement(String xpath){
	try {	
		System.out.println(d);
		WebElement element = d.findElement(By.xpath(xpath));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void calender(String xpathofdob,String month){
	FindElement.searchClickableElement(d, xpathofdob).click();
	for (String winHandle : d.getWindowHandles()) {
	    d.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	Action_Keys.ddown("//select[@name='Month']", month);
	Action_Keys.ddown("//select[@name='Year']", "1988");
	FindElement.searchClickableElement(d,"//font[contains(text(),'15')]").click();
	
	
	
}
@Test
public static String  getDb(String query) throws  ClassNotFoundException, SQLException {	
	
	
		
		try{
			
			 Map<String, String> map = new HashMap<String, String>();
		        BufferedReader in = new BufferedReader(new FileReader((relativePath()+"\\DataBaseSetUp.txt")));
		        String line = "";
		        while ((line = in.readLine()) != null) {
		        	 String[] parts = line.split("=", 2);
		             if (parts.length >= 2)
		             {
		                 String key = parts[0];
		                 String value = parts[1];
		                 map.put(key, value);
		             } else {
		                 System.out.println("ignoring line: " + line);
		             }
		        }
			
			System.out.println("KEYSET------->"+map.keySet());
			
		             for (String key : map.keySet())
		             {
			System.out.println("DB URL------------->"+map.get("dataBaseURL"));
			System.out.println("DB Name------------->"+map.get("dataBaseUserID"));
			System.out.println("DB Password------------->"+map.get("dataBasePassWord"));
			
			String dbUrl =map.get("dataBaseURL");           // "jdbc:postgresql://192.168.0.32/Base_4.8.0";					
	String username = map.get("dataBaseUserID");            //"postgres";	
		String password = map.get("dataBasePassWord");      //"password";	
		String myName=null;
	String query1 =query;// "select acc_no  from dep_mast where acc_no  like'002%' and prd_id=278 order by acc_no desc limit 1";	
String dbName=map.get("typeofDb");
	try {if(dbName.equalsIgnoreCase("postgres")){
		Class.forName("org.postgresql.Driver");
	}
	else if(dbName.equalsIgnoreCase("oracle")){
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	else if(dbName.equalsIgnoreCase("mongodb")){
		Class.forName("com.mongodb.jdbc.MongoDriver");
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
	Connection con = DriverManager.getConnection(dbUrl,username,password);
	Statement stmt = con.createStatement();					
	ResultSet rs= stmt.executeQuery(query1);
	while (rs.next()){
	    		 myName = rs.getString(1);								        
	           	
	            System. out.println(myName+"  ");		
	    }	
	con.close();			

		             	return myName; 	
	}}
	catch(Exception e){
		
	}
	return null;}



public static void inputUsingDb(String testObj, String testData){
	
	WebElement element=FindElement.searchClickableElement(d, testObj);
	WebDriverWait wait = new WebDriverWait(d, 10);
try {
	wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Action_Keys.getDb(testData));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

	
	
}
public static String DatePicker(){
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
	Date date = new Date();
	String currentDate=dateFormat.format(date);
	return currentDate;
}
public static String timePicker(){
	DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
	Date date = new Date();
	String currentDate=dateFormat.format(date);
	return currentDate;
}

public static void dateAsInput(String xpath,String dateFormat,int noofDays){

	try {
		String date1=dateFormat.toLowerCase();
		String date2=null;
		String date3=null;
		if(date1.contains("mm")){
			date2=date1.replace("mm","MM");	
			date3=date2.replace("m","M");
		}
		else{System.out.println("Incoorect date format"); }
		//String date3=date2.replace("m", "M");
		System.out.println(date3);
		Date date = new Date(); 
		date.setDate(date.getDate()+noofDays); 
		SimpleDateFormat df = new SimpleDateFormat(date3); 
		String formattedDate = df.format(date); 
		System.out.println(formattedDate);  
		
		FindElement.searchClickableElement(d, xpath).sendKeys(formattedDate);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public static void screenShotinCaseOfFailed(ITestResult result){
	if(result.getStatus()==ITestResult.FAILURE){
	File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with name "screenshot.png"
    String date=DatePicker();  
    
	 try {
		 
		 FileUtils.copyFile(scrFile, new File("E://screenshots\\"+date+ result.getName()+".png"));
			
	 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		d.switchTo().defaultContent();
		
	}
	
}

public static void clickElementUsingLoop(String xpath){
	try{
	WebElement ele=d.findElement(By.xpath(xpath));
	for(int i=0;i>50;i++){
	boolean x= ele.isDisplayed();
	
	if(x){
		ele.click();
		break;
	}
	else{
		System.out.println(i+"st time not found");
	}
	
	
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public static void clickUsingJavaScript(String xpath){
	
	WebElement element=d.findElement(By.xpath(xpath.trim()));
	JavascriptExecutor js = (JavascriptExecutor)d;
	js.executeScript("arguments[0].click();", element);
}


public static void verifyLinkActive(String linkUrl)
{
try 
{
   URL url = new URL(linkUrl);
   
   HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
   
   httpURLConnect.setConnectTimeout(3000);
   
   httpURLConnect.connect();
   Thread.sleep(3000);
   if(httpURLConnect.getResponseCode()==200)
   {
       System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
    }
  if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
   {
       System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
    }
} catch (Exception e) {
   
}

}



public static void rightClick(String target){
	
	Actions act=new Actions(d);
	
    act.contextClick(FindElement.searchClickableElement(d, target.trim()));
	act.build().perform();
	
}




public static void contextClick(){
	
	Actions act=new Actions(d);
	
    act.contextClick();
    act.build().perform();
	
}

public static void downArrow(String xpath){
	try{
	FindElement.searchClickableElement(d, xpath).sendKeys(Keys.ARROW_DOWN);
}
catch(Exception e){
	e.printStackTrace();
}

}

public static void openNewTab(String xpath){
	try{
		Action_Keys.rightClick(xpath);
		try {
			Robot ro=new Robot();
			
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.delay(2000);
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.delay(2000);
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.delay(2000);
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
catch(Exception e){
	e.printStackTrace();
}}

/*public static void sikuliClick(String imagePath){
	
	p=new Pattern(imagePath);
	
	try {
		s.click(p);
	} catch (FindFailed e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void sikuliEnterText(String text){
s.type(text);
	
}*/

public static void robotScreenShot(String path){
	BufferedImage image;
	try {
		image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	
		ImageIO.write(image, "png", new File(path));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}

public static void verifyTextWithDB(String xpath,String query){
	
	String valueFromUI=FindElement.searchClickableElement(d, xpath).getText();
	
	String valueFromDB = null;
	try {
		valueFromDB = Action_Keys.getDb(query);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try{
	Assert.assertEquals(valueFromUI, valueFromDB);
	}
	catch(Exception e){
		ReportActionKeys.addScreenShotInReport("Expected Value is "+valueFromDB+" But Value on UI is "+valueFromUI);
	}
	
}

public static void goldOrnamentLink(String requiredString,String weight){
	Action_Keys.implictwait(3000);
	String parent=d.getWindowHandle();
	System.out.println(parent+"   ------>parent");
	FindElement.searchClickableElement(d,"//a[@href='javascript:fnGoldLoan()']").click();
	Action_Keys.handle();
	Action_Keys.windowMaximize();
	imageSearch("//img[@src='../img/dacLOVRowSetInfo.gif']", requiredString);
	Action_Keys.input("//input[@id='txtTagNo']", "1");
	Action_Keys.input("//input[@id='txtGwt']", weight);
	Action_Keys.input("//input[@id='quantity']", "1");
	
	
	FindElement.searchClickableElement(d,"//input[@class='Button'][@name='add']").click();
	FindElement.searchClickableElement(d,"//input[@class='Button'][@name='Submit2']").click();
	Action_Keys.AcceptAlret();
	d.switchTo().window(parent);
}


public static void compareTwoStrings(String xpath,String expected){
	Action_Keys.sleep(3000);
	
	try{
	String present=FindElement.searchClickableElement(d, xpath).getText();
	
	try{
		System.out.println(present.trim());
	Assert.assertEquals(present.trim(), expected.trim());
	ReportActionKeys.writeLogInCaseOfPass("String present on UI is "+present+"-->String matched With "+expected);
	ReportActionKeys.writeLogInCaseOfPassInChildTest("String present on UI is "+present+"-->String matched With "+expected);
	}
	catch(Error e){
		e.printStackTrace();
		ReportActionKeys.writeLogInCaseOfFail("Expected String is "+expected+"  but the String present on the screen is "+present);
		ReportActionKeys.addScreenShotInReport(expected+"  Expected String is Not Matched");
		/*ReportActionKeys.writeLogInCaseOfFailInChildTest("Expected String is "+expected+"  but the String present on the screen is "+present);
		ReportActionKeys.addScreenShotInCaseOfFailInReportInChild(expected+"  Expected String is Not Matched");*/
	}}
	catch(Exception e){try {
		throw new Exception("invalid");
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	}
}


	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss/");
		Date date = new Date();
		return dateFormat.format(date);
	}

public static void clickWithJavaExecuter(String id){
	try{
	WebElement element = d.findElement(By.id(id));
	JavascriptExecutor executor = (JavascriptExecutor)d;
	executor.executeScript("arguments[0].click();", element);
	}
	catch(Exception e){e.printStackTrace();}}


public static void clickSilverlight(String xpath){
	
	try {sleep(3000);
		parentwindow=d.getWindowHandle();
		System.out.println("window in click metho----->"+parentwindow);
		sleep(3000);
		Action_Keys.clickWithJavaExecuter(xpath);
		sleep(3000);
		Action_Keys.handle();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


}


public  void closeSilverlight(){
	sleep(3000);
	System.out.println("Child Window---->  "+d.getWindowHandle());
	System.out.println("Parent Window---->  "+parentwindow);
	sleep(3000);
	System.out.println(parentwindow);
	if(!parentwindow.equalsIgnoreCase(d.getWindowHandle())){
		sleep(3000);
	d.close();}
	d.switchTo().window(parentwindow);
	
	
	/* String winHandleBefore = parentwindow;
	 for (String winHandle : d.getWindowHandles()) {
	   // Switch to child window
	   d.switchTo().window(winHandle);
	 }

	// Do some operation on child window and get child window handle.
	String winHandleAfter = d.getWindowHandle();

	//switch to child window of 1st child window.
	for(String winChildHandle : d.getWindowHandles()) {
	  // Switch to child window of the 1st child window.
	  if(!winChildHandle.equals(winHandleBefore) 
	 ) {
	    d.switchTo().window(winChildHandle);
	   }
	 }

	// Do some operation on child window of 1st child window.
	// to close the child window of 1st child window.
	d.close();

	// to close the child window.
	d.close();

	// to switch to parent window.
	d.switchTo().window(winHandleBefore);*/


}

public static void waitFor(int time){
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void mousehover(String movetoele, String clickele){

	Actions act = new Actions(d);
	WebElement a = FindElement.searchClickableElement(d, movetoele);
	WebElement b = FindElement.searchClickableElement(d, clickele);
	act.moveToElement(a).perform();
	implictwait(10000);
	act.moveToElement(b).click().perform();
	
	}


}
