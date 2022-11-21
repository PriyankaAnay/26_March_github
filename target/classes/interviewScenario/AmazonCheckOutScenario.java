package interviewScenario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonCheckOutScenario {


	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver= new ChromeDriver();
	
	driver.manage().window().maximize();
		
	driver.get("https://www.amazon.com/");
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	String phone="iphone 11";
	
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	//div[@class="autocomplete-results-container"]/div[3]

	List<WebElement> AllMobilelist = driver.findElements(By.xpath("//div[@class=\"autocomplete-results-container\"]/div[3]/div/div"));
	Thread.sleep(2000);
	for(WebElement preticlularMob:AllMobilelist)
	{
		String Desireelement = preticlularMob.getText();
		if(Desireelement.equalsIgnoreCase(phone))
		{
			preticlularMob.click();
			break;
		}
	}
	String ExpectePrice="59,661.77";
	driver.findElement(By.xpath("(//span[text()=\"Total by Verizon iPhone 11, 64GB, Black - Prepaid Smartphone (Locked)\"])[2]")).click();
	driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]")).click();
	driver.findElement(By.xpath("//input[@name=\"proceedToRetailCheckout\"]")).click();
	String ActualPrice = driver.findElement(By.xpath("(//td[@class=\"a-text-right a-align-bottom aok-nowrap\"])[6]")).getText();
	SoftAssert ast= new SoftAssert();
	ast.assertEquals(ActualPrice, ExpectePrice, "After CheckOUt Expected value is correct");
	ast.assertAll();
	
	}}
			
