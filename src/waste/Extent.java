package waste;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import actions.Action_Keys;
import actions.ReportActionKeys;
import testBase.TestBase;

public class Extent extends TestBase{
	
	public static void main(String[] args) {
		
	
	//ExtentReports extent = new ExtentReports("C:\\Users\\sgarlapati\\git\\wings\\Report\\test.html");
			  //ExtentTest parent = extent.startTest("Parent");

			  ReportActionKeys obj=new ReportActionKeys();
			  obj.setReportLocation("ParentChildReport");
			  obj.startTest("Parent");
			  obj.appendToExstingReport("ChildTest");
			  obj.appendToExstingReport("ChildTest1");
			  /*ExtentTest child = extent.startTest("ChildTest ");
			  child.log(LogStatus.SKIP, "Skip");

			  ExtentTest child1 = extent.startTest("Child 1");
			  child1.log(LogStatus.PASS, "Pass");

			  ExtentTest child2 = extent.startTest("Child 2");
			  child2.log(LogStatus.PASS, "Pass");


			  extent.endTest(child);
			  parent
			   .appendChild(child);
			  extent.endTest(child1);
			  extent.endTest(child2);

			  
			     parent .appendChild(child1);
			     parent .appendChild(child2);
*/

			 obj.endParent();

			  obj.writeLogToReport();
			 }
}
