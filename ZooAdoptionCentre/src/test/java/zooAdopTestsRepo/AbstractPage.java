package zooAdopTestsRepo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AbstractPage {
	
	public WebDriver driver;

public AbstractPage(WebDriver driver)
{
this.driver = driver;
}
public LandingPage navigatetoWebsite() throws InterruptedException
{
	//System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
	//System.setProperty("webdriver.chrome.driver", "C://Program Files//chromedriver_win32//chromedriver.exe");
	//driver.navigate().to("http://www.thetestroom.com/webapp/index.html");
	driver.get("http://www.thetestroom.com/webapp/index.html");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    //second commit
	return new LandingPage(driver);
}

public void closebrowser() throws InterruptedException
{
 driver.quit();	 
}
}
