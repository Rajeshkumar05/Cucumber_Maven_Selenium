package StepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import ObjectRepository.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CoinMarketCapPage;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class UIScenarioStepDefination {
	Utility utility;
    WebDriver driver; 
	CoinMarketCapPage coinMarketCapPage;
	private static Logger Log = Logger.getLogger(UIScenarioStepDefination.class.getName());
	
	
 @Before
public void setup() throws Exception{
	 utility=new Utility();
	 System.setProperty("webdriver.chrome.driver",utility.getChromePath()); 
	 driver = new ChromeDriver();
	 coinMarketCapPage=PageFactory.initElements(driver, CoinMarketCapPage.class);
	 DOMConfigurator.configure(utility.getLog4jConfigure());
	}
		
@Given("^I open the coin market application$")
public void i_open_the_coin_market_application() throws Throwable {
	 driver.get(utility.getUrl());
	 driver.manage().window().maximize();
	 driver.navigate().refresh();
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     }

@When("^I select (\\d+) row$")
public void i_select_row(int arg1) throws Throwable {
	coinMarketCapPage.controlOnRow();
	coinMarketCapPage.row();
	  }

@Then("^I capture required page content$")
public void i_capture_required_page_content() throws Throwable {
     JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
     javascriptExecutor.executeScript("scroll(0,1000)");
     List<WebElement> availableName= coinMarketCapPage.availableName();
     Log.info("Number of available names are: "+availableName.size());
     Thread.sleep(3000);
     for(WebElement name:availableName) { 
    	   String availableNameDetail=name.getText(); 
		   Log.info("Available names are :"+availableNameDetail); 
		 } 
	   List<WebElement> availablePrice= coinMarketCapPage.availablePrice();
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
	coinMarketCapPage.filters();
	coinMarketCapPage.algorithm();
	coinMarketCapPage.controlOnPow();
	coinMarketCapPage.pow();
     }

@When("^I add more filters$")
public void i_add_more_filters() throws Throwable {
	coinMarketCapPage.addFilter();
	coinMarketCapPage.mineable();
	Thread.sleep(2000);
	coinMarketCapPage.allCryptocurrencies(); 
	coinMarketCapPage.coins();
	coinMarketCapPage.price();
	coinMarketCapPage.priceText1();
	coinMarketCapPage.priceText2();
	coinMarketCapPage.applyFilter();
	Thread.sleep(2000);
	coinMarketCapPage.showresults();    
    }

@Then("^I capture filter content and compare with previous content$")
public void i_capture_filter_content_and_compare_with_previous_content() throws Throwable {
     List<WebElement> filterName= coinMarketCapPage.availableName();
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

@After
public void end() throws Exception{
	Thread.sleep(2000);
	 driver.close();
}


}
