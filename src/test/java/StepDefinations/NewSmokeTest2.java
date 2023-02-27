package StepDefination1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewSmokeTest2 {
	
	WebDriver driver; 
	
	
	@Given("^Open chrome with start application$")
	public void open_chrome_with_start_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\raselvam\\Downloads\\selenium\\chromedriver.exe"); 
		 driver = new ChromeDriver();
		 driver.get("https://coinmarketcap.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    
	}

	@When("^show rows$")
public void show_rows() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element=driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[3]")).click();
	    Thread.sleep(3000);
	   
	}

	@Then("^capture all page contents$")
	public void capture_all_page_contents() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> available=driver.findElements(By.xpath("//p[contains(text(),'#')]//following::p[@class='sc-e225a64a-0 ePTNty']"));
		System.out.println("Number of available names are:"+available.size());
				for(WebElement name:available)
				{
					String nameDetail=name.getText();
					Thread.sleep(3000);
					System.out.println("Available names are :"+nameDetail);
				}
				
				List<WebElement> available1=driver.findElements(By.xpath("//p[contains(text(),'Price')]//following::div[@class='sc-8bda0120-0 dskdZn']"));
		System.out.println("Number of available price are:"+available1.size());
				for(WebElement price:available1)
				{
					String priceDetail=price.getText();
					Thread.sleep(3000);
					System.out.println("Available names are :"+priceDetail);
				}
				
	   
	}

	@Then("^filter by Algorith PoW$")
	public void filter_by_Algorith_PoW() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]")).click();
		WebElement element1=driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"));
		Actions act1=new Actions(driver);
		act1.moveToElement(element1).click().build().perform();
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]")).click();
	    Thread.sleep(3000);
	   
	}

	@Then("^add Filter$")
	public void add_Filter() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[text()='Add Filter']")).click();
		  Thread.sleep(3000);
	   
	}

	@Then("^press Mineable$")
	public void press_Mineable() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//label[@id='mineable']")).click();
		  Thread.sleep(3000);
	   
	}

	@Then("^select Coins$")
	public void select_Coins() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[text()='All Cryptocurrencies']")).click(); 
		  driver.findElement(By.xpath("//button[text()='Coins']")).click();
		   Thread.sleep(3000);
	    
	}

	@Then("^select price$")
public void select_price() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[text()='Price']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("100");
		  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("10000");
		  driver.findElement(By.xpath("//button[text()='Apply Filter']")).click();
		  driver.findElement(By.xpath("//button[text()='Show results']")).click();
		  Thread.sleep(3000);
	    
	   
	}

	@Then("^compare the content$")
	public void compare_the_content() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> filter=driver.findElements(By.xpath("//p[contains(text(),'#')]//following::p[@class='sc-e225a64a-0 ePTNty']"));
		  System.out.println("Number of Filter names are:"+filter.size());
		  for(WebElement name:filter) 
		  {
			  String nameDetail=name.getText();
		  System.out.println("Filter names are :"+nameDetail);
		  
		  }
		  
		   List<WebElement> filter1=driver.findElements(By.xpath("//p[contains(text(),'Price')]//following::div[@class='sc-8bda0120-0 dskdZn']"));
		  System.out.println("Number of Filter names are:"+filter1.size());
		  for(WebElement price:filter1) 
		  {
			  String priceDetail=price.getText();
		  System.out.println("Filter price are :"+priceDetail);
		  
		  }
		  
	   
   
	}
}
