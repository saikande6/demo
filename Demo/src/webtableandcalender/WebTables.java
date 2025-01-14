package webtableandcalender;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTables {

WebDriver d;
	
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
	    d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://www.webdatacommons.org/webtables/");
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@Test
	public void dynamicTable()throws Exception
	{
		//Checks for Table row Count
		List<WebElement> tr_collection=d.findElements(By.xpath("//div[@id='toccontent']/table[1]/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		
		
		
		int row_num,col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            //System.out.println("NUMBER OF COLUMNS="+row_num+" "+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
               
            	System.out.println("Row # "+row_num+", Col # "+col_num  + ", Text=" +tdElement.getText());
                col_num++;
                //td_collection=trElement.findElements(By.xpath("td"));
            }
            row_num++;
        }
       // Thread.sleep(4000);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		//d.quit();
	}

}


