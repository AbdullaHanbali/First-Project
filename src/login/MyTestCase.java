package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase {
	
	WebDriver driver = new ChromeDriver();
	
	String TheURL = "https://automationteststore.com/";
	
	@BeforeTest
	public void mySetup() {
		driver.get(TheURL);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void signUp() {
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");
		
		//Elements
		WebElement userNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement lastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement telephoneInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement faxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement companyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement address1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement address2Input = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));
		
		//Data
		String firstName = "Abdullah";
		String lastName = "Hanbali";
		String email = "Abdullah@gmail.com";
		String telephone = "0790411538";
		String fax = "0790411538" ;
		String company = "Hanbali Limited";
		String address1 = "Shafa Badran";
		String address2 = "Shafa Badran";
		String city = "Amman";

		//Actions
		userNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys("Abdullah@gmail.com");
		telephoneInput.sendKeys(telephone);
		faxInput.sendKeys(fax);
		companyInput.sendKeys(company);
		address1Input.sendKeys(address1);
		address2Input.sendKeys(address2);
		cityInput.sendKeys(city);
	}
}
