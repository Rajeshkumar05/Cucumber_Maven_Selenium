package StepDefination1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import pom.WebelementByFindBy;

public class Sample {
	
    WebDriver driver; 
	WebelementByFindBy web;
	private static Logger Log = Logger.getLogger(Sample.class.getName());
	
	
 @Before
public void setup(){
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\raselvam\\Downloads\\selenium\\chromedriver.exe"); 
	 driver = new ChromeDriver();
	 web=PageFactory.initElements(driver, WebelementByFindBy.class);
	 DOMConfigurator.configure("C:\\Rajesh\\eclipse-workspace\\Cucumber_Maven_Selenium\\src\\test\\resources\\log4j.xml");
	}
		
@Given("^I open the coin market application$")
public void i_open_the_coin_market_application() throws Throwable {
	 driver.get("https://coinmarketcap.com/");
	 driver.manage().window().maximize();
	 driver.navigate().refresh();
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     }

@When("^I select (\\d+) row$")
public void i_select_row(int arg1) throws Throwable {
	  web.controlOnRow();
	  web.row();
	  }

@Then("^I capture required page content$")
public void i_capture_required_page_content() throws Throwable {
     JavascriptExecutor je=(JavascriptExecutor) driver;
	 je.executeScript("scroll(0,1000)");
     List<WebElement> availableName= web.availableName();
     Log.info("Number of available names are: "+availableName.size());
     for(WebElement name:availableName) { 
         Thread.sleep(2000);
    	   String availableNameDetail=name.getText(); 
    	   Thread.sleep(3000);
		     Log.info("Available names are :"+availableNameDetail); 
		 } 
	   List<WebElement> availablePrice= web. availablePrice();
	   Log.info("Number of available prices are:"+availablePrice.size());
	   for(WebElement price:availablePrice) { 
	       Thread.sleep(2000);
		     String availablePriceDetail=price.getText(); 
		     Thread.sleep(3000);
		     Log.info("Available prices are :"+availablePriceDetail); 
		  }
	 }

@When("^I set filter on the page by Algorithm as PoW$")
public void i_set_filter_on_the_page_by_Algorithm_as_PoW() throws Throwable {
     web.filters();
     web.algorithm();
	 web.controlOnPow();
     web.pow();
     }

@When("^I add more filters$")
public void i_add_more_filters() throws Throwable {
	web.addFilter();
	web.mineable();
	Thread.sleep(2000);
	web.allCryptocurrencies(); 
	web.coins();
	web.price();
	web.priceText1();
	web.priceText2();
	web.applyFilter();
	Thread.sleep(2000);
	web.showresults();    
    }

@Then("^I capture filter content and compare with previous content$")
public void i_capture_filter_content_and_compare_with_previous_content() throws Throwable {
     List<WebElement> filterName= web.availableName();
     Log.info("Number of Filter names are: "+filterName.size());
	   for(WebElement name:filterName) {
		     String filterNameDetail=name.getText();
		     String availableNameDetail="Bitcoin"; 
			if(filterNameDetail.contentEquals(availableNameDetail)) { 
			   Log.info(filterNameDetail + " available from 20 row list");
			   }
			 else{
				Log.info(filterNameDetail+ " Does not available from the list of 20 rows");
			   }
	   }
    }	
}
