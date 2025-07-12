package login;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase {
	
	WebDriver driver = new ChromeDriver();
	
	String username;
	String loginPassword = "Abdullah997";
	
	
	
	String TheURL = "https://automationteststore.com/";
	
	Random rand = new Random();
	
	@BeforeTest
	public void mySetup() {
		driver.get(TheURL);
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void signUp() throws InterruptedException {
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
		WebElement countryInput = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement zipCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement stateInput = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement confirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement checkBox = driver.findElement(By.id("AccountFrm_newsletter1"));
		WebElement agreeButton = driver.findElement(By.id("AccountFrm_agree"));
		WebElement continueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		
		
		//Data
		//Static Array
		String[] firstNames = {"Abdullah","Omar","Yazan","Ali"};
		String[] lastNames = {"Hanbali","Alawneh","Khalaf","Hammad"};
		
		
		
		int randomFirstNameIndex = rand.nextInt(firstNames.length);
		int randomLastNameIndex = rand.nextInt(lastNames.length);
		int randomEmailNumber = rand.nextInt(9999)+100;
		int randomCountry = rand.nextInt(1,140);
	

		
		
		String randomFirstName = firstNames[randomFirstNameIndex];
		String randomLastName = lastNames[randomLastNameIndex];
		String email = randomFirstName +"_"+ randomLastName + randomEmailNumber + "@gmail.com";
		String telephone = "Phone Number";
		String fax = "Fax Number" ;
		String company = "Company";
		String address1 = "Address 1";
		String address2 = "Address 2";
		String zipCode = "Zip Code";
		username = randomFirstName + randomLastName +randomEmailNumber ;
		String password = loginPassword ;
		String confirmPassword = loginPassword;
		
		
		
		
		//Actions
		userNameInput.sendKeys(randomFirstName);
		lastNameInput.sendKeys(randomLastName);
		emailInput.sendKeys(email);
		telephoneInput.sendKeys(telephone);
		faxInput.sendKeys(fax);
		companyInput.sendKeys(company);
		address1Input.sendKeys(address1);
		address2Input.sendKeys(address2);
		cityInput.sendKeys("city");
		
		Select countrySelect = new Select(countryInput);
		countrySelect.selectByIndex(randomCountry);
		
		Thread.sleep(3000);
		
		int stateNumber = stateInput.findElements(By.tagName("option")).size();
		Select stateSelect = new Select(stateInput);
		int randomState = rand.nextInt(1,stateNumber);
		stateSelect.selectByIndex(randomState);
		
		zipCodeInput.sendKeys(zipCode);		
		loginNameInput.sendKeys(username);
		passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
		checkBox.click();
		agreeButton.click();
		continueButton.click();
			
	}
	
	@Test(priority = 2)
	public void Logout() throws InterruptedException {
		WebElement Logout = driver.findElement(By.linkText("Logoff"));
		
		Thread.sleep(2000);
		Logout.click();
		
	}
	
	@Test(priority = 3)
	public void Login() throws InterruptedException {
	
		WebElement LoginAndRegister = driver.findElement(By.linkText("Login or register"));
		
	
		LoginAndRegister.click();
		
		WebElement loginInput = driver.findElement(By.id("loginFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("loginFrm_password"));
		
		loginInput.sendKeys(username);
		passwordInput.sendKeys(loginPassword);
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@title='Login']"));	
		loginButton.click();
	
		
		
	}
}
