public class PerformTests {
	
	public static void main(String[] args) throws Exception{
		/* KEYWORD DRIVEN PRACTICE */
		
		DemoActions myActions = new DemoActions();
		DemoValidations myValidations = new DemoValidations();
		
		myActions.invokeBrowser();
		
		String sPath = "C:\\other\\demo.xlsx";
		ExcelUtils.setExcelFile(sPath, "Sheet1");
		
		for (int iRow = 0; iRow <= 1; iRow++) {
			String sActionKeyword = ExcelUtils.getCellData(iRow,0);
						
			switch (sActionKeyword) {
			case "OpenSite":
				myActions.OpenSite("http://automationpractice.com/");
				break;
			case "ValidateTitle":
				System.out.println(myValidations.ValidateTitle(myActions.driver,"My Store"));
				break;
			}
		}
	}

}

/* ----------------------------------------------------------  */

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;


public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static void setExcelFile (String path, String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream (path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
	}
	
	public static String getCellData (int row, int column) {
		Cell cell = sheet.getRow(row).getCell(column);
		String cellData = cell.getStringCellValue();
		return cellData;
	}
}

/* ----------------------------------------------------------  */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoActions {
	WebDriver driver;
	WebElement element;
	Actions action;

	//JavaScriptExecutor jse;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rajeshg\\OneDrive - AMDOCS\\Backup Folders\\Desktop\\Other\\Java_Work\\chromedriver_win32\\new\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void OpenSite(String theurl) {
		//invokeBrowser();
		try {
			driver.get(theurl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
  public boolean ValidateTitle(WebDriver driver, String title) {
		return (driver.getTitle().equals(title));
	}
  
}

