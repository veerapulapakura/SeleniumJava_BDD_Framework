package zooAdopTestsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdoptionConfPage extends AbstractPage{

	public AdoptionConfPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
}
	public String adoptionSetup()
	{
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[2]/td[2]/p")).getText();
		//return driver.findElement(By.cssSelector(".content hi")).getText();
		//System.out.println("i am in ");
		}
	
}

