package BDD.StartOver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A002Launchmultiplebrowsers {
	
	
	WebDriver driver;
	
	String browser="edge";
	
	@BeforeMethod
	public void init() {
		
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invaled browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void LoginTest() throws InterruptedException {
	
		WebElement USER_NAME_FIELD=driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
		WebElement PASSWORD_FIELD=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGN_IN_FIELD=driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));
		
		
		USER_NAME_FIELD.clear();
		USER_NAME_FIELD.sendKeys("demo@codefios.com");
		PASSWORD_FIELD.sendKeys("abc123");
		SIGN_IN_FIELD.click();

}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
