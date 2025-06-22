package BDD.StartOver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A003Launchmultiplebrowser2 {
	
	WebDriver driver;
	
	String browser;
	String url;
	String username;
	String password;
	
	By User_Name_Field=By.xpath("//*[@id=\"user_name\"]");
	By Password_Field=By.xpath("//*[@id=\"password\"]");
	By Signin_Field=By.xpath("//*[@id=\"login_submit\"]");
	By Dashboard_Header_Field=By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	By CUSTOMER_MENU_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");	
	By ADD_CUSTOMER_HEADER_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong");	
	By FUUL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");	
	By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");	
	
	
	@BeforeClass
	public void ReadPorp() {
		
		try {
			InputStream input=new FileInputStream("src\\main\\java\\BDD\\StartOver\\config.properties");
			Properties prop=new Properties();
			prop.load(input);
			browser=prop.getProperty("BROWSER");
			url=prop.getProperty("URL");
			username=prop.getProperty("USERNAME");
			password=prop.getProperty("PASSWORD");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}

	
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
			System.out.println("invald browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void LoginTest() {
		
		driver.findElement(User_Name_Field).sendKeys(username);
		driver.findElement(Password_Field).sendKeys(password);
		driver.findElement(Signin_Field).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
