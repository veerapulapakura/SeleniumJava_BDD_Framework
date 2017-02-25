package zooAdopTestsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractPage{

	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public ContactPage navigatetoContactPage(String link) throws InterruptedException
{
	Thread.sleep(3000);
	driver.findElement(By.id(link.toLowerCase()+"_link")).click();
	//driver.findElement(By.id("contact_link")).click();
	//Thread.sleep(5000);
	return new ContactPage(driver);
	}
}
