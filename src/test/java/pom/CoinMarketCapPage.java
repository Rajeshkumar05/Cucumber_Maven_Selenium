package pom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;


public class CoinMarketCapPage {
	
	WebDriver driver;
	public CoinMarketCapPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(xpath="//button[contains(text(),'20')]") 
    WebElement row;
		 	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]")
	WebElement filters;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]")
	WebElement algorithm;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]")
	WebElement pow;
	
	@FindBy(xpath="//button[text()='Add Filter']")
	WebElement addFilter;
	
	@FindBy(xpath="//label[@id='mineable']")
	WebElement mineable;
	
	@FindBy(xpath="//button[text()='All Cryptocurrencies']")
	WebElement allCryptocurrencies;
	
	@FindBy(xpath="//button[text()='Coins']")
	WebElement coins;
	
	@FindBy(xpath="//button[text()='Price']")
	WebElement price;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement priceText1;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement priceText2;
	
	@FindBy(xpath="//button[text()='Apply Filter']")
	WebElement applyFilter;
	
	@FindBy(xpath="//button[text()='Show results']")
	WebElement showresults;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]")
	WebElement controlOnRow;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")
	WebElement controlOnPow;
	
	
	
	 @FindBy(xpath="//p[contains(text(),'Name')]//following::p[@class='sc-e225a64a-0 ePTNty']")
	 List<WebElement> availableName;
	 
	 @FindBy(xpath="//p[contains(text(),'Price')]//following::div[@class='sc-8bda0120-0 dskdZn']")
	 List<WebElement> availablePrice;
	
	public void row()
	{
		row.click();
	}
	
	public void filters()
	{
		filters.click();
	}
	
	public void algorithm()
	{
		algorithm.click();
	}
	
	public void pow()
	{
		pow.click();
	}
	
	public void addFilter()
	{
		addFilter.click();
	}
	
	public void mineable()
	{
		mineable.click();
	}
	
	public void allCryptocurrencies()
	{
		allCryptocurrencies.click();
	}
	
	public void coins()
	{
		coins.click();
	}
	
	public void price()
	{
		price.click();
	}
	
	public void priceText1()
	{
		priceText1.sendKeys("100");
	}
	
	public void priceText2()
	{
		priceText2.sendKeys("10000");
	}
	
	public void applyFilter()
	{
		applyFilter.click();
	}
	
	public void showresults()
	{
		showresults.click();
	}
	
	public void controlOnRow() 
	{
		Actions act=new Actions(driver);
	    act.moveToElement(controlOnRow).click().build().perform();
	}
	
	public void controlOnPow()
	{
		Actions act=new Actions(driver);
	    act.moveToElement(controlOnPow).click().build().perform();
	}
	
	public List<WebElement> availableName()
	{
		return availableName;
		
	}
	
	public List<WebElement> availablePrice()
	{
		return availablePrice;
		
	}
	

}
