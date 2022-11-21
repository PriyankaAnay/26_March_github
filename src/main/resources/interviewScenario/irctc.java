package interviewScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class irctc {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	
	
	
	driver.get("https://www.irctc.co.in/");
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	driver.findElement(By.xpath("(//input[@aria-haspopup=\"true\"])[1]")).sendKeys("Pune");;
	driver.findElement(By.xpath("(//input[@aria-haspopup=\"true\"])[2]")).sendKeys("Delhi");
	
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	String ToatalTrainsAvailablle=driver.findElement(By.xpath("//span[text()=\" 4 Results for \"]")).getText();
	System.out.println(ToatalTrainsAvailablle);
	
	}
}
