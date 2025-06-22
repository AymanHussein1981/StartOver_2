package BDD.StartOver;

import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A001TestNG {
	
	
WebDriver driver;
	

	
	
	
	@BeforeMethod
	public void init() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\StartOver\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
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
		

//String HeaderText=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText();
//		
//		Assert.assertEquals("HomePageDosntFound", "Dashboard", HeaderText );
		
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
