package ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
Properties properties;
	
public  Utility() throws Exception
	{
		File src=new File("src\\test\\java\\ObjectRepository\\Configuration.property");
		FileInputStream fis=new FileInputStream(src);
		properties=new Properties();
		properties.load(fis);
			
		}
	
public String getChromePath()
	{
	  return properties.getProperty("ChromeDriver");
	}
	
public String getUrl()
	{
		return properties.getProperty("URL");
	}

public String getLog4jConfigure()
{
	return properties.getProperty("Log4jConfigure");
}

public String guatemalanQuetzal()
{
	return properties.getProperty("GuatemalanQuetzal");
}

public String britishPound()
{
	return properties.getProperty("BritishPound");
}

public String dogeCoin()
{
	return properties.getProperty("DogeCoin");
}

public String getUri()
{
	return properties.getProperty("URI");
}

public double amount()

{
	String amount=properties.getProperty("Amount");
	double doubleValue=Double.parseDouble(amount);
	return doubleValue;
}
}
