package zooAdopTestsRepo;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends AbstractPage{

	public ContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
public ContactPage setNameField(String valuename)
{
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.name("name_field")).sendKeys(valuename);
	return new ContactPage(driver);
	}

public ContactPage setAddressField(String value)
{
	driver.findElement(By.name("address_field")).sendKeys(value);
	return new ContactPage(driver);
}

public ContactPage setPostcodeField(String value)
{
	driver.findElement(By.name("postcode_field")).sendKeys(value);
	return new ContactPage(driver);
}

public ContactPage setEmailField(String value)
{
	driver.findElement(By.name("email_field")).sendKeys(value);
	return new ContactPage(driver);

}
public ContactConfPage submitForm()
{
	driver.findElement(By.id("submit_message")).click();
	
	return new ContactConfPage(driver);
}

}
