package ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
Properties po;
	
public  Utility() throws Exception
	{
		File src=new File("src\\test\\java\\ObjectRepository\\Configuration.property");
		FileInputStream fis=new FileInputStream(src);
		po=new Properties();
		po.load(fis);
			
		}
	
public String getChromePath()
	{
	  return po.getProperty("ChromeDriver");
	}
	
public String getUrl()
	{
		return po.getProperty("URL");
	}

public String getLog4jConfigure()
{
	return po.getProperty("Log4jConfigure");
}

}
