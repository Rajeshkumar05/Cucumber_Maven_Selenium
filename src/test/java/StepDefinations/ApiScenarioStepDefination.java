package StepDefinations;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ObjectRepository.Utility;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import ObjectRepository.GetPrice;

public class ApiScenarioStepDefination {

	Utility utility;
	private static Logger Log = Logger.getLogger(ApiScenarioStepDefination.class.getName());
	String firstConversion;
	GetPrice getPrice;

	@Before
	public void setup() throws Exception{
		utility=new Utility();
		getPrice = new GetPrice();
		DOMConfigurator.configure(utility.getLog4jConfigure());
	}

	@Given("^I set the base URI$")
	public void i_set_the_base_URI() throws Throwable {
		Log.info("Execution of ApiScenario Started");
		RestAssured.baseURI = utility.getUri();
	}

	@When("^I convert the price of Guatemalan Quetzal to British Pound$")
	public void i_convert_the_price_of_Guatemalan_Quetzal_to_British_Pound() throws Throwable {
		double amountValue =utility.amount();
		firstConversion = getPrice.getPrice(amountValue,utility.guatemalanQuetzal(),utility.britishPound());
		Log.info( "GTQ to GBP = " + firstConversion);	
	}

	@Then("^I convert the Received British Pound to doge coin$")
	public void i_convert_the_Received_British_Pound_to_doge_coin() throws Throwable {
		double amountValue  = Double.parseDouble(firstConversion);
		String finalConversion = getPrice.getPrice(amountValue,utility.britishPound(),utility.dogeCoin());
		Log.info("GBP to DOGE = " +finalConversion);		
	}

	@Then("^I validated the status code$")
	public void i_validated_the_status_code() throws Throwable {
		int code=getPrice.getResponseCode();
		Log.info("Response code value is " +code);
		Log.info("Execution of APIScenario Stopped");
	}
}
