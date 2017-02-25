package zooAdopTestsRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdoptionPage extends AbstractPage {
	public AdoptionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
}
	public AdoptionPage selectFromDropdown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='start_select']")));
		dropdown.selectByIndex(2);
		return new AdoptionPage(driver);
	}
	
	public AdoptionPage clickOnCheckButton()
	{
		driver.findElement(By.xpath(".//*[@id='check_btn_02']")).click();
		return new AdoptionPage(driver);
	}
	
	public AdoptionPage submitAdoption()
	{
		driver.findElement(By.xpath(".//*[@id='submit_adoption']")).click();;
		return new AdoptionPage(driver);
	}
}
