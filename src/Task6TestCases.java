import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Task6TestCases {
	
	
			WebDriver driver = new ChromeDriver(); //
			String theURL = "https://www.saucedemo.com/inventory.html\r\n";
			
			String TheExpectedTheLowestPrice="$7.99";
			String ExpectedTitle = "Products";

	
	
	@BeforeTest
	public void SteUp ()
	
	{
		String MyURL="https://www.saucedemo.com/";
		driver.get(MyURL);
		
	//	driver.manage().window().fullscreen();
	}

	
	@Test(priority = 1) 
	
	public void Log_in () throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");;///place to write
		driver.findElement(By.id("password")).sendKeys("secret_sauce");;
		driver.findElement(By.id("login-button")).click();
	}
	

	
	@Test (priority = 2)

		public void verifiyTheWordProductIsThere()
		{
//			driver.get(theURL);
//		
//		String ThaActualTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
//		//*****************************************************************
//		String ThaActualTitleA = driver.findElement(By.xpath("//span[@data-test='title']")).getText();// ENG ABED 
//		
//		System.out.println(ThaActualTitle);
//		System.out.println(ThaActualTitleA);
//		System.out.println(ExpectedTitle);
//		
//		assertEquals( ThaActualTitle, ExpectedTitle);
//		assertEquals( ExpectedTitle,ThaActualTitle);
		
		WebElement theMainName =driver.findElement(By.xpath("//span[@data-test='title']"));
		boolean expectedResulat = true;//change to false to check 
		boolean actualIfTheElementThere = theMainName.isDisplayed();//actual
		
		Assert.assertEquals(actualIfTheElementThere, expectedResulat);
		
		//************************************************
		
		
		
		
		
		}

	/////////////////////////
	@SuppressWarnings("unlikely-arg-type")
	@Test (priority = 3)
	
	public void SortingItems() throws InterruptedException, IndexOutOfBoundsException
	{
		Thread.sleep(1000);
		WebElement webElement= driver.findElement(By.className("product_sort_container"));
		Select mySelector = new Select(webElement);
		
	
		


		mySelector.selectByVisibleText("Price (low to high)");
		
		List<WebElement> thePrices = driver.findElements(By.className("inventory_item_price"));
		
			String High = thePrices.get(thePrices.size()-1).getText().replace("$", "");
			String Low= thePrices.get(0).getText().replace("$", "");
			
		System.out.println(thePrices.size());
		System.out.println(High);
		System.out.println(Low);
	
		System.out.println(thePrices.isEmpty());
		System.out.println(thePrices.size()-1);
			
			
			double  theHighestPrice = Double.parseDouble(High); 
			double theLowestPrice = Double.parseDouble(Low);
	//		
	
		System.out.println(theHighestPrice);
		System.out.println(theLowestPrice);
		boolean expectedValue = true ; 
			
		Assert.assertEquals(theHighestPrice>theLowestPrice, expectedValue,"if the highest price is higher than the lowest price this should return true ");
		
		
		
		
		
				}
				
				
				
				
	
	}
	
	
	



