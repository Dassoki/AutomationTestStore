package LoginPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	
	WebDriver driver = new ChromeDriver(); 
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create"; 
	Random rand = new Random();
	
	
	@BeforeTest
	public void mySetup() {
		driver.get(theURL);
		
		driver.manage().window().maximize();
		
	}
	
	
	@Test(priority = 1)
	public void Signup() throws InterruptedException {
		
		driver.navigate().to(SignupPage);
		//element
		WebElement FirstNameInput = driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
		WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement TelephoneInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement FaxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement CompanyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement Address1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement Address2Input = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PassowrdInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement Passowrd2Input = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement CheckBoxInput = driver.findElement(By.id("AccountFrm_agree"));
		WebElement CointnueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		WebElement CountrySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateSelect = driver.findElement(By.id("AccountFrm_zone_id"));
		//data
		String [] FirstName = {"Abdulrahman" , "Abdllah" , "Ali" , "Samer"};
		int randomIndexForFirstNames = rand.nextInt(FirstName.length);
		
		String RandomFirstNames = FirstName[randomIndexForFirstNames];
		
		String [] LastName = {"AlSammer" , "AlAbdullah" , "Bassam" , "Nizar"};
		int randomIndexLastNames = rand.nextInt(LastName.length);
		
		String RandomLastNames = LastName[randomIndexLastNames];
		
		
		int randomnumberfortheemail = rand.nextInt(7000);
		String Email = RandomFirstNames+RandomLastNames+randomnumberfortheemail+"@gmail.com";
		String Telephone = "07777777";
		String Fax = "555214";
		String Company = "iTchjo";
		String Address1= "Amman";
		String Address2= "Abdoun";
		String City = "AmmanGov";
		String PostalCode = "12254";
		String Login = RandomFirstNames+RandomLastNames;
		String Password = "Test@12345";
		
		//action
		FirstNameInput.sendKeys(RandomFirstNames);
		LastNameInput.sendKeys(RandomLastNames);
		EmailInput.sendKeys(Email);
		TelephoneInput.sendKeys(Telephone);
		FaxInput.sendKeys(Fax);
		CompanyInput.sendKeys(Company);
		Address1Input.sendKeys(Address1);
		Address2Input.sendKeys(Address2);
		CityInput.sendKeys(City);
		
		
		Select MySelectionForCountry = new Select(CountrySelect);
		Select MySelectionForState = new Select(StateSelect);
		
		
		int numberOfCountries = CountrySelect.findElements(By.tagName("option")).size();
		int RandomCountryIndex = rand.nextInt(1,numberOfCountries);
		MySelectionForCountry.selectByIndex(RandomCountryIndex);
		
		Thread.sleep(1000);
		
		int numberOfOptionState = StateSelect.findElements(By.tagName("option")).size();
		int RandomStateIndex = rand.nextInt(1,numberOfOptionState);
		MySelectionForState.selectByIndex(RandomStateIndex);
		
		
		PostalCodeInput.sendKeys(PostalCode);
		LoginInput.sendKeys(Login);
		PassowrdInput.sendKeys(Password);
		Passowrd2Input.sendKeys(Password);
		CheckBoxInput.click();
		CointnueButton.click();
	}

	
	
}
