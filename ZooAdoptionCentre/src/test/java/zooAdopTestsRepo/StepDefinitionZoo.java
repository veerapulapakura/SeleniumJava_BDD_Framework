package zooAdopTestsRepo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionZoo {
	
//WebDriver driver = new ChromeDriver();
WebDriver driver;

//File pathBinary = new File("C:\\program files\\Mozilla Firefox\\firefox.exe");
//FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//FirefoxProfile firefoxProfile = new FirefoxProfile();       
//WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);

LandingPage landingpage;
ContactPage contactpage;
AdoptionPage adoptionPage;
ContactConfPage contactconfpage;
AdoptionConfPage adoptionConfPage;
AboutPage aboutPage;

//  Scenario one Lanching the main page 

public StepDefinitionZoo() throws FileNotFoundException{
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\VP1\\workspace\\ZooAdoptionCentre\\browser.properties");
	try {
		prop.load(fis);
		if(prop.getProperty("browser").equals("firefox"))
		{
	System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
	System.setProperty("webdriver.firefox.bin", "C:\\program files\\Mozilla Firefox\\firefox.exe");
	driver = new FirefoxDriver();
	adoptionPage = new AdoptionPage(driver);
	contactconfpage = new ContactConfPage(driver);
	adoptionConfPage = new AdoptionConfPage(driver);
	aboutPage = new AboutPage(driver);
}
		else if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			adoptionPage = new AdoptionPage(driver);
			contactconfpage = new ContactConfPage(driver);
			adoptionConfPage = new AdoptionConfPage(driver);
			aboutPage = new AboutPage(driver);
		}
		
		else
		{
			/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");

			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
			
			System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
			System.setProperty("webdriver.ie.driver","C:\\Program Files\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			adoptionPage = new AdoptionPage(driver);
			contactconfpage = new ContactConfPage(driver);
			adoptionConfPage = new AdoptionConfPage(driver);
			aboutPage = new AboutPage(driver);
			
		}
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}


@Given("^I am on the Zoo site$")
public void I_am_on_the_Zoo_site() throws Throwable
{
	landingpage = new LandingPage(driver);
	landingpage.navigatetoWebsite();
	//throw new PendingException();
	}

@When("^I click on \"([^\"]*)\"$")
public void  I_click_on_contact(String link) throws Throwable
{
	contactpage = landingpage.navigatetoContactPage(link);
	
}
@And("^i enter \"([^\"]*)\" into the name field$")

public void i_enter_Name_Test_into_the_name_field(String value) throws Throwable
{
	contactpage.setNameField(value);
}
@And("^i enter \"([^\"]*)\" into the Address field$")

public void I_enter_into_the_address_field(String value) throws Throwable
{
	contactpage.setAddressField(value);

}
@And("^i enter \"([^\"]*)\" into the Postcode field$")

public void I_enter_into_the_Postcode_field(String value) throws Throwable
{
	contactpage.setPostcodeField(value);

}

@And("^i enter \"([^\"]*)\" into the Email field$")

public void I_enter_into_the_email_field(String value) throws Throwable
{
	contactpage.setEmailField(value);
}

@And("^i submit the contact form$")
public void i_submit_the_contact_form() throws Throwable
{
	contactpage.submitForm();
	}


@Then("^I check i am on the confirmation page$")
public void I_check_I_am_In_confirmationPage() throws Throwable
{      
    	Assert.assertTrue(contactconfpage.getPageTitle().contains("We have your message"));
	}

@And("^i close the browser$")
public void i_close_the_browser() throws Throwable
{
	//contactconfpage.closebrowser();
	landingpage.closebrowser();
	
}
//                                                                  Adoption test steps 

@When("^i click on \"([^\"]*)\" form the dropdown menu$")
public void i_click_on_form_the_dropdown_menu(String arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
	adoptionPage.selectFromDropdown();
}

@And("^i click on \"([^\"]*)\" for turtle$")
public void i_click_on_for_turtle(String arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had  .//*[@id='check_btn_02']
	adoptionPage.clickOnCheckButton();
}

@And("^i click on the check button$")
public void i_click_on_the_check_button() throws Throwable {
    // Express the Regexp above with the code you wish you had
    //throw new PendingException();
	adoptionPage.submitAdoption();
}

@Then("^I check i am on the adoption setup page$")
public void I_check_I_am_on_the_adoption_setup_page() throws Throwable
{
    //Thread.sleep(25000);
	Assert.assertTrue(adoptionConfPage.adoptionSetup().contains("YOUR ADOPTION HAS BEEN SET UP"));
	
}
//                                                                  About Page  

@Then("^I check i am on the about page$")
public void I_check_i_am_on_the_about_page() throws Throwable {
    // Express the Regexp above with the code you wish you had
	Assert.assertTrue(aboutPage.getPageTitle().contains("They are waiting for you."));
}
}



